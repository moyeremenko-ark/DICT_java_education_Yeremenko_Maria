package Hangman;

import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"python", "java", "javascript", "kotlin"};
        String secretWord = words[random.nextInt(words.length)];

        // Формуємо підказку: перші 2 літери + дефіси замість решти
        String hint = secretWord.substring(0, 2) + "-".repeat(secretWord.length() - 2);

        System.out.println("HANGMAN");
        System.out.print("Guess the word " + hint + ": ");

        String input = scanner.nextLine();

        if (secretWord.equals(input)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
