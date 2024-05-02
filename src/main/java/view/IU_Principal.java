package view;

import controller.ControladorPrincipal;
import java.util.Scanner;

public class IU_Principal {
    ControladorPrincipal controladorPrincipal = new ControladorPrincipal();
    Scanner scanner = new Scanner(System.in);
    public void inicializar() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║     Bienvenido a UniConnect      ║");
        System.out.println("║                                  ║");
        System.out.println("║ Por favor, elija una opción:     ║");
        System.out.println("║   1. Iniciar sesión              ║");
        System.out.println("║   2. Registrarse                 ║");
        System.out.println("║   3. Salir                       ║");
        System.out.println("╚══════════════════════════════════╝");
        int opcion = scanner.nextInt();
        controladorPrincipal.sendInitMessage(opcion);
    }

    public void menu() {
        System.out.println("\nMenú:");
        System.out.println("1. Publicaciones");
        System.out.println("2. Perfil");
        System.out.println("3. Notificaciones");
        System.out.println("4. Mensajería");
        System.out.println("5. Búsqueda");
        System.out.println("6. Servicios");
        System.out.println("7. Eventos");
        System.out.println("8. Tutorías");
        System.out.println("9. Cerrar sesión");
        int opcion = scanner.nextInt();
    }
}
