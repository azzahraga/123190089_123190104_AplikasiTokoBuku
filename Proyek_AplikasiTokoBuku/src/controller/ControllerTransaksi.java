package controller;

import modell.ModelBuku;
import modell.ModelTransaksi;
import view.ViewTable;
import view.ViewTransaksi;

public class ControllerTransaksi {
    
    public void openTransaksi(){
        ViewTransaksi vt = new ViewTransaksi();
        vt.openTransaksi();
    }
    
    public void lihatBuku(){
        ModelBuku mb = new ModelBuku();
        String[][] data = mb.lihatBuku();
        if(data == null)
        {
            ViewTransaksi v = new ViewTransaksi();
            v.openTransaksi();
        }
        else
            new ViewTable(data);
    }
    
    public void lihatBuku(String kode) {
        ModelBuku model = new ModelBuku();
        ViewTransaksi detail = new ViewTransaksi();
        detail.openTransaksi(model.lihatBuku(kode));
    }
    
    public void addTransaction(String[] data) {
        ModelTransaksi modelRgst = new ModelTransaksi();
        modelRgst.doTransaction(data);
    }
}
