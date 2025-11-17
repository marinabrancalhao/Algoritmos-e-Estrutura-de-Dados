/*
Ordem de Chegada: Imagine que você está organizando o fluxo de clientes em uma loja durante uma promoção. 
Crie um programa que simule a ordem de chegada e exiba a ordem de saída, respeitando a fila de atendimento. 
*/

import java.util.LinkedList;
import java.util.Queue;

public class Exercicio07 {
    public static void main(String[] args) {

        Queue<String> filaCaixa = new LinkedList<>();

        filaCaixa.add("Cliente 1 (Horário de chegada: 08h)");
        filaCaixa.add("Cliente 2 (Horário de chegada: 08h01)");
        filaCaixa.add("Cliente 3 (Horário de chegada: 08h02)");
        filaCaixa.add("Cliente 4 (Horário de chegada: 08h05)");
        filaCaixa.add("Cliente 5 (Horário de chegada: 08h10)");

        System.out.println("\nClientes na fila: ");
        for (String cliente : filaCaixa) {
            System.out.println(cliente);  
        }
        
        System.out.println("");
        while (!filaCaixa.isEmpty()) {
            String clientAtendido = filaCaixa.poll();
            System.out.println(clientAtendido + " foi atendido.");
        }

        System.out.println("\nTodos clientes foram atendidos! Fila vazia...");
    }
}
