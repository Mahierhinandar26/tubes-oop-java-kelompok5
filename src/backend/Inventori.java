package backend;

import java.util.ArrayList;

public class Inventori {
    private ArrayList<Produk> daftarProduk = new ArrayList<>();

    public void tambahProduk(Produk p) {
        daftarProduk.add(p);
    }

    public Produk cariProduk(String nama) {
        for (Produk p : daftarProduk) {
            if (p.nama.equalsIgnoreCase(nama)) {
                return p;
            }
        }
        return null;
    }

    public void updateHarga(String nama, double hargaBaru) {
        Produk p = cariProduk(nama);
        if (p != null) {
            p.harga = hargaBaru;
        }
    }

    public void kurangiStok(String nama, int jumlah) throws StokHabisException {
        Produk p = cariProduk(nama);
        if (p != null) {
            if (p.stok < jumlah) {
                throw new StokHabisException("Stok habis!");
            }
            p.stok -= jumlah;
        }
    }

    public void tampilkanSemua() {
        for (Produk p : daftarProduk) {
            p.info();
        }
    }
}
