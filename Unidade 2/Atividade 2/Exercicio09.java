/*
Mesclar Mapas: Em um sistema de inventário, você tem dois registros de produtos e deseja mesclar as informações. 
Implemente um método para mesclar dois mapas (HashMaps) de produtos, cuidando para tratar possíveis conflitos de chaves. 
*/

import java.util.HashMap;
import java.util.Map;

public class Exercicio09 {
    public static void main(String[] args) {

        Map<String, Integer> estoque1 = new HashMap<>();
        estoque1.put("Caderno", 10);
        estoque1.put("Lápis", 15);
        estoque1.put("Agenda", 3);

        System.out.println("Estoque 1: " + estoque1);

        Map<String, Integer> estoque2 = new HashMap<>();
        estoque2.put("Agenda", 2);
        estoque2.put("Caneta", 12);
        estoque2.put("Borracha", 8);

        System.out.println("Estoque 2: " + estoque2);

        for (String produto : estoque2.keySet()) {

            int quantidadeEstoque2 = estoque2.get(produto);

            if (estoque1.containsKey(produto)) {
                int quantidadeEstoque1 = estoque1.get(produto);
                estoque1.put(produto, quantidadeEstoque1 + quantidadeEstoque2);
            } else {
                estoque1.put(produto, quantidadeEstoque2);
            }
            
        }

        System.out.println("\nEstoque Unificado: " + estoque1);
    
        
    }
}
