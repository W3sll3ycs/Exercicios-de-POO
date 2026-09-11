# Questão 5 – Scanner e System.out.printf em Java

## Como o Scanner é utilizado

O `Scanner` é uma classe do Java que uso para ler dados digitados pelo usuário durante a execução do programa. Para usar, primeiro importo a classe e depois crio um objeto associado à entrada padrão (`System.in`):

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
```

A partir desse objeto, posso chamar métodos diferentes dependendo do tipo de dado que quero ler: `nextInt()` para números inteiros, `nextDouble()` para números decimais, `next()` para uma palavra só e `nextLine()` para ler uma linha inteira. O programa fica esperando o usuário digitar algo e apertar Enter para continuar.

## Como o System.out.printf ajuda na formatação

Já o `System.out.printf()` eu uso para exibir a saída de forma mais organizada, controlando como cada valor vai aparecer na tela. Diferente do `println()`, que só junta texto, o `printf()` usa marcadores de formatação, como:

- `%d` — número inteiro
- `%f` — número decimal
- `%.2f` — número decimal com 2 casas depois da vírgula
- `%s` — texto
- `%n` — pula linha

Isso é útil principalmente quando estou trabalhando com médias, valores em dinheiro ou qualquer número decimal que eu não quero mostrar com um monte de casas decimais desnecessárias.

## Exemplo juntando os dois

```java
import java.util.Scanner;

public class ExemploScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número decimal: ");
        double numero = scanner.nextDouble();

        System.out.printf("O número informado foi: %.2f%n", numero);

        scanner.close();
    }
}
```

**Exemplo de execução:**
```
Digite um número decimal: 7.5896
O número informado foi: 7.59
```

Percebi que mesmo eu digitando `7.5896`, o `%.2f` arredondou e mostrou só duas casas decimais (`7.59`). Ou seja, o Scanner serve para ler o dado e o printf serve para controlar como esse dado aparece na saída.

---

# Questão 6 – Correção do código Contador

```java
import java.util.Scanner;

public class Contador {
    public static void main(String args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        while (contador <= 5) {
            System.out.println("Contador: " + contador)
        }
    }
}
```

## Erros que encontrei

**1. Erro de sintaxe na assinatura do main**

```java
public static void main(String args) {
```

Faltam os colchetes `[]`. O parâmetro do `main` precisa ser um array de Strings (`String[] args`), e não uma String sozinha. Sem isso, o Java não reconhece esse método como o ponto de entrada certo do programa.

Correção:
```java
public static void main(String[] args) {
```

**2. Falta ponto e vírgula**

```java
System.out.println("Contador: " + contador)
```

Toda linha de comando em Java precisa terminar com `;`, e essa está sem. Isso dá erro de compilação.

Correção:
```java
System.out.println("Contador: " + contador);
```

**3. Erro de lógica: o contador nunca aumenta**

```java
while (contador <= 5) {
    System.out.println("Contador: " + contador);
}
```

O `contador` começa em `0` e a condição do `while` é `contador <= 5`, só que dentro do laço eu não faço nada para mudar o valor do `contador`. Com isso, a condição nunca vira falsa e o programa entra num loop infinito, ficando preso imprimindo "Contador: 0" pra sempre.

Para resolver, preciso incrementar o `contador` dentro do laço, usando `contador++`.

## Código corrigido

```java
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        while (contador <= 5) {
            System.out.println("Contador: " + contador);
            contador++;
        }
    }
}
```

**Saída esperada:**
```
Contador: 0
Contador: 1
Contador: 2
Contador: 3
Contador: 4
Contador: 5
```

Uma última observação: o `Scanner` (`sc`) foi criado mas não é usado em nenhum momento do código. Isso não impede o programa de rodar, mas dá a entender que talvez o exercício original quisesse que eu lesse algum valor do usuário (tipo o limite do contador) e essa parte acabou ficando de fora.