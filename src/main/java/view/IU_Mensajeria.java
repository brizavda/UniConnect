package view;

import java.util.Scanner;

public class IU_Mensajeria {
    Scanner scanner = new Scanner(System.in);
    public void menu() {
        System.out.println("=== Menú de Mensajería ===");
        System.out.println("1. Enviar Nuevo Mensaje");
        System.out.println("2. Ver Mensajes Nuevos");
        System.out.println("3. Salir");
        int opcion = scanner.nextInt();
        //Agrega controlador
    }

    public void agregarMensaje() {
        System.out.println("=== Nuevo Mensaje ===");

        System.out.print("Remitente (ID): ");
        int idRemitente = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Mensaje: ");
        String mensaje = scanner.nextLine();

        System.out.print("Destinatario (ID): ");
        int idDestinatario = scanner.nextInt();

        //Agrega controladorMensajeria con la logica

        System.out.println("Mensaje enviado con éxito.");
    }

    public void verMensajes(){
        System.out.println("=== Mensajes Nuevos ===");
        //Agrega controlador y la logica de despliegue de los mensajes
    }
}
