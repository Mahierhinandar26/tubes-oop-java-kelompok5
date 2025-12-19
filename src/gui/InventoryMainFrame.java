package gui;
import backend.Elektronik;
import backend.Inventori;
import backend.Pakaian;
import backend.Produk;
import backend.StokHabisException;

import javax.swing.*;
import java.awt.*;
public class InventoryMainFrame extends JFrame {
    private JTable inventorTable;
    private JTextField txtSearch;

    public InventoryMainFrame() {
        setTitle("Sistem Inventori Toko Online"); //Untuk judul window
        setSize(800,450);                  //Untuk ukuran window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Untuk menutup apk saat window ditutup
        setLocationRelativeTo(null);    //posisi window di tengah layar
        setLayout(new BorderLayout());    //Untuk mengatur layout window

        //Membangun methode untuk membangun setiap bagian GUI
        initSearchPanel();  //Panel pencarian produk (atas)
        initTabelePanel();  //Tabel inventori (tengah)
        initMenuPanel();    // panel menu tombol (bawah)
    }
    //SearchPanel bagian atas
    private void initSearchPanel(){
        JPanel searchPanel = new JPanel(); //Mmebuat panel pencarian
        JLabel lblSearch = new JLabel("Cari produk: "); //text di dalam panel
        txtSearch = new JTextField(20); //untuk memasukkan kata kunci pencarian
        JButton btnSearch = new JButton("Cari"); //tombol untuk melakukan pencarian

        //menambahkan komponen ke panel search
        searchPanel.add(lblSearch);
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);

        add(searchPanel, BorderLayout.NORTH); //menempatkan panel search di bagian atas
        //ketika tombol 'Cari' ditekan
        btnSearch.addActionListener(e ->{
            String keyword = txtSearch.getText();
            JOptionPane.showMessageDialog(this, "Fitur cari produk: " + keyword);
        });
    }

    //Tabel Panel bagian tengah
    private void initTabelePanel(){
        //Nama kolom table inventori
        String[] columns ={"ID", "Nama Produk", "Kategori","Harga", "Stok"};

        //Membuat JTabel dengan data kosong 5 kolom
        inventorTable = new JTable(new Object[0][5], columns);

        //Membuat tabel untuk memenuhi area scroll
        inventorTable.setFillsViewportHeight(true);
        //Membungkus tabel dengan ScrollPane agar bisa di-scroll
        JScrollPane scrollPane = new JScrollPane(inventorTable);
        add(scrollPane, BorderLayout.CENTER); //menempatkan tabel di tengah
    }
    //Menu Panel di bagian bawah
    private void initMenuPanel(){
        //methode untuk membuat panel menu tombol
        JPanel menuPanel= new JPanel();
        JButton btnTambah = new JButton("Tambah Produk");
        JButton btnUpdate = new JButton("Update harga");

        menuPanel.add(btnTambah);
        menuPanel.add(btnUpdate);

        add(menuPanel, BorderLayout.SOUTH);

        btnTambah.addActionListener(e -> {
            FormTambahProduk form = new FormTambahProduk();
            form.setVisible(true);
    });
        btnUpdate.addActionListener(e -> {
            FormUpdateHarga form = new FormUpdateHarga();
            form.setVisible(true);
    });
    }
//Main method
public static void main(String[]args){
    SwingUtilities.invokeLater(() ->{
        new InventoryMainFrame().setVisible(true);
    });
}

}
