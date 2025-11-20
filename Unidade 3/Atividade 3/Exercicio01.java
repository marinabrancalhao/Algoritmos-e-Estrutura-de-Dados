/*
Implementação da Árvore Binária:
Imagine que você está desenvolvendo um sistema de gerenciamento de bibliotecas.
Crie uma classe em Java para representar uma árvore binária, onde cada nó armazenará informações sobre um livro.
Implemente métodos que permitam inserir novos livros e percorrer a árvore em pré-ordem, pós-ordem e em ordem para listar todos os livros disponíveis. 
*/

public class Exercicio01 {

    static class Node{
        int id;
        String titulo;
        Node left, right;

        public Node(int id, String titulo){
            this.id = id;
            this.titulo = titulo;
            left = right = null;
        }
    }

    static class ArvoreBinaria {
        Node root;

        public ArvoreBinaria(){
            root = null;
        }

        private Node inserirRecursivo(Node noAtual, int id, String titulo){
            if (noAtual == null) {
                return new Node(id, titulo);
            }
            if (id < noAtual.id) {
                noAtual.left = inserirRecursivo(noAtual.left, id, titulo);
            } else if (id > noAtual.id) {
                noAtual.right = inserirRecursivo(noAtual.right, id, titulo);
            }

            return noAtual;
        }

        public void inserir(int id, String titulo){
            root = inserirRecursivo(root, id, titulo);
        }

        public void preOrdem(Node noAtual){
            if (noAtual == null) {
                return;  
            }
            
            System.out.println("ID: " + noAtual.id + " | Título: " + noAtual.titulo);
            preOrdem(noAtual.left);
            preOrdem(noAtual.right);
        }

        public void emOrdem(Node noAtual){
            if (noAtual == null) {
                return; 
            }
            
            emOrdem(noAtual.left);
            System.out.println("ID: " + noAtual.id + " | Título: " + noAtual.titulo);
            emOrdem(noAtual.right);
        }

        public void posOrdem(Node noAtual){
            if (noAtual == null) {
                return; 
            }
            
            posOrdem(noAtual.left);
            posOrdem(noAtual.right);
            System.out.println("ID: " + noAtual.id + " | Título: " + noAtual.titulo);
        }
    }

    public static void main(String[] args) {

        ArvoreBinaria biblioteca = new ArvoreBinaria();

        System.out.println("Inserindo livros no sistema...");

        biblioteca.inserir(50, "O Senhor dos Anéis");
        biblioteca.inserir(30, "Dom Quixote");
        biblioteca.inserir(70, "Harry Potter");
        biblioteca.inserir(20, "O Pequeno Príncipe");
        biblioteca.inserir(40, "1984");
        biblioteca.inserir(60, "Game of Thrones");
        biblioteca.inserir(80, "Drácula");

        System.out.println("\n=== LIVROS EM ORDEM ===");
        biblioteca.emOrdem(biblioteca.root);

        System.out.println("\n=== LIVROS PRÉ-ORDEM ===");
        biblioteca.preOrdem(biblioteca.root);

        System.out.println("\n=== LIVROS PÓS-ORDEM ===");
        biblioteca.posOrdem(biblioteca.root);
        
    }
    
}
