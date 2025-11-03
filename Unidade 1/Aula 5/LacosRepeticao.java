public class LacosRepeticao {

    public static void main(String[] args) {
        //Laço for, repete número determinado de vezes
        for (int i = 0; i <= 5; i+=2){
            System.out.println(i);
        }

        //Laço while, repete N vezes até que não seja mais verdade
        int x = 1;
        while (x <= 5) {
            System.out.println(x);
            x++;
        }

        //Laço do-while, acontece uma vez antes
        int j = 1;
        do{
            System.out.println(j);
            j++;
        } while(j <= 5);
    }
}