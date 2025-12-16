package backend;

public class Produk {
    // Atribut class Produk
    protected int id;            // ID unik produk
    protected String nama;       // Nama produk
    protected double harga;      // Harga satuan
    protected int stok;         // Jumlah stok tersedia
    protected String kategori;   // Kategori produk

    // Constructor untuk inisialisasi produk baru
    public Produk(String nama, double harga, int stok, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
        // Note: ID akan di-set oleh Inventori saat ditambahkan
    }
    
    // Method untuk menampilkan informasi produk
    public void info() {
        // Format output: "Nama | Kategori | RpX,XXX,XXX | Stok: XX"
        System.out.printf("%s | %s | Rp%,.0f | Stok: %d%n", 
            nama, kategori, harga, stok);
    }
}