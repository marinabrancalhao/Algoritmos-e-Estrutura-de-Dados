public class Condicionais {
   public static void main(String[] args) {
    // operadores matemáticos:
    // == igual
    // != diferente
    // > maior
    // < menor
    // >= maior ou igual
    // <= menor ou igual

    // operadores lógicos
    // && E
    // || OU
    // ! NÃO

    // if sozinho
    int x = 5;
    if (x < 10) {
        System.out.println("Verdade");
    }

    // if e else
    int y = 1;
    if (y > 10) {
        System.out.println("Verdade");
    } else {
        System.out.println("Falso");
    }

    //if encadeado
    int j = 40;
    if (j > 50) {
        System.out.print("Primeiro if");
    } else if (j < 30) {
        System.out.println("Segundo if");
    } else {
        System.out.println("Else");
    }

    //switch case
    int opcao = 5;

    switch (opcao) {
        case 1:
            System.out.println("1");
            break;
        case 2:
            System.out.println("2");
            break;
        case 3:
            System.out.println("3");
            break;
        case 4:
            System.out.println("4");
            break;
        default:
           System.out.println("Opção inválida");;
    }

    //operadores lógicos && e ||
    int b = 10;
    int c = 15;

    if (b == 10 && c == 15) {
        System.out.println("Verdadeiro &&");
    }

    if (b == 11 || c == 15) {
        System.out.println("Verdadeiro ||");
    }


   } 
}
