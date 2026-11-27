/*
  Classe Arma

  CONCEITO POO DEMONSTRADO: ENCAPSULAMENTO
  - Atributos privados (private) protegem os dados internos
  - Métodos públicos (getters/setters) controlam o acesso aos dados
  - Isso garante que os dados só sejam modificados de forma controlada
*/
public class Arma {
    // Atributos privados - ENCAPSULAMENTO
    // Não podem ser acessados diretamente de fora da classe
    private String nome;
    private int dano;
    private String descricao;

    /*
      Construtor da classe Arma
      Inicializa os atributos do objeto quando ele é criado
    */
    public Arma(String nome, int dano, String descricao) {
        this.nome = nome;
        this.dano = dano;
        this.descricao = descricao;
    }

    // Métodos Getters - Permitem LEITURA controlada dos atributos privados
    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método Setter - Permite MODIFICAÇÃO controlada
    // Podemos adicionar validações aqui se necessário
    public void setDano(int dano) {
        if (dano > 0) { // Validação: dano deve ser positivo
            this.dano = dano;
        }
    }

    /*
      Sobrescrita do método toString() - POLIMORFISMO
      Permite representar o objeto como String de forma personalizada
    */
    @Override
    public String toString() {
        return nome + " (Dano: " + dano + ")";
    }
}
