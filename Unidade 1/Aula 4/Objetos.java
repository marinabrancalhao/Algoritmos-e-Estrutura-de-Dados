import java.util.Scanner;

public class Objetos{
    //Atributos - características do objeto
    private String nome;
    private int idade;
    private float peso;

    //Construtor
    public Objetos(String nome, int idade, float peso){
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    //Métodos
    public void exibirInfos(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Peso: " + peso);
    }

     public void aniversario(){
        this.idade += 1;
    }

    //Gets e Sets
    public String getNome(){
        return this.nome;
    } //precisa retornar alguma informação

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return this.idade;
    } //precisa retornar alguma informação

    public void setIdade(int idade){
        this.idade = idade;
    }

      public float getPeso(){
        return this.peso;
    } //precisa retornar alguma informação

    public void setPeso(float peso){
        this.peso = peso;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Objetos pessoa = new Objetos("Marina", 30, 90.5f);
        Objetos pessoa2 = new Objetos("Bruno", 35, 72.5f);

        pessoa.exibirInfos();
        pessoa2.exibirInfos();
        pessoa.aniversario();
        pessoa.exibirInfos();

        pessoa.setNome("Marina Brancalhão");
        pessoa.exibirInfos();

        System.out.print("Digite o seu nome: ");
        String nome = scanner.nextLine(); 
        
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Digite seu peso: ");
        float peso = scanner.nextFloat();
        scanner.nextLine();

        Objetos pessoa3 = new Objetos(nome, idade, peso);

        pessoa3.exibirInfos();

        scanner.close();
    }
}