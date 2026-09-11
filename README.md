# 5. Scanner e System.out.printf em Java

## Scanner para entrada de dados

O `Scanner` é uma classe do pacote `java.util` utilizada para ler dados digitados pelo usuário durante a execução do programa (entrada padrão, `System.in`). Para utilizá-lo, é necessário importar a classe e criar um objeto associado ao fluxo de entrada:

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
```

A partir desse objeto, é possível chamar métodos específicos para cada tipo de dado que se deseja ler, como `nextInt()` para inteiros, `nextDouble()` para números decimais, `next()` para uma palavra (sem espaços) e `nextLine()` para uma linha inteira de texto. O programa fica "parado" aguardando a digitação até que o usuário pressione Enter.

## System.out.printf para formatação de saída

O `System.out.printf()` permite exibir dados de forma formatada, usando **placeholders** (marcadores) que definem como cada valor deve aparecer. Diferente do `println()`, que apenas concatena texto, o `printf()` aceita múltiplos argumentos e aplica formatação a cada um deles através de códigos como:

- `%d` — número inteiro
- `%f` — número decimal (double/float)
- `%.2f` — número decimal com exatamente 2 casas decimais
- `%s` — texto (String)
- `%n` — quebra de linha

Isso é especialmente útil quando se trabalha com valores monetários, médias, porcentagens ou qualquer situação em que se deseja controlar a quantidade de casas decimais exibidas, evitando números com muitas casas decimais desnecessárias.

## Exemplo combinando os dois

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

Note que, mesmo o usuário tendo digitado `7.5896`, o `%.2f` fez o `printf` arredondar e exibir apenas duas casas decimais (`7.59`). Isso mostra como o Scanner cuida da **leitura** dos dados, enquanto o `printf` cuida da **apresentação** desses dados de forma controlada.

---

# 6. Correção do código `Contador`

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

## Erros identificados

**1. Erro de sintaxe: assinatura do `main` incorreta**

```java
public static void main(String args) {
```

O parâmetro do método `main` deve ser um **array de Strings** (`String[] args`), não uma `String` única. Sem os colchetes `[]`, o compilador não reconhece esse método como o ponto de entrada válido do programa, e ele nem chega a compilar/executar como esperado.

**Correção:**
```java
public static void main(String[] args) {
```

**2. Erro de sintaxe: falta ponto e vírgula (`;`)**

```java
System.out.println("Contador: " + contador)
```

Toda instrução em Java deve terminar com `;`. Essa linha está sem o ponto e vírgula no final, o que gera erro de compilação.

**Correção:**
```java
System.out.println("Contador: " + contador);
```

**3. Erro de lógica: laço infinito (o `contador` nunca é incrementado)**

```java
while (contador <= 5) {
    System.out.println("Contador: " + contador);
}
```

A variável `contador` começa em `0` e a condição do `while` é `contador <= 5`, mas dentro do laço **nada altera o valor de `contador`**. Isso significa que a condição nunca deixa de ser verdadeira, e o programa fica imprimindo `"Contador: 0"` **infinitamente**, sem nunca terminar.

**Correção:** é necessário incrementar o `contador` a cada repetição, por exemplo com `contador++`.

## Código corrigido completo

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

Note que, apesar de o `Scanner` ter sido criado (`sc`), ele não é usado em nenhum momento no código original — isso não gera erro de compilação, mas é um indício de que talvez o exercício original pretendesse ler algum valor do usuário (como o limite do contador) e essa parte tenha sido esquecida.