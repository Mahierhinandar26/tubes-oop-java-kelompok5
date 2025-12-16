package backend;

public class Main {
    public static void main(String[] args) {
        // 1. Buat objek Inventori
        Inventori inv = new Inventori();

        // 2. Tambah produk ke inventori
        inv.tambah(new Elektronik("Laptop", 8000000, 5));
        inv.tambah(new Pakaian("Jaket", 250000, 1));
        inv.tambah(new Elektronik("Mouse", 150000, 10));

        // 3. Update harga salah satu produk
        inv.updateHarga("Laptop", 7500000);
        
        // 4. Coba kurangi stok (dengan try-catch untuk exception)
        try {
            inv.kurangiStok("Jaket", 2); // Akan gagal karena stok hanya 1
        } catch (StokHabisException e) {
            // Tangkap dan tampilkan error jika stok habis
            System.out.println("❌ " + e.getMessage());
        }
        
        // 5. Tambah stok untuk produk yang kurang
        inv.tambahStok("Jaket", 5);
        
        // 6. Tampilkan semua produk setelah operasi
        inv.tampilkan();
    }
}