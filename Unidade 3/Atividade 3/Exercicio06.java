/*
BFS em Grafos:
No contexto do seu aplicativo de navegação, implemente o algoritmo de Busca em Largura (BFS) para encontrar o caminho mais curto entre dois pontos em um grafo não ponderado, ajudando os usuários a escolherem a melhor rota. 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Exercicio06 {

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

        public void buscarCaminho(String origem, String destino){
            Queue<String> fila = new LinkedList<>();
            Map<String, String> visitados = new HashMap<>();

            fila.add(origem);
            visitados.put(origem, null);

            while (!fila.isEmpty()) {
                String atual = fila.poll();

                if (atual.equals(destino)) {
                    reconstruirCaminho(visitados, destino);
                    return;
                }

                if (!adjacencias.containsKey(atual)) continue;

                for (String vizinho : adjacencias.get(atual)) {
                    if (!visitados.containsKey(vizinho)) {
                        visitados.put(vizinho, atual);
                        fila.add(vizinho);
                    }
                }
            
            }

            System.out.println("Não existe caminho");
        }

        private void reconstruirCaminho(Map<String, String> visitados, String fim){
            List<String> rota = new ArrayList<>();
            String passo = fim;

            while (passo != null) {
                rota.add(0, passo);
                passo = visitados.get(passo);
            }

            System.out.println("Rota mais curta encontrada: " + rota);

        }

    }

    public static void main(String[] args) {

        Grafo rotas = new Grafo();

        rotas.adicionarAresta("Casa", "Padaria");
        rotas.adicionarAresta("Casa", "Posto");
        rotas.adicionarAresta("Padaria", "Trabalho");
        rotas.adicionarAresta("Posto", "Shopping");
        rotas.adicionarAresta("Trabalho", "Shopping"); 

        System.out.println("--- CONEXÕES ---");
        rotas.imprimirGrafo();

        System.out.println("--- NAVEGAÇÃO ---");
        
        System.out.println("Calculando rota: Casa -> Shopping");
        rotas.buscarCaminho("Casa", "Shopping");

        // Teste 2: Caminho impossível (Ilha deserta)
        rotas.adicionarVertice("Bairro Novo");
        System.out.println("\nCalculando rota: Casa -> Bairro Novo");
        rotas.buscarCaminho("Casa", "Bairro Novo");
    }
}
