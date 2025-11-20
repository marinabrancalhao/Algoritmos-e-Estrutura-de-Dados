/*
Busca Binária:
Imagine que você está desenvolvendo um sistema de pesquisa de dados em uma lista de números ordenados.
Implemente um algoritmo de busca binária que encontre a posição de um elemento específico em um array ordenado de inteiros, retornando sua posição ou -1 se não for encontrado. 
*/

public class Exercicio04 {

    public static int buscaBinaria(int[] lista, int numeroBuscado){
        int inicio = 0;
        int fim = lista.length - 1;

        while (inicio <= fim) {
            
            int meio = inicio + (fim - inicio) / 2;

            if (lista[meio] == numeroBuscado) {
                return meio;
            }

            if (lista[meio] < numeroBuscado) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        int[] numeros = {5, 12, 18, 25, 33, 46, 59, 72, 88, 94};

        int busca1 = 33;
        int resultado1 = buscaBinaria(numeros, busca1);

        System.out.println("Buscando o número " + busca1 + "...");
        if (resultado1 != -1) {
            System.out.println("Encontrado na posição: " + resultado1);
        } else {
            System.out.println("Número não encontrado");
        }

        System.out.println("---------------------------------------------------");

        int busca2 = 89;
        int resultado2 = buscaBinaria(numeros, busca2);

        System.out.println("Buscando o número " + busca2 + "...");
        if (resultado2 != -1) {
            System.out.println("Encontrado na posição: " + resultado2);
        } else {
            System.out.println("Número não encontrado");
        }
    }
    
}
