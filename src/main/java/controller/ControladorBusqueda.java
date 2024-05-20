package controller;
import model.Perfil.Usuario;
import model.Publicaciones.Publicacion;
import java.util.List;
import model.Busqueda.GestorBusqueda;

public class ControladorBusqueda {
    private GestorBusqueda gestorBusqueda;

    public ControladorBusqueda(GestorBusqueda gestorBusqueda) {
        this.gestorBusqueda = gestorBusqueda;
    }

    public List<Usuario> buscarUsuarioPorId(int idUsuario) {
        return gestorBusqueda.buscarUsuario(idUsuario, null);
    }

    public List<Usuario> buscarUsuarioPorCorreo(String correo) {
        return gestorBusqueda.buscarUsuario(0, correo);
    }

    public List<Publicacion> buscarPublicaciones(String contenido, int idAutor) {
        Usuario autor = gestorBusqueda.buscarUsuarioPorId(idAutor);
        if (autor == null) {
            return null;
        }
        return gestorBusqueda.buscarPublicaciones(contenido, autor);
    }

    
}
