import java.util.ArrayDeque;
import java.util.Deque;

public class Documentos {

    private String titulo;
        private int numeroPaginas;

        public Documentos(String titulo, int numeroPaginas){
            this.titulo = titulo;
            this.numeroPaginas = numeroPaginas;
        }

    public static void main(String[] args) {

        Deque<Documentos> pilha = new ArrayDeque<>();
        
        Documentos doc1 = new Documentos("Processos 123", 100);
        Documentos doc2 = new Documentos("Processos 456", 240);
        Documentos doc3 = new Documentos("Processos 789", 675);
        Documentos doc4 = new Documentos("Processos 321", 45);
        Documentos doc5 = new Documentos("Processos 654", 72);

        pilha.push(doc1);
        pilha.push(doc2);
        pilha.push(doc3);
        pilha.push(doc4);
        pilha.push(doc5);

        while (!pilha.isEmpty()) {
            Documentos tempDocumentos = pilha.pop();
            System.out.println("Título:            " + tempDocumentos.titulo);
            System.out.println("Número de páginas: " + tempDocumentos.numeroPaginas);
            System.out.println(" ");
    
    }
}
}
