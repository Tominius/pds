import java.util.Scanner;

import login.AbstractUserLog;
import login.AdminLog;
import login.Login;
import menus.menuAdmin;

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
        } else {
            // Si la instancia es de otro tipo, manejarlo según sea necesario
            System.out.println("Tipo de usuario no reconocido.");
        }


    } 
}