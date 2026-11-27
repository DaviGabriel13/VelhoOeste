import java.util.ArrayList;

/**
 * Classe Jogador
 * 
 * CONCEITO POO DEMONSTRADO: HERANÇA
 * - Herda (extends) da classe Personagem
 * - Recebe todos os atributos e métodos da classe pai
 * - Adiciona características específicas do jogador (inventário de armas)
 * - Implementa os métodos abstratos da classe pai (POLIMORFISMO)
 */
public class Jogador extends Personagem {
    // Atributo adicional específico do Jogador
    private ArrayList<Arma> inventario; // Lista de armas coletadas
    private int pistoleirosderrotados;
    
    /**
     * Construtor do Jogador
     * Chama o construtor da classe pai (super) e inicializa atributos próprios
     */
    public Jogador(String nome) {
        // Chama o construtor da classe Personagem (superclasse)
        super(nome, 100, new Arma("Revólver Enferrujado", 10, "Arma inicial"));
        
        // Inicializa atributos específicos do Jogador
        this.inventario = new ArrayList<>();
        this.inventario.add(armaAtual); // Adiciona a arma inicial ao inventário
        this.pistoleirosderrotados = 0;
    }
    
    /**
     * Método para adicionar arma ao inventário
     * Chamado quando o jogador derrota um pistoleiro
     */
    public void adicionarArma(Arma arma) {
        inventario.add(arma);
        this.armaAtual = arma; // Equipa automaticamente a nova arma
    }
    
    public ArrayList<Arma> getInventario() {
        return inventario;
    }
    
    public void incrementarPistoleirosderrotados() {
        this.pistoleirosderrotados++;
    }
    
    public int getPistoleirosderrotados() {
        return pistoleirosderrotados;
    }
    
    /**
     * Implementação do método abstrato atacar() - POLIMORFISMO
     * O jogador ataca usando o dano da arma atual
     * Cada classe filha implementa este método de forma diferente
     */
    @Override
    public int atacar() {
        return armaAtual.getDano();
    }
    
    /**
     * Implementação do método abstrato obterInformacoes() - POLIMORFISMO
     * Retorna uma string com as informações do jogador
     */
    @Override
    public String obterInformacoes() {
        return "Jogador: " + nome + "\n" +
               "Vida: " + vida + "\n" +
               "Arma: " + armaAtual.getNome() + "\n" +
               "Pistoleiros derrotados: " + pistoleirosderrotados;
    }
    
    /**
     * Método para restaurar a vida do jogador
     */
    public void restaurarVida() {
        this.vida = 100;
    }
}
