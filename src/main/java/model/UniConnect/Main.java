package model.UniConnect; // Definición del paquete donde se encuentra la clase

import model.Perfil.TablaUsuarios; // Importación de la clase TablaUsuarios del paquete model.Perfil
import model.Perfil.Usuario; // Importación de la clase Usuario del paquete model.Perfil
import view.IU_Principal; // Importación de la clase IU_Principal del paquete view

import java.io.*; // Importación de clases para operaciones de entrada/salida

public class Main { // Definición de la clase Main
    public static void main(String[] args) { // Método principal main
        TablaUsuarios usuariosContainer; // Declaración de una variable para contener la tabla de usuarios

        // Verificar si el archivo usuarios.dat existe
        File archivo = new File("usuarios.dat"); // Creación de un objeto File para representar el archivo usuarios.dat en el sistema de archivos
        if (archivo.exists()) { // Comprobar si el archivo existe
            // Cargar datos desde el archivo
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) { // Utilizar un ObjectInputStream para leer objetos desde el archivo
                System.out.println("Obteniendo usuarios de ejemplo..."); // Mensaje de estado
                usuariosContainer = (TablaUsuarios) ois.readObject(); // Leer el objeto TablaUsuarios desde el archivo y asignarlo a la variable usuariosContainer
            } catch (IOException | ClassNotFoundException e) { // Captura de excepciones de entrada/salida y de clase no encontrada
                e.printStackTrace(); // Imprimir la traza de la excepción
                return; // Salir del método main en caso de error
            }
        } else { // Si el archivo no existe
            // Si el archivo no existe, crear y almacenar ejemplos de usuarios
            System.out.println("Creando usuarios de ejemplo..."); // Mensaje de estado
            usuariosContainer = new TablaUsuarios(); // Crear una nueva instancia de TablaUsuarios
            Usuario usuario1 = new Usuario(1, "correo1@example.com", "contraseña1", "Nombre1", "01/01/1990"); // Crear usuarios de ejemplo
            Usuario usuario2 = new Usuario(2, "correo2@example.com", "contraseña2", "Nombre2", "02/02/1991");
            Usuario usuario3 = new Usuario(3, "correo3@example.com", "contraseña3", "Nombre3", "03/03/1992");
            Usuario usuario4 = new Usuario(4, "correo4@example.com", "contraseña4", "Nombre4", "04/04/1993");
            Usuario usuario5 = new Usuario(5, "correo5@example.com", "contraseña5", "Nombre5", "05/05/1994");

            usuariosContainer.agregarUsuario(usuario1); // Agregar usuarios a la tabla de usuarios
            usuariosContainer.agregarUsuario(usuario2);
            usuariosContainer.agregarUsuario(usuario3);
            usuariosContainer.agregarUsuario(usuario4);
            usuariosContainer.agregarUsuario(usuario5);

            // Guardar datos en el archivo
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) { // Utilizar un ObjectOutputStream para escribir objetos en el archivo
                oos.writeObject(usuariosContainer); // Escribir la tabla de usuarios en el archivo
            } catch (IOException e) { // Captura de excepciones de entrada/salida
                e.printStackTrace(); // Imprimir la traza de la excepción
                return; // Salir del método main en caso de error
            }
        }

        IU_Principal principal = new IU_Principal(); // Crear una instancia de IU_Principal
        principal.inicializar(); // Inicializar la interfaz de usuario

        //usuariosContainer.buscarUsuarioPorCorreo("correo1@example.com");
        //usuariosContainer.buscarUsuarioPorId(5);
    }
}
