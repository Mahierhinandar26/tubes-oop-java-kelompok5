package gui;

import backend.*;
import javax.swing.*;
import java.awt.*;

public class FormTambahProduk extends JDialog {

    private Inventori inventori;
    private InventoriFrame parent;

    private JTextField txtId, txtNama, txtHarga, txtStok;
    private JComboBox<String> cmbKategori;

    public FormTambahProduk(InventoriFrame parent, Inventori inventori) {
        this.parent = parent;
        this.inventori = inventori;

        setTitle("Tambah Produk");
        setSize(350, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("ID"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Nama"));
        txtNama = new JTextField();
        panel.add(txtNama);

        panel.add(new JLabel("Kategori"));
        cmbKategori = new JComboBox<>(new String[]{"Elektronik", "Pakaian"});
        panel.add(cmbKategori);

        panel.add(new JLabel("Harga"));
        txtHarga = new JTextField();
        panel.add(txtHarga);

        panel.add(new JLabel("Stok"));
        txtStok = new JTextField();
        panel.add(txtStok);

        add(panel, BorderLayout.CENTER);

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.addActionListener(e -> simpanProduk());

        JPanel panelBtn = new JPanel();
        panelBtn.add(btnSimpan);

        add(panelBtn, BorderLayout.SOUTH);
    }

    private void simpanProduk() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nama = txtNama.getText();
            double harga = Double.parseDouble(txtHarga.getText());
            int stok = Integer.parseInt(txtStok.getText());

            Produk p = cmbKategori.getSelectedItem().equals("Elektronik")
                    ? new Elektronik(id, nama, harga, stok)
                    : new Pakaian(id, nama, harga, stok);

            inventori.tambahProduk(p);
            parent.refreshTable();
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Input tidak valid");
        }
    }
}

