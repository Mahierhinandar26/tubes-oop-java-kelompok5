package backend;

public class Produk {
    protected String nama;
    protected double harga;
    protected int stok;

    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void kurangiStok(int jumlah) throws StokHabisException {
        if (stok < jumlah) {
            throw new StokHabisException("Stok habis!");
        }
        stok -= jumlah;
    }

    public void info() {
        System.out.println(nama + " | Harga: " + harga + " | Stok: " + stok);
    }
}
