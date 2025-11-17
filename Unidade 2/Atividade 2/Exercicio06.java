/*
Implementação de um Sistema de Fila de Espera: Em uma clínica, os pacientes aguardam atendimento em uma fila de espera. 
Crie um sistema que simule essa fila, permitindo adicionar, remover e exibir a ordem de atendimento dos pacientes. 
Isso ajudará na organização e no controle da ordem de atendimento.  
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcaoDesejada;
        Queue<String> filaDeEspera = new LinkedList<>();
        
        do{
            System.out.println("\n== Fila de Espera ==");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Chamar Próximo");
            System.out.println("3. Ver Fila");
            System.out.println("0. Sair");

            System.out.print("\nDigite a opção desejada: ");
            opcaoDesejada = scanner.nextInt();
            scanner.nextLine();

            if (opcaoDesejada == 1) {

                System.out.print("\nDigite o nome do paciente: ");
                String paciente = scanner.nextLine();
                filaDeEspera.add(paciente);
                System.out.println("\nPaciente " + paciente + " entrou para lista de espera.");

            } else if (opcaoDesejada == 2) {
                
                if (filaDeEspera.isEmpty()) {
                    System.out.println("\nErro! Não há ninguém na fila para atender...");
                } else {
                String emAtendimento = filaDeEspera.poll();
                System.out.println("\nPaciente " + emAtendimento + " foi para o consultório.");
                }

            } else if (opcaoDesejada == 3) {

                System.out.println("\nFila atual: " + filaDeEspera);

            } else if (opcaoDesejada == 0) {

                System.out.println("\nEncerrando o sistema...\n");

            } else {

                System.out.println("\nOpção inválida. Tente novamente...");
            }


        }while(opcaoDesejada != 0);

        scanner.close();
    }
}
