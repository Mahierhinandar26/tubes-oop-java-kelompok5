package backend;

public class StokHabisException extends Exception {
    public StokHabisException(String produk, int tersedia, int diminta) {
        super(String.format("Stok %s tidak cukup! Tersedia: %d, Diminta: %d", 
            produk, tersedia, diminta));
    }
}