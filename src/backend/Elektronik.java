package backend;

// Class Elektronik mewarisi (extends) dari class Produk
public class Elektronik extends Produk {
    
    // Constructor khusus untuk produk elektronik
    public Elektronik(String nama, double harga, int stok) {
        // Memanggil constructor parent (Produk) dengan kategori "Elektronik"
        super(nama, harga, stok, "Elektronik");
        // Semua produk elektronik otomatis memiliki kategori "Elektronik"
    }
}