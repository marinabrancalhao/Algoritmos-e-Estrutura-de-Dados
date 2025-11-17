/*
Inversão com Pilha: Suponha que você está desenvolvendo uma ferramenta que permite ao usuário visualizar uma lista de produtos na ordem inversa da inserção original. 
Implemente um método que utilize uma pilha para inverter a ordem dos elementos de uma lista de produtos (ArrayList)
*/

import java.util.ArrayList;
import java.util.Stack;

public class Exercicio05 {

    public static void inverterLista(ArrayList<String> produtos){

        Stack<String> pilha = new Stack<>();

        for (String produto : produtos) {
            pilha.push(produto);
        }

        produtos.clear();

        while (!pilha.isEmpty()) {
            produtos.add(pilha.pop()); 
        }

    }
    public static void main(String[] args) {

        ArrayList<String> produtos = new ArrayList<>();

        produtos.add("Mouse");
        produtos.add("Teclado");
        produtos.add("Monitor");
        produtos.add("Impressora");
        produtos.add("Webcam");

        System.out.println("-- Lista de produtos --");
        for (String produto : produtos) {
            System.out.println(produto);
        }

        inverterLista(produtos);

        System.out.println("\n-- Lista de produtos invertida --");
        for (String produto : produtos) {
            System.out.println(produto);
        }  
    }
}
