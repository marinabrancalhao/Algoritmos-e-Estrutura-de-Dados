import java.util.Scanner;

public class ArraysMatrizes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays
        int[] numeros = {1, 2, 3};
        int[] numeros2 = new int[5];

        numeros2[0] = 12;
        numeros2[1] = 786;
        numeros2[2] = 1;
        numeros2[3] = 3478;
        numeros2[4] = 100;

        System.out.println(numeros2[2]);
        System.out.println(numeros2[3]);

        //Matriz
        int[][] matriz = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        int[][] matriz2 = new int[3][3];
        
        System.out.println(matriz[1][0]);
        System.out.println(matriz2[2][2]);

        System.out.print("Digite um número: ");
        numeros[0] = Integer.parseInt(scanner.nextLine());
        System.out.println(numeros[0]);

        scanner.close();
    }
    
}
