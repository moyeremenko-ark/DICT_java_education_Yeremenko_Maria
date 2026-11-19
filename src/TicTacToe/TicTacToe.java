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



// 3rd stage

//package TicTacToe;
//
//import java.util.Scanner;
//
//public class TicTacToe {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter cells: ");
//        String input = scanner.next();
//
//        char[][] board = new char[3][3];
//        for (int i = 0; i < 9; i++) {
//            board[i / 3][i % 3] = input.charAt(i);
//        }
//
//        printBoard(board);
//        System.out.println(analyzeState(board));
//    }
//
//    static void printBoard(char[][] board) {
//        System.out.println("---------");
//        for (int row = 0; row < 3; row++) {
//            System.out.println("| " + board[row][0] + " " + board[row][1] + " " + board[row][2] + " |");
//        }
//        System.out.println("---------");
//    }
//
//    static String analyzeState(char[][] board) {
//        int xCount = 0;
//        int oCount = 0;
//        int emptyCount = 0;
//
//        for (int row = 0; row < 3; row++) {
//            for (int col = 0; col < 3; col++) {
//                if (board[row][col] == 'X') {
//                    xCount++;
//                } else if (board[row][col] == 'O') {
//                    oCount++;
//                } else {
//                    emptyCount++;
//                }
//            }
//        }
//
//        boolean xWins = hasWon(board, 'X');
//        boolean oWins = hasWon(board, 'O');
//
//        // 1. Спочатку відсіюємо неможливі ситуації
//        if (Math.abs(xCount - oCount) >= 2 || (xWins && oWins)) {
//            return "Impossible";
//        }
//        // 2. Перевіряємо переможців
//        if (xWins) {
//            return "X wins";
//        }
//        if (oWins) {
//            return "O wins";
//        }
//        // 3. Якщо переможців немає — дивимося, чи залишилися ходи
//        if (emptyCount > 0) {
//            return "Game not finished";
//        }
//
//        return "Draw";
//    }
//
//    static boolean hasWon(char[][] board, char player) {
//        // Перевірка рядків і стовпців
//        for (int i = 0; i < 3; i++) {
//            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
//                return true;
//            }
//            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
//                return true;
//            }
//        }
//        // Перевірка обох діагоналей
//        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
//            return true;
//        }
//        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
//            return true;
//        }
//        return false;
//    }
//}



// 4th stage

//package TicTacToe;
//
//import java.util.Scanner;
//
//public class TicTacToe {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter cells: ");
//        String input = scanner.nextLine();
//
//        char[][] board = new char[3][3];
//        for (int i = 0; i < 9; i++) {
//            char ch = input.charAt(i);
//            board[i / 3][i % 3] = (ch == '_') ? ' ' : ch;
//        }
//
//        printBoard(board);
//        makeMove(scanner, board);
//        printBoard(board);
//    }
//
//    static void printBoard(char[][] board) {
//        System.out.println("---------");
//        for (int row = 0; row < 3; row++) {
//            System.out.println("| " + board[row][0] + " " + board[row][1] + " " + board[row][2] + " |");
//        }
//        System.out.println("---------");
//    }
//
//    static void makeMove(Scanner scanner, char[][] board) {
//        while (true) {
//            System.out.print("Enter the coordinates: ");
//            String line = scanner.nextLine().trim();
//            String[] parts = line.split("\\s+");
//
//            if (parts.length != 2) {
//                System.out.println("You should enter numbers!");
//                continue;
//            }
//
//            int row;
//            int col;
//            try {
//                row = Integer.parseInt(parts[0]);
//                col = Integer.parseInt(parts[1]);
//            } catch (NumberFormatException e) {
//                System.out.println("You should enter numbers!");
//                continue;
//            }
//
//            if (row < 1 || row > 3 || col < 1 || col > 3) {
//                System.out.println("Coordinates should be from 1 to 3!");
//                continue;
//            }
//
//            if (board[row - 1][col - 1] != ' ') {
//                System.out.println("This cell is occupied! Choose another one!");
//                continue;
//            }
//
//            board[row - 1][col - 1] = 'X';
//            break;
//        }
//    }
//}



// 5th stage

package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[3][3];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }

        char currentPlayer = 'X';
        int moves = 0;

        printBoard(board);

        while (true) {
            makeMove(scanner, board, currentPlayer);
            moves++;
            printBoard(board);

            if (hasWon(board, currentPlayer)) {
                System.out.println(currentPlayer + " wins");
                break;
            }
            if (moves == 9) {
                System.out.println("Draw");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int row = 0; row < 3; row++) {
            System.out.println("| " + board[row][0] + " " + board[row][1] + " " + board[row][2] + " |");
        }
        System.out.println("---------");
    }

    static void makeMove(Scanner scanner, char[][] board, char player) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");

            if (parts.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int row;
            int col;
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (board[row - 1][col - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            board[row - 1][col - 1] = player;
            break;
        }
    }

    static boolean hasWon(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}