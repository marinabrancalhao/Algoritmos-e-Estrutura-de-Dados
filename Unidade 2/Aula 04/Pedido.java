import java.util.LinkedList;
import java.util.Queue;

public class Pedido {
    private int numeroPedido;
    private String[] itens;
    private float preco;

    public Pedido(int numeroPedido, String[] itens, float preco){
        this.numeroPedido = numeroPedido;
        this.itens = itens;
        this.preco = preco;
    }

    public static void main(String[] args) {
        //FIFO, do inglês "First In, First Out"
        Queue<Pedido> fila = new LinkedList<>();

        String[] itensTempPedido1 = {"X-Burguer", "Refrigerante", "Batata"};
        Pedido pedido1 = new Pedido(123, itensTempPedido1, 30.45f);

        String[] itensTempPedido2 = {"Refrigerante", "Sorvete"};
        Pedido pedido2 = new Pedido(456, itensTempPedido2, 22.67f);

        String[] itensTempPedido3 = {"X-Burguer", "Refrigerante", "Batata", "Torta", "Sorvete", "Molho especial"};
        Pedido pedido3= new Pedido(789, itensTempPedido3, 55.25f);

        fila.offer(pedido1);
        fila.offer(pedido2);
        fila.offer(pedido3);

        System.out.println(pedido1);
        System.out.println(pedido2);
        System.out.println(pedido3);

        while (!fila.isEmpty()) {
            Pedido pedidoTemp = fila.poll();
            System.out.println("Número do pedido: " + pedidoTemp.numeroPedido);
            
            System.out.println("Itens: ");
            for (String item : pedidoTemp.itens) {
                System.out.println("        " + item);
              
            }
            
            System.out.println("Preço: " + pedidoTemp.preco);
            System.out.println("------------------------------------------------------");
        }
    }
}
