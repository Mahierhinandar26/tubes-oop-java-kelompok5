package backend;

public class Elektronik extends Produk {

    public Elektronik(int id, String nama, double harga, int stok) {
        super(id, nama, harga, stok);
    }

    @Override
    public String getKategori() {
        return "Elektronik";
    }
}
