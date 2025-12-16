package backend;

// Class Exception custom untuk menangani error stok habis
public class StokHabisException extends Exception {
    
    // Constructor dengan parameter detail error
    public StokHabisException(String produk, int tersedia, int diminta) {
        // Format pesan error: "Stok [nama] tidak cukup! Tersedia: X, Diminta: Y"
        super(String.format("Stok %s tidak cukup! Tersedia: %d, Diminta: %d", 
            produk, tersedia, diminta));
    }
}