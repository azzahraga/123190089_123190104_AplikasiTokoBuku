package modell;

import controller.ControllerBuku;
import database.Connectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModelBuku {
    private Connection connection;
    private Statement statement;
    DefaultTableModel tableModel;
    
    public ModelBuku(){
        Connectivity db = new Connectivity();
        connection = db.getConnection();
    }
    
    public String[][] lihatBuku(){
        try{
            int baris = 0;
            int jmlBaris = jmlBaris("buku");
            if(jmlBaris==0){
                return null;
            }
            String[][] data = new String[jmlBaris][6];
            statement = connection.createStatement();
            String sql = "Select * from buku"; 
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                data[baris][0] = resultSet.getString("id_buku");
                data[baris][1] = resultSet.getString("judul");
                data[baris][2] = resultSet.getString("kategori");
                data[baris][3] = resultSet.getString("penulis");
                data[baris][4] = resultSet.getString("harga");
                data[baris][5] = resultSet.getString("stok");
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
    
    public String[] lihatBuku(String id){
        try{
            String[] data = new String[3];
            statement = connection.createStatement();
            String sql = "Select * from buku where id_buku = " +id+ "";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                data[0] = resultSet.getString("id_buku");
                data[1] = resultSet.getString("judul");
                data[2] = resultSet.getString("harga");
            }
            return data;
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
            return null;
        }
    }
    
    public String[] lihatBooks(String id){
        try{
            String[] data = new String[6];
            statement = connection.createStatement();
            String sql = "Select * from buku where id_buku = " +id+ "";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                data[0] = resultSet.getString("id_buku");
                data[1] = resultSet.getString("judul");
                data[2] = resultSet.getString("kategori");
                data[3] = resultSet.getString("penulis");
                data[4] = resultSet.getString("harga");
                data[5] = resultSet.getString("stok");
            }
            return data;
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
            return null;
        }
    }
        
        public void tambahBuku(String[] data){
        try{
            String sql = "insert into buku (judul, kategori, penulis, harga, stok) values (?, ?, ?, ?, ?)";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, data[0]);
            p.setString(2, data[1]);
            p.setString(3, data[2]);
            p.setString(4, data[3]);
            p.setString(5, data[4]);
            p.executeUpdate();
            connection.close();
            JOptionPane.showMessageDialog(null, "Tambah Buku Berhasil!!!");
        } catch (SQLException error) {
            System.out.println("Error");
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
        
        public void updateData(String[] data){
        try{
            String query = "UPDATE buku SET judul = '"+data[1]+"', kategori = '"+data[2]+"', penulis = '"+data[3]+"', harga = '"+data[4]+"', stok = '"+data[5]+"'  WHERE id_buku = '"+data[0]+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);   
            JOptionPane.showMessageDialog(null, "Update Buku Berhasil!!!");
            ControllerBuku b = new ControllerBuku();
            b.openInput();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
        
        public void deleteData(String id) {
        try {
            String query = " delete from buku where id_buku = ?";
            PreparedStatement p = connection.prepareStatement(query);
            p.setString (1, id);
            p.execute();
            connection.close();

            JOptionPane.showMessageDialog(null, "Hapus Buku Berhasil!!!");
        }
        catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Gagal! Buku ini banyak digemari!");
        }
    }
}
