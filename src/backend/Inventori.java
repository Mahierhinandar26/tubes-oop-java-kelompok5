package backend;

import java.util.ArrayList;

public class Inventori {

    private ArrayList<Produk> daftarProduk;

    public Inventori() {
        daftarProduk = new ArrayList<>();
    }

    public void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    public ArrayList<Produk> getDaftarProduk() {
        return daftarProduk;
    }

    public Produk cariProdukById(int id) {
        for (Produk p : daftarProduk) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean updateHarga(int id, double hargaBaru) {
        Produk p = cariProdukById(id);
        if (p != null) {
            p.setHarga(hargaBaru);
            return true;
        }
        return false;
    }

    public void kurangiStok(int id, int jumlah) throws StokHabisException {
        Produk p = cariProdukById(id);
        if (p != null) {
            p.kurangiStok(jumlah);
        }
    }
}
