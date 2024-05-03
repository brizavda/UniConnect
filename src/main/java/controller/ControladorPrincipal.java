package controller; // Definición del paquete donde se encuentra la clase

import view.IU_Autenticacion; // Importación de la clase IU_Autenticacion del paquete view
import view.IU_Principal; // Importación de la clase IU_Principal del paquete view

public class ControladorPrincipal { // Definición de la clase ControladorPrincipal
    IU_Autenticacion autenticacion = new IU_Autenticacion(); // Crear una instancia de IU_Autenticacion

    public void sendInitMessage(int opcion) { // Método para enviar un mensaje de inicialización
        autenticacion.getInitMessage(opcion); // Enviar la opción al mensaje de inicialización de IU_Autenticacion
    }

    public void getInit() { // Método para obtener el mensaje de inicialización
        IU_Principal principal = new IU_Principal(); // Crear una instancia de IU_Principal
        principal.inicializar(); // Inicializar la interfaz de usuario principal
    }

    public void sendMenuMessage(int opcion) { // Método para enviar un mensaje de menú
        // Este método no está implementado en este momento
    }
}

