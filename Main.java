import java.util.ArrayList;import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("------------- Welcome -------------");
        System.out.println("Enter 1 to sum the numbers");
        System.out.println("Enter 2 to subtract numbers");
        System.out.println("Enter 3 to multiply the numbers");
        System.out.println("Enter 4 to divide the numbers");
        System.out.println("Enter 5 to modulus the numbers");
        System.out.println("Enter 6 to find minimum number");
        System.out.println("Enter 7 to find maximum number");
        System.out.println("Enter 8 to find average of numbers");
        System.out.println("Enter 9 to return the last result");
        System.out.println("Enter 10 to return all previous results");
        System.out.println("Enter 0 to exit");
        System.out.println("-----------------------------------");
    }

    public static double sum(double num, double num2) {
        return num + num2;
    }

    public static double subtract(double num, double num2) {
        return num - num2;
    }

    public static double multiply(double num, double num2) {
        return num * num2;
    }

    public static double divide(double num, double num2) {
        if (num2 == 0) {
            System.out.println("Cannot divide by zero , try again ");
            return 0;
        }
        return num / num2;
    }

    public static double modulus(double num, double num2) {
        if (num2 == 0) {
            System.out.println("Cannot perform modulus by zero , try again ");
            return 0;
        }
        return num % num2;
    }

    public static double minimum(double num, double num2) {
        return Math.min(num, num2);
    }

    public static double maximum(double num, double num2) {
        return Math.max(num, num2);
    }

    public static double average(double num, double num2) {
        return (num + num2) / 2;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<Double> results = new ArrayList<>();
        double lastResult = 0;

        while (true) {
            try {
                menu();
                System.out.print("Enter your choice from the menu: ");
                int choice = s.nextInt();

                if (choice >= 1 && choice <= 8) {
                    System.out.print("Enter first number: ");
                    double num1 = s.nextDouble();

                    System.out.print("Enter second number: ");
                    double num2 = s.nextDouble();

                    switch (choice) {
                        case 1:
                            lastResult = sum(num1, num2);
                            break;
                        case 2:
                            lastResult = subtract(num1, num2);
                            break;
                        case 3:
                            lastResult = multiply(num1, num2);
                            break;
                        case 4:
                            lastResult = divide(num1, num2);
                            break;
                        case 5:
                            lastResult = modulus(num1, num2);
                            break;
                        case 6:
                            lastResult = minimum(num1, num2);
                            break;
                        case 7:
                            lastResult = maximum(num1, num2);
                            break;
                        case 8:
                            lastResult = average(num1, num2);
                            break;
                    }

                    System.out.println("Result: " + lastResult);
                    results.add(lastResult);

                } else if (choice == 9) {
                    System.out.println("Last result: " + lastResult);

                } else if (choice == 10) {
                    System.out.println("All previous results:");
                    for (double res : results) {
                        System.out.println(res);
                    }

                } else if (choice == 0) {
                    System.out.println("Exiting calculator...");
                    break;

                } else {
                    System.out.println("Invalid choice, try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter valid number");
                s.nextLine();
            }catch (Exception e){
                System.out.println(e.fillInStackTrace());
            }
        }
    }
}
