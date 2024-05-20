package controller;

import model.Perfil.Usuario;
import model.Publicaciones.Publicacion;
import java.util.List;
import model.Busqueda.GestorBusqueda;

public class ControladorBusqueda {
   // Instancia del GestorBusqueda encargado de realizar las búsquedas
   private GestorBusqueda gestorBusqueda;

   // Constructor que recibe una instancia de GestorBusqueda
   public ControladorBusqueda(GestorBusqueda gestorBusqueda) {
       this.gestorBusqueda = gestorBusqueda;
   }

   // Método que busca usuarios por su ID
   public List<Usuario> buscarUsuarioPorId(int idUsuario) {
       // Delega la búsqueda al GestorBusqueda, pasando el ID y un criterio nulo
       return gestorBusqueda.buscarUsuario(idUsuario, null);
   }
 // Método que busca usuarios por su correo electrónico
   public List<Usuario> buscarUsuarioPorCorreo(String correo) {
       // Delega la búsqueda al GestorBusqueda, pasando un ID cero y el correo como criterio
       return gestorBusqueda.buscarUsuario(0, correo);
   }

   // Método que busca publicaciones por su contenido y el ID del autor
   public List<Publicacion> buscarPublicaciones(String contenido, int idAutor) {
       // Busca el autor por su ID
       Usuario autor = gestorBusqueda.buscarUsuarioPorId(idAutor);

       // Si el autor no existe, retorna null
       if (autor == null) {
           return null;
       }

       // Delega la búsqueda de publicaciones al GestorBusqueda, pasando el contenido y el autor
       return gestorBusqueda.buscarPublicaciones(contenido, autor);
   }
}
