# 🎥 Roteiro para Apresentação em Vídeo
## Projeto: Velho Oeste - Busca por Vingança

---

## ⏱️ Tempo Total Sugerido: 8-10 minutos

---

## 🎬 PARTE 1: INTRODUÇÃO (1-2 minutos)

### O que falar:

**[Tela: Código fechado, apenas vocês falando]**

> "Olá, somos o grupo formado por Amanda, Davi, Dariene, Everton, Gabriel, João Lucas, Kevin e Murilo."
>
> "Hoje vamos apresentar nosso projeto final de Programação Orientada a Objetos: um jogo chamado 'Velho Oeste - Busca por Vingança'."
>
> "O jogo foi desenvolvido em Java usando apenas bibliotecas padrão, especificamente a Swing para interface gráfica."
>
> "Nosso objetivo foi aplicar os 5 principais conceitos de POO: Encapsulamento, Abstração, Herança, Polimorfismo e Composição."

---

## 💻 PARTE 2: CONCEITOS POO NO CÓDIGO (4-5 minutos)

### 2.1 ENCAPSULAMENTO (1 minuto)

**[Tela: Abrir `src/Arma.java`]**

> "Começando pelo Encapsulamento, que vemos na classe Arma."
>
> **[Apontar para os atributos private]**
> "Aqui os atributos são private - não podem ser acessados diretamente de fora da classe."
>
> **[Apontar para os getters]**
> "O acesso é feito através de métodos públicos, os getters e setters."
>
> **[Apontar para a validação no setter]**
> "Reparem aqui no setter de dano: tem uma validação. Isso só é possível com encapsulamento. Se o atributo fosse público, qualquer um poderia colocar valores negativos."

### 2.2 ABSTRAÇÃO (1 minuto)

**[Tela: Abrir `src/Personagem.java`]**

> "O segundo conceito é Abstração, demonstrado na classe Personagem."
>
> **[Apontar para 'abstract class']**
> "Essa é uma classe abstrata. Ela não pode ser instanciada diretamente - serve como molde para outras classes."
>
> **[Apontar para 'abstract int atacar()']**
> "Aqui temos um método abstrato: ele não tem implementação. Cada classe filha DEVE implementar este método à sua maneira."
>
> **[Apontar para receberDano()]**
> "Mas a classe abstrata também pode ter métodos concretos, como este receberDano, que é compartilhado por todos os personagens."

### 2.3 HERANÇA (1 minuto)

**[Tela: Abrir `src/Jogador.java` e `src/Pistoleiro.java` lado a lado]**

> "O terceiro conceito é Herança."
>
> **[Apontar para 'extends Personagem']**
> "Tanto Jogador quanto Pistoleiro herdam de Personagem. Veja o 'extends' aqui."
>
> "Isso significa que eles recebem automaticamente todos os atributos e métodos de Personagem: nome, vida, arma atual."
>
> **[Apontar para o construtor com 'super']**
> "No construtor, chamamos o construtor da classe pai com 'super'. Isso inicializa os atributos herdados."
>
> "Mas cada classe também adiciona suas próprias características. O Jogador tem inventário, o Pistoleiro tem nível."

### 2.4 POLIMORFISMO (1-2 minutos)

**[Tela: Focar no método atacar() nas duas classes]**

> "Agora o Polimorfismo - um dos conceitos mais importantes."
>
> **[Mostrar atacar() no Jogador]**
> "Veja o método atacar no Jogador: ele retorna o dano da arma atual."
>
> **[Mostrar atacar() no Pistoleiro]**
> "Agora no Pistoleiro: mesmo método, mas implementação diferente. Ele retorna o dano da arma MAIS um bônus baseado no nível."
>
> "Isso é polimorfismo: mesmo nome de método, comportamentos diferentes."
>
> **[Se tiver tempo, mostrar uso prático]**
> "Na prática, quando fazemos personagem.atacar(), o Java executa a versão correta dependendo se é Jogador ou Pistoleiro. Não precisamos verificar o tipo com if/else."

### 2.5 COMPOSIÇÃO (30 segundos)

**[Tela: Abrir `src/Jogo.java`, focar nos atributos]**

> "Por último, Composição."
>
> **[Apontar para 'private Jogador jogador']**
> "A classe Jogo não herda de Jogador. Ela CONTÉM um Jogador."
>
> "É uma relação 'tem um': o Jogo TEM UM Jogador, TEM vários Pistoleiros, TEM uma janela."
>
> "Isso é composição: classes contendo objetos de outras classes."

---

## 🎮 PARTE 3: DEMONSTRAÇÃO DO JOGO (2-3 minutos)

**[Tela: Terminal/IDE]**

> "Agora vamos executar o jogo para ver tudo isso funcionando."

### Passo a passo da demonstração:

1. **Compilar**
   ```
   [Executar compilar.bat ou mostrar arquivos já compilados]
   ```
   > "Primeiro compilamos o código."

2. **Executar**
   ```
   [Executar executar.bat ou java -cp bin Main]
   ```
   > "E executamos o Main, que é nosso ponto de entrada."

3. **Tela Inicial**
   > "Aqui está a tela inicial. Vamos inserir o nome do personagem."
   
   **[Digitar nome, ex: "Cowboy"]**

4. **História**
   > "O jogo apresenta a história: buscar vingança pela mãe morta."
   
   **[Clicar em INICIAR JORNADA]**

5. **Fase de Navegação**
   > "Primeira fase: memorizar o caminho. Temos 10 segundos."
   
   **[Aguardar aparecer o caminho]**
   
   > "Veja, apareceu o caminho. Vamos memorizar..."
   
   **[Após 10 segundos, digitar o caminho]**
   
   > "Agora digitamos o caminho memorizado. Se acertar, encontramos o pistoleiro."

6. **Fase de Duelo**
   > "Segunda fase: o duelo!"
   
   **[Aguardar o "ATIRE!"]**
   
   > "Aguardamos o sinal... ATIRE! Agora pressionamos ESPAÇO e ENTER rapidamente."
   
   **[Executar o duelo]**

7. **Vitória/Progressão**
   > "Vencemos! Ganhamos a arma dele e a localização do próximo pistoleiro."
   
   > "O jogo continua assim até derrotarmos os 3 pistoleiros e completarmos a vingança."

---

## 🎯 PARTE 4: CONCLUSÃO (1 minuto)

**[Tela: Voltar para o código ou apresentação]**

> "Para resumir, implementamos todos os conceitos principais de POO:"
>
> "✅ Encapsulamento - protegendo dados com private e getters/setters"
> "✅ Abstração - classe Personagem abstrata definindo estrutura comum"
> "✅ Herança - Jogador e Pistoleiro herdando de Personagem"
> "✅ Polimorfismo - método atacar com comportamentos diferentes"
> "✅ Composição - Jogo contendo outros objetos"
>
> "O projeto foi desafiador mas muito educativo. Aprendemos não apenas a sintaxe, mas quando e por que usar cada conceito."
>
> "Obrigado pela atenção!"

---

## 📝 DICAS PARA A GRAVAÇÃO

### Antes de gravar:

1. ✅ Teste o jogo VÁRIAS vezes antes de gravar
2. ✅ Memorize o primeiro caminho (ou anote discretamente)
3. ✅ Tenha um script com os pontos principais
4. ✅ Feche programas desnecessários (notificações, etc)
5. ✅ Ajuste o zoom do editor para o código ficar legível
6. ✅ Use um fundo de tela profissional

### Durante a gravação:

1. 🎤 Fale claramente e não muito rápido
2. 🖱️ Mova o cursor/mouse para destacar o que está explicando
3. ⏸️ Faça pausas breves entre os tópicos
4. 😊 Mantenha tom de voz animado mas profissional
5. 🔄 Se errar, pode pausar e continuar (edita depois)

### Distribuição de falas (sugestão):

- **Pessoa 1**: Introdução + Encapsulamento
- **Pessoa 2**: Abstração + Herança  
- **Pessoa 3**: Polimorfismo + Composição
- **Pessoa 4**: Demonstração do jogo
- **Pessoa 5**: Conclusão

Ou dividir conforme o grupo preferir!

---

## 🎨 OPÇÕES DE APRESENTAÇÃO

### Opção A: Mais Técnica
- Foco maior no código (5 min código, 2 min jogo)
- Ideal se o professor valoriza mais a teoria

### Opção B: Mais Demonstrativa
- Foco maior no jogo funcionando (3 min código, 4 min jogo)
- Ideal se o professor valoriza o resultado prático

### Opção C: Balanceada (Recomendada)
- Como descrito neste roteiro
- Mostra teoria E prática

---

## ✨ FRASES IMPACTANTES PARA USAR

**Sobre Encapsulamento:**
> "Sem encapsulamento, qualquer parte do código poderia quebrar nosso jogo colocando valores inválidos. Com ele, mantemos controle total."

**Sobre Abstração:**
> "A classe Personagem define O QUE todo personagem deve ter, mas não COMO. Isso é abstração em ação."

**Sobre Herança:**
> "Em vez de copiar e colar código, usamos herança. Uma mudança em Personagem afeta automaticamente Jogador e Pistoleiro."

**Sobre Polimorfismo:**
> "O polimorfismo permite que tratemos Jogador e Pistoleiro de forma uniforme, mas cada um mantém seu comportamento único."

**Sobre Composição:**
> "Composição nos dá flexibilidade. Se quisermos adicionar mais tipos de fases ou personagens, basta compor novos objetos."

---

## 📊 CHECKLIST FINAL

Antes de entregar, verifique:

- [ ] Código compila sem erros
- [ ] Jogo executa completamente
- [ ] Todos os conceitos de POO estão claramente comentados
- [ ] README.md está completo
- [ ] Testamos em pelo menos 2 computadores diferentes
- [ ] Vídeo tem boa qualidade de áudio e vídeo
- [ ] Vídeo não excede o tempo máximo (se houver limite)
- [ ] Todos os membros do grupo participam (se obrigatório)

---

## 🚀 BOA APRESENTAÇÃO!

**Lembre-se:** O objetivo não é apenas mostrar que o jogo funciona, mas demonstrar que vocês **ENTENDEM** os conceitos de POO e sabem aplicá-los.

Falem com confiança sobre o que implementaram. Vocês fizeram um ótimo trabalho! 🎓🤠

---

**Dúvidas? Consulte:**
- `README.md` - Informações gerais
- `CONCEITOS_POO.md` - Detalhamento dos conceitos
- `INSTALACAO_JAVA.md` - Problemas com compilação
