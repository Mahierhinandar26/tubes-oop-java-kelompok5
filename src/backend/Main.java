package backend;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Inventori inv = new Inventori();

        System.out.println("🛒 SISTEM INVENTORI TOKO 🛒\n");
        
        // 1. TAMBAH PRODUK 
        System.out.println("1. MENAMBAH PRODUK:");
        inv.tambah(new Elektronik("Laptop Gaming", 12000000, 3));
        inv.tambah(new Pakaian("Jaket Kulit", 450000, 2));
        inv.tambah(new Elektronik("Smartphone", 3500000, 8));
        inv.tambah(new Pakaian("Kemeja Flanel", 180000, 15));
        inv.tambah(new Elektronik("Headphone", 250000, 12));
        
        // Tambah produk dengan ID spesifik (testing)
        System.out.println("\n➕ Tambah produk dengan ID spesifik:");
        inv.tambahDenganID(new Pakaian(10, "Celana Jeans", 220000, 7));
        
        // 2. UPDATE HARGA
        System.out.println("\n2. UPDATE HARGA:");
        inv.updateHarga(1, 11500000); // Laptop by ID
        inv.updateHarga("Smartphone", 3200000); // Smartphone by nama
        
        // 3. KELOLA STOK
        System.out.println("\n3. PENGURANGAN STOK:");
        try {
            inv.kurangiStok(2, 1); // Jaket Kulit by ID
            inv.kurangiStok("Kemeja Flanel", 3); // by nama
            inv.kurangiStok("Jaket Kulit", 5); // Ini akan error (stok habis)
        } catch (StokHabisException e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        }
        
        System.out.println("\n4. PENAMBAHAN STOK:");
        inv.tambahStok(2, 10); // Jaket Kulit
        inv.tambahStok("Headphone", 5); // Headphone
        
        // 4. OPERASI LAIN 
        System.out.println("\n5. PENGHAPUSAN PRODUK:");
        inv.hapusProduk(5); // Hapus Headphone ID 5
        
        // 5. LAPORAN 
        System.out.println("\n6. LAPORAN:");
        
        // 6a. Tampilkan semua
        inv.tampilkan();
        
        // 6b. Tampilkan by kategori
        System.out.println("\n7. FILTER KATEGORI:");
        inv.tampilkanByKategori("Elektronik");
        inv.tampilkanByKategori("Pakaian");
        
        // 6c. Cari produk
        System.out.println("\n8. PENCARIAN PRODUK:");
        Produk ditemukan = inv.cariById(3);
        if (ditemukan != null) {
            System.out.print("🔍 Ditemukan by ID 3: ");
            ditemukan.info();
        }
        
        Produk ditemukan2 = inv.cari("Jaket Kulit");
        if (ditemukan2 != null) {
            System.out.print("🔍 Ditemukan by nama 'Jaket Kulit': ");
            ditemukan2.info();
        }
        
        // 6d. Stok rendah
        System.out.println("\n9. PRODUK STOK RENDAH (< 5):");
        ArrayList<Produk> stokRendah = inv.getStokRendah(5);
        if (stokRendah.isEmpty()) {
            System.out.println("✅ Semua stok aman");
        } else {
            for (Produk p : stokRendah) {
                System.out.printf("⚠️  %d. %s - Stok: %d%n", 
                    p.getId(), p.nama, p.stok);
            }
        }
        
        // 6. STATISTIK 
        System.out.println("\n📊 STATISTIK:");
        System.out.println("Total produk: " + inv.getJumlahProduk());
        System.out.printf("Total nilai inventori: Rp%,.0f%n", 
            inv.getTotalNilaiInventori());
            
        System.out.println("\n✅ PROGRAM SELESAI");
    }
}