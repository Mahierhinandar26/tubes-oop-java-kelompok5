package MainAPP;

import backend.Elektronik;
import backend.Inventori;
import backend.Pakaian;
import gui.InventoriFrame;


public class SistemInventoriTokoOnline {

    public static void main(String[] args) {
        Inventori inventori = new Inventori();

        inventori.tambahProduk(new Elektronik(1, "Laptop", 8000000, 5));
        inventori.tambahProduk(new Elektronik(2, "HP", 3000000, 10));
        inventori.tambahProduk(new Pakaian(3, "Kaos", 75000, 20));

        new InventoriFrame(inventori).setVisible(true);
    }
}

