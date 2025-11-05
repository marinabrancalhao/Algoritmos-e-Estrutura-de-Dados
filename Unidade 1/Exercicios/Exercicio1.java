/*Exercício 1: Explorando Variáveis no Sistema de Reservas de um Hotel

Imagine que você está desenvolvendo um sistema de reservas para um hotel. 
Comece declarando variáveis que armazenem o número do quarto (número inteiro), o valor da diária (número com ponto flutuante) e o nome do hóspede (string). 
Atribua valores de exemplo a essas variáveis e exiba-os na tela. */

public class Exercicio1 {

private int numeroQuarto;
private float valorDiaria;
private String nomeHospede;

public Exercicio1(int numeroQuarto, float valorDiaria, String nomeHospede){
    this.numeroQuarto = numeroQuarto;
    this.valorDiaria = valorDiaria;
    this.nomeHospede = nomeHospede;
}

public void exibirInfo(){
    System.out.println("Número do quarto: " + numeroQuarto);
    System.out.printf("Valor da diária: R$%.2f%n", valorDiaria);
    System.out.println("Nome do hóspede: " + nomeHospede);
}

public static void main(String[] args) {
    Exercicio1 cliente = new Exercicio1(204, 149.90f, "Maria Oliveira");
    cliente.exibirInfo();  
}   

}


