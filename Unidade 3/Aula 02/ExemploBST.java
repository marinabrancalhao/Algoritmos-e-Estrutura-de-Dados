class Node{ //nó
    int key;
    Node left, right;

    public Node(int item){
        key = item;
        left = right = null;
    }
}

class BinarySearchTree{
    Node root;

    BinarySearchTree(){
        root = null;
    }

    void insert(int key){
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key){
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key); //menores esquerda
        } else if (key > root.key) {
            root.right = insertRec(root.right, key); //maiores direita
        }

        return root;

    }

    void inorderTraversal(){
        inorderTraversalRec(root);
    }

    void inorderTraversalRec(Node root){
        if (root != null) {
            inorderTraversalRec(root.left);
            System.out.print(root.key + " ");
            inorderTraversalRec(root.right);
        }
    }

    boolean search(int key){
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key){
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (key < root.key)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }
}
    
public class ExemploBST {
    public static void main(String[] args) {
        
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(20);
        tree.insert(30);
        tree.insert(10);
        tree.insert(40);
        tree.insert(5);

        System.out.println("Árvore ordenada: ");
        tree.inorderTraversal();

        if (tree.search(5)) {
            System.out.println("\nChave encontrada");
        } else {
            System.out.println("\nChave não encontrada");
        }

        if (tree.search(15)) {
            System.out.println("Chave encontrada");
        } else {
            System.out.println("Chave não encontrada");
        }
        
    }
}
