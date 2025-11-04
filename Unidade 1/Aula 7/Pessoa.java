public class Pessoa {
    private String nome;
    private int idade;
    private float peso;
    private float altura;
    private boolean habilitada;

public Pessoa(String nome, int idade, float peso, float altura, boolean habilitada){
    this.nome = nome;
    this.idade = idade;
    this.peso = peso;
    this.altura = altura;
    this.habilitada = habilitada;
}

public void exibirInfos(){
    System.out.println("Nome: " + nome);
    System.out.println("Idade: " + idade);
    System.out.println("Peso: " + peso);
    System.out.println("Altura: " + altura);
}

public void testarAltura(float alturaTeste){
    if (alturaTeste <= this.altura) {
        System.out.println("Entrada permitida");
        
    } else{
        System.out.println("Entrada não autorizada");
    }
}

public void testarIdade(){
    if (this.idade >= 18) {
        System.out.println("Maior de idade, pode beber");
    } else{
        System.out.println("Menor de idade, não pode beber!");
    }
}

public float testeIMC(){
    //teste IMC
    float IMC = this.peso / (this.altura * this . altura);
    //classificação
    if (IMC < 18.5) {
        System.out.println("Magreza");
    } else if (IMC >= 18.5 && IMC < 24.9) {
        System.out.println("Normal");
    } else if (IMC >= 25 && IMC < 29.9) {
        System.out.println("Sobrepeso");
    } else{
        System.out.println("Obesidade");
    }
    return IMC;
}

public void testeHabilitacao(){
    if(this.habilitada){
        System.out.println("Pessoa habilitada");
    }else{System.out.println("Pessoa não habiliatada");}
}
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Marina", 30, 90.0f, 1.65f, true);
        pessoa.exibirInfos();
        pessoa.testarAltura(1.40f);
        pessoa.testarIdade();
        
        float imc = pessoa.testeIMC();
        System.out.println(imc);

        pessoa.testeHabilitacao();
    } 
    
}
