package menus;

import datosUsuarios.Datos;
import login.AbstractUserLog;
import login.AdminLog;
import login.ClienteLog;
import pedidos.PedidoDeCompra;
import pedidos.PedidoFactory;
import vehiculos.AbstractVehiculo;
import vehiculos.VehiculoFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class menuCliente {

    public static AbstractVehiculo buscarVehiculoPorID(String id, List<AbstractVehiculo> lista) {
        for (AbstractVehiculo v : lista) {
            if (v.getID().equals(id)) {
                return v;
            }
        }
        return null;
    }
    Datos datosVendedor = new Datos();

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
                System.out.println("3. Crear pedido de compra");
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
                if (opcion == 3){
                    final String AZUL = "\u001B[34m";
                    final String VERDE = "\u001B[32m";
                    final String ROJO = "\u001B[31m";
                    final String RESET = "\u001B[0m";


                    System.out.println(AZUL + "\n=== Ingrese los datos del nuevo pedido ===" + RESET);

                    // ID del pedido
                    int idPedido = -1;
                    while (true) {
                        try {
                            System.out.print("ID del pedido: ");
                            idPedido = scannerApp.nextInt();
                            scannerApp.nextLine(); // Limpiar buffer
                            break;
                        } catch (Exception e) {
                            System.out.println(ROJO + "⚠ Ingrese un número entero válido." + RESET);
                            scannerApp.nextLine(); // Limpiar entrada inválida
                        }
                    }

                    // Concesionario
                    System.out.print("Nombre del concesionario: ");
                    String nombreConcesionario = scannerApp.nextLine();

                    System.out.print("CUIT del concesionario: ");
                    String cuitConcesionario = scannerApp.nextLine();



                    // Validar fecha
                    String fechaFiltro = null;
                    String estadoFiltro = null;
                    Date fecha = null;

                    while (true) {
                        System.out.print("Ingrese la fecha (dd/mm/yyyy) o presione Enter para omitir: ");
                        String inputFecha = scannerApp.nextLine().trim();

                        if (inputFecha.isEmpty()) {
                            break;
                        }

                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            sdf.setLenient(false); // No permite fechas inválidas como 32/01/2024
                            fecha = sdf.parse(inputFecha);
                            fechaFiltro = inputFecha;
                            break;
                        } catch (ParseException e) {
                            System.out.println(ROJO + "⚠ Fecha inválida. Asegúrese de usar el formato dd/mm/yyyy." + RESET);
                        }
                    }


                    System.out.println(AZUL + "\n=== Ingrese los datos de facturación ===" + RESET);

                    // Ver clientes y seleccionar uno
                    ((ClienteLog) instancia).verClientes();
                    System.out.print("ID Cliente: ");
                    String idCliente = scannerApp.nextLine();

                    System.out.print("Dirección: ");
                    String direccion = scannerApp.nextLine();

                    System.out.print("CUIL/CUIT: ");
                    String cuilCuit = scannerApp.nextLine();

                    System.out.print("Forma de Pago (Transferencia/Contado/Tarjeta): ");
                    String formaPago = scannerApp.nextLine();

                    System.out.println(AZUL + "\n=== Seleccione un vehículo ===" + RESET);
                    ((ClienteLog) instancia).verVehiculosDisponibles(vehiculos);

                    String idVehiculo;
                    AbstractVehiculo vehiculoSeleccionado = null;
                    while (true) {
                        System.out.print("ID del vehículo: ");
                        idVehiculo = scannerApp.next();
                        vehiculoSeleccionado = buscarVehiculoPorID(idVehiculo, vehiculos);
                        if (vehiculoSeleccionado != null) break;
                        System.out.println(ROJO + "⚠ Vehículo no encontrado. Intente nuevamente." + RESET);
                    }

                    // Costo total
                    double costoTotal = 0;
                    while (true) {
                        try {
                            System.out.print("Costo Total: ");
                            String costoStr = scannerApp.next();
                            costoTotal = Double.parseDouble(costoStr);

                            if (costoTotal < vehiculoSeleccionado.getPrecioVehiculo()) {
                                System.out.println(ROJO + "⚠ El costo total no puede ser menor al valor del vehículo: $" + vehiculoSeleccionado.getPrecioVehiculo() + RESET);
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(ROJO + "⚠ Ingrese un valor numérico válido para el costo total." + RESET);
                        }
                    }

                    // Seleccionar vendedor
                    System.out.println(AZUL + "\n=== Seleccione un vendedor ===" + RESET);
                    datosVendedor.imprimirTodosLosVendedores();
                    System.out.print("ID del vendedor: ");
                    String idVendedor = scannerApp.next();

                    // Agregar el pedido
                    ((ClienteLog) instancia).agregarPedido(
                            idVehiculo,
                            String.valueOf(idPedido),
                            nombreConcesionario,
                            cuitConcesionario,
                            fecha.toString(),
                            idCliente,
                            direccion,
                            cuilCuit,
                            String.valueOf(costoTotal),
                            formaPago,
                            idVendedor
                    );

                    // Crear y guardar pedido
                    PedidoFactory pedidoFactory = new PedidoFactory();
                    pedidos.add(pedidoFactory.crearPedido(String.valueOf(idPedido), idVehiculo, idVendedor));

                    System.out.println(VERDE + "\n✓ Pedido agregado exitosamente." + RESET);

                }

            }
        }
    }
}
