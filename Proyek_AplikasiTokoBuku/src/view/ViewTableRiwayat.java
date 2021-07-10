/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerBuku;
import controller.ControllerMenu;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author asus
 */
public class ViewTableRiwayat extends JFrame implements ActionListener{
    JButton btnKembali = new JButton("Kembali");
    private JTable table;
    private String kode;
    
    public ViewTableRiwayat(String[][] data) {
        try{
            kode = data[0][0];
            final String[] tableTitle = {"Id", "id_buku","Judul", "Kategori", "Penulis", "Harga", "Jumlah","Total Harga"};
            setTitle("RIWAYAT PEMBELIAN");
            setSize(700,400);
            
            table = new JTable(data, tableTitle);
            table.setBounds(30, 40, 300, 400);
            JScrollPane scroll = new JScrollPane(table);
            scroll.setPreferredSize(new Dimension(400,50));
            this.getContentPane().add(BorderLayout.CENTER, scroll);
            
            this.getContentPane().add(BorderLayout.SOUTH, btnKembali);
            btnKembali.addActionListener(this);
            btnKembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
//            table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//                public void valueChanged(ListSelectionEvent event) {
//                    dispose();
//                    kode = table.getValueAt(table.getSelectedRow(), 0).toString();
//                    ControllerBuku bk = new ControllerBuku();
//                    bk.lihatBuku(kode);     
//                }
//            });
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        } catch (Exception error) {
            System.out.println("Error : " + error);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==btnKembali){
            ControllerMenu back = new ControllerMenu();
            back.openAdmin();
            dispose();
        }
    }
    
   
}