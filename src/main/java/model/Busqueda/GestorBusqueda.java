package model.Busqueda;
import java.util.ArrayList;
import java.util.List;
import model.Perfil.Usuario;
import model.Publicaciones.Publicacion;

public class GestorBusqueda {
    private List<Usuario> datosUsuarios;
    private List<Publicacion> datosPublicaciones;

    public GestorBusqueda(List<Usuario> datosUsuarios, List<Publicacion> datosPublicaciones) {
        this.datosUsuarios = datosUsuarios;
        this.datosPublicaciones = datosPublicaciones;
    }

    public List<Usuario> buscarUsuario(int idUsuario, String criterio) {
        List<Usuario> usuariosEncontrados = new ArrayList<>();

        for (Usuario usuario : datosUsuarios) {
            if (usuario.getIdUsuario() == idUsuario ||
                usuario.getNombre().equals(criterio) ||
                usuario.getCorreo().equals(criterio)) {
                usuariosEncontrados.add(usuario);
            }
        }
        return usuariosEncontrados;
    }

    public List<Publicacion> buscarPublicaciones(String contenido, Usuario autor) {
        List<Publicacion> publicacionesEncontradas = new ArrayList<>();

        for (Publicacion publicacion : datosPublicaciones) {
            if (publicacion.getContenido().contains(contenido) &&
                publicacion.getAutor().equals(autor)) {
                publicacionesEncontradas.add(publicacion);
            }
        }
        return publicacionesEncontradas;
    }

    
}
