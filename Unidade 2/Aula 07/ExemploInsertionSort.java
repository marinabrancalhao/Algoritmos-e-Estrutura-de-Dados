public class ExemploInsertionSort {
    public static void insertionSort(int[] arrayNumeros){
        int tamanho = arrayNumeros.length;

        for(int i = 1; i < tamanho; i++){
            int temp = arrayNumeros[i];
            int j = i - 1;
            
            while (j >= 0 && arrayNumeros[j] > temp) {
                arrayNumeros[j+1] = arrayNumeros[j];
                j--;
            }

            arrayNumeros[j + 1] = temp;
        }
    }
   
    public static void main(String[] args) {
        int[] arrayNumeros = {56, 3, 7, 76, 323, 87};

        System.out.println("Array não ordenado");
        for (int numero : arrayNumeros) {
            System.out.print(numero + " ");
        }

        insertionSort(arrayNumeros);

        System.out.println("");
        System.out.println("Array ordenado");
        for (int numero : arrayNumeros) {
            System.out.print(numero + " ");
        }
    }
}
