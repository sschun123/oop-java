import java.util.Scanner;
import java.text.NumberFormat;

public class TempConvert {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a F value: ");
        int fahrenheit = input.nextInt();
        System.out.print("Enter the day of the week: ");
        input.next();
        System.out.print("Enter your preferred label (Celsius, Centigrade, or C): ");
        String cText = input.next();
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        String day = input.nextLine();
        String fOutput = String.format("%s Fahrenheit: %d\n", day, fahrenheit);
        String cOutput = String.format("%s %10s: %,.1f\n ", day, cText, celsius);
        System.out.printf(fOutput);
        System.out.printf(cOutput);
        input.close();
    }
}