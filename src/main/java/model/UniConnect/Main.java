package model.UniConnect;

import model.Perfil.TablaUsuarios;
import model.Perfil.Usuario;
import view.IU_Principal;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        TablaUsuarios usuariosContainer;

        // Verificar si el archivo usuarios.dat existe
        File archivo = new File("usuarios.dat");
        if (archivo.exists()) {
            // Cargar datos desde el archivo
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                System.out.println("Obteniendo usuarios de ejemplo...");
                usuariosContainer = (TablaUsuarios) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
        } else {
            // Si el archivo no existe, crear y almacenar ejemplos de usuarios
            System.out.println("Creando usuarios de ejemplo...");
            usuariosContainer = new TablaUsuarios();
            Usuario usuario1 = new Usuario(1, "correo1@example.com", "contraseña1", "Nombre1", "01/01/1990");
            Usuario usuario2 = new Usuario(2, "correo2@example.com", "contraseña2", "Nombre2", "02/02/1991");
            Usuario usuario3 = new Usuario(3, "correo3@example.com", "contraseña3", "Nombre3", "03/03/1992");
            Usuario usuario4 = new Usuario(4, "correo4@example.com", "contraseña4", "Nombre4", "04/04/1993");
            Usuario usuario5 = new Usuario(5, "correo5@example.com", "contraseña5", "Nombre5", "05/05/1994");

            usuariosContainer.agregarUsuario(usuario1);
            usuariosContainer.agregarUsuario(usuario2);
            usuariosContainer.agregarUsuario(usuario3);
            usuariosContainer.agregarUsuario(usuario4);
            usuariosContainer.agregarUsuario(usuario5);

            // Guardar datos en el archivo
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
                oos.writeObject(usuariosContainer);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        IU_Principal principal = new IU_Principal();
        principal.inicializar();

        //usuariosContainer.buscarUsuarioPorCorreo("correo1@example.com");
        //usuariosContainer.buscarUsuarioPorId(5);
    }
}