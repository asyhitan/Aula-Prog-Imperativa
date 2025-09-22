import java.util.Scanner;

public class atv01 {

    static final int CAPACIDADE = 30;

    public static void main(String[] args) {
        int[] conjuntoA = new int[CAPACIDADE];
        int[] conjuntoB = new int[CAPACIDADE];
        int tamA = 0, tamB = 0;

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1) Inserir elemento no Conjunto A");
            System.out.println("2) Inserir elemento no Conjunto B");
            System.out.println("3) Imprimir os Conjuntos A e B");
            System.out.println("4) União de A e B");
            System.out.println("5) Interseção de A e B");
            System.out.println("6) Diferença A - B");
            System.out.println("7) Diferença B - A");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    tamA = inserirElemento(conjuntoA, tamA, sc);
                    break;
                case 2:
                    tamB = inserirElemento(conjuntoB, tamB, sc);
                    break;
                case 3:
                    System.out.print("Conjunto A: ");
                    imprimir(conjuntoA, tamA);
                    System.out.print("Conjunto B: ");
                    imprimir(conjuntoB, tamB);
                    break;
                case 4:
                    int[] uniao = uniao(conjuntoA, tamA, conjuntoB, tamB);
                    System.out.print("União A ∪ B: ");
                    imprimir(uniao, tamanhoArray(uniao));
                    break;
                case 5:
                    int[] intersec = intersecao(conjuntoA, tamA, conjuntoB, tamB);
                    System.out.print("Interseção A ∩ B: ");
                    imprimir(intersec, tamanhoArray(intersec));
                    break;
                case 6:
                    int[] difAB = diferenca(conjuntoA, tamA, conjuntoB, tamB);
                    System.out.print("Diferença A - B: ");
                    imprimir(difAB, tamanhoArray(difAB));
                    break;
                case 7:
                    int[] difBA = diferenca(conjuntoB, tamB, conjuntoA, tamA);
                    System.out.print("Diferença B - A: ");
                    imprimir(difBA, tamanhoArray(difBA));
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    public static int inserirElemento(int[] v, int tam, Scanner sc) {
        if (tam >= CAPACIDADE) {
            System.out.println("Vetor cheio! Não é possível inserir mais elementos.");
            return tam;
        }

        System.out.print("Digite um número inteiro para inserir: ");
        int x = sc.nextInt();

        if (buscaSequencial(v, tam, x) != -1) {
            System.out.println("Elemento já existe no conjunto!");
            return tam;
        }

        v[tam] = x;
        System.out.println("Elemento inserido com sucesso.");
        return tam + 1;
    }

    public static int buscaSequencial(int[] v, int tam, int x) {
        for (int i = 0; i < tam; i++) {
            if (v[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void imprimir(int[] v, int tam) {
        System.out.print("{ ");
        for (int i = 0; i < tam; i++) {
            System.out.print(v[i]);
            if (i < tam - 1) System.out.print(", ");
        }
        System.out.println(" }");
    }

    public static int[] uniao(int[] a, int tamA, int[] b, int tamB) {
        int[] resultado = new int[CAPACIDADE * 2];
        int tamRes = 0;

        for (int i = 0; i < tamA; i++) {
            resultado[tamRes++] = a[i];
        }

        for (int i = 0; i < tamB; i++) {
            if (buscaSequencial(resultado, tamRes, b[i]) == -1) {
                resultado[tamRes++] = b[i];
            }
        }

        return copiarArray(resultado, tamRes);
    }

    public static int[] intersecao(int[] a, int tamA, int[] b, int tamB) {
        int[] resultado = new int[Math.min(tamA, tamB)];
        int tamRes = 0;

        for (int i = 0; i < tamA; i++) {
            if (buscaSequencial(b, tamB, a[i]) != -1) {
                resultado[tamRes++] = a[i];
            }
        }

        return copiarArray(resultado, tamRes);
    }

    public static int[] diferenca(int[] a, int tamA, int[] b, int tamB) {
        int[] resultado = new int[tamA];
        int tamRes = 0;

        for (int i = 0; i < tamA; i++) {
            if (buscaSequencial(b, tamB, a[i]) == -1) {
                resultado[tamRes++] = a[i];
            }
        }

        return copiarArray(resultado, tamRes);
    }

    public static int[] copiarArray(int[] origem, int tamanho) {
        int[] destino = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            destino[i] = origem[i];
        }
        return destino;
    }

    public static int tamanhoArray(int[] v) {
        int count = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != 0 || i == 0) count++; // evita parar se primeiro elemento for 0
        }
        return count;
    }
}
