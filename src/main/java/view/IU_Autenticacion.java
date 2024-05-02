package view;

import controller.ControladorAutenticacion;
import java.util.Scanner;

public class IU_Autenticacion {
    ControladorAutenticacion controladorAutenticacion = new ControladorAutenticacion();
    Scanner scanner = new Scanner(System.in);
    public void getMessage(int opcion){
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
        String contraseña = scanner.nextLine();

        controladorAutenticacion.sendLoginData(correo, contraseña);

        // Aquí iría la lógica para autenticar al usuario con el correo y contraseña ingresados
        System.out.println("Iniciando sesión para el correo: " + correo);

        controladorAutenticacion.getMenu();
    }

    public void registrarse() {
        System.out.println("Registrarse");

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Fecha de Nacimiento DD/MM/AAAA: ");
        String fechaNacimiento = scanner.nextLine();

        controladorAutenticacion.sendNewData(correo, contraseña, nombre, fechaNacimiento);

        // Aquí iría la lógica para registrar al usuario con los datos ingresados
        System.out.println("Registrando usuario con correo: " + correo);

        controladorAutenticacion.getInit();
    }
}

