import login.*;
import menus.menuAdmin;
import menus.menuCliente;
import menus.menuVendedor;
import pedidos.PedidoDeCompra;
import pedidos.PedidoFactory;
import vehiculos.AbstractVehiculo;
import vehiculos.VehiculoFactory;

public class App {
    public static void main(String[] args) throws Exception {




        System.out.println("Bienvenido al sistema de gestión de Consesionaria");
        System.out.println("Por favor, inicie sesión.");

        // Logearse y crear una instancia de AbstractUserLog

        Login login = new Login();
        AbstractUserLog instancia = login.loginYCrearInstancia();

        if (instancia instanceof AdminLog) {
            // Si la instancia es de tipo AdminLog, mostrar el menú de administrador
            menuAdmin menu = new menuAdmin((AdminLog) instancia);
            menu.mostrarMenu();
        } else if (instancia instanceof login.ClienteLog) {
            // Si la instancia es de tipo ClienteLog, mostrar el menú de cliente
            menuCliente menu = new menuCliente((login.ClienteLog) instancia);
            menu.mostrarMenu();
        } else if (instancia instanceof VendedorLog) {
            // Si la instancia es de tipo VendedorLog, mostrar el menú de vendedor
            menuVendedor menu = new menuVendedor((VendedorLog) instancia);
            menu.mostrarMenu();

        } else {
            // Si la instancia es de otro tipo, manejarlo según sea necesario
            System.out.println("Tipo de usuario no reconocido.");
        }


    } 
}