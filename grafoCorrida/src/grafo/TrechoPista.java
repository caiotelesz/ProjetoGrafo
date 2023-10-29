package grafo;

// Trecho da Pista = aresta
public class TrechoPista {
    private String id;
    private int distancia; // em quilômetros

//  Método construtor alternativo (com 2 parametro)
    public TrechoPista(String id, int distancia) {
        this.id = id;
        this.distancia = distancia;
    }

    public String getId() {
        return id;
    }

    public int getDistancia() {
        return distancia;
    }
}