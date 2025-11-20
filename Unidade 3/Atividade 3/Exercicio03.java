/*
Busca Linear:
Você está criando um aplicativo de agenda de contatos e precisa encontrar rapidamente a posição de um número específico na lista.
Escreva um método que realize uma busca linear em um array de inteiros, retornando a posição do número buscado ou -1 caso ele não esteja presente. 
*/

public class Exercicio03 {

    public static int buscaLinear(int[] lista, int numeroBuscado){
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == numeroBuscado) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] agenda = {101, 205, 309, 444, 512, 600};

        int busca1 = 444;
        int resultado1 = buscaLinear(agenda, busca1);

        System.out.println("Bucando o contato " + busca1 + "...");
        if (resultado1 != -1) {
            System.out.println("Encontrado na posição: " + resultado1);
        } else {
            System.out.println("Contato não encontrado");
        }

        System.out.println("---------------------------------------------------");

        int busca2 = 999;
        int resultado2 = buscaLinear(agenda, busca2);

        System.out.println("Bucando o contato " + busca2 + "...");
        if (resultado2 != -1) {
            System.out.println("Encontrado na posição: " + resultado2);
        } else {
            System.out.println("Contato não encontrado");
        }
    }
}