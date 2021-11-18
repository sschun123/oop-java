import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String operation = input.nextLine().toLowerCase();
        final String ERROR_MSG = "Invalid input entered. Terminating...";

        switch (operation) {
            case "add":
                System.out.println("Enter two integers:");

                try {
                    int a = input.nextInt();
                    int b = input.nextInt();
                    int answer = a + b;
                    System.out.println("Answer: " + answer);
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_MSG);
                    input.close();
                    return;
                }
                break;
            case "subtract":
                System.out.println("Enter two integers:");

                try {
                    int a = input.nextInt();
                    int b = input.nextInt();
                    int answer = a - b;
                    System.out.println("Answer: " + answer);
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_MSG);
                    input.close();
                    return;
                }
                break;
            case "multiply":
                System.out.println("Enter two doubles:");

                try {
                    double a = input.nextDouble();
                    double b = input.nextDouble();
                    double answer = a * b;
                    System.out.printf("Answer: %,.2f\n", answer);                    
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_MSG);
                    input.close();
                    return;
                }
                break;
            case "divide":
                System.out.println("Enter two doubles:");

                try {
                    double a = input.nextDouble();
                    double b = input.nextDouble();
                    if (b == 0) {
                        System.out.println(ERROR_MSG);
                        input.close();
                        return;
                    } 
                    double answer = a / b;
                    System.out.printf("Answer: %,.2f\n", answer);
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_MSG);
                    input.close();
                    return;
                }
                break;
            case "alphabetize":
                System.out.println("Enter two words:");

                try {
                    String a = input.next().toLowerCase();
                    String b = input.next().toLowerCase();
                    input.nextLine();
                    String answer;
                    int compare = a.compareTo(b);
                    if (compare < 0) {
                        answer = String.format("%s comes before %s alphabetically", a, b);
                    }
                    else if (compare > 0) {
                        answer = String.format("%s comes before %s alphabetically", b, a);
                    }
                    else {
                        answer = "Chicken or Egg";
                    }
                    System.out.printf("Answer: %s\n", answer);
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_MSG);
                    input.close();
                    return;
                }
                break;    
            default:
                System.out.println(ERROR_MSG);
                input.close();
                return;
        }
        input.close();
    }
}
