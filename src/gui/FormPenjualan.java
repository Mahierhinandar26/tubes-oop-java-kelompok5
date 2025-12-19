package gui;

import backend.*;
import javax.swing.*;
import java.awt.*;

public class FormPenjualan extends JFrame {

    private Inventori inventori;
    private InventoriFrame parent; 

    private JComboBox<Produk> cbProduk;
    private JTextField tfHarga, tfStok, tfJumlah;
    private JButton btnJual;

    public FormPenjualan(InventoriFrame parent, Inventori inventori) {
        this.parent = parent;
        this.inventori = inventori;

        setTitle("Form Penjualan");
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        cbProduk = new JComboBox<>();
        for (Produk p : inventori.getDaftarProduk()) {
            cbProduk.addItem(p);
        }

        tfHarga = new JTextField();
        tfHarga.setEditable(false);

        tfStok = new JTextField();
        tfStok.setEditable(false);

        tfJumlah = new JTextField();

        btnJual = new JButton("Proses Penjualan");

        panel.add(new JLabel("Produk"));
        panel.add(cbProduk);

        panel.add(new JLabel("Harga"));
        panel.add(tfHarga);

        panel.add(new JLabel("Stok Tersedia"));
        panel.add(tfStok);

        panel.add(new JLabel("Jumlah Beli"));
        panel.add(tfJumlah);

        panel.add(new JLabel(""));
        panel.add(btnJual);

        add(panel);

        cbProduk.addActionListener(e -> tampilkanDetail());
        btnJual.addActionListener(e -> prosesPenjualan());

        if (cbProduk.getItemCount() > 0) {
            tampilkanDetail();
        }
    }

    private void tampilkanDetail() {
        Produk p = (Produk) cbProduk.getSelectedItem();
        if (p != null) {
            tfHarga.setText(String.valueOf(p.getHarga()));
            tfStok.setText(String.valueOf(p.getStok()));
        }
    }

    private void prosesPenjualan() {
        try {
            Produk p = (Produk) cbProduk.getSelectedItem();
            int jumlah = Integer.parseInt(tfJumlah.getText());

            inventori.kurangiStok(p.getId(), jumlah);

            JOptionPane.showMessageDialog(this, "Penjualan berhasil!");

            parent.refreshTable(); 
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah harus angka!");
        } catch (StokHabisException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
