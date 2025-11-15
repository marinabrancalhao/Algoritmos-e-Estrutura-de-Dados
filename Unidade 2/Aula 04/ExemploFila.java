import java.util.LinkedList;
import java.util.Queue;

public class ExemploFila {
    public static void main(String[] args) {
        
        //FIFO, do inglês "First In, First Out"
        Queue<String> fila = new LinkedList<>();

        //adicionar itens à fila
        fila.offer("1º fila");
        fila.offer("2º fila");
        fila.offer("3º fila");

        //exibir a primeira posição da fila
        System.out.println(fila.peek());

        //remover primeiro item da fila e exibir o item
        System.out.println(fila.poll());

        while (!fila.isEmpty()) {
        System.out.println(fila.poll());   
        }

        System.out.println(fila);
        
    }
}
