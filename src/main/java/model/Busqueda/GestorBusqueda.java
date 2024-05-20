package model.Busqueda;
import java.util.ArrayList;
import java.util.List;
import model.Perfil.Usuario;
import model.Publicaciones.Publicacion;

public class GestorBusqueda {
    private List<Usuario> datosUsuarios;
    private List<Publicacion> datosPublicaciones;
    
// Constructor que recibe las listas de usuarios y publicaciones
    public GestorBusqueda(List<Usuario> datosUsuarios, List<Publicacion> datosPublicaciones) {
        this.datosUsuarios = datosUsuarios;
        this.datosPublicaciones = datosPublicaciones;
    }
    
 // Método que busca usuarios por ID, nombre o correo
    public List<Usuario> buscarUsuario(int idUsuario, String criterio) {
        List<Usuario> usuariosEncontrados = new ArrayList<>();
         // Recorre la lista de usuarios
        for (Usuario usuario : datosUsuarios) {
            // Verifica si el usuario coincide con el ID, nombre o correo proporcionados
            if (usuario.getIdUsuario() == idUsuario ||
                usuario.getNombre().equals(criterio) ||
                usuario.getCorreo().equals(criterio)) {
                  // Agrega el usuario a la lista de usuarios encontrados
                usuariosEncontrados.add(usuario);
            }
        }
        return usuariosEncontrados;
    }
     // Método que busca publicaciones por contenido y autor
    public List<Publicacion> buscarPublicaciones(String contenido, Usuario autor) {
        List<Publicacion> publicacionesEncontradas = new ArrayList<>();
        // Recorre la lista de publicaciones
        for (Publicacion publicacion : datosPublicaciones) {
           // Recorre la lista de publicaciones
            if (publicacion.getContenido().contains(contenido) &&
                publicacion.getAutor().equals(autor)) {
                 // Agrega la publicación a la lista de publicaciones encontradas
                publicacionesEncontradas.add(publicacion);
            }
        }
        return publicacionesEncontradas;
    }

    
}
