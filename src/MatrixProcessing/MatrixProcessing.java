// 1st stage

//package MatrixProcessing;
//
//import java.util.Scanner;
//
//public class MatrixProcessing {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Вхід:");
//        int[][] matrixA = readMatrix(scanner);
//        int[][] matrixB = readMatrix(scanner);
//
//        System.out.println("Вихід:");
//        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
//            System.out.println("ERROR");
//            return;
//        }
//
//        int[][] sum = addMatrices(matrixA, matrixB);
//        printMatrix(sum);
//    }
//
//    static int[][] readMatrix(Scanner scanner) {
//        int rows = scanner.nextInt();
//        int cols = scanner.nextInt();
//        int[][] matrix = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                matrix[i][j] = scanner.nextInt();
//            }
//        }
//        return matrix;
//    }
//
//    static int[][] addMatrices(int[][] a, int[][] b) {
//        int rows = a.length;
//        int cols = a[0].length;
//        int[][] result = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                result[i][j] = a[i][j] + b[i][j];
//            }
//        }
//        return result;
//    }
//
//    static void printMatrix(int[][] matrix) {
//        for (int[] row : matrix) {
//            StringBuilder line = new StringBuilder();
//            for (int j = 0; j < row.length; j++) {
//                line.append(row[j]);
//                if (j < row.length - 1) {
//                    line.append(" ");
//                }
//            }
//            System.out.println(line);
//        }
//    }
//}



// 2nd stage

//package MatrixProcessing;
//
//import java.util.Scanner;
//
//public class MatrixProcessing {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Вхід:");
//        int[][] matrix = readMatrix(scanner);
//        int constant = scanner.nextInt();
//
//        System.out.println("Вихід:");
//        int[][] result = multiplyByConstant(matrix, constant);
//        printMatrix(result);
//    }
//
//    static int[][] readMatrix(Scanner scanner) {
//        int rows = scanner.nextInt();
//        int cols = scanner.nextInt();
//        int[][] matrix = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                matrix[i][j] = scanner.nextInt();
//            }
//        }
//        return matrix;
//    }
//
//    static int[][] addMatrices(int[][] a, int[][] b) {
//        int rows = a.length;
//        int cols = a[0].length;
//        int[][] result = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                result[i][j] = a[i][j] + b[i][j];
//            }
//        }
//        return result;
//    }
//
//    static int[][] multiplyByConstant(int[][] matrix, int constant) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int[][] result = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                result[i][j] = matrix[i][j] * constant;
//            }
//        }
//        return result;
//    }
//
//    static void printMatrix(int[][] matrix) {
//        for (int[] row : matrix) {
//            StringBuilder line = new StringBuilder();
//            for (int j = 0; j < row.length; j++) {
//                line.append(row[j]);
//                if (j < row.length - 1) {
//                    line.append(" ");
//                }
//            }
//            System.out.println(line);
//        }
//    }
//}



// 3rd stage

//package MatrixProcessing;
//
//import java.util.Locale;
//import java.util.Scanner;
//
//public class MatrixProcessing {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        scanner.useLocale(Locale.US);
//
//        while (true) {
//            printMenu();
//            System.out.print("Your choice: ");
//            int choice = scanner.nextInt();
//
//            if (choice == 0) {
//                break;
//            }
//
//            switch (choice) {
//                case 1:
//                    handleAddition(scanner);
//                    break;
//                case 2:
//                    handleScalarMultiplication(scanner);
//                    break;
//                case 3:
//                    handleMatrixMultiplication(scanner);
//                    break;
//            }
//            System.out.println();
//        }
//    }
//
//    static void printMenu() {
//        System.out.println("1. Add matrices");
//        System.out.println("2. Multiply matrix by a constant");
//        System.out.println("3. Multiply matrices");
//        System.out.println("0. Exit");
//    }
//
//    static void handleAddition(Scanner scanner) {
//        System.out.print("Enter size of first matrix: ");
//        int rowsA = scanner.nextInt();
//        int colsA = scanner.nextInt();
//        System.out.println("Enter first matrix:");
//        double[][] matrixA = readMatrix(scanner, rowsA, colsA);
//
//        System.out.print("Enter size of second matrix: ");
//        int rowsB = scanner.nextInt();
//        int colsB = scanner.nextInt();
//        System.out.println("Enter second matrix:");
//        double[][] matrixB = readMatrix(scanner, rowsB, colsB);
//
//        if (rowsA != rowsB || colsA != colsB) {
//            System.out.println("The operation cannot be performed.");
//            return;
//        }
//
//        System.out.println("The result is:");
//        printMatrix(addMatrices(matrixA, matrixB));
//    }
//
//    static void handleScalarMultiplication(Scanner scanner) {
//        System.out.print("Enter size of matrix: ");
//        int rows = scanner.nextInt();
//        int cols = scanner.nextInt();
//        System.out.println("Enter matrix:");
//        double[][] matrix = readMatrix(scanner, rows, cols);
//
//        System.out.print("Enter constant: ");
//        double constant = scanner.nextDouble();
//
//        System.out.println("The result is:");
//        printMatrix(multiplyByConstant(matrix, constant));
//    }
//
//    static void handleMatrixMultiplication(Scanner scanner) {
//        System.out.print("Enter size of first matrix: ");
//        int rowsA = scanner.nextInt();
//        int colsA = scanner.nextInt();
//        System.out.println("Enter first matrix:");
//        double[][] matrixA = readMatrix(scanner, rowsA, colsA);
//
//        System.out.print("Enter size of second matrix: ");
//        int rowsB = scanner.nextInt();
//        int colsB = scanner.nextInt();
//        System.out.println("Enter second matrix:");
//        double[][] matrixB = readMatrix(scanner, rowsB, colsB);
//
//        if (colsA != rowsB) {
//            System.out.println("The operation cannot be performed.");
//            return;
//        }
//
//        System.out.println("The result is:");
//        printMatrix(multiplyMatrices(matrixA, matrixB));
//    }
//
//    static double[][] readMatrix(Scanner scanner, int rows, int cols) {
//        double[][] matrix = new double[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                matrix[i][j] = scanner.nextDouble();
//            }
//        }
//        return matrix;
//    }
//
//    static double[][] addMatrices(double[][] a, double[][] b) {
//        int rows = a.length;
//        int cols = a[0].length;
//        double[][] result = new double[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                result[i][j] = a[i][j] + b[i][j];
//            }
//        }
//        return result;
//    }
//
//    static double[][] multiplyByConstant(double[][] matrix, double constant) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        double[][] result = new double[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                result[i][j] = matrix[i][j] * constant;
//            }
//        }
//        return result;
//    }
//
//    static double[][] multiplyMatrices(double[][] a, double[][] b) {
//        int rowsA = a.length;
//        int colsA = a[0].length;
//        int colsB = b[0].length;
//        double[][] result = new double[rowsA][colsB];
//
//        for (int i = 0; i < rowsA; i++) {
//            for (int j = 0; j < colsB; j++) {
//                for (int k = 0; k < colsA; k++) {
//                    result[i][j] += a[i][k] * b[k][j];
//                }
//            }
//        }
//        return result;
//    }
//
//    static void printMatrix(double[][] matrix) {
//        for (double[] row : matrix) {
//            StringBuilder line = new StringBuilder();
//            for (int j = 0; j < row.length; j++) {
//                double val = (row[j] == 0) ? 0.0 : row[j];
//                if (val == (long) val) {
//                    line.append((long) val);
//                } else {
//                    line.append(val);
//                }
//                if (j < row.length - 1) {
//                    line.append(" ");
//                }
//            }
//            System.out.println(line);
//        }
//    }
//}



// 4th stage

package MatrixProcessing;

import java.util.Locale;
import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        while (true) {
            printMenu();
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    handleAddition(scanner);
                    break;
                case 2:
                    handleScalarMultiplication(scanner);
                    break;
                case 3:
                    handleMatrixMultiplication(scanner);
                    break;
                case 4:
                    handleTransposition(scanner);
                    break;
            }
            System.out.println();
        }
    }

    static void printMenu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("0. Exit");
    }

    static void handleAddition(Scanner scanner) {
        System.out.print("Enter size of first matrix: ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] matrixA = readMatrix(scanner, rowsA, colsA);

        System.out.print("Enter size of second matrix: ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        System.out.println("Enter second matrix:");
        double[][] matrixB = readMatrix(scanner, rowsB, colsB);

        if (rowsA != rowsB || colsA != colsB) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        System.out.println("The result is:");
        printMatrix(addMatrices(matrixA, matrixB));
    }

    static void handleScalarMultiplication(Scanner scanner) {
        System.out.print("Enter size of matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        System.out.println("Enter matrix:");
        double[][] matrix = readMatrix(scanner, rows, cols);

        System.out.print("Enter constant: ");
        double constant = scanner.nextDouble();

        System.out.println("The result is:");
        printMatrix(multiplyByConstant(matrix, constant));
    }

    static void handleMatrixMultiplication(Scanner scanner) {
        System.out.print("Enter size of first matrix: ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] matrixA = readMatrix(scanner, rowsA, colsA);

        System.out.print("Enter size of second matrix: ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        System.out.println("Enter second matrix:");
        double[][] matrixB = readMatrix(scanner, rowsB, colsB);

        if (colsA != rowsB) {
            System.out.println("The operation cannot be performed.");
            return;
        }

        System.out.println("The result is:");
        printMatrix(multiplyMatrices(matrixA, matrixB));
    }

    static void handleTransposition(Scanner scanner) {
        System.out.println("\n1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
        int transposeType = scanner.nextInt();

        System.out.print("Enter matrix size: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        System.out.println("Enter matrix:");
        double[][] matrix = readMatrix(scanner, rows, cols);

        double[][] result;
        switch (transposeType) {
            case 1:
                result = transposeMainDiagonal(matrix);
                break;
            case 2:
                result = transposeSideDiagonal(matrix);
                break;
            case 3:
                result = transposeVertical(matrix);
                break;
            case 4:
                result = transposeHorizontal(matrix);
                break;
            default:
                System.out.println("The operation cannot be performed.");
                return;
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    static double[][] transposeMainDiagonal(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    static double[][] transposeSideDiagonal(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result[i][j] = matrix[rows - 1 - j][cols - 1 - i];
            }
        }
        return result;
    }

    static double[][] transposeVertical(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][cols - 1 - j];
            }
        }
        return result;
    }

    static double[][] transposeHorizontal(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[rows - 1 - i][j];
            }
        }
        return result;
    }

    static double[][] readMatrix(Scanner scanner, int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    static double[][] addMatrices(double[][] a, double[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    static double[][] multiplyByConstant(double[][] matrix, double constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }
        return result;
    }

    static double[][] multiplyMatrices(double[][] a, double[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                double val = (row[j] == 0) ? 0.0 : row[j];
                if (val == (long) val) {
                    line.append((long) val);
                } else {
                    line.append(val);
                }
                if (j < row.length - 1) {
                    line.append(" ");
                }
            }
            System.out.println(line);
        }
    }
}