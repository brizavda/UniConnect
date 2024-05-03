package controller;

import view.IU_Autenticacion;
import view.IU_Principal;

public class ControladorPrincipal {
    IU_Autenticacion autenticacion = new IU_Autenticacion();
    public void sendInitMessage(int opcion){
        //System.out.println(opcion);
        autenticacion.getInitMessage(opcion);
    }

    public void getInit(){
        IU_Principal principal = new IU_Principal();
        principal.inicializar();
    }

    public void sendMenuMessage(int opcion) {
    }
}
