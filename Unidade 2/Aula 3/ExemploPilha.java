import java.util.ArrayDeque;
import java.util.Deque;

public class ExemploPilha {
    public static void main(String[] args) {

        //LIFO, do inglês "Last In, First Out"
        Deque<Integer> pilha = new ArrayDeque<>();

        //adicionar itens novos
        pilha.push(10);
        pilha.push(15);
        pilha.push(20);
        pilha.push(30);
        pilha.push(56); //primeiro a imprimir

        System.out.println(pilha);

        //visualizar o primeiro item da pilha sem remover
        System.out.println(pilha.peek()); 

        //retorna o primeiro item da pilha e remove
        System.out.println(pilha.pop()); 
        System.out.println(pilha);

        //desempiljando a pilha item a item
        while (!pilha.isEmpty()) { //só funciona o laço enquanto é true
            System.out.println(pilha.pop());   
        }
    }
    
}
