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

package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int neededCups = scanner.nextInt();

        int cupsFromWater = water / 200;
        int cupsFromMilk = milk / 50;
        int cupsFromBeans = beans / 15;

        int maxCups = Math.min(cupsFromWater, Math.min(cupsFromMilk, cupsFromBeans));

        if (maxCups == neededCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxCups > neededCups) {
            int extraCups = maxCups - neededCups;
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
        } else {
            System.out.println("No, I can make only " + maxCups + " cups of coffee");
        }
    }
}