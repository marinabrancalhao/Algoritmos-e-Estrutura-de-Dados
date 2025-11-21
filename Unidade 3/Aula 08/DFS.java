import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

class DFS {

    //mapa de adjacências
    private Map<String, List<Aresta>> adjacencias;

    public DFS(){
        adjacencias = new HashMap<>();
    }

    public Map<String, Boolean> buscaPorProfundidade(String verticeInicial){

        Map<String, Boolean> visitados = new HashMap<>();

        for (String vertice : adjacencias.keySet()) {
            visitados.put(vertice, false);
            
        }

        dfs(verticeInicial, visitados);

        return visitados;

    }

    public void dfs(String vertice, Map<String, Boolean> visitados){
        visitados.put(vertice, true);
        System.out.print(vertice + " ");

        List<Aresta> vizinhos = adjacencias.get(vertice);
        for (Aresta aresta : vizinhos) {
            if (!visitados.get(aresta.getDestino())) {
                dfs(aresta.getDestino(), visitados);
                
            }
        }

    }

    

    //adiciona um novo vértice
    public void adicionarVertice(String rotulo){
        adjacencias.put(rotulo, new ArrayList<>());
    }

    //adiciona uma nova aresta
    public void adicionarAresta(String origem, String destino, int peso){
        if (!adjacencias.containsKey(origem)) {
            adicionarVertice(origem);
        }
        if (!adjacencias.containsKey(destino)) {
            adicionarVertice(destino);
        }
        
        adjacencias.get(origem).add(new Aresta(destino, peso));
    }

    //imprime o grafo completo
    public void imprimirGrafo(){
        for (String vertice: adjacencias.keySet()) {
            List<Aresta> arestas = adjacencias.get(vertice);
            System.out.print(vertice + " -> ");
            for (Aresta aresta : arestas) {
                System.out.print(aresta.getDestino() + "(" + aresta.getPeso() + ") ");
            }
            System.out.println();
        }
    }

    //classe que constroi a aresta
    private class Aresta{
        private String destino;
        private int peso;

        public Aresta(String destino, int peso){
            this.destino = destino;
            this.peso = peso;
        }

        public String getDestino() {
            return destino;
        }

        public int getPeso() {
            return peso;
        }
    }

    public static void main(String[] args) {
        
        DFS grafo = new DFS();

        //adicionando países no grafo
        grafo.adicionarVertice("Brasil");
        grafo.adicionarVertice("México");
        grafo.adicionarVertice("Alemanha");
        grafo.adicionarVertice("Portugal");
        grafo.adicionarVertice("Inglaterra");

        //adicionando conexões de países
        grafo.adicionarAresta("Brasil", "Japão", 5);
        grafo.adicionarAresta("Alemanha", "Portugal", 3);
        grafo.adicionarAresta("Portugal", "Alemanha", 5);
        grafo.adicionarAresta("Brasil", "México", 7);
        grafo.adicionarAresta("Inglaterra", "México", 2);

    grafo.buscaPorProfundidade("Brasil");
    }
}