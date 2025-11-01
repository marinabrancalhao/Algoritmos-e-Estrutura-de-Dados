public class ExemploDadosPrimitivos{
    public static void main(String[] args) {

        // números inteiros
        byte valorByte = 127; //-128 a 127
        short valorShort = 32767; //-32768 a 32767
        int valorInt = 2147483647; //-2147483648 a 2147483647
        long valorLong = 9223372036854775807L; //-9223372036854775808 a 9223372036854775807

        //números flutuantes
        float valorFloat = 3.14f;
        double valorDouble = 3.14159265359;

        //tipo caracter
        char caracter = 'a';

        //tipo booleano
        boolean verdadeiro = true;
        boolean falso = false;

        //número pi - constante
        final float nPi = 3.1415f;

        System.out.println(valorByte);
        System.out.println(valorShort);
        System.out.println(valorInt);
        System.out.println(valorLong);
        System.out.println(valorFloat);
        System.out.println(valorDouble);
        System.out.println(caracter);
        System.out.println(verdadeiro);
        System.out.println(falso);
        System.out.println(nPi);
    }
}