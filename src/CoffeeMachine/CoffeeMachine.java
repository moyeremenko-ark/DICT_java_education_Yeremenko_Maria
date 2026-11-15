// 1st stage

//package CoffeeMachine;
//
//public class CoffeeMachine {
//    public static void main(String[] args) {
//        System.out.println("Starting to make a coffee");
//        System.out.println("Grinding coffee beans");
//        System.out.println("Boiling water");
//        System.out.println("Mixing boiled water with crushed coffee beans");
//        System.out.println("Pouring coffee into the cup");
//        System.out.println("Pouring some milk into the cup");
//        System.out.println("Coffee is ready!");
//    }
//}



// 2nd stage

//package CoffeeMachine;
//
//import java.util.Scanner;
//
//public class CoffeeMachine {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Write how many cups of coffee you will need:");
//        int cups = scanner.nextInt();
//
//        int water = cups * 200;
//        int milk = cups * 50;
//        int beans = cups * 15;
//
//        System.out.println("For " + cups + " cups of coffee you will need:");
//        System.out.println(water + " ml of water");
//        System.out.println(milk + " ml of milk");
//        System.out.println(beans + " g of coffee beans");
//    }
//}



// 3rd stage
//
//package CoffeeMachine;
//
//import java.util.Scanner;
//
//public class CoffeeMachine {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Write how many ml of water the coffee machine has:");
//        int water = scanner.nextInt();
//
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int milk = scanner.nextInt();
//
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        int beans = scanner.nextInt();
//
//        System.out.println("Write how many cups of coffee you will need:");
//        int neededCups = scanner.nextInt();
//
//        int cupsFromWater = water / 200;
//        int cupsFromMilk = milk / 50;
//        int cupsFromBeans = beans / 15;
//
//        int maxCups = Math.min(cupsFromWater, Math.min(cupsFromMilk, cupsFromBeans));
//
//        if (maxCups == neededCups) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (maxCups > neededCups) {
//            int extraCups = maxCups - neededCups;
//            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
//        } else {
//            System.out.println("No, I can make only " + maxCups + " cups of coffee");
//        }
//    }
//}



// 4th stage

package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printState();

        System.out.println("\nWrite action (buy, fill, take):");
        String action = scanner.next();

        switch (action) {
            case "buy":
                buy(scanner);
                break;
            case "fill":
                fill(scanner);
                break;
            case "take":
                take();
                break;
        }

        System.out.println();
        printState();
    }

    static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    static void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: // Еспресо
                water -= 250;
                beans -= 16;
                cups -= 1;
                money += 4;
                break;
            case 2: // Лате
                water -= 350;
                milk -= 75;
                beans -= 20;
                cups -= 1;
                money += 7;
                break;
            case 3: // Капучино
                water -= 200;
                milk -= 100;
                beans -= 12;
                cups -= 1;
                money += 6;
                break;
        }
    }

    static void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();

        System.out.println("Write how many disposable coffee cups you want to add:");
        cups += scanner.nextInt();
    }

    static void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }
}