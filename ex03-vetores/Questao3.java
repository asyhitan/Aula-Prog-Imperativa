import java.util.Scanner;

public class Questao3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] vetor = new int[10];

        int soma = 0;

        // leitura

        for (int i = 0; i < 10; i++) {

            System.out.print("Digite um valor: ");

            vetor[i] = sc.nextInt();

            soma += vetor[i];

        }

        double media = soma / 10.0;

        System.out.println("Média: " + media);

        System.out.println("Valores acima da média:");

        for (int i = 0; i < 10; i++) {

            if (vetor[i] > media) {

                System.out.println("Índice: " + i + " | Valor: " + vetor[i]);

            }

        }

        sc.close();

    }

}
 