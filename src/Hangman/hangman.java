package Hangman;

import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"python", "java", "javascript", "kotlin"};
        String secretWord = words[random.nextInt(words.length)];

        char[] maskedWord = "-".repeat(secretWord.length()).toCharArray();

        System.out.println("HANGMAN");

        for (int i = 0; i < 8; i++) {
            System.out.println();
            System.out.println(String.valueOf(maskedWord));
            System.out.print("Input a letter: ");

            String input = scanner.nextLine();

            if (!input.isEmpty()) {
                char letter = input.charAt(0);

                if (secretWord.indexOf(letter) != -1) {
                    for (int j = 0; j < secretWord.length(); j++) {
                        if (secretWord.charAt(j) == letter) {
                            maskedWord[j] = letter;
                        }
                    }
                } else {
                    System.out.println("That letter doesn't appear in the word");
                }
            }
        }

        System.out.println();
        System.out.println("Thanks for playing!");
        System.out.println("We'll see how well you did in the next stage");
    }
}