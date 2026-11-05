package Hangman;

import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"python", "java", "javascript", "kotlin"};
        String secretWord = words[random.nextInt(words.length)];

        System.out.println("HANGMAN");
        System.out.print("Guess the word: ");

        String input = scanner.nextLine();

        if (secretWord.equals(input)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}