/*
Exercício 8: Análise de Frequência de Pedidos no Delivery

Em uma análise dos pedidos feitos por um cliente, você precisa descobrir qual item é mais pedido. 
Crie um programa que solicite uma lista de números (representando o código dos pedidos) e exiba o item que mais se repete na lista.
*/

import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos códigos de pedidos você deseja analisar? ");
        int quantidade = scanner.nextInt();

        int[] codigosPedidos = new int[quantidade];

        for(int i = 0; i < codigosPedidos.length; i++){
            System.out.print("Código #" + (i + 1)+ ": ");
            codigosPedidos[i] = scanner.nextInt();
        }

        int itemMaisFrequente = 0;
        int contagemMaisAlta = 0;

        for(int i = 0; i < codigosPedidos.length; i++) {
            int itemTeste = codigosPedidos[i];
            int contagemAtualTeste = 0;

            for(int j = 0; j < codigosPedidos.length; j++){
                if (codigosPedidos[j] == itemTeste) {
                    contagemAtualTeste++;
                }
            }

            if (contagemAtualTeste > contagemMaisAlta) {
                itemMaisFrequente = itemTeste;
                contagemMaisAlta = contagemAtualTeste;
                
            }
        }

        System.out.println("O item " + itemMaisFrequente + " foi o mais pedido: " + contagemMaisAlta + " vezes.");

        scanner.close();
            
    }
}