package view;

import controller.ControllerBuku;
import controller.ControllerLoginReg;
import controller.ControllerMenu;
import controller.ControllerTransaksi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ViewInputBuku extends JFrame implements ActionListener {
    JLabel labelTitle, labelNamaBuku, labelHarga, labelKategori, labelStok, labelPenulis, iconBook, iconBook2;
    JTextField fieldNamaBuku, fieldHarga, fieldStok, fieldPenulis;
    String[] kategori = {"Novel", "Dongeng", "Literasi", "Biografi"};
    JComboBox cbKategori;
    JButton btnTambah, btnReset, btnLihat,btnkmb;
    
    public void inputBuku() {
        setTitle("INPUT BUKU");
        getContentPane().setBackground(Color.WHITE);//warna bg
        setSize(650,360);//ukuran
        
        labelTitle = new JLabel("INPUT BUKU");
        labelTitle.setForeground(Color.GRAY);
        labelTitle.setFont(new Font("Arial Black", Font.BOLD, 20));
        iconBook = new JLabel(new ImageIcon(getClass().getResource("/image/book.png")));
        iconBook2 = new JLabel(new ImageIcon(getClass().getResource("/image/book.png")));
        
        labelNamaBuku = new JLabel("Nama Buku");
        labelNamaBuku.setForeground(Color.black);
        labelNamaBuku.setFont(new Font("Arial Black", Font.PLAIN, 12));
        
        labelHarga = new JLabel("Harga Buku");
        labelHarga.setForeground(Color.black);
        labelHarga.setFont(new Font("Arial Black", Font.PLAIN, 12));
        
        labelKategori = new JLabel("Kategori");
        labelKategori.setForeground(Color.black);
        labelKategori.setFont(new Font("Arial Black", Font.PLAIN, 12));
        
        labelPenulis = new JLabel("Penulis");
        labelPenulis.setForeground(Color.black);
        labelPenulis.setFont(new Font("Arial Black", Font.PLAIN, 12));

        labelStok = new JLabel("Stok");
        labelStok.setForeground(Color.black);
        labelStok.setFont(new Font("Arial Black", Font.PLAIN, 12));
        
        fieldNamaBuku = new JTextField();
        fieldHarga = new JTextField();
        fieldStok = new JTextField();
        fieldPenulis = new JTextField();
        
        cbKategori = new JComboBox(kategori);
        
        btnTambah = new JButton("TAMBAH");
        btnTambah.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnTambah.setBackground(Color.ORANGE);
        btnTambah.setForeground(Color.WHITE);
        
        btnReset = new JButton("RESET");
        btnReset.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnReset.setBackground(Color.PINK);
        btnReset.setForeground(Color.WHITE);
        
        btnLihat = new JButton("LIHAT DATA");
        btnLihat.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnLihat.setBackground(Color.DARK_GRAY);
        btnLihat.setForeground(Color.WHITE);
        
        btnkmb = new JButton("KEMBALI");
        btnkmb.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnkmb.setBackground(Color.BLACK);
        btnkmb.setForeground(Color.WHITE);
        
        //setLayout, addComponent
        setLayout(null);
        add(labelTitle);
        add(iconBook);
        add(iconBook2);
        add(labelNamaBuku);
        add(labelHarga);
        add(labelKategori);
        add(labelStok);
        add(labelPenulis);
        add(fieldNamaBuku);
        add(fieldHarga);
        add(fieldStok);
        add(fieldPenulis);
        add(cbKategori);
        add(btnTambah);
        add(btnReset);
        add(btnLihat);
        add(btnkmb);
                
        //set bounds(m,n,o,p)
        labelTitle.setBounds(230, 15, 150, 25);
        iconBook.setBounds(160, 0, 50, 50);
        iconBook2.setBounds(400, 0, 50, 50);
        
        labelNamaBuku.setBounds(30, 60, 160, 25);
        fieldNamaBuku.setBounds(30, 90, 250, 25);
        
        labelKategori.setBounds(30, 130, 160, 25);
        cbKategori.setBounds(30, 160, 250, 25);
        
        labelPenulis.setBounds(30, 200, 160, 25);
        fieldPenulis.setBounds(30, 230, 250, 25);
        
        labelHarga.setBounds(350, 60, 160, 25);
        fieldHarga.setBounds(350, 90, 250, 25);
          
        labelStok.setBounds(350, 130, 160, 25);
        fieldStok.setBounds(350, 160, 250, 25);
        
        btnTambah.setBounds(365, 195, 110, 25);
        btnTambah.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnTambah.addActionListener(this);
        
        btnReset.setBounds(480, 195, 110, 25);
        btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReset.addActionListener(this);
        
        btnLihat.setBounds(365, 230, 110, 25);
        btnLihat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLihat.addActionListener(this);
        
        btnkmb.setBounds(480, 230, 110, 25);
        btnkmb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnkmb.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String k;
        k= (String) cbKategori.getSelectedItem();
        
        if(e.getSource()== btnTambah){
           
            if (fieldNamaBuku.getText().equals("")) {
                setMessage("Nama buku harus diisi");
            } else if (fieldPenulis.getText().equals("")) {
                setMessage("Penulis harus diisi");
            } else if (fieldHarga.getText().equals("")) {
                setMessage("Harga harus diisi");
            } else if (fieldStok.getText().equals("")) {
                setMessage("Stok harus diisi");
            } else if(fieldHarga.getText().matches("^[a-zA-Z]*$")){
                setMessage("Harga harus bilangan");
            } else if(fieldStok.getText().matches("^[a-zA-Z]*$")){
                setMessage("Stok harus bilangan");
            } else if(Integer.valueOf(fieldHarga.getText()) == 0){
                setMessage("Harga tidak boleh 0");
            } else if(Integer.valueOf(fieldStok.getText()) == 0){
                setMessage("Stok tidak boleh 0");
            } else if(Integer.valueOf(fieldHarga.getText())<0){
                setMessage("Harga harus bernilai positif");
            } else if(Integer.valueOf(fieldStok.getText())<0){
                setMessage("Stok harus bernilai positif");
            }
            else {
                String[] data = {
                        fieldNamaBuku.getText(), k, fieldPenulis.getText(), fieldHarga.getText(), fieldStok.getText()
                };
                ControllerBuku controlBuku = new ControllerBuku();
                controlBuku.tambahBuku(data);
                //dispose();
            }
        }
        else if(e.getSource()== btnReset){
            fieldNamaBuku.setText("");
            fieldPenulis.setText("");
            fieldHarga.setText("");
            fieldStok.setText("");
        }
        else if(e.getSource()==btnLihat){
            ControllerBuku controlLihat = new ControllerBuku();
            controlLihat.lihatBuku();
            dispose();      
        }
        else if(e.getSource()==btnkmb){
            //ControllerLoginReg kmb = new ControllerLoginReg();
            //kmb.cekLogin();
            ControllerMenu mn = new ControllerMenu();
            mn.openAdmin();
            dispose();      
        }
    }
    
    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
