package view;

import controller.ControllerBuku;
import controller.ControllerTransaksi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ViewUpdate extends JFrame implements ActionListener{
    private String id;
    JLabel labelTitle, labelNamaBuku, labelHarga, labelKategori, labelStok, labelPenulis, iconBook, iconBook2;
    JTextField fieldNamaBuku, fieldHarga, fieldStok, fieldPenulis;
    String[] kategori = {"Novel", "Dongeng", "Literasi", "Biografi"};
    JComboBox cbKategori;
    JButton btnReset, btnEdit, btnHapus, btnKembali;
    
    
    public void update(String[] data) {
        this.id = data[0];
        setTitle("DATA DETAIL BUKU");
        getContentPane().setBackground(Color.WHITE);//warna bg
        setSize(650,360);//ukuran
        
        labelTitle = new JLabel("DATA BUKU");
        labelTitle.setForeground(Color.GRAY);
        labelTitle.setFont(new Font("Arial Black", Font.BOLD, 20));
        iconBook = new JLabel(new ImageIcon(getClass().getResource("/image/books.png")));
        iconBook2 = new JLabel(new ImageIcon(getClass().getResource("/image/books.png")));
        
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
        
        fieldNamaBuku = new JTextField(data[1], 10);
        fieldPenulis = new JTextField(data[3], 10);
        fieldHarga = new JTextField(data[4], 10);
        fieldStok = new JTextField(data[5], 10);
               
        cbKategori = new JComboBox(kategori);
        //cbKategori.addItem(data[2]);
        
        btnReset = new JButton("RESET");
        btnReset.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnReset.setBackground(Color.PINK);
        btnReset.setForeground(Color.WHITE);
        
        btnEdit = new JButton("UPDATE");
        btnEdit.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnEdit.setBackground(Color.BLUE);
        btnEdit.setForeground(Color.WHITE);
        
        btnHapus = new JButton("HAPUS");
        btnHapus.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnHapus.setBackground(Color.RED);
        btnHapus.setForeground(Color.WHITE);
        
        btnKembali = new JButton("KEMBALI");
        btnKembali.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnKembali.setBackground(Color.BLACK);
        btnKembali.setForeground(Color.WHITE);
        
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
        add(btnKembali);
        add(btnReset);
        add(btnEdit);
        add(btnHapus);
        
        //set bounds(m,n,o,p)
        labelTitle.setBounds(240, 15, 150, 25);
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
        
        
        btnReset.setBounds(480, 230, 100, 25);
        btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReset.addActionListener(this);
        
        btnEdit.setBounds(365, 200, 100, 25);
        btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEdit.addActionListener(this);
        
        btnHapus.setBounds(480, 200, 100, 25);
        btnHapus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnHapus.addActionListener(this);
        
        btnKembali.setBounds(365, 230, 100, 25);
        btnKembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnKembali.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String k;
        k= (String) cbKategori.getSelectedItem();
        
        if(e.getSource()== btnEdit){
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
            }else if(Integer.valueOf(fieldHarga.getText())<0){
                setMessage("Harga harus bernilai positif");
            } else if(Integer.valueOf(fieldStok.getText())<0){
                setMessage("Stok harus bernilai positif");
            }
            else {
                String[] data = {
                        id, fieldNamaBuku.getText(), k, fieldPenulis.getText(), fieldHarga.getText(), fieldStok.getText()
                };
                ControllerBuku buku = new ControllerBuku();
                buku.updateBuku(data);
                dispose();
            }
        }
        else if(e.getSource()== btnReset){
           fieldNamaBuku.setText("");
           fieldPenulis.setText("");
           fieldHarga.setText("");
           fieldStok.setText("");
        }
        else if(e.getSource()== btnKembali){
           ControllerBuku back = new ControllerBuku();
           back.lihatBuku();
           dispose();
        }
        else if(e.getSource()== btnHapus){
           OptDialog();
        }
    }
    
    public void OptDialog(){
        int check = JOptionPane.showOptionDialog(this, "Yakin ingin menghapus?", "Hapus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if(check==0){
            ControllerBuku delete = new ControllerBuku();
            delete.deleteBuku(id);
            dispose();
            ControllerBuku buku = new ControllerBuku();
            buku.lihatBuku();
        }
    }
    
    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
