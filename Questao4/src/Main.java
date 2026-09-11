import java.util.Scanner;

void main(){
    Scanner scanner= new Scanner (System.in);
    int i,j;

    for(i=0; i<5; i++){
        System.out.print("Informe um numero inteiro: ");
        int num= scanner.nextInt();
        for(j=0; j<num; j++){
            System.out.print("*");
        }
        System.out.println();
    }
}
