package gui;

import backend.Elektronik;
import backend.Inventori;
import backend.Pakaian;
import backend.Produk;
import backend.StokHabisException;

import javax.swing.*;
import java.awt.*;

public class FormTambahProduk extends JFrame {

    public FormTambahProduk() {
        setTitle("Tambah Produk");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // setting umum
        gbc.insets = new Insets(8, 8, 8, 8); // jarak rapi
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== Nama Produk =====
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID Produk"), gbc);

        gbc.gridx = 1;
        JTextField txtID = new JTextField(15);
        panel.add(txtID, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nama Produk"), gbc);

        gbc.gridx = 1;
        JTextField txtNama = new JTextField(15);
        panel.add(txtNama, gbc);

        // ===== Harga =====
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Harga"), gbc);

        gbc.gridx = 1;
        JTextField txtHarga = new JTextField(15);
        panel.add(txtHarga, gbc);

        // ===== Stok =====
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Stok"), gbc);

        gbc.gridx = 1;
        JTextField txtStok = new JTextField(15);
        panel.add(txtStok, gbc);

        // ===== Tombol Simpan =====
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        JButton btnSimpan = new JButton("Simpan");
        panel.add(btnSimpan, gbc);

        add(panel);
    }
}
