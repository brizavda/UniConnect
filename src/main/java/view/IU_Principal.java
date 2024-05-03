package view; // Definición del paquete donde se encuentra la clase

import controller.ControladorPrincipal; // Importación de la clase ControladorPrincipal del paquete controller

import java.util.Scanner; // Importación de la clase Scanner del paquete java.util

public class IU_Principal { // Definición de la clase IU_Principal
    ControladorPrincipal controladorPrincipal = new ControladorPrincipal(); // Crear una instancia de ControladorPrincipal
    Scanner scanner = new Scanner(System.in); // Crear una instancia de Scanner para entrada de usuario

    public void inicializar() { // Método para inicializar la interfaz de usuario principal
        System.out.println("╔══════════════════════════════════╗"); // Imprimir el encabezado de bienvenida
        System.out.println("║     Bienvenido a UniConnect      ║"); // Imprimir el título
        System.out.println("║                                  ║"); // Imprimir una línea vacía
        System.out.println("║ Por favor, elija una opción:     ║"); // Imprimir instrucciones
        System.out.println("║   1. Iniciar sesión              ║"); // Imprimir opciones disponibles
        System.out.println("║   2. Registrarse                 ║");
        System.out.println("║   3. Salir                       ║");
        System.out.println("╚══════════════════════════════════╝"); // Imprimir el pie de página
        int opcion = scanner.nextInt(); // Leer la opción ingresada por el usuario
        controladorPrincipal.sendInitMessage(opcion); // Enviar la opción al controlador principal
    }

    public void menu() { // Método para mostrar el menú principal
        System.out.println("\nMenú:"); // Imprimir título del menú
        System.out.println("1. Publicaciones"); // Imprimir opciones del menú
        System.out.println("2. Perfil");
        System.out.println("3. Notificaciones");
        System.out.println("4. Mensajería");
        System.out.println("5. Búsqueda");
        System.out.println("6. Servicios");
        System.out.println("7. Eventos");
        System.out.println("8. Tutorías");
        System.out.println("9. Cerrar sesión");
        int opcion = scanner.nextInt(); // Leer la opción ingresada por el usuario
        controladorPrincipal.sendMenuMessage(opcion); // Enviar la opción al controlador principal
    }
}

