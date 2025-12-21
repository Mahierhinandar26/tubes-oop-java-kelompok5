package backend;

public class Pakaian extends Produk {

    public Pakaian(int id, String nama, double harga, int stok) {
        super(id, nama, harga, stok);
    }

    @Override
    public String getKategori() {
        return "Pakaian";
    }
}
