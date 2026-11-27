# Velho Oeste - Busca por Vingança
### Projeto Final de Programação Orientada a Objetos

**Participantes:** Amanda Soares, Davi Oliveira, Dariene Leite, Everton Junca, Gabriel Augusto, João Lucas, Kevin Washington e Murilo Inácio.

---

## 📖 Sobre o Jogo

Um jogo de aventura ambientado no Velho Oeste onde o jogador busca vingança pela morte de sua mãe. Para encontrar o assassino final, é necessário derrotar seus capangas em duelos clássicos de pistoleiros.

### Gameplay

O jogo possui duas fases principais:

1. **Fase de Navegação**: Memorize o caminho até o pistoleiro (exemplo: Esquerda → Frente → Direita)
2. **Fase de Duelo**: Aguarde o sinal e pressione ESPAÇO + ENTER antes que o pistoleiro atire em você

---

## 🎯 Conceitos de POO Implementados

### 1. **Encapsulamento**
- **Classe `Arma`**: Atributos privados (`private`) com acesso controlado por getters/setters
- Protege os dados internos e permite validação

### 2. **Abstração**
- **Classe `Personagem`**: Classe abstrata que serve como molde para `Jogador` e `Pistoleiro`
- Define métodos abstratos que devem ser implementados pelas subclasses

### 3. **Herança**
- **Classes `Jogador` e `Pistoleiro`**: Herdam de `Personagem` usando `extends`
- Reutilizam código da classe pai (atributos e métodos comuns)
- Adicionam características específicas de cada tipo

### 4. **Polimorfismo**
- Método `atacar()`: Implementado de forma diferente em `Jogador` e `Pistoleiro`
- Método `obterInformacoes()`: Cada classe apresenta seus dados de forma única
- Mesmo método, comportamentos diferentes

### 5. **Composição**
- **Classe `Jogo`**: Contém objetos de outras classes (Jogador, Pistoleiros, Fases)
- **Classes de Fase**: Usam objetos Jogador e Pistoleiro para realizar suas operações

---

## 🚀 Como Compilar e Executar

### Pré-requisitos
- Java JDK 8 ou superior instalado
- Terminal/Prompt de Comando

### Passo 1: Compilar

No diretório raiz do projeto (onde está a pasta `src`), execute:

```bash
# Windows
javac -d bin -encoding UTF-8 src/*.java

# Linux/Mac
javac -d bin -encoding UTF-8 src/*.java
```

Isso criará uma pasta `bin` com os arquivos `.class` compilados.

### Passo 2: Executar

```bash
# Windows
java -cp bin Main

# Linux/Mac
java -cp bin Main
```

---

## 📁 Estrutura do Projeto

```
velhooeste/
│
├── src/
│   ├── Main.java              # Ponto de entrada do programa
│   ├── Jogo.java              # Controlador principal do jogo
│   ├── Personagem.java        # Classe abstrata (Abstração + Herança)
│   ├── Jogador.java           # Herda de Personagem (Herança + Polimorfismo)
│   ├── Pistoleiro.java        # Herda de Personagem (Herança + Polimorfismo)
│   ├── Arma.java              # Demonstra Encapsulamento
│   ├── FaseNavegacao.java     # Fase de memorizar caminho
│   └── FaseDuelo.java         # Fase de combate
│
├── README.md                   # Este arquivo
└── CONCEITOS_POO.md           # Explicação detalhada dos conceitos
```

---

## 🎮 Como Jogar

1. Execute o programa
2. Digite o nome do seu personagem
3. Leia a história inicial
4. Clique em "INICIAR JORNADA"

### Para cada pistoleiro:

**Fase de Navegação:**
- Memorize o caminho mostrado (você tem 10 segundos)
- Digite o caminho usando as opções: Esquerda, Frente, Direita
- Se errar, você pode tentar novamente

**Fase de Duelo:**
- Aguarde o sinal "ATIRE!"
- Pressione ESPAÇO e depois ENTER rapidamente
- Se for mais rápido que o pistoleiro, você vence!
- Se perder, pode tentar o duelo novamente

### Objetivo:
Derrote os 3 pistoleiros para completar o jogo e vingar sua mãe!

---

## 🎓 Para Apresentação em Vídeo

### Roteiro Sugerido:

1. **Introdução** (1-2 min)
   - Apresentar o grupo
   - Explicar brevemente a proposta do jogo

2. **Conceitos de POO** (3-4 min)
   - Mostrar código da classe `Arma` (Encapsulamento)
   - Mostrar classe `Personagem` (Abstração)
   - Mostrar `Jogador` e `Pistoleiro` (Herança e Polimorfismo)
   - Mostrar `Jogo` (Composição)

3. **Demonstração do Jogo** (2-3 min)
   - Executar o jogo
   - Mostrar as duas fases
   - Completar pelo menos um pistoleiro

4. **Conclusão** (1 min)
   - Recapitular os conceitos aplicados
   - Dificuldades e aprendizados

---

## 📝 Observações

- O jogo usa apenas bibliotecas padrão do Java (Swing)
- Todo o código está comentado explicando os conceitos de POO
- A complexidade é adequada para um projeto de Programação 2
- O foco está nos conceitos, não em gráficos avançados

---

## ✨ Funcionalidades Implementadas

✅ Sistema de navegação por memorização  
✅ Sistema de duelo em tempo real  
✅ Sistema de inventário de armas  
✅ Progressão de dificuldade (3 pistoleiros)  
✅ Interface gráfica com Swing  
✅ Sistema de vida e combate  
✅ Opções de tentar novamente ou desistir  
✅ História e narrativa do jogo  

---

**Boa sorte na apresentação! 🤠🔫**
