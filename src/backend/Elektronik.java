package backend;

public class Elektronik extends Produk {

    public Elektronik(String nama, double harga, int stok) {
        super(nama, harga, stok);
    }

    @Override
    public void info() {
        System.out.println(
            nama + " | Elektronik | Harga: " + harga + " | Stok: " + stok
        );
    }
}
