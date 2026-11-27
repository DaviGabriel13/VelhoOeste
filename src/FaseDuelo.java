import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
  Classe FaseDuelo

  CONCEITO POO: COMPOSIÇÃO e uso de POLIMORFISMO
  - Usa objetos Jogador e Pistoleiro (ambos são Personagens - Polimorfismo)
  - Encapsula a lógica do duelo entre os personagens
  - Demonstra como classes podem interagir através de seus métodos públicos
*/
public class FaseDuelo {
    private Jogador jogador;
    private Pistoleiro pistoleiro;
    private boolean jogadorVenceu;

    // Construtor - recebe os dois personagens que vão duelar
    public FaseDuelo(Jogador jogador, Pistoleiro pistoleiro) {
        this.jogador = jogador;
        this.pistoleiro = pistoleiro;
        this.jogadorVenceu = false;
    }

    /*
      Inicia o duelo
      Retorna true se o jogador venceu
    */
    public boolean iniciar() {
        // Mostra a descrição do duelo
        JOptionPane.showMessageDialog(
            null,
            pistoleiro.getDescricaoDuelo(),
            "DUELO!",
            JOptionPane.WARNING_MESSAGE
        );

        // Realiza o duelo
        return realizarDuelo();
    }

    /*
      Lógica principal do duelo
      O jogador precisa pressionar ESPAÇO e ENTER antes do tempo acabar
    */
    private boolean realizarDuelo() {
        // Cria a janela do duelo
        JDialog janelaDuelo = new JDialog();
        janelaDuelo.setTitle("DUELO - " + pistoleiro.getNome());
        janelaDuelo.setSize(500, 400);
        janelaDuelo.setLocationRelativeTo(null);
        janelaDuelo.setModal(true);
        janelaDuelo.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBackground(new Color(139, 90, 43)); // Cor marrom (terra do oeste)

        // Label de instrução
        JLabel labelInstrucao = new JLabel("Aguarde o sinal...", SwingConstants.CENTER);
        labelInstrucao.setFont(new Font("Arial", Font.BOLD, 24));
        labelInstrucao.setForeground(Color.WHITE);
        painel.add(labelInstrucao, BorderLayout.CENTER);

        // Label de status
        JLabel labelStatus = new JLabel("Prepare-se!", SwingConstants.CENTER);
        labelStatus.setFont(new Font("Arial", Font.PLAIN, 16));
        labelStatus.setForeground(Color.YELLOW);
        painel.add(labelStatus, BorderLayout.SOUTH);

        janelaDuelo.add(painel);

        // Variável para controlar o resultado
        final boolean[] resultado = {false};
        final boolean[] podeAtirar = {false};
        final boolean[] jogadorAtirou = {false};

        // Timer para dar o sinal de "ATIRE!"
        int tempoEspera = 2000 + (int)(Math.random() * 3000); // 2-5 segundos aleatórios

        Timer timerSinal = new Timer(tempoEspera, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                podeAtirar[0] = true;
                labelInstrucao.setText("ATIRE!");
                labelInstrucao.setForeground(Color.RED);
                labelStatus.setText("Pressione ESPAÇO e depois ENTER!");

                // Timer do pistoleiro - ele atira após um tempo
                int tempoPistoleiro = 800 + (int)(Math.random() * 400); // 0.8-1.2 segundos

                Timer timerPistoleiro = new Timer(tempoPistoleiro, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!jogadorAtirou[0]) {
                            // Pistoleiro atirou primeiro! Jogador perde
                            resultado[0] = false;
                            labelInstrucao.setText("VOCÊ FOI ATINGIDO!");
                            labelStatus.setText("O pistoleiro foi mais rápido...");

                            // POLIMORFISMO: chamando método atacar() que tem implementações diferentes
                            jogador.receberDano(pistoleiro.atacar());

                            Timer fechar = new Timer(2000, evt -> {
                                janelaDuelo.dispose();
                                mostrarResultado(false);
                            });
                            fechar.setRepeats(false);
                            fechar.start();
                        }
                    }
                });
                timerPistoleiro.setRepeats(false);
                timerPistoleiro.start();
            }
        });
        timerSinal.setRepeats(false);
        timerSinal.start();

        // Listener para detectar as teclas
        janelaDuelo.addKeyListener(new KeyAdapter() {
            private boolean espacoPressionado = false;

            @Override
            public void keyPressed(KeyEvent e) {
                if (!podeAtirar[0]) {
                    // Jogador atirou antes do sinal!
                    labelInstrucao.setText("VOCÊ ATIROU ANTES DO SINAL!");
                    labelStatus.setText("Desonra no duelo!");
                    timerSinal.stop();

                    Timer fechar = new Timer(2000, evt -> {
                        janelaDuelo.dispose();
                        mostrarResultado(false);
                    });
                    fechar.setRepeats(false);
                    fechar.start();
                    return;
                }

                if (e.getKeyCode() == KeyEvent.VK_SPACE && !espacoPressionado) {
                    espacoPressionado = true;
                    labelStatus.setText("Agora pressione ENTER!");
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER && espacoPressionado && !jogadorAtirou[0]) {
                    // Jogador atirou com sucesso!
                    jogadorAtirou[0] = true;
                    resultado[0] = true;

                    labelInstrucao.setText("VOCÊ ACERTOU!");
                    labelInstrucao.setForeground(Color.GREEN);
                    labelStatus.setText("Pistoleiro derrotado!");

                    // POLIMORFISMO: chamando método atacar() e receberDano()
                    pistoleiro.receberDano(jogador.atacar());

                    Timer fechar = new Timer(2000, evt -> {
                        janelaDuelo.dispose();
                        mostrarResultado(true);
                    });
                    fechar.setRepeats(false);
                    fechar.start();
                }
            }
        });

        janelaDuelo.setVisible(true);

        return jogadorVenceu;
    }

    // Mostra o resultado do duelo
    private void mostrarResultado(boolean vitoria) {
        if (vitoria) {
            jogadorVenceu = true;

            String mensagem = "Você derrotou " + pistoleiro.getNome() + "!\n\n";
            mensagem += "Você pegou a arma dele: " + pistoleiro.getArmaAtual().getNome() + "\n";
            mensagem += pistoleiro.getArmaAtual().getDescricao();

            JOptionPane.showMessageDialog(
                null,
                mensagem,
                "VITÓRIA!",
                JOptionPane.INFORMATION_MESSAGE
            );

            // Adiciona a arma ao inventário do jogador
            jogador.adicionarArma(pistoleiro.getArmaAtual());
            jogador.incrementarPistoleirosderrotados();
            jogador.restaurarVida(); // Restaura vida para o próximo duelo

        } else {
            // Jogador perdeu
            int tentarNovamente = JOptionPane.showConfirmDialog(
                null,
                "Você foi derrotado!\nVida restante: " + jogador.getVida() + "\n\nTentar o duelo novamente?",
                "Derrota",
                JOptionPane.YES_NO_OPTION
            );

            if (tentarNovamente == JOptionPane.YES_OPTION) {
                jogador.restaurarVida(); // Restaura vida para tentar novamente
                jogadorVenceu = iniciar(); // Tenta novamente (recursão)
            } else {
                jogadorVenceu = false;
            }
        }
    }

    public boolean jogadorVenceu() {
        return jogadorVenceu;
    }
}
