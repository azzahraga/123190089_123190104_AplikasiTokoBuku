package database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Connectivity {
    String dbUrl = "jdbc:mysql://localhost/apltokobuku";
    String dbUsername = "root";
    String dbPassword = "";
    private Connection connection;
    
    public Connectivity(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Koneksi berhasil");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal");
        }
    }

    public Connection getConnection(){
        return  connection;
    }
}
