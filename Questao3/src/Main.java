import java.util.Scanner;

void main(){
    Scanner scanner= new Scanner (System.in);
    int i, cont=0;
    System.out.print("Informe um numero natural positivo: ");
    int num= scanner.nextInt();
    for(i=2; i<=num; i++) {
        if (num % i == 0) {
            cont = cont + 1;
        }
        if(cont==2){
            System.out.println("os numero primos de 2 a " +num+ " sao " +i);
        }
    }
}
