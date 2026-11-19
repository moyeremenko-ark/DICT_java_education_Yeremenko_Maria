// 1st stage

//package TicTacToe;
//
//public class TicTacToe {
//    public static void main(String[] args) {
//        System.out.println("X O X");
//        System.out.println("O X O");
//        System.out.println("X X O");
//    }
//}


// 2nd stage

//package TicTacToe;
//
//import java.util.Scanner;
//
//public class TicTacToe {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter cells: ");
//        String cells = scanner.next();
//
//        System.out.println("---------");
//        for (int i = 0; i < 9; i += 3) {
//            System.out.println("| " + cells.charAt(i) + " " + cells.charAt(i + 1) + " " + cells.charAt(i + 2) + " |");
//        }
//        System.out.println("---------");
//    }
//}


package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.next();

        char[][] board = new char[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = input.charAt(i);
        }

        printBoard(board);
        System.out.println(analyzeState(board));
    }

    static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int row = 0; row < 3; row++) {
            System.out.println("| " + board[row][0] + " " + board[row][1] + " " + board[row][2] + " |");
        }
        System.out.println("---------");
    }

    static String analyzeState(char[][] board) {
        int xCount = 0;
        int oCount = 0;
        int emptyCount = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == 'X') {
                    xCount++;
                } else if (board[row][col] == 'O') {
                    oCount++;
                } else {
                    emptyCount++;
                }
            }
        }

        boolean xWins = hasWon(board, 'X');
        boolean oWins = hasWon(board, 'O');

        // 1. Спочатку відсіюємо неможливі ситуації
        if (Math.abs(xCount - oCount) >= 2 || (xWins && oWins)) {
            return "Impossible";
        }
        // 2. Перевіряємо переможців
        if (xWins) {
            return "X wins";
        }
        if (oWins) {
            return "O wins";
        }
        // 3. Якщо переможців немає — дивимося, чи залишилися ходи
        if (emptyCount > 0) {
            return "Game not finished";
        }

        return "Draw";
    }

    static boolean hasWon(char[][] board, char player) {
        // Перевірка рядків і стовпців
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Перевірка обох діагоналей
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}