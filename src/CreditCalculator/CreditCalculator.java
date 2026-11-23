// 1st stage

//package CreditCalculator;
//
//public class CreditCalculator {
//    public static void main(String[] args) {
//        System.out.println("Loan principal: 1000");
//        System.out.println("Month 1: repaid 250");
//        System.out.println("Month 2: repaid 250");
//        System.out.println("Month 3: repaid 500");
//        System.out.println("The loan has been repaid!");
//    }
//}



// 2nd stage
package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the loan principal:");
        int principal = scanner.nextInt();

        System.out.println("What do you want to calculate?");
        System.out.println("type \"m\" - for number of monthly payments,");
        System.out.println("type \"p\" - for the monthly payment:");
        String choice = scanner.next();

        switch (choice) {
            case "m":
                calculateMonths(scanner, principal);
                break;
            case "p":
                calculatePayment(scanner, principal);
                break;
            default:
                System.out.println("Incorrect parameters");
                break;
        }
    }

    static void calculateMonths(Scanner scanner, int principal) {
        System.out.println("Enter the monthly payment:");
        int payment = scanner.nextInt();

        int months = (int) Math.ceil((double) principal / payment);
        String monthWord = (months == 1) ? "month" : "months";

        System.out.println("It will take " + months + " " + monthWord + " to repay the loan");
    }

    static void calculatePayment(Scanner scanner, int principal) {
        System.out.println("Enter the number of months:");
        int months = scanner.nextInt();

        int payment = (int) Math.ceil((double) principal / months);
        int lastPayment = principal - (months - 1) * payment;

        if (lastPayment == payment) {
            System.out.println("Your monthly payment = " + payment);
        } else {
            System.out.println("Your monthly payment = " + payment + " and the last payment = " + lastPayment + ".");
        }
    }
}