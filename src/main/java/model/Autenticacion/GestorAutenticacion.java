package model.Autenticacion;

import controller.ControladorAutenticacion;
import controller.ControladorPrincipal;
import model.Perfil.TablaUsuarios;
import model.Perfil.Usuario;

import java.io.*;

import static java.lang.System.exit;

public class GestorAutenticacion {
    TablaUsuarios usuariosContainer;
    public void getOption(int opcion) {
        ControladorAutenticacion controladorAutenticacion = new ControladorAutenticacion();
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal();
        //System.out.println(opcion);
        switch (opcion) {
            case 1 -> controladorAutenticacion.getLogIn();
            case 2 -> controladorAutenticacion.getRegistro();
            case 3 -> exit(0);
            default -> { System.out.println("Opcion invalida. Intente otra vez");
                controladorPrincipal.getInit();
            }
        }
    }

    public boolean logIn(String correo, String contrasena) {
        // Cargar datos desde el archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            usuariosContainer = (TablaUsuarios) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Usuario usuario = usuariosContainer.buscarUsuarioPorCorreo(correo);

        // Verificar si se encontró un usuario con el correo electrónico dado
        if (usuario != null) {
            // Verificar si la contraseña coincide
            if (usuario.getContraseña().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuario.getNombre() + "!");
                return true;
            } else {
                System.out.println("La contraseña ingresada es incorrecta.");
            }
        } else {
            System.out.println("No se encontró ningún usuario con el correo electrónico proporcionado.");
        }
        return false;
    }

    public boolean newUser(String correo, String contrasena, String nombre, String fecNac) {
        // Cargar datos desde el archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            usuariosContainer = (TablaUsuarios) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (usuariosContainer.buscarUsuarioPorCorreo(correo) != null) {
            System.out.println("El correo electrónico ya está registrado.");
            return false;
        }

        // Generar un ID único para el nuevo usuario (puede ser implementado de otra manera según las necesidades)
        int nuevoId = generarNuevoId();

        // Crear un nuevo usuario
        Usuario nuevoUsuario = new Usuario(nuevoId, correo, contrasena, nombre, fecNac);

        // Agregar el nuevo usuario a la tabla de usuarios
        usuariosContainer.agregarUsuario(nuevoUsuario);
        System.out.println("Usuario registrado exitosamente.");

        // Guardar datos en el archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
            oos.writeObject(usuariosContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private int generarNuevoId() {
        // Generar un ID de usuario único de forma aleatoria (por ejemplo, entre 1000 y 9999)
        return 1000 + (int) (Math.random() * 9000);
    }
}
