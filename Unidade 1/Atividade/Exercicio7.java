/*
Exercício 7: Jogo da Velha Interativo

Desenvolva um programa de Jogo da Velha (Tic-Tac-Toe) para uma brincadeira entre amigos. 
Utilize uma matriz para representar o tabuleiro e permita que dois jogadores façam jogadas alternadas, verificando quem será o vencedor!
*/

import java.util.Scanner;

public class Exercicio7 {

    public static void main(String[] args) {
        
        char[][] tabuleiro = new char[3][3];

    char jogadorAtual = 'X';

    Scanner scanner = new Scanner(System.in);
    boolean jogoContinua = true;

    for(int i = 0; i < tabuleiro.length; i++){
    
        for(int j = 0; j < tabuleiro[i].length; j++){
            tabuleiro[i][j] = ' ';
        }
    }

    imprimirTabuleiro(tabuleiro);

    while (jogoContinua) {
        
        System.out.println("Jogador " + jogadorAtual + " é sua vez.");
        
        System.out.print("Digite a linha (0, 1 ou 2): ");
        int linha = scanner.nextInt();

        System.out.print("Digite a coluna (0, 1 ou 2): ");
        int coluna = scanner.nextInt();

        if(tabuleiro[linha][coluna] == ' '){

            tabuleiro[linha][coluna] = jogadorAtual;
            
            imprimirTabuleiro(tabuleiro);
            
            boolean venceu = verificarVencedor(tabuleiro, jogadorAtual);
            if (venceu) {
                System.out.println("\n---- FIM DE JOGO ----");
                System.out.println("O jogador " + jogadorAtual + " venceu!");
                jogoContinua = false;
            } else {
                if (jogadorAtual == 'X') { //trocar jogador
                    jogadorAtual = 'O';
                } else{
                    jogadorAtual = 'X';
                }
            }
            
        } else{
            System.out.println("\nJogada inválida! Essa casa já está ocupada. Tente novamente.\n");
        }
    }
}

    public static void imprimirTabuleiro(char[][] tabuleiro){

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                
                System.out.print(tabuleiro[i][j]);

                if (j < 2) {
                    System.out.print("  |");
                }
            }

            System.out.println();

                if (i < 2) {
                    System.out.println("---+---+---");
                }
        }
    }

    /*professor, sendo bem sincera, essa parte não consegui fazer sozinha e precisei copiar, se achar que deve descontar 
    nota, mas achei avançado demais pro meu conhecimento*/

    public static boolean verificarVencedor(char[][] tabuleiro, char jogador) {
        
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                return true;
            }
        }
        
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }
        
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        }
        
        return false;
    }
    
    
}
