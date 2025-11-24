/*
Mínimo de uma BST:
Imagine que você está analisando uma árvore binária de busca para identificar o produto mais barato de uma lista.
Escreva um método que encontre o menor valor em uma árvore binária de busca, ajudando a determinar a melhor oferta disponível.
*/

public class Exercicio08 {

    static class Node {

        int preco;
        Node left, right;

        public Node(int preco){
            this.preco = preco;
            left = right = null;
        }
    }

    static class ArvoreProdutos {
        
        Node root;

        public void inserir(int preco){
            root = inserirRecursivo(root, preco);
        }

        private Node inserirRecursivo(Node atual, int preco){
            if (atual == null) {
                return new Node(preco);
            }

            if (preco < atual.preco) {
                atual.left = inserirRecursivo(atual.left, preco);
            } else if (preco > atual.preco) {
                atual.right = inserirRecursivo(atual.right, preco);
            }

            return atual;
        }

        public int encontrarMenorPreco(){

            if (root == null) {
                System.out.println("Árvore vazia...");
                return -1;
            }

            Node atual = root;

            while (atual.left != null) {
                atual = atual.left;
            }

            return atual.preco;

        }
        
    }

    public static void main(String[] args) {

        ArvoreProdutos loja = new ArvoreProdutos();

        loja.inserir(50);
        loja.inserir(30);
        loja.inserir(20);
        loja.inserir(40);
        loja.inserir(70);
        loja.inserir(10);
        loja.inserir(80);

        int menorPreco = loja.encontrarMenorPreco();
        System.out.println("O produto mais barato custa: R$ " + menorPreco);
        
    }
    
}