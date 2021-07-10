package modell;

import controller.ControllerBuku;
import controller.ControllerLoginReg;
import controller.ControllerMenu;
import controller.ControllerTransaksi;
import database.Connectivity;
import javax.swing.*;
import java.sql.*;

public class ModelLoginReg {
    private Connection connection;
    private Statement statement,statement1;
    
    public ModelLoginReg(){
        Connectivity db = new Connectivity();
        connection = db.getConnection();
    }
    
    public void cekLogin(String[] data){
        try{
            String query = "SELECT * FROM admin WHERE username_adm = '"+data[0]+"' and password_adm = '"+data[1]+"'";
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery(query);
            //connection.close();    
            if(r.next()){
                JOptionPane.showMessageDialog(null, "Login Successfully");
                ControllerMenu mn = new ControllerMenu();
                mn.openAdmin();
            }else
            {
                JOptionPane.showMessageDialog(null, "Wrong Username or Password");
                ControllerLoginReg c = new ControllerLoginReg();
                c.cekLogin();

            }
        } catch (SQLException error) {
            System.out.println("Error");
            JOptionPane.showMessageDialog(null, error.getMessage());
            
        } 
    }
    
    public void doRegist(String[] data){
            try{
                String sql = "insert into admin (namalengkap, username_adm, password_adm) values (?, ?, ?)";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setString(1, data[0]);
                p.setString(2, data[1]);
                p.setString(3, data[2]);
                p.executeUpdate();
                connection.close();
                JOptionPane.showMessageDialog(null, "Create Account Successfully!!!");
                ControllerLoginReg lg = new ControllerLoginReg();
                lg.cekLogin();
            } catch (SQLException error) {
                System.out.println("Error");
                JOptionPane.showMessageDialog(null, error.getMessage());
            } 
    }
}
