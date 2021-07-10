package controller;

import modell.ModelLoginReg;
import view.ViewLogin;
import view.ViewRegister;

public class ControllerLoginReg {
    public void cekLogin(){
        ViewLogin log = new ViewLogin();
        log.openLogin();
    }
    
    public void cekLogin(String[] data){
        ModelLoginReg modelLgn = new ModelLoginReg();
        modelLgn.cekLogin(data);
    }
    
    public void doRegist(){
        ViewRegister regist = new ViewRegister();
        regist.openRegister();
    }
    
    public void doRegist(String[] data){
         ModelLoginReg modelRgst = new ModelLoginReg();
         modelRgst.doRegist(data);
    }
}