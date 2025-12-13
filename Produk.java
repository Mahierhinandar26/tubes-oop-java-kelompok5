public class Produk {
    String kode;
    String nama;
    int stok;
    double harga;

    void tampilInfo() {
        System.out.println(
            kode + " - " + nama + 
            " | Stok: " + stok + 
            " | Harga: " + harga
        );
    }
}
