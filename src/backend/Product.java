package backend;
public class Product {
    String nama;
    double harga;
    int stok;
    String kategori;

    public Product(String nama, double harga, int stok, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }

    void info() {
        System.out.println(nama + " | " + kategori +
                " | Harga: " + harga +
                " | Stok: " + stok);
    }
}
