package aula24032026; 

public class Main {
   public static void main(String[] args) {
       int[][] A = {
           {1, 2, 3},
           {4, 5, 6},
           {7, 8, 9}
       };
       int[][] B = {
           {4, 1, 0},
           {3, 1, 2},
           {2, 1, 1}
       };
       int[][] C = new int[3][3];
       // Soma das matrizes
       for (int i = 0; i < A.length; i++) {
           for (int j = 0; j < A.length; j++) {
               C[i][j] = A[i][j] + B[i][j];
           }
       }
       // Mostrar resultado
       System.out.println("Matriz C (A + B):");
       for (int i = 0; i < C.length; i++) {
           for (int j = 0; j < C.length; j++) {
               System.out.print(C[i][j] + "\t");
           }
           System.out.println();
       }
   }
}
    
