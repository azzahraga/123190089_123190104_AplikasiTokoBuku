package view;

import controller.ControllerLoginReg;
import controller.ControllerMenu;
import controller.ControllerTransaksi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTransaksi extends JFrame implements ActionListener{
     JLabel labelTitle = new JLabel("TRANSAKSI");
     private String id;
     private JTextField fnama,fharga;
    
    JLabel labelnama = new JLabel("Judul Buku");
//    final JTextField fnama = new JTextField();
    
    JLabel labelharga = new JLabel("Harga Buku");
//    final JTextField fharga = new JTextField();
    
    JLabel labelbnyk = new JLabel("Jumlah");
    final JTextField fbnyk = new JTextField();
    
    JLabel labeldiskon = new JLabel("Diskon");
    final JTextField fdiskon = new JTextField();
    
    JLabel labeltotal = new JLabel("Total Harga");
    final JTextField ftotal = new JTextField();
    
    JLabel labelbayar = new JLabel("Jumlah Bayar");
    final JTextField fbayar = new JTextField();
    
    JLabel labelkembalian = new JLabel("KEMBALIAN");
    final JTextField fkembalian = new JTextField();
    
    JLabel iconcari = new JLabel(new ImageIcon(getClass().getResource("/image/rsz_search_3.png")));;
    
    JButton btnlihat = new JButton("Lihat Barang");
    JButton btnbayar = new JButton("Proses");
    JButton btnreset = new JButton("Reset");
    JButton btntot = new JButton("Total");
    JButton btnkembali = new JButton("Kembali");
    
    public void openTransaksi(){
        setTitle("TRANSAKSI");
        getContentPane().setBackground(Color.WHITE);
        setSize(665, 450);
     
        fnama = new JTextField();
        fharga = new JTextField();
        //setLayout
        setLayout(null);
        add(labelTitle);
        add(labelnama);
        add(fnama);
        add(labelharga);
        add(fharga);
        add(labelbnyk);
        add(fbnyk);
        add(labeldiskon);
        add(fdiskon);
        add(labeltotal);
        add(ftotal);
        add(labelbayar);
        add(fbayar);
        add(labelkembalian);
        add(fkembalian);
        add(btnlihat);
        add(btnbayar);
        add(btnreset);
        add(btnkembali);
        add(btntot);
        add(iconcari);

        
        //set bounds(m,n,o,p)
        labelTitle.setBounds(250, 20, 150, 25);
        labelTitle.setFont(new Font("Arial Black", Font.PLAIN,20));
        labelnama.setBounds(30, 50, 160, 20);
        labelnama.setFont(new Font("Arial Black", Font.PLAIN,12));
        fnama.setBounds(40, 80, 280, 24);
        
        labelharga.setBounds(30, 110, 160, 20);
        labelharga.setFont(new Font("Arial Black", Font.PLAIN,12));
        fharga.setBounds(40, 140, 280, 24);
        
        labelbnyk.setBounds(30, 170, 160, 20);
        labelbnyk.setFont(new Font("Arial Black", Font.PLAIN,12));
        fbnyk.setBounds(40, 200, 280, 24);
        
        labeldiskon.setBounds(30, 250, 160, 20);
        labeldiskon.setFont(new Font("Arial Black", Font.PLAIN,12));
        fdiskon.setBounds(40, 280, 280, 24);
        
        labeltotal.setBounds(38, 330, 120, 20);
        labeltotal.setFont(new Font("Arial Black", Font.PLAIN,12));
        ftotal.setBounds(123, 330, 197, 24);
        
        labelbayar.setBounds(450, 110, 160, 20);
        labelbayar.setFont(new Font("Arial Black", Font.PLAIN,12));
        fbayar.setBounds(350, 140, 280, 24);
        
        btnlihat.setBounds(450, 70, 120, 20);
       
        iconcari.setBounds(580, 50, 50, 50);
        
        btnlihat.setBackground(Color.BLACK);
        btnlihat.setForeground(Color.WHITE);
        btnlihat.addActionListener(this);
        btnbayar.setBounds(350, 200, 85, 20);
        btnbayar.setBackground(Color.BLACK);
        btnbayar.setForeground(Color.WHITE);
        btnbayar.addActionListener(this);
        btnreset.setBounds(445, 200, 85, 20);
        btnreset.setBackground(Color.RED);
        btnreset.setForeground(Color.WHITE);
        btnreset.addActionListener(this);
        btnkembali.setBounds(540, 200, 85, 20);
        btnkembali.setBackground(Color.BLUE);
        btnkembali.setForeground(Color.WHITE);
        btnkembali.addActionListener(this);
        btntot.setBounds(140, 230, 70, 20);
        btntot.setBackground(Color.BLACK);
        btntot.setForeground(Color.WHITE);
        btntot.addActionListener(this);

        labelkembalian.setBounds(435, 270, 280, 24);
        labelkembalian.setFont(new Font("Arial Black", Font.PLAIN,18));
        fkembalian.setBounds(353, 310, 280, 24);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    public void openTransaksi(String[] data){
        this.id = data[0];
        setTitle(data[1]);
        setTitle("TRANSAKSI");
        getContentPane().setBackground(Color.WHITE);
        setSize(665, 450);
        
        fnama = new JTextField(data[1]);
        fharga = new JTextField(data[2]);
        //setLayout
        setLayout(null);
        add(labelTitle);
        add(labelnama);
        add(fnama);
        add(labelharga);
        add(fharga);
        add(labelbnyk);
        add(fbnyk);
        add(labeldiskon);
        add(fdiskon);
        add(labeltotal);
        add(ftotal);
        add(labelbayar);
        add(fbayar);
        add(labelkembalian);
        add(fkembalian);
        add(btnlihat);
        add(btnbayar);
        add(btnreset);
        add(btnkembali);
        add(iconcari);
        add(btntot);

        
        //set bounds(m,n,o,p)
        labelTitle.setBounds(250, 20, 150, 25);
        labelTitle.setFont(new Font("Arial Black", Font.PLAIN,20));
        labelnama.setBounds(30, 50, 160, 20);
        labelnama.setFont(new Font("Arial Black", Font.PLAIN,12));
        fnama.setBounds(40, 80, 280, 24);
        
        labelharga.setBounds(30, 110, 160, 20);
        labelharga.setFont(new Font("Arial Black", Font.PLAIN,12));
        fharga.setBounds(40, 140, 280, 24);
        
        labelbnyk.setBounds(30, 170, 160, 20);
        labelbnyk.setFont(new Font("Arial Black", Font.PLAIN,12));
        fbnyk.setBounds(40, 200, 280, 24);
        
        labeldiskon.setBounds(30, 250, 160, 20);
        labeldiskon.setFont(new Font("Arial Black", Font.PLAIN,12));
        fdiskon.setBounds(40, 280, 280, 24);
        
        labeltotal.setBounds(38, 330, 120, 20);
        labeltotal.setFont(new Font("Arial Black", Font.PLAIN,12));
        ftotal.setBounds(123, 330, 197, 24);
        
        labelbayar.setBounds(450, 110, 160, 20);
        labelbayar.setFont(new Font("Arial Black", Font.PLAIN,12));
        fbayar.setBounds(350, 140, 280, 24);
        
        btnlihat.setBounds(450, 70, 120, 20);
       
        iconcari.setBounds(580, 50, 50, 50);
        
        btnlihat.setBackground(Color.BLACK);
        btnlihat.setForeground(Color.WHITE);
        btnlihat.addActionListener(this);
        btnbayar.setBounds(350, 200, 85, 20);
        btnbayar.setBackground(Color.BLACK);
        btnbayar.setForeground(Color.WHITE);
        btnbayar.addActionListener(this);
        btnreset.setBounds(445, 200, 85, 20);
        btnreset.setBackground(Color.RED);
        btnreset.setForeground(Color.WHITE);
        btnreset.addActionListener(this);
        btnkembali.setBounds(540, 200, 85, 20);
        btnkembali.setBackground(Color.BLUE);
        btnkembali.setForeground(Color.WHITE);
        btnkembali.addActionListener(this);
        btntot.setBounds(140, 230, 70, 20);
        btntot.setBackground(Color.BLACK);
        btntot.setForeground(Color.WHITE);
        btntot.addActionListener(this);

        labelkembalian.setBounds(435, 270, 280, 24);
        labelkembalian.setFont(new Font("Arial Black", Font.PLAIN,18));
        fkembalian.setBounds(353, 310, 280, 24);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnlihat) {
          
            ControllerTransaksi l = new ControllerTransaksi();
            l.lihatBuku();
            dispose();
           
        }else if(e.getSource()==btnbayar){
            if (fbayar.getText().equals("")) {
                setMessage("Pembayaran harus diisi");
            } else if(fbayar.getText().matches("^[a-zA-Z]*$")){
                setMessage("Pembayaran harus bernilai bilangan");
            } else if(Integer.valueOf(fbayar.getText()) == 0){
                    setMessage("Pembayaran tidak boleh 0");
            } else if (Double.parseDouble(fbayar.getText())<0) {
                setMessage("Pembayaran harus positif");
            } else {
                double bayar= Double.parseDouble(fbayar.getText());
                double tot= Double.parseDouble(ftotal.getText());
                if(bayar>=tot)
                {
                    double byr = bayar-tot;
                    String kmbli=String.valueOf(byr);
                    fkembalian.setText(kmbli);
                    setMessage("Pembayaran berhasil!");
                    
                    String [] data = {
                        id, fbnyk.getText(), ftotal.getText()
                    };
                    ControllerTransaksi trans = new ControllerTransaksi();
                    trans.addTransaction(data); 
                }else{
                    setMessage("Uang tidak cukup! Isi kembali!");
                }
            }
            
        } else if(e.getSource()==btnreset){
            fnama.setText("");
            fharga.setText("");
            fbnyk.setText("");
            fdiskon.setText("");
            ftotal.setText("");
            fbayar.setText("");
            fkembalian.setText("");
        }else if(e.getSource()==btntot){
            if (fbnyk.getText().equals("")) {
                setMessage("Jumlah harus diisi");
            } else if(fbnyk.getText().matches("^[a-zA-Z]*$")){
                setMessage("Jumlah pembelian harus bilangan");
            } else if(Integer.valueOf(fbnyk.getText()) == 0){
                    setMessage("Jumlah pembelian tidak boleh 0");
            }else if (Double.parseDouble(fbnyk.getText())<0) {
                setMessage("Jumlah harus positif");
            } else {
                double b=Double.parseDouble(fbnyk.getText());
                double h=Double.parseDouble(fharga.getText());
                double dsk= b*h;
               if(b>2){
                   double disk= 0.2*dsk;
                   double dskn =dsk-disk;
                   String diskon=String.valueOf(disk);
                   String total=String.valueOf(dskn);
                   fdiskon.setText(diskon);
                   ftotal.setText(total);
               }else{
                   String harg=String.valueOf(dsk);
                   fdiskon.setText("0");
                   ftotal.setText(harg);
               }
            }
        }else if(e.getSource()==btnkembali){
            dispose();
            ControllerMenu mn = new ControllerMenu();
            mn.openMenu();
        }
    }

    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}

