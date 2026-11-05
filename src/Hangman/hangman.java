package Hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"python", "java", "javascript", "kotlin"};

        System.out.println("HANGMAN");

        while (true) {
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: ");
            String action = scanner.nextLine();

            if ("play".equals(action)) {
                playGame(scanner, random, words);
                System.out.println();
            } else if ("exit".equals(action)) {
                break;
            }
        }
    }

    private static void playGame(Scanner scanner, Random random, String[] words) {
        String secretWord = words[random.nextInt(words.length)];
        char[] maskedWord = "-".repeat(secretWord.length()).toCharArray();
        Set<Character> guessedLetters = new HashSet<>();
        int lives = 8;

        while (lives > 0) {
            System.out.println();
            System.out.println(String.valueOf(maskedWord));
            System.out.print("Input a letter: ");

            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char letter = input.charAt(0);

            if (letter < 'a' || letter > 'z') {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (guessedLetters.contains(letter)) {
                System.out.println("You've already guessed this letter");
                continue;
            }

            guessedLetters.add(letter);

            if (secretWord.indexOf(letter) != -1) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == letter) {
                        maskedWord[i] = letter;
                    }
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                lives--;
            }

            if (String.valueOf(maskedWord).equals(secretWord)) {
                System.out.println();
                System.out.println("You guessed the word " + secretWord + "!");
                System.out.println("You survived!");
                return;
            }
        }

        if (lives == 0) {
            System.out.println("You lost!");
        }
    }
}