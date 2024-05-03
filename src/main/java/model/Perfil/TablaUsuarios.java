package model.Perfil;

import java.io.Serializable;
import java.util.ArrayList;

public class TablaUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Usuario> usuarios;

    public TablaUsuarios() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuarioPorCorreo(String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                System.out.println("Usuario con correo " + correo + " encontrado.");
                return usuario;
            }
        }
        System.out.println("No se encontró ningún usuario con el correo " + correo + ".");
        return null;
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == id) {
                System.out.println("Usuario con ID " + id + " encontrado.");
                return usuario;
            }
        }
        System.out.println("No se encontró ningún usuario con ID " + id + ".");
        return null;
    }

}
