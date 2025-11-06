/*Exercício 1: Explorando Variáveis no Sistema de Reservas de um Hotel

Imagine que você está desenvolvendo um sistema de reservas para um hotel. 
Comece declarando variáveis que armazenem o número do quarto (número inteiro), o valor da diária (número com ponto flutuante) e o nome do hóspede (string). 
Atribua valores de exemplo a essas variáveis e exiba-os na tela. */

public class Exercicio1 {
    
public static void main(String[] args) {
    
    int numeroQuarto = 204;
    float valorDiaria = 149.90f;
    String nomeHospede = "Maria Oliveira";

    System.out.println("== RESERVA HOTEL ==");
    System.out.println("Número do quarto: " + numeroQuarto);
    System.out.printf("Valor da diária: R$%.2f%n", valorDiaria);
    System.out.println("Nome do hóspede: " + nomeHospede);  
}   

}