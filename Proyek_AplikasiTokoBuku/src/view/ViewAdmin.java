package view;

import controller.ControllerBuku;
import controller.ControllerLoginReg;
import controller.ControllerRiwayat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAdmin extends JFrame implements ActionListener {
    JLabel labelTitle, iconTitle, iconTitle2, iconKelola, iconRiwayat;
    JButton btnKelola, btnRiwayat,btnkemb;  
    
    public void openAdmin() {
        setTitle("MENU ADMIN");
        getContentPane().setBackground(Color.WHITE);
        setSize(600,350);
        
        iconTitle = new JLabel(new ImageIcon(getClass().getResource("/image/bookstore.png")));
        iconTitle2 = new JLabel(new ImageIcon(getClass().getResource("/image/bookstore.png")));
        labelTitle = new JLabel("MENU ADMIN");
        labelTitle.setForeground(Color.DARK_GRAY);
        labelTitle.setFont(new Font("Arial Black", Font.BOLD, 20));
        
        iconKelola = new JLabel(new ImageIcon(getClass().getResource("/image/kelola.png")));
        btnKelola = new JButton("KELOLA");
        btnKelola.setFont(new Font("Arial Black", Font.PLAIN, 14));
        btnKelola.setBackground(Color.DARK_GRAY);
        btnKelola.setForeground(Color.WHITE);
        
        iconRiwayat = new JLabel(new ImageIcon(getClass().getResource("/image/riwayat.png")));
        btnRiwayat = new JButton("RIWAYAT");
        btnRiwayat.setFont(new Font("Arial Black", Font.PLAIN, 14));
        btnRiwayat.setBackground(Color.DARK_GRAY);
        btnRiwayat.setForeground(Color.WHITE);
        
        btnkemb = new JButton("LOGOUT");
        btnkemb.setFont(new Font("Arial Black", Font.PLAIN, 14));
        btnkemb.setBackground(Color.BLACK);
        btnkemb.setForeground(Color.WHITE);
        
        //setLayout, addComponent
        setLayout(null);
        add(labelTitle);
        add(iconTitle);
        add(iconTitle2);
        add(iconKelola);
        add(iconRiwayat);
        add(btnKelola);
        add(btnRiwayat);
        add(btnkemb);
        
        //set bounds(m,n,o,p)
        labelTitle.setBounds(220, 15, 200, 50);
        iconTitle.setBounds(155, 10, 50, 50);
        iconTitle2.setBounds(390, 10, 50, 50);
        
        iconKelola.setBounds(160, 110, 90, 90);
        btnKelola.setBounds(150, 215, 120, 30);
        btnKelola.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnKelola.addActionListener(this);
        
        iconRiwayat.setBounds(350, 110, 90, 90);
        btnRiwayat.setBounds(340, 215, 120, 30);
        btnRiwayat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRiwayat.addActionListener(this);
        
        btnkemb.setBounds(245, 270, 120, 30);
        btnkemb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnkemb.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnKelola){
            ControllerBuku ci = new ControllerBuku();
            ci.openInput();
            dispose();
        }
        else if(e.getSource()== btnRiwayat){
            ControllerRiwayat r = new ControllerRiwayat();
            r.lihatRiwayat();
            dispose();
        }else if(e.getSource()== btnkemb){
            ControllerLoginReg lg = new ControllerLoginReg();
            lg.cekLogin();
            dispose();
        }
    }
}
