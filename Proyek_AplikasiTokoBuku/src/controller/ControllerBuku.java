package controller;

import modell.ModelBuku;
import view.ViewAdmin;
import view.ViewInputBuku;
import view.ViewTable;
import view.ViewTableBuku;
import view.ViewTransaksi;
import view.ViewUpdate;

public class ControllerBuku {
    
    public void openInput(){
        ViewInputBuku vi = new ViewInputBuku();
        vi.inputBuku();
    }
    
    public void tambahBuku(String[] data){
        ModelBuku tb = new ModelBuku();
        tb.tambahBuku(data);
    }
    
    public void lihatBuku(){
        ModelBuku lb = new ModelBuku();
        String[][]data = lb.lihatBuku();
        if(data == null)
            new ViewAdmin();
        else
            new ViewTableBuku(data);
    }
    
    public void lihatBuku(String kode) {
        ModelBuku book = new ModelBuku();
        ViewUpdate detail = new ViewUpdate();
        detail.update(book.lihatBooks(kode));
    }
    
    public void updateBuku(String[] data){
        ModelBuku ub = new ModelBuku(); 
        ub.updateData(data);
    }
    
    public void deleteBuku(String id){
        ModelBuku model = new ModelBuku(); 
        model.deleteData(id);  
    }
}
