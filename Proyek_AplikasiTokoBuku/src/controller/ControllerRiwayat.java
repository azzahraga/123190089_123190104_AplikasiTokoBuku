package controller;

import modell.ModelRiwayat;
import view.ViewAdmin;
import view.ViewTableRiwayat;

public class ControllerRiwayat {
    
    public void lihatRiwayat(){
        ModelRiwayat mr = new ModelRiwayat();
        String[][] data = mr.lihatRiwayat();
        if(data == null)
        {
            new ViewAdmin();
        }
        else
            new ViewTableRiwayat(data);
    }
}