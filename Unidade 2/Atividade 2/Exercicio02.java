/*
Remoção de Elementos Duplicados: Em um sistema de cadastro, é comum que contatos sejam adicionados mais de uma vez. 
Crie um método que remova contatos duplicados de uma lista de usuários (ArrayList), deixando apenas uma entrada por pessoa e otimizando o banco de dados. 
*/

import java.util.ArrayList;

public class Exercicio02 {

    public static ArrayList<String> removerDuplicados(ArrayList<String> listaContatos){
        ArrayList<String> listaSemDuplicados = new ArrayList<>();

        for (String pessoa : listaContatos) {
            if (!listaSemDuplicados.contains(pessoa)) {
                listaSemDuplicados.add(pessoa);
            }
        }

        listaContatos.clear();
        listaContatos.addAll(listaSemDuplicados);

        return listaContatos;
    }
    public static void main(String[] args) {
        
        ArrayList<String> listaContatos = new ArrayList<>();
        
        listaContatos.add("Júlia");
        listaContatos.add("Carlos");
        listaContatos.add("Beatriz");
        listaContatos.add("Júlia");
        listaContatos.add("Rafaela");

        System.out.println("Lista com contatos duplicados: ");
        for (String pessoa : listaContatos) {
            System.out.println(pessoa);
        }

        removerDuplicados(listaContatos);

        System.out.println("\nLista sem contatos duplicados: ");
        for (String pessoa : listaContatos) {
            System.out.println(pessoa);
        }
    }
}
