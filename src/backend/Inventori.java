package backend;

import java.util.ArrayList;

public class Inventori {
    private ArrayList<Produk> produk = new ArrayList<>();
    private int idCounter = 1;

    // Tambah produk baru (auto ID)
    public void tambah(Produk p) {
        p.setId(idCounter++);
        produk.add(p);
        System.out.printf("✅ %s ditambahkan (ID: %d)%n", p.nama, p.getId());
    }
    
    // Tambah produk dengan ID tertentu
    public void tambahDenganID(Produk p) {
        if (p.getId() == 0) {
            p.setId(idCounter++);
        } else if (p.getId() >= idCounter) {
            idCounter = p.getId() + 1;
        }
        produk.add(p);
        System.out.printf("✅ %s ditambahkan (ID: %d)%n", p.nama, p.getId());
    }

    // Cari produk by ID
    public Produk cariById(int id) {
        for (Produk p : produk) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    // Cari produk by nama
    public Produk cari(String nama) {
        for (Produk p : produk) {
            if (p.nama.equalsIgnoreCase(nama)) return p;
        }
        return null;
    }

    // Update harga by ID
    public void updateHarga(int id, double hargaBaru) {
        Produk p = cariById(id);
        if (p != null) {
            double hargaLama = p.harga;
            p.harga = hargaBaru;
            System.out.printf("💰 ID %d: %s diupdate Rp%,.0f → Rp%,.0f%n", 
                id, p.nama, hargaLama, hargaBaru);
        } else {
            System.out.println("❌ Produk ID " + id + " tidak ditemukan!");
        }
    }
    
    // Update harga by nama
    public void updateHarga(String nama, double hargaBaru) {
        Produk p = cari(nama);
        if (p != null) {
            double hargaLama = p.harga;
            p.harga = hargaBaru;
            System.out.printf("💰 %s (ID: %d) diupdate Rp%,.0f → Rp%,.0f%n", 
                nama, p.getId(), hargaLama, hargaBaru);
        } else {
            System.out.println("❌ Produk '" + nama + "' tidak ditemukan!");
        }
    }

    // Kurangi stok by ID
    public void kurangiStok(int id, int jumlah) throws StokHabisException {
        Produk p = cariById(id);
        if (p != null) {
            if (p.stok < jumlah) throw new StokHabisException(p.nama, p.stok, jumlah);
            p.stok -= jumlah;
            System.out.printf("📦 ID %d: %s berkurang %d, sisa stok: %d%n",
                id, p.nama, jumlah, p.stok);
        } else {
            System.out.println("❌ Produk ID " + id + " tidak ditemukan!");
        }
    }
    
    // Kurangi stok by nama
    public void kurangiStok(String nama, int jumlah) throws StokHabisException {
        Produk p = cari(nama);
        if (p != null) {
            if (p.stok < jumlah) throw new StokHabisException(nama, p.stok, jumlah);
            p.stok -= jumlah;
            System.out.printf("📦 %s (ID: %d) berkurang %d, sisa stok: %d%n",
                p.nama, p.getId(), jumlah, p.stok);
        } else {
            System.out.println("❌ Produk '" + nama + "' tidak ditemukan!");
        }
    }
    
    // Tambah stok by ID
    public void tambahStok(int id, int jumlah) {
        Produk p = cariById(id);
        if (p != null) {
            p.stok += jumlah;
            System.out.printf("📥 ID %d: %s bertambah %d, total stok: %d%n",
                id, p.nama, jumlah, p.stok);
        } else {
            System.out.println("❌ Produk ID " + id + " tidak ditemukan!");
        }
    }
    
    // Tambah stok by nama
    public void tambahStok(String nama, int jumlah) {
        Produk p = cari(nama);
        if (p != null) {
            p.stok += jumlah;
            System.out.printf("📥 %s (ID: %d) bertambah %d, total stok: %d%n",
                p.nama, p.getId(), jumlah, p.stok);
        } else {
            System.out.println("❌ Produk '" + nama + "' tidak ditemukan!");
        }
    }
    
    // Hapus produk by ID
    public boolean hapusProduk(int id) {
        for (int i = 0; i < produk.size(); i++) {
            if (produk.get(i).getId() == id) {
                String nama = produk.get(i).nama;
                produk.remove(i);
                System.out.printf("🗑️ Produk ID %d: %s dihapus%n", id, nama);
                return true;
            }
        }
        System.out.println("❌ Produk ID " + id + " tidak ditemukan!");
        return false;
    }
    
    // Get jumlah produk
    public int getJumlahProduk() {
        return produk.size();
    }
    
    // Get total nilai inventori
    public double getTotalNilaiInventori() {
        double total = 0;
        for (Produk p : produk) {
            total += p.harga * p.stok;
        }
        return total;
    }
    
    // Get produk dengan stok rendah (< threshold)
    public ArrayList<Produk> getStokRendah(int threshold) {
        ArrayList<Produk> stokRendah = new ArrayList<>();
        for (Produk p : produk) {
            if (p.stok < threshold) {
                stokRendah.add(p);
            }
        }
        return stokRendah;
    }

    // Tampilkan semua produk
    public void tampilkan() {
        System.out.println("\n📋 DAFTAR PRODUK (" + getJumlahProduk() + " produk):");
        System.out.println("=" .repeat(50));
        if (produk.isEmpty()) {
            System.out.println("📭 Tidak ada produk dalam inventori");
            return;
        }
        for (Produk p : produk) {
            p.info();
        }
        System.out.println("=" .repeat(50));
        System.out.printf("💰 Total nilai inventori: Rp%,.0f%n", getTotalNilaiInventori());
    }
    
    // Tampilkan produk by kategori
    public void tampilkanByKategori(String kategori) {
        System.out.println("\n📂 Kategori: " + kategori);
        System.out.println("-".repeat(40));
        int count = 0;
        for (Produk p : produk) {
            if (p.kategori.equalsIgnoreCase(kategori)) {
                p.info();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Tidak ada produk dalam kategori ini");
        }
        System.out.println("-".repeat(40));
    }
}