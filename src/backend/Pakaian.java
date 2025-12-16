package backend;

// Class Pakaian mewarisi dari class Produk
public class Pakaian extends Produk {
    
    // Constructor khusus untuk produk pakaian
    public Pakaian(String nama, double harga, int stok) {
        // Memanggil constructor parent dengan kategori "Pakaian"
        super(nama, harga, stok, "Pakaian");
        // Semua produk pakaian otomatis memiliki kategori "Pakaian"
    }
}