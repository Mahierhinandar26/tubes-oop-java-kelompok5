package backend;

public abstract class Produk {

    protected int id;
    protected String nama;
    protected double harga;
    protected int stok;

    public Produk(int id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public int getId() {
        return id;
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
            throw new StokHabisException("Stok produk habis!");
        }
        stok -= jumlah;
    }

    public abstract String getKategori();

    @Override
    public String toString() {
        return id + " | " + nama + " | " + getKategori() +
               " | Harga: " + harga + " | Stok: " + stok;
    }
}
