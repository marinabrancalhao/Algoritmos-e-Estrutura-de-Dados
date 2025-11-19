class Node{
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
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }
}

public class ExemploBST {
    public static void main(String[] args) {
        
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(20);
        tree.insert(30);
        tree.insert(10);

        System.out.println(tree.root.key);
        System.out.println(tree.root.left.key);
        System.out.println(tree.root.right.key);

        
    }
}
