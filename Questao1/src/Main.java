import java.util.Scanner;

void main() {
    Scanner scanner= new Scanner (System.in);
    System.out.print("Informe seu nome: ");
    String aluno= scanner.nextLine();
    System.out.print("Informe sua primeira nota: ");
    float nota1= scanner.nextFloat();
    System.out.print("Informe sua segunda nota: ");
    float nota2= scanner.nextFloat();
    System.out.print("Informe sua terceira nota: ");
    float nota3= scanner.nextFloat();

    int pesos= 1+1+2;
    float media_ponderada= ((nota1 * 1)+(nota2 * 1)+ (nota3 * 2))/pesos;

    if(media_ponderada>=7){
        System.out.printf("O aluno %s foi Aprovado com media %.2f", aluno, media_ponderada);
    }
    if(media_ponderada<7){
        System.out.printf("O aluno %s foi Reprovado com media %.2f", aluno, media_ponderada);
    }
}
