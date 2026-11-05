package Hangman;

import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("HANGMAN");
        System.out.print("Guess the word: ");

        String input = scanner.nextLine();

        if ("java".equals(input)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}