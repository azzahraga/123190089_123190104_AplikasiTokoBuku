package modell;

import controller.ControllerLoginReg;
import database.Connectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModelTransaksi {
    private Connection connection;
    private Statement statement;
    DefaultTableModel tableModel;
    
    public ModelTransaksi(){
        Connectivity db = new Connectivity();
        connection = db.getConnection();
    }
    
    public void doTransaction(String[] data){
            try{
                String sql = "insert into penjualan (id_buku, jumlah, total_harga) values (?, ?, ?)";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setString(1, data[0]);
                p.setString(2, data[1]);
                p.setString(3, data[2]);
                p.executeUpdate();
                connection.close();
                System.out.println("Tambah transaksi sukses!");
                //JOptionPane.showMessageDialog(null, "Create Account Successfully!!!");
                //ControllerLoginReg lg = new ControllerLoginReg();
                //lg.cekLogin();
            } catch (SQLException error) {
                System.out.println("Error");
                //JOptionPane.showMessageDialog(null, error.getMessage());
            } 
    }
}
