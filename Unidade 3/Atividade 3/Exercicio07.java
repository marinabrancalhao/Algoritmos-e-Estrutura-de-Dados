/*
DFS em Grafos:
Continuando no seu aplicativo de navegação, escreva um método para realizar a Busca em Profundidade (DFS) em um grafo.
Esse método deve exibir todos os vértices visitados, permitindo que os usuários visualizem as possíveis rotas de maneira mais detalhada. 
*/

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Exercicio07 {

    static class Grafo {
        
        private Map<String, List<String>> adjacencias;

        public Grafo(){
            adjacencias = new HashMap<>();
        }

        public void adicionarVertice(String local){
            if (!adjacencias.containsKey(local)) {
                adjacencias.put(local, new ArrayList<>());    
            }
            
        }

        public void adicionarAresta(String origem, String destino){
            if (!adjacencias.containsKey(origem)) {
                adjacencias.put(origem, new ArrayList<>());
            }
            if (!adjacencias.containsKey(destino)) {
                adjacencias.put(destino, new ArrayList<>());
            }

            adjacencias.get(origem).add(destino);
            adjacencias.get(destino).add(origem);
        }

        public void imprimirGrafo(){
            for (String local : adjacencias.keySet()) {
                System.out.println(local + "->" + adjacencias.get(local));
            }
            System.out.println();
        }

        public void realizarDFS(String pontoPartida) {

            Set<String> visitados = new HashSet<>();
            dfsRecursivo(pontoPartida, visitados);
            
        }

        private void dfsRecursivo(String atual, Set<String> visitados) {
            
            visitados.add(atual);
            System.out.print(atual + " -> ");

            List<String> vizinhos = adjacencias.get(atual);
            
            if (vizinhos != null) {
                for (String vizinho : vizinhos) {
                    if (!visitados.contains(vizinho)) {
                        dfsRecursivo(vizinho, visitados);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Grafo bairroCentral = new Grafo();

        bairroCentral.adicionarVertice("Terreno Baldio");

        bairroCentral.adicionarAresta("Estação Central", "Shopping");
        bairroCentral.adicionarAresta("Shopping", "Cinema");
        bairroCentral.adicionarAresta("Shopping", "Praça de Alimentação");
        bairroCentral.adicionarAresta("Estação Central", "Universidade");
        bairroCentral.adicionarAresta("Universidade", "Biblioteca");
        bairroCentral.adicionarAresta("Biblioteca", "Papelaria");

        bairroCentral.imprimirGrafo(); 

        bairroCentral.realizarDFS("Estação Central");
    }
    
}
