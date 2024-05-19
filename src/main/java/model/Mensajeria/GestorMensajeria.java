package model.Mensajeria;
import model.Mensajeria.Mensaje;
import java.util.ArrayList;
import java.util.List;
public class GestorMensajeria {
    private List<Mensaje> mensajes = new ArrayList<>();

    public void agregarMensaje(int idRemitente, String mensaje, int idDestinatario) {
        Mensaje nuevoMensaje = new Mensaje(idRemitente, mensaje, idDestinatario);
        mensajes.add(nuevoMensaje);
    }

    public void verMensajes(int idUsuario) {
        for (Mensaje mensaje : mensajes) {
            if (mensaje.getIdDestinatario() == idUsuario) {
                System.out.println("De: " + mensaje.getIdRemitente());
                System.out.println("Mensaje: " + mensaje.getMensaje());
                System.out.println("---");
            }
        }
    }
}
