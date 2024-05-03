package view;
import controller.ControladorMensajeria;
import view.IU_Mensajeria;
import java.util.Scanner;

public class IU_Mensajeria {
     Scanner scanner = new Scanner(System.in);
     ControladorMensajeria controladorMensajeria = new ControladorMensajeria();
    public void menu() {
    boolean salir = false;

        while (!salir) {
        System.out.println("=== Menú de Mensajería ===");
        System.out.println("1. Enviar Nuevo Mensaje");
        System.out.println("2. Ver Mensajes Nuevos");
        System.out.println("3. Salir");
        int opcion = scanner.nextInt();
       
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarMensaje();
                    break;
                case 2:
                    verMensajes();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    public void agregarMensaje() {
        System.out.println("=== Nuevo Mensaje ===");
        System.out.print("Remitente (ID): ");
        int idRemitente = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Mensaje: ");
        String mensaje = scanner.nextLine();

        System.out.print("Destinatario (ID): ");
        int idDestinatario = scanner.nextInt();
        scanner.nextLine(); 

        controladorMensajeria.agregarMensaje(idRemitente, mensaje, idDestinatario);
        System.out.println("Mensaje enviado con éxito.");
    }

        //Agrega controladorMensajeria con la logica
        
        public void verMensajes() {
        System.out.println("=== Mensajes Nuevos ===");
        int idUsuario = obtenerIdUsuario();
        controladorMensajeria.verMensajes(idUsuario);
    }

}
