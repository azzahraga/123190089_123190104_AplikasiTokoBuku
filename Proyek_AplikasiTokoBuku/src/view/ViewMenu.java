package view;

import controller.ControllerLoginReg;
import controller.ControllerTransaksi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenu extends JFrame implements ActionListener {
    JLabel labelWelcome,labelToko, iconToko, iconToko2, iconWelcome, iconWelcome2, iconAdmin, iconBeli;
    JButton btnBeli, btnAdmin;
    
    public void openMenu() {
        setTitle("MAIN MENU");
        getContentPane().setBackground(Color.WHITE);
        setSize(600,420);
        
        iconToko = new JLabel(new ImageIcon(getClass().getResource("/image/tokobuku.png")));
        iconToko2 = new JLabel(new ImageIcon(getClass().getResource("/image/tokobuku.png")));
        labelToko = new JLabel("TOKO BUKU GALIS");
        labelToko.setForeground(Color.DARK_GRAY);
        labelToko.setFont(new Font("Arial Black", Font.BOLD, 22));
        
        iconWelcome = new JLabel(new ImageIcon(getClass().getResource("/image/shining.png")));
        iconWelcome2 = new JLabel(new ImageIcon(getClass().getResource("/image/shining.png")));
        labelWelcome = new JLabel("WELCOME, READERS");
        labelWelcome.setForeground(Color.DARK_GRAY);
        labelWelcome.setFont(new Font("Arial Black", Font.BOLD, 20));
        
        iconBeli = new JLabel(new ImageIcon(getClass().getResource("/image/shopping.png")));
        btnBeli = new JButton("SHOPPING");
        btnBeli.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnBeli.setBackground(Color.DARK_GRAY);
        btnBeli.setForeground(Color.WHITE);
        
        iconAdmin = new JLabel(new ImageIcon(getClass().getResource("/image/admin.png")));
        btnAdmin = new JButton("ADMIN");
        btnAdmin.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnAdmin.setBackground(Color.DARK_GRAY);
        btnAdmin.setForeground(Color.WHITE);
        
        //setLayout, addComponent
        setLayout(null);
        add(labelToko);
        add(iconToko);
        add(iconToko2);
        add(labelWelcome);
        add(iconWelcome);
        add(iconWelcome2);
        add(btnBeli);
        add(iconBeli);
        add(btnAdmin);
        add(iconAdmin);
        
        //set bounds(m,n,o,p)
        labelToko.setBounds(170, 15, 280, 50);
        iconToko.setBounds(110, 10, 50, 50);
        iconToko2.setBounds(425, 10, 50, 50);
        
        labelWelcome.setBounds(175, 100, 250, 50);
        iconWelcome.setBounds(120, 100, 50, 50);
        iconWelcome2.setBounds(415, 100, 50, 50);

        iconBeli.setBounds(180, 200, 90, 90);
        btnBeli.setBounds(165, 300, 120, 30);
        btnBeli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBeli.addActionListener(this);
        
        iconAdmin.setBounds(340, 200, 90, 90);
        btnAdmin.setBounds(325, 300, 120, 30);
        btnAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAdmin.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnBeli){
           ControllerTransaksi tr = new ControllerTransaksi();
           tr.openTransaksi();
           dispose();
        }
        else if(e.getSource()== btnAdmin){
            ControllerLoginReg lg = new ControllerLoginReg();
            lg.cekLogin();
            dispose();
        }
    }
}
