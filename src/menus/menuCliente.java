package menus;

import datosUsuarios.Datos;
import login.AbstractUserLog;
import login.AdminLog;
import login.ClienteLog;
import pedidos.DatosGeneral;
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
    String rutaCSV = "C:\\Users\\54116\\Documents\\Facultad\\PDS\\TPO\\VersionFinal\\pds\\src\\vehiculos\\vehiculos.csv";
    java.util.List<AbstractVehiculo> vehiculos = new java.util.ArrayList<>(vehiculoFactory.cargarVehiculosDesdeCSV(rutaCSV));

    // Lista Pedidos

    PedidoFactory pedidoFactory = new PedidoFactory();
    String rutaCSVPedidos = "C:\\Users\\54116\\Documents\\Facultad\\PDS\\TPO\\VersionFinal\\pds\\src\\pedidos\\pedidos.csv";
    java.util.List<PedidoDeCompra> pedidos = new java.util.ArrayList<>(pedidoFactory.cargarPedidosDesdeCSV(rutaCSVPedidos));

    AbstractUserLog instancia;
    String idCliente;

    public menuCliente(ClienteLog instancia, String idCliente) {
        this.instancia = instancia;
        this.idCliente = idCliente;
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
                    DatosGeneral datosGeneral = new DatosGeneral();
                    while (true) {
                        try {
                            System.out.print("ID del pedido: ");
                            idPedido = scannerApp.nextInt();
                            scannerApp.nextLine(); // Limpiar buffer

                            if (datosGeneral.existePedido(String.valueOf(idPedido))) {
                                System.out.println(ROJO + "⚠ El ID de pedido ya existe. Ingrese uno diferente." + RESET);
                                continue;
                            }
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
                    ((ClienteLog) instancia).verClientes(((ClienteLog) instancia).getIdCliente());
                    System.out.print("ID Cliente: ");
                    String idCliente = scannerApp.nextLine();

                    while (datosVendedor.usuarioExistePorIdYTipo(idCliente, "cliente") == false) {
                        System.out.println(ROJO + "⚠ ID de cliente no válido. Por favor, ingrese un ID de cliente existente." + RESET);
                        System.out.print("ID Cliente: ");
                        idCliente = scannerApp.nextLine();
                    }


                    System.out.print("Dirección: ");
                    String direccion = scannerApp.nextLine();

                    System.out.print("CUIL/CUIT: ");
                    String cuilCuit = scannerApp.nextLine();

                    String formaPago1 = "";
                    while (true) {
                        System.out.print("Forma de Pago (Transferencia/Contado/Tarjeta): ");
                        formaPago1 = scannerApp.nextLine().trim().toLowerCase();
                        if (formaPago1.equals("transferencia") || formaPago1.equals("contado") || formaPago1.equals("tarjeta")) {
                            // Capitalizar la primera letra para mantener formato
                            formaPago1 = formaPago1.substring(0, 1).toUpperCase() + formaPago1.substring(1);
                            break;
                        } else {
                            System.out.println("Forma de pago no válida. Ingrese Transferencia, Contado o Tarjeta.");
                        }
                    }

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
                    scannerApp.nextLine(); // Limpiar buffer

                    while (datosVendedor.usuarioExistePorIdYTipo(idVendedor, "vendedor") == false) {
                        System.out.println(ROJO + "⚠ ID de vendedor no válido. Por favor, ingrese un ID de vendedor existente." + RESET);
                        System.out.print("ID Vendedor: ");
                        idVendedor = scannerApp.nextLine();
                    }

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
                            formaPago1,
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
