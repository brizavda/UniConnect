package controller;
import model.Autenticacion.GestorAutenticacion;
import model.Perfil.TablaUsuarios;
import view.IU_Autenticacion;
import view.IU_Principal;

public class ControladorAutenticacion {
    private TablaUsuarios tablaUsuarios;
    GestorAutenticacion gestorAutenticacion = new GestorAutenticacion(tablaUsuarios);
    public void sendOptionMessage(int opcion) {
        //System.out.println(opcion);
        gestorAutenticacion.getMessage(opcion);
    }
    public void getLogIn(){
        IU_Autenticacion autenticacion = new IU_Autenticacion();
        autenticacion.inicioSesion();
    }
    public void getRegistro(){
        IU_Autenticacion autenticacion = new IU_Autenticacion();
        autenticacion.registrarse();
    }

    public void sendLoginData(String correo, String contraseña) {
        gestorAutenticacion.logIn(correo,contraseña);
    }

    public void sendNewData(String correo, String contraseña, String nombre, String fechaNacimiento) {
        gestorAutenticacion.newUser(correo,contraseña,nombre,fechaNacimiento);
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
