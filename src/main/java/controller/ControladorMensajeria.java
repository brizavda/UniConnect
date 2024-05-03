package controller;

import view.IU_Principal;
import model.Mensajeria.Mensaje;
import model.Mensajeria.GestorMensajeria;


public class ControladorMensajeria {
    private GestorMensajeria gestorMensajeria;

    public ControladorMensajeria() {
        gestorMensajeria = new GestorMensajeria();
    }

    public void agregarMensaje(int idRemitente, String mensaje, int idDestinatario) {
        gestorMensajeria.agregarMensaje(idRemitente, mensaje, idDestinatario);
    }

    public void verMensajes(int idUsuario) {
        gestorMensajeria.verMensajes(idUsuario);
    }
}
