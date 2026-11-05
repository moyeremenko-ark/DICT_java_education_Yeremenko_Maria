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
        int lives = 8;

        System.out.println("HANGMAN");

        while (lives > 0) {
            System.out.println();
            System.out.println(String.valueOf(maskedWord));
            System.out.print("Input a letter: ");

            String input = scanner.nextLine();
            if (input.isEmpty()) {
                continue;
            }

            char letter = input.charAt(0);

            if (secretWord.indexOf(letter) != -1) {
                boolean alreadyGuessed = false;
                for (char c : maskedWord) {
                    if (c == letter) {
                        alreadyGuessed = true;
                        break;
                    }
                }

                if (alreadyGuessed) {
                    System.out.println("No improvements");
                    lives--;
                } else {
                    for (int i = 0; i < secretWord.length(); i++) {
                        if (secretWord.charAt(i) == letter) {
                            maskedWord[i] = letter;
                        }
                    }
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                lives--;
            }

            if (String.valueOf(maskedWord).equals(secretWord)) {
                System.out.println();
                System.out.println(String.valueOf(maskedWord));
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                break;
            }
        }

        if (lives == 0 && !String.valueOf(maskedWord).equals(secretWord)) {
            System.out.println("You lost!");
        }
    }
}