/**
 * Classe Abstrata Personagem
 * 
 * CONCEITOS POO DEMONSTRADOS: ABSTRAÇÃO e base para HERANÇA
 * - Uma classe abstrata não pode ser instanciada diretamente
 * - Serve como molde (template) para outras classes
 * - Define atributos e comportamentos comuns a todos os personagens
 * - Pode ter métodos concretos (com implementação) e abstratos (sem implementação)
 */
public abstract class Personagem {
    // Atributos protegidos (protected) - acessíveis pelas classes filhas
    // Demonstra ENCAPSULAMENTO com acesso controlado por herança
    protected String nome;
    protected int vida;
    protected Arma armaAtual;
    
    /**
     * Construtor da classe abstrata
     * Mesmo sendo abstrata, pode ter construtor para inicializar atributos comuns
     */
    public Personagem(String nome, int vida, Arma armaAtual) {
        this.nome = nome;
        this.vida = vida;
        this.armaAtual = armaAtual;
    }
    
    // Métodos Getters - ENCAPSULAMENTO
    public String getNome() {
        return nome;
    }
    
    public int getVida() {
        return vida;
    }
    
    public Arma getArmaAtual() {
        return armaAtual;
    }
    
    // Método Setter
    public void setArmaAtual(Arma arma) {
        this.armaAtual = arma;
    }
    
    /**
     * Método concreto (com implementação)
     * Reduz a vida do personagem quando ele sofre dano
     */
    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }
    
    /**
     * Método concreto para verificar se o personagem está vivo
     */
    public boolean estaVivo() {
        return this.vida > 0;
    }
    
    /**
     * Método ABSTRATO - não tem implementação aqui
     * Cada classe filha DEVE implementar este método à sua maneira
     * Isso demonstra POLIMORFISMO - cada tipo de personagem ataca diferente
     */
    public abstract int atacar();
    
    /**
     * Outro método abstrato
     * Obriga as classes filhas a implementarem como apresentam suas informações
     */
    public abstract String obterInformacoes();
}
