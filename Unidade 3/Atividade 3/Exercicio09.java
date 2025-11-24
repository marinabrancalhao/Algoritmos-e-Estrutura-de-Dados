/*
Caminho Mais Curto em Grafo Ponderado:
Ao modificar seu algoritmo BFS, você precisa encontrar o caminho mais curto entre dois pontos em um grafo ponderado, considerando as distâncias. 
Esse ajuste é crucial para garantir que os usuários recebam as rotas mais eficientes. 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;

public class Exercicio09 {

    static class Grafo {
        // O Mapa mudou: Agora é String -> (Vizinho -> Peso)
        // Ex: "Casa" -> { "Padaria": 10, "Trabalho": 20 }
        private Map<String, Map<String, Integer>> adjacencias; 

        public Grafo() {
            adjacencias = new HashMap<>();
        }

        public void adicionarVertice(String vertice) {
            adjacencias.putIfAbsent(vertice, new HashMap<>());
        }

        public void adicionarAresta(String origem, String destino, int peso) {
            // Garante que os locais existem
            adicionarVertice(origem);
            adicionarVertice(destino);
            
            // Cria a conexão com PESO (distância)
            adjacencias.get(origem).put(destino, peso);
            adjacencias.get(destino).put(origem, peso); // Grafo não direcionado
        }

        // O Algoritmo de Dijkstra (Cópia da lógica do professor)
        public List<String> buscaCaminhoMaisCurto(String origem, String destino) {
            Map<String, Integer> distancia = new HashMap<>();
            Map<String, String> predecessores = new HashMap<>();
            
            // Fila que organiza quem tem o MENOR peso primeiro
            PriorityQueue<String> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancia::get));

            // Inicialização (Infinito)
            for (String vertice : adjacencias.keySet()) {
                distancia.put(vertice, Integer.MAX_VALUE);
                predecessores.put(vertice, null); // null = sem pai
            }

            distancia.put(origem, 0);
            filaPrioridade.add(origem);

            while (!filaPrioridade.isEmpty()) {
                String atual = filaPrioridade.poll();

                // Se chegamos no destino, pode parar (Otimização)
                if (atual.equals(destino)) break;

                // Olha os vizinhos
                for (String vizinho : adjacencias.get(atual).keySet()) {
                    // Custo novo = Custo até aqui + Peso da estrada
                    int novaDistancia = distancia.get(atual) + adjacencias.get(atual).get(vizinho);
                    
                    // Se achou um atalho...
                    if (novaDistancia < distancia.get(vizinho)) {
                        distancia.put(vizinho, novaDistancia);
                        predecessores.put(vizinho, atual);
                        filaPrioridade.add(vizinho);
                    }
                }
            }

            // Reconstruir o caminho de volta
            if (distancia.get(destino) == Integer.MAX_VALUE) {
                return new ArrayList<>(); // Não achou caminho
            }

            List<String> caminho = new ArrayList<>();
            String noAtual = destino;
            while (noAtual != null) {
                caminho.add(noAtual);
                noAtual = predecessores.get(noAtual);
            }

            Collections.reverse(caminho);
            return caminho;
        }
    }

    public static void main(String[] args) {
        Grafo gps = new Grafo();

        // Cenário: O Atalho
        // Caminho Direto (A -> B) é longe: 10km
        // Caminho com Escala (A -> C -> B) é perto: 2km + 1km = 3km
        
        gps.adicionarAresta("Casa", "Trabalho", 10);
        gps.adicionarAresta("Casa", "Padaria", 2);
        gps.adicionarAresta("Padaria", "Trabalho", 1);

        String inicio = "Casa";
        String fim = "Trabalho";

        System.out.println("Calculando rota GPS de " + inicio + " para " + fim + "...");
        List<String> rota = gps.buscaCaminhoMaisCurto(inicio, fim);

        if (rota.isEmpty()) {
            System.out.println("Não há caminho!");
        } else {
            System.out.println("Melhor rota encontrada (Menor Distância): " + rota);
        }
    }
}