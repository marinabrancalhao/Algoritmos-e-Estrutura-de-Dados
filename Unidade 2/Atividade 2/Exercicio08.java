/*
Contagem de Palavras: Você precisa criar uma análise de palavras usadas em um artigo para entender quais termos aparecem com maior frequência. 
Escreva um programa que conte a frequência de cada palavra em uma frase, utilizando um HashMap, para identificar as palavras mais comuns.  
*/

import java.util.HashMap;
import java.util.Map;

public class Exercicio08 {
    public static void main(String[] args) {
        
        String frase = "O tempo perguntou pro tempo quanto tempo o tempo tem";
        
        String[] palavras = frase.toLowerCase().split(" ");

        Map<String, Integer> contador = new HashMap<>();

        for (String palavra : palavras) {
            if (contador.containsKey(palavra)) {
                contador.put(palavra, contador.get(palavra) + 1);
            } else {
                contador.put(palavra, 1);
            } 
        }

        int maiorValor = 0;
        for (Integer valor : contador.values()) {
            if (valor > maiorValor) {
                maiorValor = valor;
            }
        }

        System.out.print("Palavra mais frequente: ");
        for (String chave : contador.keySet()) {
            if (contador.get(chave) == maiorValor){
                System.out.println(chave);
            }  
        }

        System.out.println("Repete " + maiorValor + " vezes");
    }
  
}