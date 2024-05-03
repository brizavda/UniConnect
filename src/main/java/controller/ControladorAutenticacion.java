package controller; // Definición del paquete donde se encuentra la clase

import model.Autenticacion.GestorAutenticacion; // Importación de la clase GestorAutenticacion del paquete model.Autenticacion
import model.Perfil.TablaUsuarios; // Importación de la clase TablaUsuarios del paquete model.Perfil
import view.IU_Autenticacion; // Importación de la clase IU_Autenticacion del paquete view
import view.IU_Principal; // Importación de la clase IU_Principal del paquete view

public class ControladorAutenticacion { // Definición de la clase ControladorAutenticacion
    GestorAutenticacion gestorAutenticacion = new GestorAutenticacion(); // Crear una instancia de GestorAutenticacion

    public void sendOptionMessage(int opcion) { // Método para enviar un mensaje de opción
        gestorAutenticacion.getOption(opcion); // Enviar la opción al gestor de autenticación
    }

    public void sendOptionMenu(int opcion) {
        gestorAutenticacion.getViews(opcion);
    }

    public void getLogIn() { // Método para obtener el inicio de sesión
        IU_Autenticacion autenticacion = new IU_Autenticacion(); // Crear una instancia de IU_Autenticacion
        autenticacion.inicioSesion(); // Iniciar sesión
    }

    public void getRegistro() { // Método para obtener el registro
        IU_Autenticacion autenticacion = new IU_Autenticacion(); // Crear una instancia de IU_Autenticacion
        autenticacion.registrarse(); // Registrarse
    }

    public void sendLoginData(String correo, String contrasena) { // Método para enviar los datos de inicio de sesión
        boolean correcto = gestorAutenticacion.logIn(correo, contrasena); // Verificar los datos de inicio de sesión

        if (correcto) { // Si los datos son correctos
            getMenu(); // Obtener el menú principal
        } else { // Si los datos son incorrectos
            getInit(); // Obtener el mensaje de inicialización
        }
    }

    public void sendNewData(String correo, String contrasena, String nombre, String fechaNacimiento) { // Método para enviar los nuevos datos
        boolean correcto = gestorAutenticacion.newUser(correo, contrasena, nombre, fechaNacimiento); // Verificar los nuevos datos

        if (correcto) { // Si los datos son correctos
            getLogIn(); // Obtener el inicio de sesión
        } else { // Si los datos son incorrectos
            System.out.println("Registro sin éxito. Intenta de nuevo"); // Imprimir un mensaje de error
            getInit(); // Obtener el mensaje de inicialización
        }
    }

    public void getMenu() { // Método para obtener el menú principal
        IU_Principal principal = new IU_Principal(); // Crear una instancia de IU_Principal
        principal.menu(); // Mostrar el menú principal
    }

    public void getInit() { // Método para obtener el mensaje de inicialización
        IU_Principal principal = new IU_Principal(); // Crear una instancia de IU_Principal
        principal.inicializar(); // Inicializar la interfaz de usuario principal
    }
}


