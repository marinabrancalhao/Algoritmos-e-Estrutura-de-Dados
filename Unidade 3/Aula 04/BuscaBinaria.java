public class BuscaBinaria {
    static int buscaBinaria(int[] array, int elemento){
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if(array[meio] == elemento){
                return meio;
            }

            if (array[meio] < elemento) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }

        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arrayNumeros = {10, 20, 30, 40, 50, 60, 70, 80, 90}; //array precisa estar ordenado
        int ElementoBuscado = 40;

        int resultado = buscaBinaria(arrayNumeros, ElementoBuscado);

        if (resultado != -1) {
            System.out.println("Elemento encontrado na posição do array: " + resultado);
        } else {
            System.out.println("Elemento não encontrado");
        }
    }
}
