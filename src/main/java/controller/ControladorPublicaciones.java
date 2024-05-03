package controller;

import model.Publicaciones.GestorPublicacion;
import model.Publicaciones.Publicacion;
import model.Publicaciones.TablaPublicacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControladorPublicacion {

    private TablaPublicacion tablaPublicacion;
    private GestorPublicacion gestorPublicacion;

    public ControladorPublicacion() {
        tablaPublicacion = new TablaPublicacion();
        gestorPublicacion = new GestorPublicacion(tablaPublicacion);
    }

    // Método para enviar mensajes de opción al gestor de publicaciones
    public void sendOptionMessage(int opcion) {
        gestorPublicacion.getMessage(opcion);
    }

    // Método para crear una nueva publicación
    public void crearPublicacion(String datosPublicacion, String autor) {
        LocalDateTime fechaHora = LocalDateTime.now(); 
        int idPublicacion = generarIdPublicacionUnico(); 
        Publicacion nuevaPublicacion = new Publicacion(datosPublicacion, fechaHora, autor, idPublicacion);
        tablaPublicacion.agregarPublicacion(nuevaPublicacion);
    }

    // Método para obtener todas las publicaciones
    public List<Publicacion> obtenerPublicaciones() {
        return tablaPublicacion.obtenerPublicaciones();
    }

    // Método para generar un ID único para una publicación
    private int generarIdPublicacionUnico() {
      
        return (int) (Math.random() * 1000); // Ejemplo simple: ID aleatorio entre 0 y 999
    }
}
