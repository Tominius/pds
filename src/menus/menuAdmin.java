package menus;

import datosUsuarios.Datos;
import login.AbstractUserLog;
import login.AdminLog;
import login.ClienteLog;
import login.UsersFactory;
import pedidos.PedidoDeCompra;
import pedidos.PedidoFactory;
import vehiculos.AbstractVehiculo;
import vehiculos.VehiculoFactory;

import java.util.Scanner;

public class menuAdmin {

    // Lista Usuarios
    UsersFactory usersF = new UsersFactory();
    String rutaCSVUsuarios = "src/datosUsuarios/datos.csv";
    java.util.List<AbstractUserLog> usuarios = new java.util.ArrayList<>(usersF.cargarUsuariosDesdeCSV(rutaCSVUsuarios));

    // Lista Vehículos

    VehiculoFactory vehiculoFactory = new VehiculoFactory();
    String rutaCSV = "src/vehiculos/vehiculos.csv";
    java.util.List<AbstractVehiculo> vehiculos = new java.util.ArrayList<>(vehiculoFactory.cargarVehiculosDesdeCSV(rutaCSV));

    // Lista Pedidos

    PedidoFactory pedidoFactory = new PedidoFactory();
    String rutaCSVPedidos = "src/pedidos/pedidos.csv";
    java.util.List<PedidoDeCompra> pedidos = new java.util.ArrayList<>(pedidoFactory.cargarPedidosDesdeCSV(rutaCSVPedidos));



    AbstractUserLog instancia;

    public menuAdmin(AdminLog instancia) {
        this.instancia = instancia;
    }

    // Menu Administrador
    public static boolean esSiONo(String entrada) {
        String normalizada = entrada.toLowerCase().replace("í", "i");
        return normalizada.equals("si") || normalizada.equals("no");
    }

    public void mostrarMenu() {

        Scanner scannerApp = new Scanner(System.in);
        int opcion = -1;
        Datos datosVendedor = new Datos();

        if (instancia instanceof AdminLog) {

            while (opcion != 0) {
                // Aquí puedes mostrar el menú y leer la opción del usuario
                System.out.println();
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
                System.out.print("Ingrese una opción (0 para salir):");
                opcion = scannerApp.nextInt();
                System.out.println();
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
                    System.out.println();
                    ((AdminLog) instancia).agregarCliente(username, contraseña, dni, telefono, email);
                    // Agregar el cliente a la lista local
                    usuarios.add(usersF.devuelveClienteLog(username, contraseña, dni, telefono, email));
                } else if (opcion == 3) { //

                    for (AbstractUserLog user : usuarios) {
                        if (user instanceof ClienteLog) {
                            user.imprimirAtributos();
                        }
                    }
                    System.out.println();
                    System.out.print("Ingrese el username del cliente a eliminar: ");
                    String username = scannerApp.next();
                    ((AdminLog) instancia).eliminarCliente(username);
                    // Eliminar el cliente de la lista local
                    usuarios.removeIf(user -> user instanceof ClienteLog && ((ClienteLog) user).getUsername().equals(username));

                } else if (opcion == 4) {

                    final String VERDE = "\u001B[32m";
                    final String AMARILLO = "\u001B[33m";
                    final String RESET = "\u001B[0m";

                    System.out.println(VERDE + "=== Ingrese los datos del vehículo a cargar ===" + RESET);

                    String tipo = "";
                    while (true) {
                        System.out.print("Tipo (Auto/Moto/Camión/Camioneta): ");
                        tipo = scannerApp.next();
                        if (tipo.equalsIgnoreCase("Auto") || tipo.equalsIgnoreCase("Moto") ||
                                tipo.equalsIgnoreCase("Camion") || tipo.equalsIgnoreCase("Camión") ||
                                tipo.equalsIgnoreCase("Camioneta")) break;
                        System.out.println(AMARILLO + "Tipo no válido. Ingrese Auto, Moto, Camión o Camioneta." + RESET);
                    }

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

                    scannerApp.nextLine(); // Limpiar buffer
                    System.out.print("Características: ");
                    String caracteristicas = scannerApp.nextLine();

                    String disponible = "";
                    while (true) {
                        System.out.print("Disponible (Si/No): ");
                        disponible = scannerApp.next();
                        if (esSiONo(disponible)) break;
                        System.out.println(AMARILLO + "Respuesta no válida. Ingrese Si o No." + RESET);
                    }

                    String atributoEspecifico = "";

                    if (tipo.equalsIgnoreCase("Auto")) {
                        while (true) {
                            System.out.print("Tracción Delantera (Si/No): ");
                            atributoEspecifico = scannerApp.next();
                            if (esSiONo(atributoEspecifico)) break;
                            System.out.println(AMARILLO + "Respuesta no válida. Ingrese Si o No." + RESET);
                        }
                    } else if (tipo.equalsIgnoreCase("Moto")) {
                        while (true) {
                            System.out.print("Deportiva (Si/No): ");
                            atributoEspecifico = scannerApp.next();
                            if (esSiONo(atributoEspecifico)) break;
                            System.out.println(AMARILLO + "Respuesta no válida. Ingrese Si o No." + RESET);
                        }
                    } else if (tipo.equalsIgnoreCase("Camion") || tipo.equalsIgnoreCase("Camión")) {
                        while (true) {
                            System.out.print("Acoplado (Si/No): ");
                            atributoEspecifico = scannerApp.next();
                            if (esSiONo(atributoEspecifico)) break;
                            System.out.println(AMARILLO + "Respuesta no válida. Ingrese Si o No." + RESET);
                        }
                    } else if (tipo.equalsIgnoreCase("Camioneta")) {
                        while (true) {
                            System.out.print("4x4 (Si/No): ");
                            atributoEspecifico = scannerApp.next();
                            if (esSiONo(atributoEspecifico)) break;
                            System.out.println(AMARILLO + "Respuesta no válida. Ingrese Si o No." + RESET);
                        }
                    }

                    System.out.print("ID del vehículo: ");
                    String ID = scannerApp.next();

                    System.out.println(VERDE + "\n✓ Vehículo cargado correctamente." + RESET);

                    ((AdminLog) instancia).cargarVehiculo(tipo, marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, ID);
                    // Agregar el vehículo a la lista local
                    AbstractVehiculo nuevoVehiculo = vehiculoFactory.crearVehiculo(tipo, marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, ID);

                    if (nuevoVehiculo != null) {
                        vehiculos.add(nuevoVehiculo);
                        System.out.println("Vehículo agregado correctamente.");
                    } else {
                        System.out.println("Error al agregar el vehículo. Tipo no reconocido.");
                    }

                } else if (opcion == 5) {

                    for (AbstractVehiculo vehiculo : vehiculos) {
                        vehiculo.imprimirDatos();
                    }

                    System.out.print("Ingrese el ID del vehículo a eliminar: ");
                    String id = scannerApp.next();
                    ((AdminLog) instancia).eliminarVehiculo(id);
                    // Eliminar el vehículo de la lista local
                    vehiculos.removeIf(v -> v.getID().equals(id));

                } else if (opcion == 6) {

                    ((AdminLog) instancia).verVehiculos(vehiculos);

                } else if (opcion == 7) {

                    ((AdminLog) instancia).generarReporte(pedidos);

                } else if (opcion == 8) {

                    System.out.println("Ingrese los datos del nuevo pedido:");
                    System.out.print("ID del pedido: ");
                    int idPedido = scannerApp.nextInt();
                    scannerApp.nextLine(); // Limpiar el buffer antes de leer la línea completa
                    System.out.print("Nombre del concesionario: ");
                    String nombreConcesionario = scannerApp.nextLine();
                    System.out.print("CUIT del consecionario: ");
                    String cuitConcesionario = scannerApp.nextLine();
                    System.out.print("Fecha: ");
                    String fecha = scannerApp.nextLine();
                    System.out.println("A contunuacion ingrese los datos de facturacion");
                    ((AdminLog) instancia).verClientes();
                    System.out.print("ID Cliente: ");
                    String idCliente = scannerApp.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scannerApp.nextLine();
                    System.out.print("Cuil-Cuit: ");
                    String cuilCuit = scannerApp.nextLine();
                    System.out.print("Costo Total: ");
                    String costoTotal = scannerApp.nextLine();
                    System.out.print("Forma de Pago(Transferencia/Contado/Tarjeta): ");
                    String formaPago = scannerApp.nextLine();
                    System.out.println("Seleccione un vehiculo: ");
                    ((AdminLog) instancia).verVehiculos(vehiculos);
                    System.out.print("ID del vehículo: ");
                    String idVehiculo = String.valueOf(scannerApp.nextInt());
                    datosVendedor.imprimirTodosLosVendedores();
                    System.out.println("Seleccione un vendedor (ID): ");
                    String idVendedor = scannerApp.next();
                    ((AdminLog) instancia).agregarPedido(idVehiculo, String.valueOf(idPedido), nombreConcesionario, cuitConcesionario, fecha, idCliente, direccion, cuilCuit, costoTotal, formaPago, idVendedor);
                    PedidoFactory pedidoFactory = new PedidoFactory();
                    pedidos.add(pedidoFactory.crearPedido(String.valueOf(idPedido), idVehiculo , idVendedor)); // Asignar un pedido de ejemplo

                } else if (opcion == 9) {
                    System.out.println("Pedidos disponibles:");
                    for (PedidoDeCompra pedido : pedidos) {
                        System.out.println("ID del Pedido: " + pedido.getIdPedido() + " | Fecha: " + pedido.getFecha() + " | Estado: " + pedido.getEstado());
                    }

                    System.out.print("Ingrese el ID del pedido a ver: ");
                    int id = scannerApp.nextInt();
                    ((AdminLog) instancia).verPedido(pedidos, String.valueOf(id));

                } else {

                    System.out.println("Opción no válida. Por favor, intente de nuevo.");

                }
            }
            scannerApp.close();
        }
    }
}
