import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/*
  Classe FaseNavegacao

  CONCEITO POO: COMPOSIÇÃO e ENCAPSULAMENTO
  - Esta classe gerencia a fase de navegação do jogo
  - Usa composição ao ter um objeto Pistoleiro como atributo
  - Encapsula toda a lógica da fase de memorizar o caminho
*/
public class FaseNavegacao {
    private Pistoleiro pistoleiro;
    private JFrame janela;
    private ArrayList<String> caminhoJogador;
    private boolean faseCompleta;

    // Construtor - inicializa a fase de navegação
    public FaseNavegacao(Pistoleiro pistoleiro) {
        this.pistoleiro = pistoleiro;
        this.caminhoJogador = new ArrayList<>();
        this.faseCompleta = false;
    }

    /*
      Inicia a fase de navegação
      Retorna true se o jogador conseguiu chegar ao local correto
    */
    public boolean iniciar() {
        // Mostra o caminho para o jogador memorizar
        mostrarCaminho();

        // Aguarda o jogador digitar o caminho
        if (!faseCompleta) {
            return false; // Jogador desistiu
        }

        // Verifica se o caminho está correto
        return verificarCaminho();
    }

    // Mostra o caminho que o jogador precisa memorizar
    private void mostrarCaminho() {
        String[] caminho = pistoleiro.getCaminho();
        String caminhoTexto = "MEMORIZE O CAMINHO PARA " + pistoleiro.getNome() + ":\n\n";

        for (int i = 0; i < caminho.length; i++) {
            caminhoTexto += (i + 1) + ". " + caminho[i] + "\n";
        }

        caminhoTexto += "\nVocê tem 10 segundos para memorizar!";

        // Cria um diálogo para mostrar o caminho
        JDialog dialogo = new JDialog();
        dialogo.setTitle("Localize o Pistoleiro");
        dialogo.setModal(true);
        dialogo.setSize(400, 300);
        dialogo.setLocationRelativeTo(null);

        JTextArea textoArea = new JTextArea(caminhoTexto);
        textoArea.setEditable(false);
        textoArea.setFont(new Font("Monospaced", Font.BOLD, 14));
        textoArea.setMargin(new Insets(10, 10, 10, 10));

        dialogo.add(new JScrollPane(textoArea));

        // Timer para fechar automaticamente após 10 segundos
        Timer timer = new Timer(10000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialogo.dispose();
                coletarCaminhoJogador();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialogo.setVisible(true);
    }

    // Coleta o caminho digitado pelo jogador
    private void coletarCaminhoJogador() {
        String[] opcoes = {"Esquerda", "Frente", "Direita"};
        int quantidadePassos = pistoleiro.getCaminho().length;

        caminhoJogador.clear();

        for (int i = 0; i < quantidadePassos; i++) {
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Passo " + (i + 1) + " de " + quantidadePassos + "\nPara onde você vai?",
                "Navegando até " + pistoleiro.getNome(),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            if (escolha == -1) { // Jogador fechou o diálogo
                faseCompleta = false;
                return;
            }

            caminhoJogador.add(opcoes[escolha]);
        }

        faseCompleta = true;
    }

    // Verifica se o caminho digitado pelo jogador está correto
    private boolean verificarCaminho() {
        String[] caminhoCorreto = pistoleiro.getCaminho();

        // Compara cada passo
        for (int i = 0; i < caminhoCorreto.length; i++) {
            if (!caminhoCorreto[i].equalsIgnoreCase(caminhoJogador.get(i))) {
                // Caminho errado!
                int tentarNovamente = JOptionPane.showConfirmDialog(
                    null,
                    "Você se perdeu! O caminho estava errado.\n\nTentar novamente?",
                    "Caminho Errado",
                    JOptionPane.YES_NO_OPTION
                );

                if (tentarNovamente == JOptionPane.YES_OPTION) {
                    return iniciar(); // Tenta novamente (recursão)
                } else {
                    return false; // Desiste
                }
            }
        }

        // Caminho correto!
        JOptionPane.showMessageDialog(
            null,
            "Você chegou ao local correto!\n" + pistoleiro.getLocalizacao(),
            "Localização Encontrada",
            JOptionPane.INFORMATION_MESSAGE
        );

        return true;
    }
}
