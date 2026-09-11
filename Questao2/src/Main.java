import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Informe um numero N qualquer: ");
    int num = scanner.nextInt();

    if(num % 3 == 0 && num % 5 == 0){
        System.out.println(num + " eh multiplo de 3 e 5");
    }
    else if(num % 3 == 0){
        System.out.println(num + " eh multiplo de 3");
    }
    else if(num % 5 == 0){
        System.out.println(num + " eh multiplo de 5");
    }
    else{
        System.out.println(num + " nao eh multiplo de 3 nem de 5");
    }
}