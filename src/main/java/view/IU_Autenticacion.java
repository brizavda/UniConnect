package view;

import controller.ControladorAutenticacion;
import java.util.Scanner;

public class IU_Autenticacion {
    ControladorAutenticacion controladorAutenticacion = new ControladorAutenticacion();
    Scanner scanner = new Scanner(System.in);
    public void getInitMessage(int opcion){
        //System.out.println(opcion);
        controladorAutenticacion.sendOptionMessage(opcion);
    }

    public void inicioSesion() {
        System.out.println("╔══════════════════════════╗");
        System.out.println("║    Inicio de Sesión      ║");
        System.out.println("╚══════════════════════════╝");

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        controladorAutenticacion.sendLoginData(correo, contrasena);

    }

    public void registrarse() {
        System.out.println("Registrarse");

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Fecha de Nacimiento DD/MM/AAAA: ");
        String fechaNacimiento = scanner.nextLine();

        controladorAutenticacion.sendNewData(correo, contrasena, nombre, fechaNacimiento);

    }
}

