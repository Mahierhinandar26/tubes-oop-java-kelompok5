package backend;

public class Main {
    public static void main(String[] args) {

        Inventori inv = new Inventori();

        Produk laptop = new Elektronik("Laptop", 8000000, 5);
        Produk jaket = new Pakaian("Jaket", 250000, 1);

        inv.tambahProduk(laptop);
        inv.tambahProduk(jaket);

        inv.updateHarga("Laptop", 7500000);

        try {
            inv.kurangiStok("Jaket", 2);
        } catch (StokHabisException e) {
            System.out.println(e.getMessage());
        }

        inv.tampilkanSemua();
    }
}


