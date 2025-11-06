/*Exercício 4: Organizando uma Lista de Espera Dinâmica

Em um restaurante, há uma lista de espera para os clientes. 
Implemente um programa que permita adicionar e remover clientes dessa lista dinâmica. 
A cada alteração, exiba a lista atualizada para que os funcionários saibam quantos clientes estão aguardando.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        ArrayList<String> listaDeEspera = new ArrayList<>(); 
        Scanner scanner = new Scanner(System.in);
        int opcaoDesejada;

        System.out.println("== Lista de Espera ==");

        do{
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Sair");
        System.out.print("Escolha a opção desejada: ");

        opcaoDesejada = scanner.nextInt();
        scanner.nextLine();

        if (opcaoDesejada == 1) {
            System.out.print("Digite o nome do(a) cliente: ");
            String cliente = scanner.nextLine();
            
            listaDeEspera.add(cliente);
            System.out.println("== Lista de Espera Atualizada ==");
            for (String nome : listaDeEspera) {
                System.out.println(nome);
            }
        } else if (opcaoDesejada == 2) {
            System.out.print("Digite o nome do(a) cliente: ");
            String cliente = scanner.nextLine();
            
            listaDeEspera.remove(cliente);
            System.out.println("== Lista de Espera Atualizada ==");
            for (String nome : listaDeEspera) {
                System.out.println(nome);
            }
        } else if (opcaoDesejada == 3) {
            System.out.println("Encerrando programa...");
        } else{
            System.out.println("Opção inválida");
        }

        } while (opcaoDesejada != 3);

        scanner.close();
        
    }
}
