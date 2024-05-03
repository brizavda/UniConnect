package view;

import java.util.Scanner;
import controller.ControladorPublicacion;

public class IU_Publicaciones {
    private ControladorPublicacion controladorPublicacion;
    private Scanner scanner;

    public IU_Publicacion() {
        controladorPublicacion = new ControladorPublicacion();
        scanner = new Scanner(System.in);

    public void getMessage(int opcion) {
        controladorPublicacion.sendOptionMessage(opcion);
    }

    public void publicacion() {
        System.out.println("=== Menú de Publicaciones ^_^ ===");
        System.out.println("1. Crear Publicacion");
        System.out.println("2. Ver Publicaciones");
        System.out.println("3. Salir");

        char opcion = scanner.nextLine().charAt(0);

        switch (opcion) {
            case '1':
                crearPublicacion();
                break;
            case '2':
                verPublicaciones();
                break;
            case '3':
                System.out.println("Saliendo para afuera");
                break;
            default:
                System.out.println("Opcion incorrecta, intentalo otra vez :3 ");
        }
    }

    public void crearPublicacion() {
        System.out.println("=== Crea Publicacion ===");

        System.out.print("Escribe una publicacion: ");
        String publicacion = scanner.nextLine();

   
        controladorPublicacion.crearPublicacion(publicacion);

        System.out.println("Publicacion creada con éxito");
    }

    public void verPublicaciones() {
        System.out.println("=== Ver publicaciones ===");
        
        // publicaciones
        controladorPublicacion.verPublicaciones();
    }
}
}
