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
//
//package CreditCalculator;
//
//import java.util.Locale;
//import java.util.Scanner;
//
//public class CreditCalculator {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        scanner.useLocale(Locale.US);
//
//        System.out.println("What do you want to calculate?");
//        System.out.println("type \"n\" for number of monthly payments,");
//        System.out.println("type \"a\" for annuity monthly payment amount,");
//        System.out.println("type \"p\" for loan principal:");
//        String choice = scanner.next();
//
//        switch (choice) {
//            case "n":
//                calculatePeriods(scanner);
//                break;
//            case "a":
//                calculateAnnuity(scanner);
//                break;
//            case "p":
//                calculatePrincipal(scanner);
//                break;
//            default:
//                System.out.println("Incorrect parameters");
//                break;
//        }
//    }
//
//    static void calculatePeriods(Scanner scanner) {
//        System.out.println("Enter the loan principal:");
//        double principal = scanner.nextDouble();
//
//        System.out.println("Enter the monthly payment:");
//        double payment = scanner.nextDouble();
//
//        System.out.println("Enter the loan interest:");
//        double interest = scanner.nextDouble();
//
//        double i = interest / (12 * 100);
//        double n = Math.log(payment / (payment - i * principal)) / Math.log(1 + i);
//        int totalMonths = (int) Math.ceil(n);
//
//        System.out.println("It will take " + formatDuration(totalMonths) + " to repay this loan!");
//    }
//
//    static void calculateAnnuity(Scanner scanner) {
//        System.out.println("Enter the loan principal:");
//        double principal = scanner.nextDouble();
//
//        System.out.println("Enter the number of periods:");
//        int periods = scanner.nextInt();
//
//        System.out.println("Enter the loan interest:");
//        double interest = scanner.nextDouble();
//
//        double i = interest / (12 * 100);
//        double factor = Math.pow(1 + i, periods);
//        double annuity = principal * (i * factor) / (factor - 1);
//
//        System.out.println("Your monthly payment = " + (int) Math.ceil(annuity) + "!");
//    }
//
//    static void calculatePrincipal(Scanner scanner) {
//        System.out.println("Enter the annuity payment:");
//        double annuity = scanner.nextDouble();
//
//        System.out.println("Enter the number of periods:");
//        int periods = scanner.nextInt();
//
//        System.out.println("Enter the loan interest:");
//        double interest = scanner.nextDouble();
//
//        double i = interest / (12 * 100);
//        double factor = Math.pow(1 + i, periods);
//        double principal = annuity / ((i * factor) / (factor - 1));
//
//        System.out.println("Your loan principal = " + (long) Math.floor(principal) + "!");
//    }
//
//    static String formatDuration(int totalMonths) {
//        int years = totalMonths / 12;
//        int months = totalMonths % 12;
//
//        String yearsPart = years + (years == 1 ? " year" : " years");
//        String monthsPart = months + (months == 1 ? " month" : " months");
//
//        if (years == 0) {
//            return monthsPart;
//        }
//        if (months == 0) {
//            return yearsPart;
//        }
//        return yearsPart + " and " + monthsPart;
//    }
//}



// 4th stage

package CreditCalculator;

import java.util.HashMap;
import java.util.Map;

public class CreditCalculator {
    public static void main(String[] args) {
        Map<String, String> params = parseParameters(args);

        String type = params.get("type");
        if ((!"annuity".equals(type) && !"diff".equals(type)) || params.size() != 4) {
            System.out.println("Incorrect parameters");
            return;
        }

        if (!params.containsKey("interest")) {
            System.out.println("Incorrect parameters");
            return;
        }

        if ("diff".equals(type) && params.containsKey("payment")) {
            System.out.println("Incorrect parameters");
            return;
        }

        try {
            double interest = Double.parseDouble(params.get("interest"));
            if (interest <= 0) {
                System.out.println("Incorrect parameters");
                return;
            }

            Double principal = params.containsKey("principal") ? Double.parseDouble(params.get("principal")) : null;
            Integer periods = params.containsKey("periods") ? Integer.parseInt(params.get("periods")) : null;
            Double payment = params.containsKey("payment") ? Double.parseDouble(params.get("payment")) : null;

            if ((principal != null && principal <= 0)
                    || (periods != null && periods <= 0)
                    || (payment != null && payment <= 0)) {
                System.out.println("Incorrect parameters");
                return;
            }

            if ("diff".equals(type)) {
                if (principal == null || periods == null) {
                    System.out.println("Incorrect parameters");
                    return;
                }
                calculateDifferentiated(principal, periods, interest);
            } else {
                if (payment == null && principal != null && periods != null) {
                    calculateAnnuityPayment(principal, periods, interest);
                } else if (principal == null && payment != null && periods != null) {
                    calculateAnnuityPrincipal(payment, periods, interest);
                } else if (periods == null && principal != null && payment != null) {
                    calculateAnnuityPeriods(principal, payment, interest);
                } else {
                    System.out.println("Incorrect parameters");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect parameters");
        }
    }

    static Map<String, String> parseParameters(String[] args) {
        Map<String, String> params = new HashMap<>();
        String[] keys = {"type", "principal", "periods", "interest", "payment"};

        for (String key : keys) {
            String value = System.getProperty(key);
            if (value != null && !value.isEmpty()) {
                params.put(key, value);
            }
        }

        for (String arg : args) {
            if (arg.startsWith("--") && arg.contains("=")) {
                int eqIndex = arg.indexOf('=');
                String key = arg.substring(2, eqIndex);
                String value = arg.substring(eqIndex + 1);
                if (!value.isEmpty()) {
                    params.put(key, value);
                }
            }
        }
        return params;
    }

    static void calculateDifferentiated(double principal, int periods, double interest) {
        double i = interest / (12 * 100);
        long totalPaid = 0;

        for (int m = 1; m <= periods; m++) {
            double dm = (principal / periods) + i * (principal - (principal * (m - 1)) / periods);
            long roundedPayment = (long) Math.ceil(dm);
            totalPaid += roundedPayment;
            System.out.println("Month " + m + ": payment is " + roundedPayment);
        }

        long overpayment = totalPaid - Math.round(principal);
        System.out.println("\nOverpayment = " + overpayment);
    }

    static void calculateAnnuityPayment(double principal, int periods, double interest) {
        double i = interest / (12 * 100);
        double factor = Math.pow(1 + i, periods);
        double annuity = principal * (i * factor) / (factor - 1);
        long roundedPayment = (long) Math.ceil(annuity);

        System.out.println("Your annuity payment = " + roundedPayment + "!");
        long overpayment = roundedPayment * periods - Math.round(principal);
        System.out.println("Overpayment = " + overpayment);
    }

    static void calculateAnnuityPrincipal(double payment, int periods, double interest) {
        double i = interest / (12 * 100);
        double factor = Math.pow(1 + i, periods);
        double principal = payment / ((i * factor) / (factor - 1));
        long roundedPrincipal = (long) Math.floor(principal);

        System.out.println("Your loan principal = " + roundedPrincipal + "!");
        long overpayment = Math.round(payment * periods) - roundedPrincipal;
        System.out.println("Overpayment = " + overpayment);
    }

    static void calculateAnnuityPeriods(double principal, double payment, double interest) {
        double i = interest / (12 * 100);
        if (payment <= i * principal) {
            System.out.println("Incorrect parameters");
            return;
        }

        double n = Math.log(payment / (payment - i * principal)) / Math.log(1 + i);
        int totalMonths = (int) Math.ceil(n);

        System.out.println("It will take " + formatDuration(totalMonths) + " to repay this loan!");
        long overpayment = Math.round(payment * totalMonths - principal);
        System.out.println("Overpayment = " + overpayment);
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