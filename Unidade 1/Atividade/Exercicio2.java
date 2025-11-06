/*Exercício 2: Verificador de Características de Um Produto

Em uma loja, os produtos têm códigos específicos. 
Escreva um programa que, ao ler o código de um produto, indique se o número é par ou ímpar. 
Imprima o resultado na tela para ajudar o setor de inventário a identificar características básicas dos produtos. 
*/

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Digite o código do produto: ");
        int codigoProduto = scanner.nextInt();

        if (codigoProduto % 2 == 0) {
            System.out.println("O código é um número par"); 
        } else{
            System.out.println("O código é um número ímpar");
        }

        scanner.close();
    }
}
