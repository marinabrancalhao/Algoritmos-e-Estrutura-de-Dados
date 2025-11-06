/*
Exercício 5: Avaliação de Notas dos Alunos

Você é responsável por calcular o desempenho dos alunos em uma avaliação. 
Crie uma matriz (array) com as notas dos alunos em uma prova e encontre a maior nota da turma, exibindo-a ao final.
*/

public class Exercicio5 {

    public static void main(String[] args) {
    
        float[] notas = {8.5f, 9, 6.5f, 9.5f, 7.5f, };
        float maiorNota = 0.0f;  

        for(int i = 0; i < notas.length; i++ ){
            System.out.println("Nota " + (i + 1) + " = " + notas[i]);  
        }
        
        for(int i = 0; i < notas.length; i++ ){

            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
            }
        }

        System.out.println("Maior nota = " + maiorNota);
    } 
}
