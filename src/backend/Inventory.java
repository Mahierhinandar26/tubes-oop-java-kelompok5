package backend;
import java.util.ArrayList;

public class Inventory {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public Product searchProduct(String nama) {
        for (Product p : products) {
            if (p.nama.equalsIgnoreCase(nama)) {
                return p;
            }
        }
        return null;
    }

    public void updatePrice(String nama, double hargaBaru) {
        Product p = searchProduct(nama);
        if (p != null) {
            p.harga = hargaBaru;
        }
    }

    public void reduceStock(String nama, int jumlah) {
        Product p = searchProduct(nama);
        if (p != null) {
            if (p.stok < jumlah) {
                throw new RuntimeException("Stok habis!");
            }
            p.stok -= jumlah;
        }
    }

    public void showAll() {
        for (Product p : products) {
            p.info();
        }
    }
}
