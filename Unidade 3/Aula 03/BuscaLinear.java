public class BuscaLinear {
    static int buscaLinear(int[] array, int elementoBuscado){
        for (int i = 0; i < array.length; i++){
            if (array[i] == elementoBuscado) {
                return i;
            }    
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arrayNumeros = {10, 45, 1, 65, 87, 42, 61, 4, 23, 69};
        int elementoBuscado = 65;

        int resultado = buscaLinear(arrayNumeros, elementoBuscado);

        if (resultado != -1) {
            System.out.println("O elemento buscado foi encontrado na poisção do array: " + resultado);
        } else {
            System.out.println("Elemento não econtrado");
        }
        
    }
    
}
