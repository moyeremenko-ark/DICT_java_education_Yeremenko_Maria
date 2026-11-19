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


package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String cells = scanner.next();

        System.out.println("---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + cells.charAt(i) + " " + cells.charAt(i + 1) + " " + cells.charAt(i + 2) + " |");
        }
        System.out.println("---------");
    }
}