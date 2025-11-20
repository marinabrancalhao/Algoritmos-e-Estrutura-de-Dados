/*
Representação de Grafos:
Você está desenvolvendo um sistema de roteamento para um aplicativo de navegação.
Crie uma classe que represente um grafo em Java, utilizando lista de adjacências ou matriz de adjacências, para mapear as conexões entre diferentes locais. 
*/

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Exercicio05 {

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
    }
    
}
