package backend;

public class Pakaian extends Produk {

    public Pakaian(String nama, double harga, int stok) {
        super(nama, harga, stok);
    }

    @Override
    public void info() {
        System.out.println(
            nama + " | Pakaian | Harga: " + harga + " | Stok: " + stok
        );
    }
}
