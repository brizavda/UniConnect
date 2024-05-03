package model.Autenticacion; // Definición del paquete donde se encuentra la clase

import controller.ControladorAutenticacion; // Importación de la clase ControladorAutenticacion del paquete controller
import controller.ControladorPrincipal; // Importación de la clase ControladorPrincipal del paquete controller
import model.Perfil.TablaUsuarios; // Importación de la clase TablaUsuarios del paquete model.Perfil
import model.Perfil.Usuario; // Importación de la clase Usuario del paquete model.Perfil

import java.io.*; // Importación de clases para operaciones de entrada/salida
import static java.lang.System.exit; // Importación de la clase System del paquete java.lang

public class GestorAutenticacion { // Definición de la clase GestorAutenticacion
    TablaUsuarios usuariosContainer; // Declaración de una variable para contener la tabla de usuarios

    public void getOption(int opcion) { // Método para obtener la opción seleccionada
        ControladorAutenticacion controladorAutenticacion = new ControladorAutenticacion(); // Crear una instancia de ControladorAutenticacion
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(); // Crear una instancia de ControladorPrincipal

        // Switch para manejar las opciones
        switch (opcion) {
            case 1 -> controladorAutenticacion.getLogIn(); // Iniciar sesión
            case 2 -> controladorAutenticacion.getRegistro(); // Registrarse
            case 3 -> exit(0); // Salir del programa
            default -> { // Si la opción no es válida
                System.out.println("Opción inválida. Intente nuevamente"); // Mensaje de error
                controladorPrincipal.getInit(); // Obtener el mensaje de inicialización
            }
        }
    }

    public boolean logIn(String correo, String contrasena) { // Método para iniciar sesión
        // Cargar datos desde el archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) { // Utilizar un ObjectInputStream para leer objetos desde el archivo
            usuariosContainer = (TablaUsuarios) ois.readObject(); // Leer el objeto TablaUsuarios desde el archivo y asignarlo a la variable usuariosContainer
        } catch (IOException | ClassNotFoundException e) { // Captura de excepciones de entrada/salida y de clase no encontrada
            e.printStackTrace(); // Imprimir la traza de la excepción
        }

        Usuario usuario = usuariosContainer.buscarUsuarioPorCorreo(correo); // Buscar usuario por correo electrónico

        // Verificar si se encontró un usuario con el correo electrónico dado
        if (usuario != null) {
            // Verificar si la contraseña coincide
            if (usuario.getContraseña().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuario.getNombre() + "!"); // Mensaje de éxito
                return true; // Devolver verdadero si el inicio de sesión es exitoso
            } else {
                System.out.println("La contraseña ingresada es incorrecta."); // Mensaje de error de contraseña incorrecta
            }
        } else {
            System.out.println("No se encontró ningún usuario con el correo electrónico proporcionado."); // Mensaje de error de usuario no encontrado
        }
        return false; // Devolver falso si el inicio de sesión no es exitoso
    }

    public boolean newUser(String correo, String contrasena, String nombre, String fecNac) { // Método para registrar un nuevo usuario
        // Cargar datos desde el archivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) { // Utilizar un ObjectInputStream para leer objetos desde el archivo
            usuariosContainer = (TablaUsuarios) ois.readObject(); // Leer el objeto TablaUsuarios desde el archivo y asignarlo a la variable usuariosContainer
        } catch (IOException | ClassNotFoundException e) { // Captura de excepciones de entrada/salida y de clase no encontrada
            e.printStackTrace(); // Imprimir la traza de la excepción
        }

        if (usuariosContainer.buscarUsuarioPorCorreo(correo) != null) { // Verificar si el correo electrónico ya está registrado
            System.out.println("El correo electrónico ya está registrado."); // Mensaje de error
            return false; // Devolver falso si el correo electrónico ya está registrado
        }

        // Generar un ID único para el nuevo usuario
        int nuevoId = generarNuevoId();

        // Crear un nuevo usuario
        Usuario nuevoUsuario = new Usuario(nuevoId, correo, contrasena, nombre, fecNac);

        // Agregar el nuevo usuario a la tabla de usuarios
        usuariosContainer.agregarUsuario(nuevoUsuario);
        System.out.println("Usuario registrado exitosamente."); // Mensaje de éxito

        // Guardar datos en el archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) { // Utilizar un ObjectOutputStream para escribir objetos en el archivo
            oos.writeObject(usuariosContainer); // Escribir el objeto TablaUsuarios en el archivo
        } catch (IOException e) { // Captura de excepción de entrada/salida
            e.printStackTrace(); // Imprimir la traza de la excepción
        }

        return true; // Devolver verdadero si el registro de usuario es exitoso
    }

    private int generarNuevoId() { // Método para generar un nuevo ID de usuario único
        // Generar un ID de usuario único de forma aleatoria (por ejemplo, entre 1000 y 9999)
        return 1000 + (int) (Math.random() * 9000);
    }
}

