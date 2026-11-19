// 1st stage

package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вхід:");
        int[][] matrixA = readMatrix(scanner);
        int[][] matrixB = readMatrix(scanner);

        System.out.println("Вихід:");
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.out.println("ERROR");
            return;
        }

        int[][] sum = addMatrices(matrixA, matrixB);
        printMatrix(sum);
    }

    static int[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                line.append(row[j]);
                if (j < row.length - 1) {
                    line.append(" ");
                }
            }
            System.out.println(line);
        }
    }
}
