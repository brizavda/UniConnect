package model.Perfil;

import java.io.*;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idUsuario;
    private String correo;
    private String contraseña;
    private String nombre;
    private String fecNac;

    public Usuario(int idUsuario, String correo, String contraseña, String nombre, String fecNac) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.fecNac = fecNac;
    }

    // Getters and setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecNac() {
        return fecNac;
    }

    public void setFecNac(String fecNac) {
        this.fecNac = fecNac;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecNac='" + fecNac + '\'' +
                '}';
    }
}
