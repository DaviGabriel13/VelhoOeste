import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
  Classe Jogo - Controlador Principal

  CONCEITOS POO: COMPOSIÇÃO e ORQUESTRAÇÃO
  - Contém e gerencia todos os objetos do jogo (Jogador, Pistoleiros, Fases)
  - Coordena a interação entre as diferentes classes
  - Demonstra o princípio de responsabilidade única: apenas controla o fluxo
*/
public class Jogo {
    // Atributos do jogo - COMPOSIÇÃO
    // O jogo "tem um" jogador e "tem vários" pistoleiros
    private Jogador jogador;
    private ArrayList<Pistoleiro> pistoleiros;
    private int pistoleiroAtual;
    private JFrame janelaPrincipal;

    /*
      Construtor - inicializa o jogo
      Cria todos os objetos necessários e inicia a interface
    */
    public Jogo() {
        inicializarJogo();
        criarInterface();
    }

    /*
      Inicializa os dados do jogo
      Cria o jogador e os pistoleiros
    */
    private void inicializarJogo() {
        // Pede o nome do jogador
        String nomeJogador = JOptionPane.showInputDialog(
            null,
            "Digite o nome do seu personagem:",
            "Velho Oeste - Busca por Vingança",
            JOptionPane.QUESTION_MESSAGE
        );

        if (nomeJogador == null || nomeJogador.trim().isEmpty()) {
            nomeJogador = "Pistoleiro Misterioso";
        }

        // Cria o jogador - INSTANCIAÇÃO de objeto
        jogador = new Jogador(nomeJogador);

        // Cria a lista de pistoleiros
        pistoleiros = new ArrayList<>();
        criarPistoleiros();

        pistoleiroAtual = 0;
    }

    /*
      Cria os pistoleiros do jogo
      Demonstra INSTANCIAÇÃO múltipla de objetos da mesma classe
    */
    private void criarPistoleiros() {
        // Pistoleiro 1 - Fácil
        Arma colt45 = new Arma("Colt 45", 15, "Um revólver confiável");
        String[] caminho1 = {"Frente", "Esquerda", "Frente"};
        Pistoleiro p1 = new Pistoleiro(
            "Joãozinho Lucas 'Mão Rápida'",
            1,
            colt45,
            caminho1,
            "Saloon da cidade de Dustville"
        );
        pistoleiros.add(p1);

        // Pistoleiro 2 - Médio
        Arma winchester = new Arma("Winchester 73", 25, "Rifle de repetição lendário");
        String[] caminho2 = {"Direita", "Frente", "Direita", "Esquerda"};
        Pistoleiro p2 = new Pistoleiro(
            "Inácinho 'Olho de Águia'",
            2,
            winchester,
            caminho2,
            "Mina abandonada nas montanhas"
        );
        pistoleiros.add(p2);

        // Pistoleiro 3 - Chefe Final (assassino da mãe)
        Arma peacemaker = new Arma("Peacemaker Dourada", 40, "A arma lendária do oeste");
        String[] caminho3 = {"Esquerda", "Esquerda", "Frente", "Direita", "Frente"};
        Pistoleiro p3 = new Pistoleiro(
            "Aluísio 'O Cruel'",
            3,
            peacemaker,
            caminho3,
            "Cemitério ao pôr do sol - onde sua mãe foi enterrada"
        );
        pistoleiros.add(p3);
    }

    // Cria a interface gráfica principal
    private void criarInterface() {
        janelaPrincipal = new JFrame("Velho Oeste - Busca por Vingança");
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setSize(600, 400);
        janelaPrincipal.setLocationRelativeTo(null);

        // Painel com cor temática do oeste
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBackground(new Color(210, 180, 140)); // Cor areia

        // Área de texto para história
        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setMargin(new Insets(15, 15, 15, 15));
        areaTexto.setBackground(new Color(245, 222, 179));

        String historia = "=== VELHO OESTE - BUSCA POR VINGANÇA ===\n\n";
        historia += "Você é " + jogador.getNome() + ", um pistoleiro em busca de vingança.\n\n";
        historia += "Há anos atrás, sua mãe foi morta por um pistoleiro cruel chamado Aluísio 'O Cruel'.\n\n";
        historia += "Para encontrá-lo, você precisa derrotar seus capangas e seguir as pistas.\n\n";
        historia += "Cada pistoleiro derrotado revelará a localização do próximo.\n\n";
        historia += "Sua jornada começa agora...\n\n";
        historia += "Boa sorte, pistoleiro!";

        areaTexto.setText(historia);

        JScrollPane scroll = new JScrollPane(areaTexto);
        painel.add(scroll, BorderLayout.CENTER);

        // Botão para começar
        JButton botaoIniciar = new JButton("INICIAR JORNADA");
        botaoIniciar.setFont(new Font("Arial", Font.BOLD, 16));
        botaoIniciar.setBackground(new Color(139, 69, 19));
        botaoIniciar.setForeground(Color.WHITE);
        botaoIniciar.addActionListener(e -> {
            janelaPrincipal.setVisible(false);
            enfrentarProximoPistoleiro();
        });

        painel.add(botaoIniciar, BorderLayout.SOUTH);

        janelaPrincipal.add(painel);
        janelaPrincipal.setVisible(true);
    }

    /*
      Lógica para enfrentar o próximo pistoleiro
      Demonstra como as classes interagem entre si
    */
    private void enfrentarProximoPistoleiro() {
        if (pistoleiroAtual >= pistoleiros.size()) {
            // Jogador venceu o jogo!
            jogoCompleto();
            return;
        }

        // POLIMORFISMO: pistoleiroAtual é um Personagem, mas acessamos métodos específicos
        Pistoleiro pistoleiro = pistoleiros.get(pistoleiroAtual);

        // Mostra informações do próximo alvo
        JOptionPane.showMessageDialog(
            null,
            "PRÓXIMO ALVO:\n\n" + pistoleiro.obterInformacoes(),
            "Novo Pistoleiro",
            JOptionPane.INFORMATION_MESSAGE
        );

        // FASE 1: Navegação - encontrar o pistoleiro
        FaseNavegacao faseNav = new FaseNavegacao(pistoleiro);
        boolean encontrou = faseNav.iniciar();

        if (!encontrou) {
            // Jogador desistiu
            int continuar = JOptionPane.showConfirmDialog(
                null,
                "Você desistiu de procurar " + pistoleiro.getNome() + ".\n\nTentar novamente?",
                "Desistência",
                JOptionPane.YES_NO_OPTION
            );

            if (continuar == JOptionPane.YES_OPTION) {
                enfrentarProximoPistoleiro(); // Tenta novamente
            } else {
                gameOver();
            }
            return;
        }

        // FASE 2: Duelo
        FaseDuelo faseDuelo = new FaseDuelo(jogador, pistoleiro);
        boolean venceu = faseDuelo.iniciar();

        if (venceu) {
            // Avança para o próximo pistoleiro
            pistoleiroAtual++;

            // Mostra status do jogador
            mostrarStatus();

            // Próximo desafio
            enfrentarProximoPistoleiro();
        } else {
            // Jogador perdeu ou desistiu
            gameOver();
        }
    }

    // Mostra o status atual do jogador
    private void mostrarStatus() {
        JOptionPane.showMessageDialog(
            null,
            jogador.obterInformacoes(), // Usa o método da classe Jogador
            "Status do Jogador",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Fim de jogo - jogador desistiu ou perdeu
    private void gameOver() {
        String mensagem = "=== GAME OVER ===\n\n";
        mensagem += jogador.obterInformacoes();
        mensagem += "\n\nSua jornada terminou aqui...";

        JOptionPane.showMessageDialog(
            null,
            mensagem,
            "Fim de Jogo",
            JOptionPane.ERROR_MESSAGE
        );

        System.exit(0);
    }

    // Jogo completo - jogador venceu todos os pistoleiros
    private void jogoCompleto() {
        String mensagem = "=== PARABÉNS! ===\n\n";
        mensagem += "Você derrotou todos os pistoleiros e vingou sua mãe!\n\n";
        mensagem += jogador.obterInformacoes();
        mensagem += "\n\n=== VITÓRIA COMPLETA ===";

        JOptionPane.showMessageDialog(
            null,
            mensagem,
            "JOGO COMPLETO!",
            JOptionPane.INFORMATION_MESSAGE
        );

        System.exit(0);
    }
}
