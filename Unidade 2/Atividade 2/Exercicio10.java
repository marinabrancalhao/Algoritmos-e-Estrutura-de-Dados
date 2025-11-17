/*
Implementação de Algoritmo de Ordenação: Imagine que você está desenvolvendo um sistema de classificação que exibe os produtos mais populares em uma loja online. 
Escolha um algoritmo de ordenação (ex: Bubble Sort, Quick Sort, Merge Sort) e implemente-o para ordenar uma lista de produtos com base nas vendas, de forma decrescente, para que os mais vendidos apareçam primeiro.
*/

import java.util.ArrayList;

public class Exercicio10 {

    static class Produto {
        
        private String nome;
        private int numeroVendas;

        Produto(String nome, int numeroVendas){
            this.nome = nome;
            this.numeroVendas = numeroVendas;
        } 

        public String getNome() {
            return nome;
        }

        public int getNumeroVendas() {
            return numeroVendas;
        }

        @Override
        public String toString() {
            return "Produto: " + nome + " | Número de vendas: " + numeroVendas;
        }
        
    }

    public static void ordenarDecrescente(ArrayList<Produto> produtos){ //BubbleSort
        
        boolean swap;

        for(int i = 0; i < produtos.size() - 1; i++){
            swap = false;
            for(int j = 0; j < produtos.size() - i - 1; j++){
                if (produtos.get(j).getNumeroVendas() < produtos.get(j + 1).getNumeroVendas()) {
                    Produto temp = produtos.get(j);
                    produtos.set(j, produtos.get(j + 1));
                    produtos.set(j + 1, temp);
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }

    }
    public static void main(String[] args) {

        Produto produto1 = new Produto("Notebook", 78);
        Produto produto2 = new Produto("Televisão", 23);
        Produto produto3 = new Produto("Air-fryer", 122);
        Produto produto4 = new Produto("Geladeira", 12);
        Produto produto5 = new Produto("Secador", 54);

        ArrayList<Produto> produtos = new ArrayList<>();

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);

        System.out.println("Lista desordenada: ");
        for (Produto produto : produtos) {
        System.out.println(produto);   
        }

        ordenarDecrescente(produtos);

        System.out.println("\nLista em ordem decrescente: ");
        for (Produto produto : produtos) {
        System.out.println(produto);   
        }
    }
}
