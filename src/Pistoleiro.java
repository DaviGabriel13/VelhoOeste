/*
  Classe Pistoleiro

  CONCEITO POO DEMONSTRADO: HERANÇA e POLIMORFISMO
  - Herda (extends) da classe Personagem
  - Implementa os métodos abstratos de forma diferente do Jogador
  - Demonstra como diferentes classes podem herdar da mesma classe pai
    mas ter comportamentos distintos (POLIMORFISMO)
*/
public class Pistoleiro extends Personagem {
    // Atributos específicos do Pistoleiro
    private int nivel; // Dificuldade do pistoleiro (1 = fácil, 3 = chefe final)
    private String[] caminho; // Caminho para chegar até ele
    private String localizacao; // Descrição do local

    /*
      Construtor do Pistoleiro
      Recebe mais parâmetros que o Jogador, pois tem mais características
    */
    public Pistoleiro(String nome, int nivel, Arma arma, String[] caminho, String localizacao) {
        // Chama o construtor da classe Personagem
        // A vida do pistoleiro aumenta conforme o nível (mais difícil = mais vida)
        super(nome, 50 + (nivel * 25), arma);

        this.nivel = nivel;
        this.caminho = caminho;
        this.localizacao = localizacao;
    }

    // Getters específicos do Pistoleiro
    public int getNivel() {
        return nivel;
    }

    public String[] getCaminho() {
        return caminho;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    /*
      Implementação do método abstrato atacar() - POLIMORFISMO
      O pistoleiro ataca com base na arma E no nível
      Note que é diferente da implementação do Jogador
    */
    @Override
    public int atacar() {
        // Pistoleiros mais fortes causam mais dano
        return armaAtual.getDano() + (nivel * 5);
    }

    /*
      Implementação do método abstrato obterInformacoes() - POLIMORFISMO
      Formato diferente da implementação do Jogador
    */
    @Override
    public String obterInformacoes() {
        String info = "=== PISTOLEIRO ===\n";
        info += "Nome: " + nome + "\n";
        info += "Nível: " + nivel + "\n";
        info += "Vida: " + vida + "\n";
        info += "Arma: " + armaAtual.getNome() + "\n";
        info += "Local: " + localizacao;

        return info;
    }

    /*
      Método específico do Pistoleiro
      Retorna uma descrição dramática para o duelo
    */
    public String getDescricaoDuelo() {
        if (nivel == 3) {
            return nome + ", o assassino da sua mãe, está à sua frente!\n" +
                   "Este é o duelo final!";
        } else {
            return "Você encontrou " + nome + "!\n" +
                   "Prepare-se para o duelo!";
        }
    }
}
