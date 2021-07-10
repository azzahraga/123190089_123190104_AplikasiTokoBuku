package modell;

import database.Connectivity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModelRiwayat {
    private Connection connection;
    private Statement statement;
    DefaultTableModel tableModel;
    
    public ModelRiwayat(){
        Connectivity db = new Connectivity();
        connection = db.getConnection();
    }
    public String[][] lihatRiwayat(){
        try{
            int baris = 0;
            int jmlBaris = jmlBaris("penjualan");
            if(jmlBaris==0){
                return null;
            }
            String[][] data = new String[jmlBaris][8];
            statement = connection.createStatement();
            String sql = "select buku.id_buku,  penjualan.id_jual, buku.judul, buku.kategori, buku.penulis, buku.harga, penjualan.jumlah, penjualan.total_harga  from buku, penjualan where buku.id_buku = penjualan.id_buku"; 
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                data[baris][0] = resultSet.getString("id_jual");
                data[baris][1] = resultSet.getString("id_buku");
                data[baris][2] = resultSet.getString("judul");
                data[baris][3] = resultSet.getString("kategori");
                data[baris][4] = resultSet.getString("penulis");
                data[baris][5] = resultSet.getString("harga");
                data[baris][6] = resultSet.getString("jumlah");
                data[baris][7] = resultSet.getString("total_harga");
                baris++;
            }
            return data;
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
            return null;
        }
    }
    
    public int jmlBaris(String table){
        int jml = 0;
        try{
            statement = connection.createStatement();
            String query = "select * from " + table;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jml++;
            }
            return jml;

        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
            return 0;
        }
    }
}
