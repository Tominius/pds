import java.util.Scanner;

import login.AbstractUserLog;
import login.AdminLog;
import login.Login;
import menus.menuAdmin;
import vehiculos.AbstractVehiculo;

public class App {
    public static void main(String[] args) throws Exception {

        // Lista Usuarios
        UsersFactory usersF = new UsersFactory();
        String rutaCSVUsuarios = "src/datosUsuarios/datos.csv";
        AbstractUserLog[] usuarios =  usersF.cargarUsuariosDesdeCSV(rutaCSVUsuarios).toArray(new AbstractUserLog[0]);

        // Lista Vehículos

        VehiculoFactory vehiculoFactory = new VehiculoFactory();
        String rutaCSV = "src/vehiculos/vehiculos.csv";
        AbstractVehiculo[] vehiculos = vehiculoFactory.cargarVehiculosDesdeCSV(rutaCSV).toArray(new AbstractVehiculo[0]);

        // Lista Pedidos







        System.out.println("Bienvenido al sistema de gestión de Consesionaria");
        System.out.println("Por favor, inicie sesión.");

        // Logearse y crear una instancia de AbstractUserLog

        Login login = new Login();
        AbstractUserLog instancia = login.loginYCrearInstancia();

        if (instancia instanceof AdminLog) {
            // Si la instancia es de tipo AdminLog, mostrar el menú de administrador
            menuAdmin menu = new menuAdmin((AdminLog) instancia);
            menu.mostrarMenu();
        } else {
            // Si la instancia es de otro tipo, manejarlo según sea necesario
            System.out.println("Tipo de usuario no reconocido.");
        }


    } 
}