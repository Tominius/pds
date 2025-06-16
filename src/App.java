import java.util.Scanner;

import login.AbstractUserLog;
import login.AdminLog;
import login.Login;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Bienvenido al sistema de gestión de Consesionaria");
        System.out.println("Por favor, inicie sesión.");

        // Logearse y crear una instancia de AbstractUserLog

        Login login = new Login();
        AbstractUserLog instancia = login.loginYCrearInstancia();

        // Menu Administrador

        Scanner scannerApp = new Scanner(System.in);
        int opcion = -1;

        if (instancia instanceof AdminLog) {

            while (opcion != 0) {
                // Aquí puedes mostrar el menú y leer la opción del usuario
                System.out.println("Menú de opciones:");
                System.out.println("1. Ver clientes");
                System.out.println("2. Agregar cliente");
                System.out.println("3. Eliminar cliente");
                System.out.println("4. Cargar vehículo");
                System.out.println("5. Eliminar vehículo");
                System.out.println("6. Ver vehículos");
                System.out.println("7. Generar reporte");
                System.out.println("8. Agregar pedido");
                System.out.println("9. Ver pedido");
                System.out.println();
                System.out.println("Ingrese una opción (0 para salir):");
                opcion = scannerApp.nextInt();
                // Procesar la opción aquí
                if (opcion == 0) {
                    System.out.println("Saliendo del sistema...");
                    break;
                } else if (opcion == 1) {
                    ((AdminLog) instancia).verClientes();
                } else if (opcion == 2) { //
                    System.out.println("Ingrese los datos del nuevo cliente:");
                    System.out.print("Username: ");
                    String username = scannerApp.next();
                    System.out.print("Contraseña: ");
                    String contraseña = scannerApp.next();
                    System.out.print("DNI: ");
                    String dni = scannerApp.next();
                    System.out.print("Teléfono: ");
                    String telefono = scannerApp.next();
                    System.out.print("Email: ");
                    String email = scannerApp.next();
                    ((AdminLog) instancia).agregarCliente(username, contraseña, dni, telefono, email);
                } else if (opcion == 3) { //
                    System.out.print("Ingrese el username del cliente a eliminar: ");
                    String username = scannerApp.next();
                    ((AdminLog) instancia).eliminarCliente(username);
                } else if (opcion == 4) {
                    System.out.println("Ingrese los datos del vehículo a cargar:");
                    System.out.print("Tipo (Auto/Moto/Camión/Camioneta): ");
                    String tipo = scannerApp.next();
                    System.out.print("Marca: ");
                    String marca = scannerApp.next();
                    System.out.print("Modelo: ");
                    String modelo = scannerApp.next();
                    System.out.print("Color: ");
                    String color = scannerApp.next();
                    System.out.print("Equipamiento Adicional: ");
                    String equipAdicional = scannerApp.next();
                    System.out.print("Número de Chasis: ");
                    String chasis = scannerApp.next();
                    System.out.print("Número de Motor: ");
                    String motor = scannerApp.next();
                    scannerApp.nextLine(); // Limpiar el buffer antes de leer la línea completa
                    System.out.print("Características: ");
                    String caracteristicas = scannerApp.nextLine();
                    System.out.print("Disponible (Sí/No): ");
                    String disponible = scannerApp.next();
                    if (tipo.equalsIgnoreCase("Auto")) {
                        System.out.print("Tracción Delantera (Sí/No): ");
                    } else if (tipo.equalsIgnoreCase("Moto")) {
                        System.out.print("Deportiva (Sí/No): ");
                    } else if (tipo.equalsIgnoreCase("Camion")) {
                        System.out.print("Acoplado (Sí/No): ");
                    } else if (tipo.equalsIgnoreCase("Camioneta")) {
                        System.out.print("4x4 (Sí/No): ");
                    }
                    String atributoEspecifico = scannerApp.next();
                    System.out.print("ID del vehículo: ");
                    String ID = scannerApp.next();
                    ((AdminLog) instancia).cargarVehiculo(tipo, marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, ID);
                } else if (opcion == 5) {
                    System.out.print("Ingrese el ID del vehículo a eliminar: ");
                    String id = scannerApp.next();
                    ((AdminLog) instancia).eliminarVehiculo(id);
                } else if (opcion == 6) {
                    ((AdminLog) instancia).verVehiculos();
                } else if (opcion == 7) {
                    ((AdminLog) instancia).generarReporte();
                } else if (opcion == 8) {
                    ((AdminLog) instancia).agregarPedido();
                } else if (opcion == 9) {
                    System.out.print("Ingrese el ID del pedido a ver: ");
                    int id = scannerApp.nextInt();
                    ((AdminLog) instancia).verPedido(id);
                } else {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            }

            scannerApp.close();
        }   
    } 
}