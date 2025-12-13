public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        Product p1 = new Product("Laptop", 8000000, 5, "Elektronik");
        Product p2 = new Product("Jaket", 250000, 1, "Pakaian");

        inv.addProduct(p1);
        inv.addProduct(p2);

        inv.updatePrice("Laptop", 7500000);

        try {
            inv.reduceStock("Jaket", 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        inv.showAll();
    }
}