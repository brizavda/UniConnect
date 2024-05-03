package view; // Definición del paquete donde se encuentra la clase

import controller.ControladorAutenticacion; // Importación de la clase ControladorAutenticacion del paquete controller
import java.util.Scanner; // Importación de la clase Scanner del paquete java.util

public class IU_Autenticacion { // Definición de la clase IU_Autenticacion
    ControladorAutenticacion controladorAutenticacion = new ControladorAutenticacion(); // Crear una instancia de ControladorAutenticacion
    Scanner scanner = new Scanner(System.in); // Crear una instancia de Scanner para entrada de usuario

    public void getInitMessage(int opcion) { // Método para obtener el mensaje de inicialización
        controladorAutenticacion.sendOptionMessage(opcion); // Enviar la opción al controlador de autenticación
    }
    public void getMenuMessage(int opcion) {
        controladorAutenticacion.sendOptionMenu(opcion);
    }

    public void inicioSesion() { // Método para iniciar sesión
        System.out.println("╔══════════════════════════╗"); // Imprimir el encabezado de inicio de sesión
        System.out.println("║    Inicio de Sesión      ║");
        System.out.println("╚══════════════════════════╝");

        System.out.print("Correo: "); // Solicitar al usuario que ingrese su correo electrónico
        String correo = scanner.nextLine(); // Leer el correo electrónico ingresado por el usuario

        System.out.print("Contraseña: "); // Solicitar al usuario que ingrese su contraseña
        String contrasena = scanner.nextLine(); // Leer la contraseña ingresada por el usuario

        controladorAutenticacion.sendLoginData(correo, contrasena); // Enviar los datos de inicio de sesión al controlador de autenticación
    }

    public void registrarse() { // Método para registrarse
        System.out.println("Registrarse"); // Imprimir el título del registro

        System.out.print("Correo: "); // Solicitar al usuario que ingrese su correo electrónico
        String correo = scanner.nextLine(); // Leer el correo electrónico ingresado por el usuario

        System.out.print("Contraseña: "); // Solicitar al usuario que ingrese su contraseña
        String contrasena = scanner.nextLine(); // Leer la contraseña ingresada por el usuario

        System.out.print("Nombre: "); // Solicitar al usuario que ingrese su nombre
        String nombre = scanner.nextLine(); // Leer el nombre ingresado por el usuario

        System.out.print("Fecha de Nacimiento DD/MM/AAAA: "); // Solicitar al usuario que ingrese su fecha de nacimiento
        String fechaNacimiento = scanner.nextLine(); // Leer la fecha de nacimiento ingresada por el usuario

        controladorAutenticacion.sendNewData(correo, contrasena, nombre, fechaNacimiento); // Enviar los nuevos datos al controlador de autenticación
    }
}


