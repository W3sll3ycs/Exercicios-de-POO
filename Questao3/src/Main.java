import java.util.Scanner;

void main(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Informe um numero natural positivo: ");
    int num = scanner.nextInt();

    System.out.print("Os numeros primos de 2 a " + num + " sao: ");

    for (int n = 2; n <= num; n++) {
        int cont = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cont++;
            }
        }
        if (cont == 2) {
            System.out.print(n + " ");
        }
    }
}
