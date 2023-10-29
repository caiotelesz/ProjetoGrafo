package grafo;

// grafo.Corredor = Vértice
public class Corredor {
    private String nome;
    private int[] tempos; // Array de tempos para cada trecho de pista
    private int tempoTotal;

//    Método construtor padrão
    public Corredor() {
    }

//    Método construtor alternativo (2 parametro)
    public Corredor(String nome, int[] tempos) {
        this.nome = nome;
        this.tempos = tempos;
    }

//    Método de Acesso
    public String getNome() {
        return nome;
    }

    public int getTempo(int trecho) {
        return tempos[trecho];
    }

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(int tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

//    Método toString

    @Override
    public String toString() {
        return "O grafo.Corredor " + nome + " percorreu por " + tempoTotal + " minutos";
    }
}