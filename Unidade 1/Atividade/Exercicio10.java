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

        public int getQuantidadeEstoque() {
            return quantidadeEstoque;
        }

        public void setQuantidadeEstoque(int novaQuantidade) {
            this.quantidadeEstoque = novaQuantidade;
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
                    scanner.nextLine();

                    Produto novoProduto = new Produto(id, nome, categoria, preco, quantidadeEstoque);
                    
                    produtos.add(novoProduto);

                    System.out.println("\nO produto '" + nome + "' foi adicionado com sucesso!\n");

                    break;

                case 2:

                    if (produtos.isEmpty()) {
                        System.out.println("\nEstoque vazio... não há nada para remover.\n");
                        break;
                    }
                    
                    System.out.println("\n--- Produtos em Estoque ---)");
                    for (Produto produto : produtos) {
                        produto.exibirNomeEId();
                        System.out.println("--------------------------------------------------------------------");
                        
                    }

                    System.out.print("Digite o ID do produto que deseja remover: #");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();

                    Produto produtoRemover = null;

                    for (Produto produto : produtos) {
                        if (produto.getId() == idRemover) {
                            produtoRemover = produto;
                            break;
                        }
                    }

                    if (produtoRemover != null) {
                        produtos.remove(produtoRemover);
                        System.out.println("\nProduto '" + produtoRemover.getNome() + "' removido com sucesso!\n");
                    } else {
                     System.out.println("\nID #" + idRemover + " não encontrado.\n");       
                    }

                    break;
                
                case 3:

                    if (produtos.isEmpty()) {
                    System.out.println("\nEstoque vazio... Adicione um produto primeiro.\n");
                    break;
                    }

                    System.out.println("\n--- Produtos em Estoque ---");
                    for (Produto produto : produtos) {
                        System.out.println(produto);
                        System.out.println("--------------------------------------------------------------------");
                        
                    }

                    System.out.print("Digite o ID do produto que deseja dar entrada no estoque: #");
                    int idEntrada = scanner.nextInt();
                    scanner.nextLine();

                    Produto produtoEntrada =  null;
                    for (Produto produto : produtos) {
                        if (produto.getId() == idEntrada) {
                            produtoEntrada = produto;
                            break;
                        }
                    }

                    if (produtoEntrada != null) {
                        System.out.println("Produto selecionado: " + produtoEntrada.getNome());
                        System.out.print("Digite a quantidade que deseja adicionar: ");
                        int quantidadeEntrada = scanner.nextInt();
                        scanner.nextLine();

                        int estoqueAtual = produtoEntrada.getQuantidadeEstoque();
                        int novoEstoque = estoqueAtual + quantidadeEntrada;
                        produtoEntrada.setQuantidadeEstoque(novoEstoque);

                        System.out.println("\nEstoque atualizado! Novo total: " + novoEstoque + " unidades.\n");
                    } else {
                        System.out.println("\nID #" + idEntrada + " não encontrado.\n");
                    }
                    
                    break;

                case 4:
                    
                    if (produtos.isEmpty()) {
                    System.out.println("\nEstoque vazio... Adicione um produto primeiro.\n");
                    break;
                    }

                    System.out.println("\n--- Produtos em Estoque ---");
                    for (Produto produto : produtos) {
                    System.out.println(produto);
                    System.out.println("--------------------------------------------------------------------");
                    }

                    System.out.print("Digite o ID do produto que deseja dar saída do estoque: #");
                    int idSaida = scanner.nextInt();
                    scanner.nextLine();

                    Produto produtoSaida = null;
                    for (Produto produto : produtos) {
                        if (produto.getId() == idSaida) {
                        produtoSaida = produto;
                        break;
                }
            }

            if (produtoSaida != null) {
                System.out.println("Produto selecionado: " + produtoSaida.getNome());
                
                int estoqueAtual = produtoSaida.getQuantidadeEstoque();

                System.out.print("Digite a quantidade que deseja dar saída: ");
                int quantidadeSaida = scanner.nextInt();
                scanner.nextLine();

                if (quantidadeSaida > estoqueAtual) {
                    System.out.println("\nErro: Não é possível remover " + quantidadeSaida + " unidades.");
                    System.out.println("Você só tem " + estoqueAtual + " em estoque.\n");
                } else {
                    int novoEstoque = estoqueAtual - quantidadeSaida;
                    produtoSaida.setQuantidadeEstoque(novoEstoque);
                    System.out.println("\nEstoque atualizado! Novo total: " + novoEstoque + " unidades.\n");
                }

            } else {
                System.out.println("\nID #" + idSaida + " não encontrado.\n");
            }
            break;

                case 5:

                    if (produtos.isEmpty()) {
                    System.out.println("\nEstoque vazio... Adicione um produto primeiro.\n");
                    break;
                    }

                    System.out.println("\n--- Produtos em Estoque ---");
                    for (Produto produto : produtos) {
                        System.out.println(produto);
                        System.out.println("--------------------------------------------------------------------"); 
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
