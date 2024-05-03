package model.Perfil; // Definición del paquete donde se encuentra la clase

import java.io.Serializable; // Importación de la interfaz Serializable del paquete java.io
import java.util.ArrayList; // Importación de la clase ArrayList del paquete java.util

public class TablaUsuarios implements Serializable { // Definición de la clase TablaUsuarios que implementa Serializable
    private static final long serialVersionUID = 1L; // Identificador de versión para control de serialización
    private ArrayList<Usuario> usuarios; // Declaración de una lista de usuarios

    public TablaUsuarios() { // Constructor de la clase TablaUsuarios
        usuarios = new ArrayList<>(); // Inicialización de la lista de usuarios
    }

    public void agregarUsuario(Usuario usuario) { // Método para agregar un usuario a la tabla
        usuarios.add(usuario); // Agregar el usuario a la lista
    }

    public ArrayList<Usuario> getUsuarios() { // Método para obtener la lista de usuarios
        return usuarios; // Devolver la lista de usuarios
    }

    public Usuario buscarUsuarioPorCorreo(String correo) { // Método para buscar un usuario por correo electrónico
        for (Usuario usuario : usuarios) { // Iterar sobre la lista de usuarios
            if (usuario.getCorreo().equals(correo)) { // Si se encuentra un usuario con el correo especificado
                System.out.println("Usuario con correo " + correo + " encontrado."); // Imprimir mensaje de éxito
                return usuario; // Devolver el usuario encontrado
            }
        }
        System.out.println("No se encontró ningún usuario con el correo " + correo + "."); // Imprimir mensaje de error
        return null; // Devolver null si no se encontró ningún usuario con el correo especificado
    }

    public Usuario buscarUsuarioPorId(int id) { // Método para buscar un usuario por ID
        for (Usuario usuario : usuarios) { // Iterar sobre la lista de usuarios
            if (usuario.getIdUsuario() == id) { // Si se encuentra un usuario con el ID especificado
                System.out.println("Usuario con ID " + id + " encontrado."); // Imprimir mensaje de éxito
                return usuario; // Devolver el usuario encontrado
            }
        }
        System.out.println("No se encontró ningún usuario con ID " + id + "."); // Imprimir mensaje de error
        return null; // Devolver null si no se encontró ningún usuario con el ID especificado
    }
}

