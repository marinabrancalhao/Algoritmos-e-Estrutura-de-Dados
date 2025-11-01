public class ExemploDadosNaoPrimitivos {
    public static void main(String[] args) {
        
        //tipos caracter primitivo
        char caracter = 'A';

        // tipo caracter não primitivo
        String nome = "Marina";
        nome = "Marina Brancalhão";

        //tipo Enum (coleção de palavras que se repete)
        enum DiasDaSemana{
            DOMINGO, SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA, SÁBADO
        }

        DiasDaSemana dia = DiasDaSemana.DOMINGO;

        //tipo array - coleção de valores
        int[] numeros = {1, 2, 3, 4, 5};

        System.out.println(nome);
        System.out.println(dia);
        System.out.println(numeros[0]);
    }    
}
