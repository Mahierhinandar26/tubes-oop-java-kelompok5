package backend;

import java.util.ArrayList;

public class Inventori {
    // List untuk menyimpan semua produk
    private ArrayList<Produk> produk = new ArrayList<>();
    // Counter untuk generate ID otomatis
    private int idCounter = 1;

    // Method untuk menambah produk ke inventori
    public void tambah(Produk p) {
        // Set ID produk dengan counter, lalu increment counter
        p.id = idCounter++;
        // Tambahkan ke list
        produk.add(p);
        // Beri konfirmasi ke user
        System.out.println("✅ " + p.nama + " ditambahkan");
    }

    // Method untuk mencari produk berdasarkan nama (case-insensitive)
    public Produk cari(String nama) {
        // Loop melalui semua produk
        for (Produk p : produk) {
            // Jika nama cocok (abaikan besar/kecil huruf)
            if (p.nama.equalsIgnoreCase(nama)) {
                return p; // Kembalikan produk yang ditemukan
            }
        }
        return null; // Return null jika tidak ditemukan
    }

    // Method untuk mengupdate harga produk
    public void updateHarga(String nama, double hargaBaru) {
        // Cari produk terlebih dahulu
        Produk p = cari(nama);
        if (p != null) {
            // Update harga jika produk ditemukan
            p.harga = hargaBaru;
            System.out.println("💰 " + nama + ": Rp" + hargaBaru);
        }
    }

    // Method untuk mengurangi stok (bisa throw exception)
    public void kurangiStok(String nama, int jumlah) throws StokHabisException {
        Produk p = cari(nama);
        if (p != null) {
            // Cek apakah stok mencukupi
            if (p.stok < jumlah) {
                // Throw exception jika stok tidak cukup
                throw new StokHabisException(nama, p.stok, jumlah);
            }
            // Kurangi stok jika mencukupi
            p.stok -= jumlah;
        }
    }
    
    // Method untuk menambah stok
    public void tambahStok(String nama, int jumlah) {
        Produk p = cari(nama);
        if (p != null) {
            // Tambah jumlah stok
            p.stok += jumlah;
        }
    }

    // Method untuk menampilkan semua produk
    public void tampilkan() {
        System.out.println("\n📋 Daftar Produk:");
        // Loop dan panggil info() setiap produk
        for (Produk p : produk) {
            p.info();
        }
    }
}