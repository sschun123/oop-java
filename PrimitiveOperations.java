public class PrimitiveOperations {
    public static void main(String[] args) {
        int items = 20;
        double cost = 212.0;
        System.out.println(items);
        System.out.println(cost);

        double totalCost = items * cost;
        System.out.println(totalCost);

        float floatItems = (float)items;
        System.out.println(floatItems);

        char first = 'A';
        System.out.println(first);

        int ascii = (int) first;
        ascii = ascii + 32;
        System.out.println(Character.toString(ascii));
    }
}
