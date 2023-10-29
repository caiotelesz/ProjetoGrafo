package application;

import grafo.*;

import javax.swing.*;
import java.util.*;
public class Main {

    static ArrayList<Corredor> corredores = new ArrayList<Corredor>();
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JOptionPane.showMessageDialog(null, "Seja bem vindo ao programa");
        String[] opcao = {"3 Corredores", "5 Corredores", "7 Corredores", "10 Corredores"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha quantos corredores desejam correr: ", "Total de Corredores",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[3]);

        if (escolha == 0) {  // Se o usuário selecionar a opção 3 corredores, vetor será igual à 0 e o valor total corredores igual à 3
            totalCorredores(3);
        } else if (escolha == 1) {
            totalCorredores(5);
        } else if (escolha == 2) {
            totalCorredores(7);
        } else if (escolha == 3) {
            totalCorredores(10);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Esta linha garante que o programa encerrará quando a janela for fechada
    }

    private static void totalCorredores(int n) {
        Corredor corredor;
        GrafoCorrida grafo = new GrafoCorrida();

        int run = 1; // Exibição melhor para o usuário digitar
        for(int i = 0; i < n; i++) { // loop para adicionar os corredores
            corredor = new Corredor(JOptionPane.showInputDialog("Digite o nome do " + run + "º corredor "), new int[]{numeroAleatorio(), numeroAleatorio()});
            corredores.add(corredor);
            run++;
        }

        TrechoPista trechoA = new TrechoPista("A", 10); // trecho da pista A será de 10 km
        TrechoPista trechoB = new TrechoPista("B", 20); // trecho da pista B será de 20 km

//      Adicionando esses trechos no grafo
        grafo.adicionarTrecho(trechoA);
        grafo.adicionarTrecho(trechoB);


        for (int i = 0; i < n; i++) {

            // Adicionara o corredor, o trecho e o tempo dele
            grafo.adicionarCorredor(corredores.get(i), trechoA, corredores.get(i).getTempo(0));
            grafo.adicionarCorredor(corredores.get(i), trechoB, corredores.get(i).getTempo(1));

            // Calcula e armazena os tempos para o Trecho A e B
            int tempoTrechoA = corredores.get(i).getTempo(0);
            int tempoTrechoB = corredores.get(i).getTempo(1);

            int tempoTotal = tempoTrechoA + tempoTrechoB;

            // Armazena o tempo total no corredor
            corredores.get(i).setTempoTotal(tempoTotal);
        }

        // Classifique os corredores pelo tempo total
        corredores.sort(Comparator.comparingInt(Corredor::getTempoTotal));

        // Exiba os 3 primeiros ganhadores da corrida
        JOptionPane.showMessageDialog(null,
                "Vencedor da corrida: " + corredores.get(0).getNome() + " com " + corredores.get(0).getTempoTotal() + " minutos\n" +
                "Segundo colocado: " + corredores.get(1).getNome() + " com " + corredores.get(1).getTempoTotal() + " minutos\n" +
                "Terceiro colocado: " + corredores.get(2).getNome() + " com " + corredores.get(2).getTempoTotal() + " minutos");
    }

    // Gerador de minutos percorridos
    public static int numeroAleatorio() {
        Random rand = new Random();
        int num = rand.nextInt(10, 60);
        return num;
    }
}