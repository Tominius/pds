import java.util.List;

import login.AbstractUserLog;
import login.Login;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Crear una instancia de la clase Datos
        datosUsuarios.Datos datos = new datosUsuarios.Datos();

        // Insertar un cliente
        datos.insertarCliente("cliente1", "contrasena1", "12345678A", "123456789", "t@uade.com");
        // Insertar un administrador
        datos.insertarAdministrador("admin1", "contrasenaAdmin");
        // Eliminar un usuario
        datos.eliminarUser("cliente1");

        // Ver datos de un usuario
        List<String> datosUsuario = datos.leerDatos("admin1");
        if (datosUsuario != null) {
            System.out.println("Datos del usuario:");
            for (String dato : datosUsuario) {
                System.out.println(dato);
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
        
        Login login = new Login();
        AbstractUserLog instancia = login.loginYCrearInstancia();

        instancia.imprimirAtributos();
    }

}
