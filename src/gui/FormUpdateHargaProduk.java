package gui;

import backend.*;
import javax.swing.*;
import java.awt.*;

public class FormUpdateHargaProduk extends JDialog {

    private Inventori inventori;
    private InventoriFrame parent;

    private JTextField txtId, txtNama, txtHargaLama, txtHargaBaru;
    private JComboBox<String> cmbKategori;

    public FormUpdateHargaProduk(InventoriFrame parent, Inventori inventori) {
        this.parent = parent;
        this.inventori = inventori;

        setTitle("Update Harga Produk");
        setSize(420, 320);
        setLocationRelativeTo(parent);
        setModal(true);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ID
        panel.add(new JLabel("ID Produk"));
        txtId = new JTextField();
        panel.add(txtId);

        // Nama
        panel.add(new JLabel("Nama Produk"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // Kategori
        panel.add(new JLabel("Kategori"));
        cmbKategori = new JComboBox<>(new String[]{"Elektronik", "Pakaian"});
        panel.add(cmbKategori);

        // Harga Lama (INPUT MANUAL)
        panel.add(new JLabel("Harga Lama"));
        txtHargaLama = new JTextField();
        panel.add(txtHargaLama);

        // Harga Baru
        panel.add(new JLabel("Harga Baru"));
        txtHargaBaru = new JTextField();
        panel.add(txtHargaBaru);

        add(panel, BorderLayout.CENTER);

        JButton btnUpdate = new JButton("Update Harga");
        btnUpdate.addActionListener(e -> updateHarga());

        JPanel panelBtn = new JPanel();
        panelBtn.add(btnUpdate);

        add(panelBtn, BorderLayout.SOUTH);
    }

    private void updateHarga() {
        try {
            int id = Integer.parseInt(txtId.getText());
            double hargaBaru = Double.parseDouble(txtHargaBaru.getText());

            boolean berhasil = inventori.updateHarga(id, hargaBaru);

            if (berhasil) {
                parent.refreshTable();
                JOptionPane.showMessageDialog(this, "Harga berhasil diupdate");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Produk tidak ada");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Input tidak valid");
        }
    }
}



