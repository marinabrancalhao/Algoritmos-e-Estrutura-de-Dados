import java.util.ArrayList;

public class Lista2 {

    public static void main(String[] args) {
        ArrayList<String> ListaComprasUpgrade = new ArrayList<>();

        //adicionar itens novos a lista dinamica
        ListaComprasUpgrade.add("Queijo");
        ListaComprasUpgrade.add("Presunto");
        ListaComprasUpgrade.add("Pão");
        ListaComprasUpgrade.add("Alface");
        ListaComprasUpgrade.add("Tomate");

        //clonar lista
        ArrayList<String> ListaLanche = (ArrayList<String>)ListaComprasUpgrade.clone();

        ListaLanche.add("Requeijão");
        System.out.println(ListaLanche);
        System.out.println(ListaComprasUpgrade);

        System.out.println(ListaComprasUpgrade.size());
        System.out.println(ListaComprasUpgrade.isEmpty());
        
        ListaComprasUpgrade.clear();
        System.out.println(ListaComprasUpgrade.size());
        System.out.println(ListaComprasUpgrade.isEmpty());

        //foreach -> antes: for(variavel controle, condição e iterador)
        
        for (String item : ListaLanche) {
            System.out.println(item);
        }

        //assim imprime item não encontrado a cada volta
        /*for (String item : ListaLanche) {
            System.out.println(item);
            if (item == "Alface") {
                System.out.println("Item encontrado");
            }else{
                System.out.println("Item não encontrado");
            }
          
        }*/

        boolean existe = false;
        for(String item : ListaLanche){
            System.out.println(item);
            if (item == "Feijão") {
                existe = true;  
            }
        }

        if (existe) {
            System.out.println("Item encontrado");
        } else{
           System.out.println("Item não encontrado"); 
        }


    }
}