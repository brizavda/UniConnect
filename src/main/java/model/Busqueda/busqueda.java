package model.Busqueda;
import model.Perfil.Usuario;

public class Busqueda {
    private int IdUsuario;
    private String correoUsuario;
    private String contenidoPublicacion;
    private Usuario autorPublicacion;
    

    public Busqueda(int IdUsuario, String correoUsuario, Usuario usuarioBuscado) {
        this.IdUsuario = IdUsuario;
        this.correoUsuario = correoUsuario;
      
    }

    public Busqueda(String contenidoPublicacion, Usuario autorPublicacion) {
        this.contenidoPublicacion = contenidoPublicacion;
        this.autorPublicacion = autorPublicacion;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    // Getters for publication search attributes
    public String getContenidoPublicacion() {
        return contenidoPublicacion;
    }

    public Usuario getAutorPublicacion() {
        return autorPublicacion;
    }

   
}
