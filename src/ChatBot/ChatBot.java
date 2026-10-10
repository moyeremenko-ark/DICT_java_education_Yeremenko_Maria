package ChatBot;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1-st stage
        String botName = "Asta";
        String birthYear = "2026";

        System.out.println("Hello! My name is " + botName +".");
        System.out.println("I was created in " + birthYear + ".");

        // 2-nd stage
        System.out.println("Please, remind me your name.");

        String name = scanner.nextLine();

        System.out.println("What a great name you have, " + name + "!");



        scanner.close();
    }
}