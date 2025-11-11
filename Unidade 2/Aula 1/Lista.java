import java.util.ArrayList;

public class Lista {

    public static void main(String[] args) {

        //Array
        String[] ListaCompras = new String[3];

        ListaCompras[0] = "Banana";
        ListaCompras[1] = "Tomate";
        ListaCompras[2] = "Feijão";

        ArrayList<String> ListaComprasUpgrade = new ArrayList<>();

        //adicionar itens
        ListaComprasUpgrade.add("Queijo");
        ListaComprasUpgrade.add("Presunto");
        ListaComprasUpgrade.add("Pão");
        ListaComprasUpgrade.add("Tomate");

        //visualizar lista
        System.out.println(ListaCompras[1]); //definir posição pra acessar
        System.out.println((ListaComprasUpgrade).get(1));

        //tamanho da lista(quantos itens)
        System.out.println(ListaCompras.length); 
        System.out.println(ListaComprasUpgrade.size());

        //procurar na lista pelo item(true ou false)
        System.out.println(ListaComprasUpgrade.contains("Presunto"));

        //remover da lista
        ListaComprasUpgrade.remove("Tomate");
        // por indice ListaComprasUpgrade.remove(3);

        //limpar lista inteira
        ListaComprasUpgrade.clear();
    }
}