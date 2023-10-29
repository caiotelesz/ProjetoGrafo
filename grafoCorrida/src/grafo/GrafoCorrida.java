package grafo;

import java.util.HashMap;
import java.util.Map;

// Grafo da corrida = grafo
public class GrafoCorrida {
    private Map<TrechoPista, Map<Corredor, Integer>> arestas;

//    Método Construtor
    public GrafoCorrida() {
        arestas = new HashMap<>();
    }

//    Método para adicionar um trecho de pista ao grafo
    public void adicionarTrecho(TrechoPista trecho) {
        arestas.put(trecho, new HashMap<>());
    }

//    Método para associar um corredor a um trecho de pista com um tempo
//    (pegará o trecho (a/b) e estará colocando o nome do corredor e o tempo percorrido por ele)
    public void adicionarCorredor(Corredor corredor, TrechoPista trecho, int tempo) {
        arestas.get(trecho).put(corredor, tempo);
    }

//    Método para obter o tempo de um corredor em um trecho de pista
    public int getTempo(Corredor corredor, TrechoPista trecho) {
        return arestas.get(trecho).get(corredor);
    }
}