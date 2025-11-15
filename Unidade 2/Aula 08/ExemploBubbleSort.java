public class ExemploBubbleSort {
    public static void bubbleSort(int[] arrayNumeros){
        boolean swap;

        for(int i = 0; i < arrayNumeros.length - 1; i++){
            swap = false;
            for(int j = 0; j < arrayNumeros.length - i - 1; j++){
                if (arrayNumeros[j] > arrayNumeros[j + 1]) {
                    int temp = arrayNumeros[j];
                    arrayNumeros[j] = arrayNumeros[j + 1];
                    arrayNumeros[j + 1] = temp;
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrayNumeros = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Array não ordenado");
        for (int numero : arrayNumeros) {
            System.out.print(numero + " ");
        }

        bubbleSort(arrayNumeros);

        System.out.println("");
        System.out.println("Array ordenado");
        for (int numero : arrayNumeros) {
            System.out.print(numero + " ");
        }
    }
}