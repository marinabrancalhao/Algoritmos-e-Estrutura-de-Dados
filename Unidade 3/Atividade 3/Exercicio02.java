/*
Validação de BST:
Suponha que você tenha uma árvore que armazena a hierarquia de categorias de produtos em um e-commerce.
Escreva um método que verifique se essa árvore binária é uma árvore binária de busca (BST), garantindo que os produtos estejam organizados corretamente para facilitar a busca e navegação. 
*/

public class Exercicio02 {

    static class Node{
        int codigo;
        String categoriaProduto;
        Node left, right;

        public Node(int codigo, String categoriaProduto){
            this.codigo = codigo;
            this.categoriaProduto = categoriaProduto;
            left = right = null;
        }
    }

    static class ArvoreBinaria{
        Node root;

        public ArvoreBinaria(){
            root = null;
        }
    

    public boolean verificarBST(){
        return validarRecursivo(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validarRecursivo(Node noAtual, int min, int max){
        if (noAtual == null) {
            return true;
        }

        if (noAtual.codigo < min || noAtual.codigo > max) {
            return false;
        }

        return validarRecursivo(noAtual.left, min, noAtual.codigo -1) &&
                validarRecursivo(noAtual.right, noAtual.codigo + 1, max);
    
    }
}
    public static void main(String[] args) {

        ArvoreBinaria ecommerce = new ArvoreBinaria();

        System.out.println("--- TESTE 1: Árvore Válida ---");
        ecommerce.root = new Node(50, "Eletrônicos");
        ecommerce.root.left = new Node(20, "Celulares");
        ecommerce.root.right = new Node(80, "Computadores");

        System.out.println("A árvore é binária é uma BST? ");
        System.out.println((ecommerce.verificarBST() ? "Sim" : "Não"));

        System.out.println("--- TESTE 2: Árvore Inválida ---");
        ecommerce.root.left.right = new Node(90, "TV 8K");
        System.out.println("A árvore é binária é uma BST? ");
        System.out.println((ecommerce.verificarBST() ? "Sim" : "Não")); 
        
    }
    
}
