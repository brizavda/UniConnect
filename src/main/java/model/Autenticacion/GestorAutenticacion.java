package model.Autenticacion;
import controller.ControladorAutenticacion;
import controller.ControladorPrincipal;
import model.Perfil.TablaUsuarios;
import model.Perfil.Usuario;

import static java.lang.System.exit;

public class GestorAutenticacion {
    private TablaUsuarios tablaUsuarios;

    public GestorAutenticacion(TablaUsuarios tablaUsuarios) {
        this.tablaUsuarios = tablaUsuarios;
    }

    public void getMessage(int opcion) {
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

    public void logIn(String correo, String contraseña) {

    }

    public void newUser(String correo, String contraseña, String nombre, String fechaNacimiento) {
        // Generar ID de usuario de forma aleatoria
        int idUsuario = generarIdUsuarioAleatorio();

        // Crear un nuevo usuario con los datos proporcionados y el ID generado
        Usuario nuevoUsuario = new Usuario(idUsuario, correo, contraseña, nombre, fechaNacimiento);

        // Agregar el nuevo usuario a la tabla de usuarios
        tablaUsuarios.agregarUsuario(nuevoUsuario);

        // Mostrar mensaje de éxito
        System.out.println("Usuario registrado con éxito:");
        System.out.println(nuevoUsuario.toString());
    }

    private int generarIdUsuarioAleatorio() {
        // Generar un ID de usuario único de forma aleatoria (por ejemplo, entre 1000 y 9999)
        return 1000 + (int) (Math.random() * 9000);
    }
}
