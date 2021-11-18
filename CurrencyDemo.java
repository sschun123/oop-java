import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyDemo {
    public static void main(String[] args) {
        int items;
        double itemCost, total;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        items = input.nextInt();
        System.out.print("Enter the cost per item: ");
        itemCost = input.nextDouble();
        total = itemCost * items;
        System.out.println();
        System.out.printf("Unformatted Total: %f\n", total);
        // NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("Formatted Total: " + currencyFormat.format(total));
        input.close();
    }
}
