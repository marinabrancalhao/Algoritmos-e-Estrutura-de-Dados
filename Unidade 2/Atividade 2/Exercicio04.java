/*
Verificação de Expressões: No desenvolvimento de uma calculadora, você precisa verificar se a expressão matemática digitada está com os parênteses corretamente balanceados. 
Utilize uma pilha para desenvolver um programa que verifique essa estrutura, ajudando a identificar possíveis erros antes do cálculo. 
*/

import java.util.Stack;

public class Exercicio04 {
    public static boolean verificarParenteses(String expressao){
        
        Stack<Character> pilha = new Stack<>();

        for(int i = 0; i < expressao.length(); i++){
            char caractereAtual = expressao.charAt(i);

            if (caractereAtual == '(') {
                pilha.push(caractereAtual);
            } else if (caractereAtual == ')') {
                if (pilha.isEmpty()) {
                    return false;
                } else {
                    pilha.pop();
                }
                
            }
        }

        return pilha.isEmpty();

    }
    public static void main(String[] args) {

    String teste1 = "(A + B)";
    System.out.println(verificarParenteses(teste1) ? "Parênteses balanceados" : "Faltando parênteses" );

    String teste2 = "(A + B))";
    System.out.println(verificarParenteses(teste2) ? "Parênteses balanceados" : "Faltando parênteses" );

    String teste3 = "((A + B)";
    System.out.println(verificarParenteses(teste3) ? "Parênteses balanceados" : "Faltando parênteses" );

    String teste4 = "((A + B)*C)";
    System.out.println(verificarParenteses(teste4) ? "Parênteses balanceados" : "Faltando parênteses" );
        
    }
}