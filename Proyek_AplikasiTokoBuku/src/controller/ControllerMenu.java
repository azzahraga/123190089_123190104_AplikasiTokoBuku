package controller;

import view.ViewAdmin;
import view.ViewMenu;


public class ControllerMenu {
    public void openMenu(){
        ViewMenu vm = new ViewMenu();
        vm.openMenu();
        
    }
    
    public void openAdmin(){
        ViewAdmin adm = new ViewAdmin();
        adm.openAdmin();
    }
}
