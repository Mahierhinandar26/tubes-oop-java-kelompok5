package backend;

public class Pakaian extends Produk {
    
    // Constructor dengan ID (untuk testing/import data)
    public Pakaian(int id, String nama, double harga, int stok) {
        super(id, nama, harga, stok, "Pakaian");
    }
    
    @Override
    public void info() {
        System.out.printf("%d. %s | Pakaian | Rp%,.0f | Stok: %d%n", 
            id, nama, harga, stok);
    }
}