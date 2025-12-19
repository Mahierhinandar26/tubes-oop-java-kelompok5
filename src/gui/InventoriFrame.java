package gui; 
// Package gui → berisi class-class untuk tampilan (GUI)

import backend.*; 
// Import semua class dari package backend (Inventori, Produk, dll)

import javax.swing.*; 
// Import komponen Swing (JFrame, JButton, JTable, dll)

import javax.swing.table.DefaultTableModel; 
// Import model tabel untuk JTable

import java.awt.*; 
// Import layout dan Color, Font, dll

public class InventoriFrame extends JFrame {
    // Class utama GUI inventori, turunan dari JFrame

    private Inventori inventori; 
    // Objek inventori (backend) sebagai sumber data

    private DefaultTableModel tableModel; 
    // Model tabel untuk menyimpan data produk

    private JTextField txtSearch; 
    // TextField untuk input pencarian produk

    public InventoriFrame(Inventori inventori) {
        // Konstruktor menerima objek inventori
        this.inventori = inventori;
        initUI();                // Inisialisasi tampilan GUI
        setLocationRelativeTo(null); // Membuat frame muncul di tengah layar
        refreshTable();          // Menampilkan data produk ke tabel
    }

    private void initUI() {
        // Method untuk membangun seluruh tampilan GUI

        setTitle("Inventori Stok"); // Judul window
        setSize(900, 500);          // Ukuran window
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Keluar saat window ditutup
        setLayout(new BorderLayout()); // Layout utama menggunakan BorderLayout

        // warna
        Color abu = new Color(240, 240, 240); // Warna abu-abu muda
        Color hitam = Color.BLACK;            // Warna hitam
        Color putih = Color.WHITE;            // Warna putih

        // Judul
        JLabel judul = new JLabel("Inventori Stok", JLabel.CENTER);
        // Label judul dengan posisi tengah

        judul.setFont(new Font("Segoe UI", Font.BOLD, 26));
        // Mengatur font judul

        judul.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        // Memberi jarak (padding) di sekitar judul

        JPanel panelJudul = new JPanel();
        // Panel untuk menampung judul

        panelJudul.setBackground(abu); 
        // Warna background panel judul

        panelJudul.add(judul); 
        // Menambahkan label judul ke panel

        // =search
        JPanel panelSearch = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // Panel pencarian dengan layout rata kiri

        panelSearch.setBackground(abu);

        panelSearch.add(new JLabel("Cari Produk:"));
        // Label teks "Cari Produk"

        txtSearch = new JTextField(20);
        // TextField untuk input keyword pencarian

        JButton btnSearch = new JButton("Cari");
        // Tombol pencarian

        btnSearch.setBackground(hitam);
        btnSearch.setForeground(putih);
        // Mengatur warna tombol cari

        panelSearch.add(txtSearch);
        panelSearch.add(btnSearch);
        // Menambahkan TextField dan tombol ke panel search

        JPanel panelAtas = new JPanel(new BorderLayout());
        // Panel bagian atas (judul + search)

        panelAtas.add(panelJudul, BorderLayout.NORTH);
        panelAtas.add(panelSearch, BorderLayout.SOUTH);

        add(panelAtas, BorderLayout.NORTH);
        // Menambahkan panel atas ke frame

        // table
        tableModel = new DefaultTableModel(
                new String[]{"ID", "Nama", "Kategori", "Harga", "Stok"}, 0
        );
        // Membuat model tabel dengan kolom tertentu

        JTable table = new JTable(tableModel);
        // JTable menggunakan tableModel

        table.setRowHeight(25);
        // Tinggi baris tabel

        add(new JScrollPane(table), BorderLayout.CENTER);
        // Menambahkan tabel ke frame dengan scroll

        // ===== BUTTON =====
        JButton btnTambah = new JButton("Tambah Produk");
        // Tombol untuk menambah produk

        JButton btnUpdate = new JButton("Update Harga");
        // Tombol untuk update harga produk

        JButton btnPenjualan = new JButton("Form Penjualan");
        // Tombol membuka form penjualan

        btnTambah.setBackground(hitam);
        btnTambah.setForeground(putih);

        btnUpdate.setBackground(hitam);
        btnUpdate.setForeground(putih);
        // Styling tombol

        btnTambah.addActionListener(e ->
                new FormTambahProduk(this, inventori).setVisible(true)
        );
        // Event: buka form tambah produk

        btnUpdate.addActionListener(e ->
                new FormUpdateHargaProduk(this, inventori).setVisible(true)
        );
        // Event: buka form update harga

        btnPenjualan.addActionListener(e ->
                new FormPenjualan(this, inventori).setVisible(true)
        );
        // Event: buka form penjualan

        JPanel panelBtn = new JPanel();
        // Panel untuk tombol-tombol bawah

        panelBtn.setBackground(abu);

        panelBtn.add(btnTambah);
        panelBtn.add(btnUpdate);
        panelBtn.add(btnPenjualan);
        // Menambahkan tombol ke panel

        add(panelBtn, BorderLayout.SOUTH);
        // Menambahkan panel tombol ke frame

        // search event
        btnSearch.addActionListener(e -> {
            String keyword = txtSearch.getText();
            // Ambil teks dari TextField

            if (keyword.isEmpty()) {
                refreshTable(); 
                // Jika kosong, tampilkan semua data
            } else {
                searchTable(keyword); 
                // Jika ada keyword, lakukan pencarian
            }
        });
    }

    public void refreshTable() {
        // Method untuk menampilkan ulang semua data produk

        tableModel.setRowCount(0);
        // Menghapus semua data lama di tabel

        for (Produk p : inventori.getDaftarProduk()) {
            // Loop semua produk di inventori

            tableModel.addRow(new Object[]{
                    p.getId(),
                    p.getNama(),
                    p.getKategori(),
                    p.getHarga(),
                    p.getStok()
            });
            // Menambahkan data produk ke tabel
        }
    }

    private void searchTable(String keyword) {
    tableModel.setRowCount(0);

    boolean ditemukan = false; 

    // Method untuk mencari produk berdasarkan id dan nama
    for (Produk p : inventori.getDaftarProduk()) {

        // Cek ID
        boolean matchId = String.valueOf(p.getId()).contains(keyword);

        // Cek Nama
        boolean matchNama = p.getNama()
                .toLowerCase()
                .contains(keyword.toLowerCase());

        // Jika ID atau Nama cocok → tampilkan
        if (matchId || matchNama) {
            ditemukan = true; 
            tableModel.addRow(new Object[]{
                p.getId(),
                p.getNama(),
                p.getKategori(),
                p.getHarga(),
                p.getStok()
            });
        }
    }

    // Jika tidak ada satupun data yang cocok
    if (!ditemukan) {
        JOptionPane.showMessageDialog(this,
            "Produk tidak ditemukan",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
    }
}

}
    

  
