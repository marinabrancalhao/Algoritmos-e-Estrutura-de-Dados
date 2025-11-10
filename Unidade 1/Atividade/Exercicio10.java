/*
Exercício 10: Desafio Final - Sistema de Gerenciamento de Estoque para uma Loja

Desenvolva um sistema completo de gerenciamento de estoque para uma loja. 
Permita que o usuário adicione, remova e atualize itens no estoque, usando classes para representar os produtos e listas para organizar os itens cadastrados. 
Esse sistema ajudará na administração dos produtos disponíveis para venda.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio10 {
    
    static class Produto {
        
        private int id;
        private String nome;
        private String categoria;
        private float preco;
        private int quantidadeEstoque;

        public Produto(int id, String nome, String categoria, float preco, int quantidadeEstoque){
            this.id = id;
            this.nome = nome;
            this.categoria = categoria;
            this.preco = preco;
            this.quantidadeEstoque = quantidadeEstoque;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public void exibirNomeEId(){
            System.out.println("ID #" + this.id + " | Produto: " + this.nome);
        }

        @Override
        public String toString() {
            return "ID #" + this.id + " | Produto: " + this.nome +
                    "\nCategoria: " + this.categoria + "     " +
                    "Preço: R$" + this.preco + "     " + 
                    "Quantidade em estoque: " + this.quantidadeEstoque;
        }
    }

    public static void main(String[] args) {

        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcaoDesejada = 0;

        System.out.println("\n== GERENCIADOR DE ESTOQUE ==\n");

        do{
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Realizar entrada no estoque");
            System.out.println("4. Realizar saída no estoque");
            System.out.println("5. Gerar relatório de estoque");
            System.out.println("0. Sair");
            
            System.out.print("\nEscolha a opção desejada: ");
            opcaoDesejada = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoDesejada) {
                case 1:

                    System.out.print("\nID do produto: #");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Categoria do produto: ");
                    String categoria = scanner.nextLine();

                    System.out.print("Preço do produto: R$ ");
                    float preco = scanner.nextFloat();

                    System.out.print("Quantidade deste produto em estoque: ");
                    int quantidadeEstoque = scanner.nextInt();

                    Produto novoProduto = new Produto(id, nome, categoria, preco, quantidadeEstoque);
                    
                    produtos.add(novoProduto);

                    System.out.println("\nO produto " + nome + " foi adicionado com sucesso!\n");

                    break;

                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;   
                case 5:
                    System.out.println("\n--- Produtos em Estoque ---");
                    for (Produto produto : produtos) {
                        System.out.println(produto);
                        System.out.println("--------------------------------------------------"); 
                    }
                    break;

                case 0:
                    System.out.println("\nEncerrando o programa... \n");
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente...\n");
                    break;
            }


        } while(opcaoDesejada != 0);
        
    }


}
