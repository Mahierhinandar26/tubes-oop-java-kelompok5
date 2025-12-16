package backend;

public class Produk {
    protected int id;            // ID unik produk
    protected String nama;       // Nama produk
    protected double harga;      // Harga satuan
    protected int stok;         // Jumlah stok tersedia
    protected String kategori;   // Kategori produk

    // Constructor untuk inisialisasi produk baru
    public Produk(String nama, double harga, int stok, String kategori) {
        this.id = 0;  // ID default, akan di-set oleh Inventori
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }
    
    // Constructor dengan ID (untuk testing)
    public Produk(int id, String nama, double harga, int stok, String kategori) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }
    
    // Getter untuk ID
    public int getId() {
        return id;
    }
    
    // Setter untuk ID
    public void setId(int id) {
        this.id = id;
    }
    
    // Method untuk menampilkan informasi produk dengan ID
    public void info() {
        // Format output: "ID. Nama | Kategori | RpX,XXX,XXX | Stok: XX"
        System.out.printf("%d. %s | %s | Rp%,.0f | Stok: %d%n", 
            id, nama, kategori, harga, stok);
    }
}