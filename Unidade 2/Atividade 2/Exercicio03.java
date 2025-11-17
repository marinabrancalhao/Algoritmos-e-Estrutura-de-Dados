/*
Mesclar Listas: Suponha que você está gerenciando duas listas de convidados para um evento e deseja criar uma nova lista com os nomes intercalados das listas originais. 
Implemente uma função que receba duas listas de convidados e retorne uma nova lista com os elementos intercalados.
*/

import java.util.ArrayList;

public class Exercicio03 {
   public static ArrayList<String> intercalarListas(ArrayList<String> lista1, ArrayList<String> lista2){

      ArrayList<String> listaMista = new ArrayList<>();
      
      int tamanho = lista1.size();

      for(int i = 0; i < tamanho; i++){
         listaMista.add(lista1.get(i));
         listaMista.add(lista2.get(i));
      }

      return listaMista;

   }
   public static void main(String[] args) {

      ArrayList<String> lista1 = new ArrayList<>();
      lista1.add("Maria");
      lista1.add("Beto");
      lista1.add("Carla");

      System.out.println("Lista 1:");
      for (String pessoa : lista1) {
         System.out.println(pessoa);
      }

      ArrayList<String> lista2 = new ArrayList<>();
      lista2.add("Daniel");
      lista2.add("Eduardo");
      lista2.add("Fernanda");

      System.out.println("\nLista 2:");
      for (String pessoa : lista2) {
         System.out.println(pessoa);
      }

      ArrayList<String> listaMista = intercalarListas(lista1, lista2);
      System.out.println("\nLista mista: ");
      for (String pessoa : listaMista) {
         System.out.println(pessoa);
      }
    
   } 
}
