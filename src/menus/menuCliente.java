package menus;

import datosUsuarios.Datos;
import login.AbstractUserLog;
import login.AdminLog;
import login.ClienteLog;
import pedidos.PedidoDeCompra;
import pedidos.PedidoFactory;
import vehiculos.AbstractVehiculo;
import vehiculos.VehiculoFactory;

import java.util.Scanner;

public class menuCliente {

    // Lista Vehículos

    VehiculoFactory vehiculoFactory = new VehiculoFactory();
    String rutaCSV = "src/vehiculos/vehiculos.csv";
    java.util.List<AbstractVehiculo> vehiculos = new java.util.ArrayList<>(vehiculoFactory.cargarVehiculosDesdeCSV(rutaCSV));

    // Lista Pedidos

    PedidoFactory pedidoFactory = new PedidoFactory();
    String rutaCSVPedidos = "src/pedidos/pedidos.csv";
    java.util.List<PedidoDeCompra> pedidos = new java.util.ArrayList<>(pedidoFactory.cargarPedidosDesdeCSV(rutaCSVPedidos));

    AbstractUserLog instancia;

    public menuCliente(ClienteLog instancia) {
        this.instancia = instancia;
    }

    // Menu Cliente

    public void mostrarMenu() {

        Scanner scannerApp = new Scanner(System.in);
        int opcion = -1;

        if (instancia instanceof ClienteLog) {

            while (opcion != 0) {
                // Aquí puedes mostrar el menú y leer la opción del usuario
                System.out.println();
                System.out.println("Menú de opciones:");
                System.out.println("1. Ver vehículos disponibles");
                System.out.println("2. Ver estado de Compra");
                System.out.println();
                System.out.print("Ingrese una opción (0 para salir):");

                opcion = scannerApp.nextInt();
                System.out.println();
                if (opcion == 1){
                    ((ClienteLog) instancia).verVehiculosDisponibles(vehiculos);
                }
                if (opcion == 2){
                    ((ClienteLog) instancia).verEstadoCompra(pedidos);
                }

            }
        }
    }
}
