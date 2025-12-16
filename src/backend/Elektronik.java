package backend;

public class Elektronik extends Produk {
    
    public Elektronik(String nama, double harga, int stok) {
        super(nama, harga, stok, "Elektronik");
    }
    
    // Constructor dengan ID (untuk testing/import data)
    public Elektronik(int id, String nama, double harga, int stok) {
        super(id, nama, harga, stok, "Elektronik");
    }
    
    @Override
    public void info() {
        System.out.printf("%d. %s | Elektronik | Rp%,.0f | Stok: %d%n", 
            id, nama, harga, stok);
    }
}