package view;

import controller.ControllerLoginReg;
import controller.ControllerMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewLogin extends JFrame implements ActionListener {
    JLabel labelUser,labelPass,labelTitle, iconUser, iconPass;
    JTextField fieldUser;
    JPasswordField fieldPass;
    JButton btnLogin, btnRegister,btnback;
    
    public void openLogin() {
        setTitle("LOGIN TOKO BUKU");
        getContentPane().setBackground(Color.WHITE);//warna bg
        setSize(400,400);//ukuran
       
        labelTitle = new JLabel("LOGIN");
        labelTitle.setForeground(Color.DARK_GRAY);
        labelTitle.setFont(new Font("Arial Black", Font.BOLD, 20));
        
        iconUser = new JLabel(new ImageIcon(getClass().getResource("/image/rsz_man.png")));
        iconPass = new JLabel(new ImageIcon(getClass().getResource("/image/rsz_pass.png")));
        labelUser = new JLabel("USERNAME");
        labelUser.setForeground(Color.black);
        labelUser.setFont(new Font("Arial Black", Font.PLAIN, 16));
        labelPass = new JLabel("PASSWORD");
        labelPass.setForeground(Color.black);
        labelPass.setFont(new Font("Arial Black", Font.PLAIN, 16));
        fieldUser = new JTextField();
        fieldPass = new JPasswordField();

        btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.WHITE);
        
        btnRegister = new JButton("REGISTER");
        btnRegister.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setForeground(Color.WHITE);
        
        btnback = new JButton("KEMBALI");
        btnback.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnback.setBackground(Color.GRAY);
        btnback.setForeground(Color.WHITE);
        
        //setLayout, addComponent
        setLayout(null);
        add(labelTitle);
        add(labelUser);
        add(labelPass);
        add(iconUser);
        add(iconPass);
        add(fieldUser);
        add(fieldPass);
        add(btnLogin);
        add(btnRegister);
        add(btnback);
        
        //set bounds(m,n,o,p)
        labelTitle.setBounds(160, 10, 150, 30);
        
        iconUser.setBounds(10, 78, 100, 50);
        labelUser.setBounds(100, 70, 150, 30);
        fieldUser.setBounds(100, 105, 230, 30);
        
        iconPass.setBounds(10, 158, 100, 50);
        labelPass.setBounds(100, 150, 150, 30);
        fieldPass.setBounds(100, 185, 230, 30);
        
        btnLogin.setBounds(55, 260, 120, 30);
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.addActionListener(this);
        
        btnRegister.setBounds(210, 260, 120, 30);
        btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegister.addActionListener(this);
        
        btnback.setBounds(110, 310, 160, 30);
        btnback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnback.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnLogin){
            if (fieldUser.getText().equals("")) {
                setMessage("Username tidak boleh kosong!");
            }
            else if (fieldPass.getText().equals("")) {
                setMessage("Password tidak boleh kosong!");
            }
            else {
                String[] data = {
                        fieldUser.getText(), fieldPass.getText()
                };
                ControllerLoginReg controlLogin = new ControllerLoginReg();
                controlLogin.cekLogin(data);
                dispose();
            }   
        }
        else if(e.getSource()== btnRegister){
            ControllerLoginReg controlRegist = new ControllerLoginReg();
            controlRegist.doRegist();
            dispose();
        }
        else if(e.getSource()== btnback){
            ControllerMenu controlback = new ControllerMenu();
            controlback.openMenu();
            dispose();
        }
    }
    
    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    
}
