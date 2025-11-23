package Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoSabores {
    
    private Map<String, List<String>> adjacencias;

    public GrafoSabores(){
        adjacencias = new HashMap<>();
    }

    public void adicionarVertice(String sabor){
        adjacencias.putIfAbsent(sabor, new ArrayList<>());
    }

    public void adicionarAresta(String sabor1, String sabor2){


        if (!adjacencias.containsKey(sabor1)) {
            adicionarVertice(sabor1);
        }
        if (!adjacencias.containsKey(sabor2)) {
            adicionarVertice(sabor2);
        }

        if (!adjacencias.get(sabor2).contains(sabor1)) {
            adjacencias.get(sabor2).add(sabor1);
        }
        if (!adjacencias.get(sabor1).contains(sabor2)) {
            adjacencias.get(sabor1).add(sabor2);
        }
    }

    public void imprimirGrafo() {
        
        System.out.println("\n----------------------- Combinação de Sabores -----------------------");

        if (adjacencias.isEmpty()) {
            System.out.println("\nNenhuma combinação registrada...");            
        } else {

            for (String sabor : adjacencias.keySet()) {
                System.out.print("\nQuem pede " + sabor + " também pede: " + adjacencias.get(sabor));
            }
        }

        System.out.println();
        System.out.println("\n---------------------------------------------------------------------\n");

        
    }

}



