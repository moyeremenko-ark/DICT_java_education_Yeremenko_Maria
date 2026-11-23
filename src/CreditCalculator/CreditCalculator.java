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

//package CreditCalculator;
//
//import java.util.Scanner;
//
//public class CreditCalculator {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter the loan principal:");
//        int principal = scanner.nextInt();
//
//        System.out.println("What do you want to calculate?");
//        System.out.println("type \"m\" - for number of monthly payments,");
//        System.out.println("type \"p\" - for the monthly payment:");
//        String choice = scanner.next();
//
//        switch (choice) {
//            case "m":
//                calculateMonths(scanner, principal);
//                break;
//            case "p":
//                calculatePayment(scanner, principal);
//                break;
//            default:
//                System.out.println("Incorrect parameters");
//                break;
//        }
//    }
//
//    static void calculateMonths(Scanner scanner, int principal) {
//        System.out.println("Enter the monthly payment:");
//        int payment = scanner.nextInt();
//
//        int months = (int) Math.ceil((double) principal / payment);
//        String monthWord = (months == 1) ? "month" : "months";
//
//        System.out.println("It will take " + months + " " + monthWord + " to repay the loan");
//    }
//
//    static void calculatePayment(Scanner scanner, int principal) {
//        System.out.println("Enter the number of months:");
//        int months = scanner.nextInt();
//
//        int payment = (int) Math.ceil((double) principal / months);
//        int lastPayment = principal - (months - 1) * payment;
//
//        if (lastPayment == payment) {
//            System.out.println("Your monthly payment = " + payment);
//        } else {
//            System.out.println("Your monthly payment = " + payment + " and the last payment = " + lastPayment + ".");
//        }
//    }
//}



// 3rd stage

package CreditCalculator;

import java.util.Locale;
import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("What do you want to calculate?");
        System.out.println("type \"n\" for number of monthly payments,");
        System.out.println("type \"a\" for annuity monthly payment amount,");
        System.out.println("type \"p\" for loan principal:");
        String choice = scanner.next();

        switch (choice) {
            case "n":
                calculatePeriods(scanner);
                break;
            case "a":
                calculateAnnuity(scanner);
                break;
            case "p":
                calculatePrincipal(scanner);
                break;
            default:
                System.out.println("Incorrect parameters");
                break;
        }
    }

    static void calculatePeriods(Scanner scanner) {
        System.out.println("Enter the loan principal:");
        double principal = scanner.nextDouble();

        System.out.println("Enter the monthly payment:");
        double payment = scanner.nextDouble();

        System.out.println("Enter the loan interest:");
        double interest = scanner.nextDouble();

        double i = interest / (12 * 100);
        double n = Math.log(payment / (payment - i * principal)) / Math.log(1 + i);
        int totalMonths = (int) Math.ceil(n);

        System.out.println("It will take " + formatDuration(totalMonths) + " to repay this loan!");
    }

    static void calculateAnnuity(Scanner scanner) {
        System.out.println("Enter the loan principal:");
        double principal = scanner.nextDouble();

        System.out.println("Enter the number of periods:");
        int periods = scanner.nextInt();

        System.out.println("Enter the loan interest:");
        double interest = scanner.nextDouble();

        double i = interest / (12 * 100);
        double factor = Math.pow(1 + i, periods);
        double annuity = principal * (i * factor) / (factor - 1);

        System.out.println("Your monthly payment = " + (int) Math.ceil(annuity) + "!");
    }

    static void calculatePrincipal(Scanner scanner) {
        System.out.println("Enter the annuity payment:");
        double annuity = scanner.nextDouble();

        System.out.println("Enter the number of periods:");
        int periods = scanner.nextInt();

        System.out.println("Enter the loan interest:");
        double interest = scanner.nextDouble();

        double i = interest / (12 * 100);
        double factor = Math.pow(1 + i, periods);
        double principal = annuity / ((i * factor) / (factor - 1));

        System.out.println("Your loan principal = " + (long) Math.floor(principal) + "!");
    }

    static String formatDuration(int totalMonths) {
        int years = totalMonths / 12;
        int months = totalMonths % 12;

        String yearsPart = years + (years == 1 ? " year" : " years");
        String monthsPart = months + (months == 1 ? " month" : " months");

        if (years == 0) {
            return monthsPart;
        }
        if (months == 0) {
            return yearsPart;
        }
        return yearsPart + " and " + monthsPart;
    }
}