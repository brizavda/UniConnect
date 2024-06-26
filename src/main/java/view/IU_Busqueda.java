package view;

import controller.ControladorBusqueda;
import model.Perfil.Usuario;
import model.Publicaciones.Publicacion;
import java.util.List;
import java.util.Scanner;

public class IU_Busqueda {
   // Instancia del ControladorBusqueda para realizar las búsquedas
   private ControladorBusqueda controladorBusqueda;
   // Escáner para leer la entrada del usuario
   private Scanner scanner;

   // Constructor que recibe una instancia de ControladorBusqueda
   public IU_Busqueda(ControladorBusqueda controladorBusqueda) {
       this.controladorBusqueda = controladorBusqueda;
       this.scanner = new Scanner(System.in);
   }
// Método que muestra el menú de búsqueda y maneja las opciones
   public void menuBusqueda() {
       boolean salir = false;
       while (!salir) {
           System.out.println("---- Menú de Búsqueda ----");
           System.out.println("1. Buscar Usuario por ID");
           System.out.println("2. Buscar Usuario por Correo");
           System.out.println("3. Buscar Publicaciones por Contenido y Autor");
           System.out.println("4. Regresar");
           System.out.print("Ingrese su elección: ");
           int opcion = scanner.nextInt();
           scanner.nextLine(); // Consume el salto de línea

           switch (opcion) {
               case 1:
                   buscarUsuarioPorId();
                   break;
               case 2:
                   buscarUsuarioPorCorreo();
                   break;
                    case 3:
                   buscarPublicaciones();
                   break;
               case 4:
                   salir = true;
                   break;
               default:
                   System.out.println("Opción inválida. Intenta de nuevo.");
           }
       }
   }

   // Método que busca usuarios por su ID
   private void buscarUsuarioPorId() {
       System.out.println("---- Buscar Usuario por ID ----");
       System.out.print("Ingrese el ID del usuario: ");
       int idUsuario = scanner.nextInt();
       scanner.nextLine(); // Consume el salto de línea
List<Usuario> usuariosEncontrados = controladorBusqueda.buscarUsuarioPorId(idUsuario);
       if (usuariosEncontrados.isEmpty()) {
           System.out.println("No se encontró el usuario con el ID especificado.");
       } else {
           System.out.println("Usuarios encontrados:");
           for (Usuario usuario : usuariosEncontrados) {
               System.out.println(usuario);
           }
       }
   }

   // Método que busca usuarios por su correo electrónico
   private void buscarUsuarioPorCorreo() {
       System.out.println("---- Buscar Usuario por Correo ----");
       System.out.print("Ingrese el correo del usuario: ");
       String correo = scanner.nextLine();
        List<Usuario> usuariosEncontrados = controladorBusqueda.buscarUsuarioPorCorreo(correo);
       if (usuariosEncontrados.isEmpty()) {
           System.out.println("No se encontró el usuario con el correo especificado.");
       } else {
           System.out.println("Usuarios encontrados:");
           for (Usuario usuario : usuariosEncontrados) {
               System.out.println(usuario);
           }
       }
   }
    
   // Método que busca publicaciones por su contenido y el autor
   private void buscarPublicaciones() {
       System.out.println("---- Buscar Publicaciones ----");
       System.out.print("Ingrese el contenido: ");
       String contenido = scanner.nextLine();
       System.out.print("Ingrese el ID del autor: ");
       int idAutor = scanner.nextInt();
       scanner.nextLine(); // Consume el salto de línea
     List<Publicacion> publicacionesEncontradas = controladorBusqueda.buscarPublicaciones(contenido, idAutor);
       if (publicacionesEncontradas == null || publicacionesEncontradas.isEmpty()) {
           System.out.println("No se encontraron publicaciones con los criterios especificados.");
       } else {
           System.out.println("Publicaciones encontradas:");
           for (Publicacion publicacion : publicacionesEncontradas) {
               System.out.println(publicacion);
           }
       }
   }
}
