/*
Ordenação de Grafos:
Por fim, implemente um algoritmo que ordene os vértices de um grafo de acordo com a topologia das conexões entre eles. 
Essa ordenação pode ser útil em diversas aplicações, como planejamento de projetos ou organização de tarefas interdependentes. 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Exercicio10 {

    static class Grafo {
        private Map<String, List<String>> adjacencias;

        public Grafo() {
            adjacencias = new HashMap<>();
        }

        public void adicionarVertice(String vertice) {
            adjacencias.putIfAbsent(vertice, new ArrayList<>());
        }

        public void adicionarAresta(String origem, String destino) {
            adicionarVertice(origem);
            adicionarVertice(destino);
            adjacencias.get(origem).add(destino);
        }

        public List<String> ordenacaoTopologica() {
            Map<String, Integer> grauEntrada = new HashMap<>();
            for (String vertice : adjacencias.keySet()) {
                grauEntrada.put(vertice, 0);
            }

            for (List<String> vizinhos : adjacencias.values()) {
                for (String vizinho : vizinhos) {
                    grauEntrada.put(vizinho, grauEntrada.get(vizinho) + 1);
                }
            }

            Queue<String> fila = new LinkedList<>();
            for (String vertice : adjacencias.keySet()) {
                if (grauEntrada.get(vertice) == 0) {
                    fila.add(vertice);
                }
            }

            List<String> resultado = new ArrayList<>();
            while (!fila.isEmpty()) {
                String vertice = fila.poll();
                resultado.add(vertice);

                if (adjacencias.containsKey(vertice)) {
                    for (String vizinho : adjacencias.get(vertice)) {
                        grauEntrada.put(vizinho, grauEntrada.get(vizinho) - 1);
                        if (grauEntrada.get(vizinho) == 0) {
                            fila.add(vizinho);
                        }
                    }
                }
            }

            if (resultado.size() != adjacencias.size()) {
                return new ArrayList<>();
            }

            return resultado;
        }
    }

    public static void main(String[] args) {
        Grafo projeto = new Grafo();

        projeto.adicionarAresta("Fundação", "Paredes");
        projeto.adicionarAresta("Paredes", "Telhado");
        projeto.adicionarAresta("Paredes", "Encanamento");
        projeto.adicionarAresta("Paredes", "Eletrica");
        projeto.adicionarAresta("Telhado", "Pintura");
        projeto.adicionarAresta("Encanamento", "Acabamento");
        projeto.adicionarAresta("Eletrica", "Acabamento");
        projeto.adicionarAresta("Acabamento", "Entrega das Chaves");
        projeto.adicionarAresta("Pintura", "Entrega das Chaves");

        List<String> cronograma = projeto.ordenacaoTopologica();

        if (cronograma.isEmpty()) {
            System.out.println("Erro: O grafo possui ciclo.");
        } else {
            System.out.println("Ordenação topológica: " + cronograma);
        }
    }
}