import java.util.ArrayList;

public class Inventory {
    ArrayList<Product> products = new ArrayList<>();

    // TAMBAH PRODUK
    void addProduct(Product p) {
        products.add(p);
    }

    // CARI PRODUK
    Product searchProduct(String nama) {
        for (Product p : products) {
            if (p.nama.equalsIgnoreCase(nama)) {
                return p;
            }
        }
        return null;
    }

    // UPDATE HARGA
    void updatePrice(String nama, double hargaBaru) {
        Product p = searchProduct(nama);
        if (p != null) {
            p.harga = hargaBaru;
        }
    }

    // KURANGI STOK
    void reduceStock(String nama, int jumlah) throws Exception {
        Product p = searchProduct(nama);
        if (p != null) {
            if (p.stok < jumlah) {
                throw new Exception("Stok produk habis!");
            }
            p.stok -= jumlah;
        }
    }

    // TAMPIL SEMUA
    void showAll() {
        for (Product p : products) {
            p.info();
        }
    }
}