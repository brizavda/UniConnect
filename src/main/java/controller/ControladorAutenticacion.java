package controller;

import model.Autenticacion.GestorAutenticacion;
import model.Perfil.TablaUsuarios;
import view.IU_Autenticacion;
import view.IU_Principal;

public class ControladorAutenticacion {
    GestorAutenticacion gestorAutenticacion = new GestorAutenticacion();
    public void sendOptionMessage(int opcion) {
        //System.out.println(opcion);
        gestorAutenticacion.getOption(opcion);
    }
    public void getLogIn(){
        IU_Autenticacion autenticacion = new IU_Autenticacion();
        autenticacion.inicioSesion();
    }
    public void getRegistro(){
        IU_Autenticacion autenticacion = new IU_Autenticacion();
        autenticacion.registrarse();
    }

    public void sendLoginData(String correo, String contrasena) {
        boolean correcto = gestorAutenticacion.logIn(correo,contrasena);

        if (correcto==true){
            getMenu();
        }else {
            getInit();
        }
    }

    public void sendNewData(String correo, String contrasena, String nombre, String fechaNacimiento) {
        boolean correcto = gestorAutenticacion.newUser(correo,contrasena,nombre,fechaNacimiento);

        if (correcto==true){
            getLogIn();
        }else {
            System.out.println("Registro sin exito. Intenta de nuevo");
            getInit();
        }
    }

    public void getMenu() {
        IU_Principal principal = new IU_Principal();
        principal.menu();
    }
    public void getInit() {
        IU_Principal principal = new IU_Principal();
        principal.inicializar();
    }
}

