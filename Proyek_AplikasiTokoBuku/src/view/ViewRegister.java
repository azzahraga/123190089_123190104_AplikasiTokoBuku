package view;

import controller.ControllerLoginReg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewRegister extends JFrame implements ActionListener {
    JLabel labelTitle, labelNama, labelUser,labelPass, labelConPass, iconNama, iconUser, iconConPass, iconPass, iconID;
    JTextField fieldUser, fieldNama;
    JPasswordField fieldPass, fieldConPass;
    JButton btnRegister,btnkembali;
    
    public void openRegister(){
        setTitle("REGISTER TOKO BUKU");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,560);//ukuran
        
        labelTitle = new JLabel("REGISTER");
        labelTitle.setForeground(Color.DARK_GRAY);
        labelTitle.setFont(new Font("Arial Black", Font.BOLD, 20));
        
        iconID = new JLabel(new ImageIcon(getClass().getResource("/image/id.png")));
        iconNama = new JLabel(new ImageIcon(getClass().getResource("/image/rname.png")));
        iconUser = new JLabel(new ImageIcon(getClass().getResource("/image/ruser.png")));
        iconPass = new JLabel(new ImageIcon(getClass().getResource("/image/rpas.png")));
        iconConPass = new JLabel(new ImageIcon(getClass().getResource("/image/rconpas.png")));
        
        labelNama = new JLabel("NAME");
        labelNama.setForeground(Color.black);
        labelNama.setFont(new Font("Arial Black", Font.PLAIN, 16));
        
        labelUser = new JLabel("USERNAME");
        labelUser.setForeground(Color.black);
        labelUser.setFont(new Font("Arial Black", Font.PLAIN, 16));
        
        labelPass = new JLabel("PASSWORD");
        labelPass.setForeground(Color.black);
        labelPass.setFont(new Font("Arial Black", Font.PLAIN, 16));
        
        labelConPass = new JLabel("CONFIRMED PASSWORD");
        labelConPass.setForeground(Color.black);
        labelConPass.setFont(new Font("Arial Black", Font.PLAIN, 16));
  
        fieldNama = new JTextField();
        fieldUser = new JTextField();
        fieldPass = new JPasswordField();
        fieldConPass = new JPasswordField();

        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setForeground(Color.WHITE);
        
        btnkembali = new JButton("KEMBALI");
        btnkembali.setFont(new Font("Arial Black", Font.PLAIN, 13));
        btnkembali.setBackground(Color.BLACK);
        btnkembali.setForeground(Color.WHITE);
        
        //setLayout, addComponent
        setLayout(null);
        add(labelTitle);
        add(iconID);
        
        add(labelNama);
        add(labelUser);
        add(labelPass);
        add(labelConPass);
        
        add(iconUser);
        add(iconPass);
        add(iconNama);
        add(iconConPass);
        
        add(fieldNama);
        add(fieldUser);
        add(fieldPass);
        add(fieldConPass);
        
        add(btnRegister);
        add(btnkembali);
        
        //set bounds(m,n,o,p)
        labelTitle.setBounds(140, 10, 150, 30);
        iconID.setBounds(165, 50, 60, 50);
   
        iconNama.setBounds(10, 118, 100, 50);
        labelNama.setBounds(100, 110, 150, 30);
        fieldNama.setBounds(100, 145, 230, 30);
        
        iconUser.setBounds(10, 198, 100, 50);
        labelUser.setBounds(100, 190, 150, 30);
        fieldUser.setBounds(100, 225, 230, 30);
        
        iconPass.setBounds(10, 278, 100, 50);
        labelPass.setBounds(100, 270, 150, 30);
        fieldPass.setBounds(100, 305, 230, 30);
        
        iconConPass.setBounds(10, 358, 100, 50);
        labelConPass.setBounds(100, 350, 250, 30);
        fieldConPass.setBounds(100, 385, 230, 30);
        
        btnRegister.setBounds(65, 455, 120, 30);
        btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegister.addActionListener(this);
        
        btnkembali.setBounds(215, 455, 120, 30);
        btnkembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnkembali.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnRegister){
            if (fieldNama.getText().equals("")) {
                setMessage("Nama tidak boleh kosong!");
            }
            else if (fieldUser.getText().equals("")) {
                setMessage("Username tidak boleh kosong!");
            }
            else if (fieldPass.getText().equals("")) {
                setMessage("Password tidak boleh kosong!");
            }
            else if (fieldConPass.getText().equals("")) {
                setMessage("Konfirmasi Password harus diisi!");
            } 
            else if (!fieldPass.getText().equals(fieldConPass.getText())) {
                setMessage("Password tidak cocok!");
            }
            else {
                String[] data = {
                        fieldNama.getText(), fieldUser.getText(), fieldPass.getText(), fieldConPass.getText()
                };
                ControllerLoginReg controlRegist = new ControllerLoginReg();
                controlRegist.doRegist(data);
                dispose();
            }
        }else  if(e.getSource()== btnkembali){
            ControllerLoginReg back = new ControllerLoginReg();
            back.cekLogin();
            dispose();
        }
    }
    
    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
