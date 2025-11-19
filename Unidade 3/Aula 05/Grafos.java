import java.util.LinkedList;

public class Grafos {
    
    private int vertices;
    private LinkedList<Integer> conexoes[];

    Grafos(int v){ //grafo
        vertices = v;
        conexoes = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            conexoes[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){ //conexão entre os vértices
        conexoes[v].add(w);
        conexoes[w].add(v);
    }

    public static void main(String[] args) {
        Grafos grafo = new Grafos(5);

        grafo.addEdge(0, 1);
        grafo.addEdge(2, 4);
        grafo.addEdge(0, 3);
        grafo.addEdge(1, 4);

        System.out.println(grafo.vertices);
        System.out.println(grafo.conexoes[0]);
        System.out.println(grafo.conexoes[1]);
        System.out.println(grafo.conexoes[2]);
        System.out.println(grafo.conexoes[3]);
        System.out.println(grafo.conexoes[4]);
    }
    
}
