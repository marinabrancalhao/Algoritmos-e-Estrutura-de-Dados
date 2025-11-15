public class ExemploSelectionSort {
     
    public static void selectionSort(int[] arrayNumeros){
        int tamanho = arrayNumeros.length;

        //percorre todo o array
        for(int i = 0; i < tamanho; i++){
            int minIndex = i;
            //percorre o array novamente para comparar
            for(int j = i + 1; j < tamanho; j++){
                //compara o elemento do array atual com o selecionado
                if(arrayNumeros[j] < arrayNumeros[minIndex]){
                    minIndex = j;
                }
            }
            //swap, troca o elemento pelo encontrado
            int temp = arrayNumeros[minIndex];
            arrayNumeros[minIndex] = arrayNumeros[i];
            arrayNumeros[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arrayNumeros = {5,1,8,65,42,30};

        System.out.println("Array Não Ordenado:");
        for (int numero : arrayNumeros) {
            System.out.print(numero + " ");
        }

        selectionSort(arrayNumeros);

        System.out.println("");
        System.out.println("Array Ordenado:");
        for (int i : arrayNumeros) {
            System.out.print(i + " ");
        }
    }
}