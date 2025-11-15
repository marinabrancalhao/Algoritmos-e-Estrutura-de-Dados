/*
Exercício 6: Seleção de Números Primos para Criptografia

Em um sistema de segurança, números primos são utilizados como base para a criptografia.
Escreva um programa que encontre e exiba todos os números primos entre 1 e 100, ajudando a equipe de segurança a selecionar números para esse propósito. 
*/
public class Exercicio06 {
    public static void main(String[] args) {

        System.out.println("== Números Primos 0 a 100 ==");

        for(int num = 1; num <= 100; num++){
            int divisores = 0;

            for(int i = 1; i <= num; i++){
                if (num % i == 0) {
                    divisores++;
                }
            }

            if (divisores == 2) {
                System.out.println(num);
            }
            
        }
        
    }
    
}
