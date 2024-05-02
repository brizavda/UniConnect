package model.Perfil;

import java.io.*;
import java.util.ArrayList;

public class TablaUsuarios {
    private ArrayList<Usuario> usuarios;
    private String nombreArchivo;

    public TablaUsuarios(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para eliminar una tutoría
    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    // Método para obtener todas las tutorías
    public ArrayList<Usuario> obtenerUsuario() {
        return usuarios;
    }

    public void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(usuarios);
            System.out.println("Usuarios guardados correctamente en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            usuarios = (ArrayList<Usuario>) ois.readObject();
            System.out.println("Usuarios cargados correctamente desde el archivo: " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
    }
}


