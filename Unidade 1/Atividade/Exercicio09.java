/*
Exercício 9: Gerenciando um Cadastro de Clientes

Em uma agência de viagens, você precisa organizar o cadastro dos clientes. 
Crie uma classe Pessoa com atributos como nome, idade e endereço, e desenvolva um programa que permita criar e gerenciar uma lista desses clientes.
*/

import java.util.ArrayList;
import java.util.Scanner;

class Pessoa{

    private String nome;
    private int idade;
    private String endereco;

    public Pessoa(String nome, int idade, String endereco){
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente: " + this.nome +
                "\nIdade: " + this.idade + "anos" +
                " | Endereço: " + this.endereco;
    }
}

public class Exercicio09 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Pessoa> listaDeClientes = new ArrayList<>();

        int opcaoEscolhida = 0;

        do{

        System.out.println("\n== Cadastro de Clientes ==");
        System.out.println("1. Cadastrar novo cliente");
        System.out.println("2. Gerar lista de clientes");
        System.out.println("0. Sair");
        
        System.out.print("Escolha a opção desejada: ");
        opcaoEscolhida = scanner.nextInt(); 
        scanner.nextLine();
        
        if (opcaoEscolhida == 1) {
        System.out.print("\nDigite o nome: "); 
        String nome = scanner.nextLine();   
        
        System.out.print("Digite a idade: "); 
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o endereço: "); 
        String endereco = scanner.nextLine();

        Pessoa cliente = new Pessoa(nome, idade, endereco);

        System.out.println("\nCadastro realizado com sucesso!");
        
        listaDeClientes.add(cliente);
        } else if (opcaoEscolhida == 2) {
            for (Pessoa cliente : listaDeClientes) {
                System.out.println("\n" + cliente);
                System.out.print("----------------------------------------\n");
            }  
        } else if (opcaoEscolhida == 0) {
            System.out.println("\nEncerrando o programa...");
        } else {
            System.out.println("Opção inválida");
        }

    } while (opcaoEscolhida != 0);  

    scanner.close();
}

}
