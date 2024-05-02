package model.Perfil;

public class Usuario {
    private int idUsuario;
    private String correo;
    private String contraseña;
    private String nombre;
    private String fecNac;

    // Constructor
    public Usuario(int idUsuario, String correo, String contraseña, String nombre, String fecNac) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.fecNac = fecNac;
    }

    // Métodos getters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecNac(){
        return fecNac;
    }

    // Métodos setters
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecNac(String fecNac){
        this.fecNac = fecNac;
    }

    // Método toString
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
