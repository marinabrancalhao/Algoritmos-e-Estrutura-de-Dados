/*
Inversão de Lista: Imagine que você está desenvolvendo um recurso em um aplicativo que exibe uma lista de tarefas do dia em ordem inversa.
Escreva um programa que inverta os elementos de uma lista de tarefas (ArrayList) sem utilizar métodos prontos da linguagem, dando ao usuário a opção de ver a lista do fim para o começo. 
*/

import java.util.ArrayList;

public class Exercicio01 {

    public static ArrayList<String> inverterLista(ArrayList<String> tarefasDoDia){
        
        ArrayList<String> listaInvertida = new ArrayList<>();
       
        int tamanho = tarefasDoDia.size();
        for(int i = tamanho - 1; i >= 0; i--){
            listaInvertida.add(tarefasDoDia.get(i));
        }

        return listaInvertida;

    }
    public static void main(String[] args) {

        ArrayList<String> tarefasDoDia = new ArrayList<>();

        tarefasDoDia.add("8h - Ir para academia");
        tarefasDoDia.add("11h30 - Almoço com Ana");
        tarefasDoDia.add("15h - Reunião");
        tarefasDoDia.add("18h30 - Aula de inglês");
        tarefasDoDia.add("19h30 - Passar no supermercado");

        System.out.println("-- Tarefas do Dia | Ordem Crescente--");
        for (String tarefa : tarefasDoDia) {
            System.out.println(tarefa);
        }

        ArrayList<String> tarefasInvertidas = inverterLista(tarefasDoDia);
        System.out.println("\n-- Tarefas do Dia | Ordem Decrescente--");
        for (String tarefa : tarefasInvertidas) {
            System.out.println(tarefa);
        }
    }
}
