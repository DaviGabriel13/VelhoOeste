# Conceitos de Programação Orientada a Objetos
## Implementados no Projeto "Velho Oeste"

---

## 1. 🔒 ENCAPSULAMENTO

### O que é?
Encapsulamento é o conceito de **proteger os dados** de uma classe, impedindo acesso direto a eles. Os atributos são declarados como `private` e o acesso é feito através de métodos públicos (getters e setters).

### Onde está no projeto?
**Classe: `Arma.java`**

```java
public class Arma {
    // Atributos PRIVADOS - não podem ser acessados diretamente
    private String nome;
    private int dano;
    
    // Método público para LER o valor (Getter)
    public String getNome() {
        return nome;
    }
    
    // Método público para MODIFICAR o valor (Setter)
    public void setDano(int dano) {
        if (dano > 0) { // Validação!
            this.dano = dano;
        }
    }
}
```

### Por que é importante?
- **Proteção**: Ninguém pode modificar `dano` para um valor negativo
- **Controle**: Podemos adicionar validações nos setters
- **Manutenção**: Se precisar mudar a estrutura interna, os métodos públicos continuam funcionando

### No jogo:
Quando o jogador coleta uma arma, não podemos deixar que o dano seja alterado para valores absurdos. O encapsulamento garante isso!

---

## 2. 🎭 ABSTRAÇÃO

### O que é?
Abstração é criar uma **classe genérica** que serve como molde para outras classes. Uma classe abstrata:
- Não pode ser instanciada diretamente (não podemos criar objetos dela)
- Define métodos abstratos (sem implementação)
- As classes filhas DEVEM implementar os métodos abstratos

### Onde está no projeto?
**Classe: `Personagem.java`**

```java
public abstract class Personagem {
    protected String nome;
    protected int vida;
    
    // Método abstrato - SEM implementação
    // Cada classe filha implementa à sua maneira
    public abstract int atacar();
    
    // Método concreto - COM implementação
    // Pode ser usado por todas as classes filhas
    public void receberDano(int dano) {
        this.vida -= dano;
    }
}
```

### Por que é importante?
- **Organização**: Define o que todos os personagens devem ter
- **Flexibilidade**: Cada tipo de personagem pode atacar de forma diferente
- **Reutilização**: Código comum fica na classe pai

### No jogo:
Tanto `Jogador` quanto `Pistoleiro` são Personagens, mas atacam de formas diferentes. A abstração permite isso!

---

## 3. 👨‍👦 HERANÇA

### O que é?
Herança permite que uma classe **herde atributos e métodos** de outra classe. A classe filha recebe tudo da classe pai e pode adicionar características próprias.

**Sintaxe:** `class ClasseFilha extends ClassePai`

### Onde está no projeto?
**Classes: `Jogador.java` e `Pistoleiro.java`**

```java
// Jogador HERDA de Personagem
public class Jogador extends Personagem {
    // Atributo adicional (só o Jogador tem)
    private ArrayList<Arma> inventario;
    
    // Construtor chama o construtor da classe pai
    public Jogador(String nome) {
        super(nome, 100, armaInicial); // Chama construtor de Personagem
        this.inventario = new ArrayList<>();
    }
    
    // Implementa o método abstrato
    @Override
    public int atacar() {
        return armaAtual.getDano();
    }
}
```

```java
// Pistoleiro TAMBÉM HERDA de Personagem
public class Pistoleiro extends Personagem {
    // Atributo adicional (só o Pistoleiro tem)
    private int nivel;
    
    // Implementa o método abstrato DE FORMA DIFERENTE
    @Override
    public int atacar() {
        return armaAtual.getDano() + (nivel * 5); // Mais forte!
    }
}
```

### Por que é importante?
- **Reutilização**: Não precisamos repetir código (nome, vida, arma)
- **Organização**: Hierarquia clara de classes
- **Facilidade**: Se mudarmos `Personagem`, todos os filhos são afetados

### No jogo:
Jogador e Pistoleiro compartilham características (nome, vida, arma) mas têm diferenças (inventário vs. nível).

---

## 4. 🎨 POLIMORFISMO

### O que é?
Polimorfismo significa "muitas formas". É a capacidade de objetos diferentes responderem ao **mesmo método de formas diferentes**.

**Tipos:**
- **Sobrescrita** (`@Override`): Reescrever um método da classe pai
- **Sobrecarga**: Mesmo método, parâmetros diferentes (não usado neste projeto)

### Onde está no projeto?

#### Exemplo 1: Método `atacar()`
```java
// Na classe Jogador
@Override
public int atacar() {
    return armaAtual.getDano(); // Ataca com o dano da arma
}

// Na classe Pistoleiro
@Override
public int atacar() {
    return armaAtual.getDano() + (nivel * 5); // Mais forte!
}
```

Mesmo método, **comportamentos diferentes**!

#### Exemplo 2: Na prática
```java
// Na classe FaseDuelo
Personagem jogador = new Jogador("João");
Personagem pistoleiro = new Pistoleiro("Billy", 1, ...);

// POLIMORFISMO: mesmo método, execuções diferentes
int danoJogador = jogador.atacar();     // Usa implementação de Jogador
int danoPistoleiro = pistoleiro.atacar(); // Usa implementação de Pistoleiro
```

### Por que é importante?
- **Flexibilidade**: Podemos tratar objetos diferentes de forma uniforme
- **Extensibilidade**: Fácil adicionar novos tipos de personagens
- **Elegância**: Código mais limpo e intuitivo

### No jogo:
Quando calculamos o dano no duelo, não precisamos verificar "se é jogador ou pistoleiro" - apenas chamamos `atacar()` e cada um faz do seu jeito!

---

## 5. 🧩 COMPOSIÇÃO

### O que é?
Composição é quando uma classe **contém objetos** de outras classes. É o relacionamento "tem um" (HAS-A).

Diferente de herança (que é "é um" / IS-A).

### Onde está no projeto?
**Classe: `Jogo.java`**

```java
public class Jogo {
    // O jogo TEM UM jogador
    private Jogador jogador;
    
    // O jogo TEM VÁRIOS pistoleiros
    private ArrayList<Pistoleiro> pistoleiros;
    
    // O jogo TEM UMA janela
    private JFrame janelaPrincipal;
}
```

**Classe: `FaseDuelo.java`**

```java
public class FaseDuelo {
    // A fase TEM UM jogador
    private Jogador jogador;
    
    // A fase TEM UM pistoleiro
    private Pistoleiro pistoleiro;
}
```

### Por que é importante?
- **Modularidade**: Cada classe tem sua responsabilidade
- **Manutenção**: Mudanças em uma classe não afetam as outras
- **Testabilidade**: Podemos testar cada classe separadamente

### No jogo:
O jogo coordena todas as partes (jogador, pistoleiros, fases) mas cada uma tem sua própria lógica.

---

## 📊 Diagrama de Classes Simplificado

```
         Personagem (ABSTRATA)
         ├── nome: String
         ├── vida: int
         ├── armaAtual: Arma
         ├── atacar(): int (ABSTRATO)
         └── receberDano(int): void
                  ▲
                  │ HERANÇA
         ┌────────┴────────┐
         │                 │
     Jogador          Pistoleiro
  + inventario      + nivel
  + atacar()        + atacar()
  
  
         Arma (ENCAPSULAMENTO)
         ├── nome: String (private)
         ├── dano: int (private)
         ├── getNome(): String
         └── getDano(): int
         
         
         Jogo (COMPOSIÇÃO)
         ├── jogador: Jogador
         ├── pistoleiros: List<Pistoleiro>
         └── enfrentarProximoPistoleiro(): void
```

---

## 🎯 Checklist de Conceitos POO

- ✅ **Encapsulamento**: Atributos privados com getters/setters (Classe `Arma`)
- ✅ **Abstração**: Classe abstrata com métodos abstratos (Classe `Personagem`)
- ✅ **Herança**: Classes filhas herdando da pai (`Jogador` e `Pistoleiro` extends `Personagem`)
- ✅ **Polimorfismo**: Métodos sobrescritos com comportamentos diferentes (`atacar()`, `obterInformacoes()`)
- ✅ **Composição**: Classes contendo objetos de outras classes (`Jogo` tem `Jogador` e `Pistoleiros`)

---

## 💡 Dicas para Apresentação

### Ao explicar ENCAPSULAMENTO:
"Vejam aqui na classe Arma: os atributos são private. Se não fosse assim, alguém poderia fazer `arma.dano = -100` e quebrar o jogo. Com getters e setters, controlamos isso."

### Ao explicar ABSTRAÇÃO:
"Personagem é abstrata porque não faz sentido criar um 'Personagem genérico'. Todo personagem é OU Jogador OU Pistoleiro. A classe abstrata força isso."

### Ao explicar HERANÇA:
"Em vez de copiar e colar o código de 'nome', 'vida' e 'arma' nas duas classes, usamos herança. Ambas herdam esses atributos de Personagem."

### Ao explicar POLIMORFISMO:
"O método atacar() existe nas duas classes, mas funciona diferente. O Jogador ataca com o dano da arma. O Pistoleiro ataca com dano da arma MAIS um bônus do nível. Mesmo método, lógicas diferentes!"

### Ao explicar COMPOSIÇÃO:
"A classe Jogo não HERDA de Jogador ou Pistoleiro. Ela CONTÉM esses objetos. É uma relação de composição: o Jogo TEM UM Jogador e TEM Pistoleiros."

---

## 🔍 Onde Encontrar Cada Conceito no Código

| Conceito | Arquivo | Linha Aproximada | O que procurar |
|----------|---------|------------------|----------------|
| Encapsulamento | `Arma.java` | 10-30 | `private` + getters/setters |
| Abstração | `Personagem.java` | 1-50 | `abstract class`, `abstract int atacar()` |
| Herança | `Jogador.java` | 1 | `extends Personagem` |
| Herança | `Pistoleiro.java` | 1 | `extends Personagem` |
| Polimorfismo | `Jogador.java` | 40-45 | `@Override public int atacar()` |
| Polimorfismo | `Pistoleiro.java` | 35-40 | `@Override public int atacar()` |
| Composição | `Jogo.java` | 15-20 | `private Jogador jogador` |
| Composição | `FaseDuelo.java` | 10-15 | `private Jogador` + `Pistoleiro` |

---

**Boa apresentação! 🎓**
