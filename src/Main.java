/**
 * PROJETO FINAL - PROGRAMAÇÃO ORIENTADA A OBJETOS
 * Jogo: Velho Oeste - Busca por Vingança
 * 
 * Participantes: Amanda Soares, Davi Oliveira, Dariene Leite, Everton Junca,
 * Gabriel Augusto, João Lucas, Kevin Washington e Murilo Inácio.
 * 
 * Classe Main - Ponto de entrada da aplicação
 * Esta classe apenas inicializa o jogo, seguindo o princípio de responsabilidade única
 */
public class Main {
    public static void main(String[] args) {
        // Inicia a interface gráfica na thread de eventos do Swing
        // Isso é uma boa prática para aplicações GUI em Java
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Jogo(); // Cria e inicia o jogo
            }
        });
    }
}
