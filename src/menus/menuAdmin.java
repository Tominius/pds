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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class menuAdmin {

    public static AbstractVehiculo buscarVehiculoPorID(String id, List<AbstractVehiculo> lista) {
        for (AbstractVehiculo v : lista) {
            if (v.getID().equals(id)) {
                return v;
            }
        }
        return null;
    }


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
            System.out.println("7. Filtrar reportes");
            System.out.println("8. Agregar pedido");
            System.out.println("9. Ver pedido");
            System.out.println();
            System.out.print("Ingrese una opción (0 para salir):");

            // Validar que la opción sea un int
            while (!scannerApp.hasNextInt()) {
                System.out.println("Opción no válida. Por favor, ingrese un número.");
                System.out.print("Ingrese una opción (0 para salir):");
                scannerApp.next(); // Limpiar entrada inválida
            }
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

                String dni;
                while (true) {
                    System.out.print("DNI: ");
                    dni = scannerApp.next();
                    if (dni.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("El DNI solo debe contener números. Intente nuevamente.");
                    }
                }

                String telefono;
                while (true) {
                    System.out.print("Teléfono: ");
                    telefono = scannerApp.next();
                    if (telefono.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("El teléfono solo debe contener números. Intente nuevamente.");
                    }
                }

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

                String marca;
                while (true) {
                System.out.print("Marca: ");
                if (scannerApp.hasNext("[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+")) {
                    marca = scannerApp.next();
                    break;
                } else {
                    System.out.println(AMARILLO + "Marca no válida. vuelva a ingresar." + RESET);
                    scannerApp.next(); // Limpiar entrada inválida
                }
                }

                String modelo;
                while (true) {
                System.out.print("Modelo: ");
                if (scannerApp.hasNext("[A-Za-z0-9\\-\\s]+")) {
                    modelo = scannerApp.next();
                    break;
                } else {
                    System.out.println(AMARILLO + "Modelo no válido. vuelva a ingresar." + RESET);
                    scannerApp.next(); // Limpiar entrada inválida
                }
                }

                String color;
                while (true) {
                System.out.print("Color: ");
                if (scannerApp.hasNext("[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+")) {
                    color = scannerApp.next();
                    break;
                } else {
                    System.out.println(AMARILLO + "Color no válido. vuelva a ingresar." + RESET);
                    scannerApp.next(); // Limpiar entrada inválida
                }
                }

                String equipAdicional = "";
                while (true) {
                System.out.print("Equipamiento Adicional (Si/No): ");
                equipAdicional = scannerApp.next();
                if (esSiONo(equipAdicional)) break;
                System.out.println(AMARILLO + "Respuesta no válida. Ingrese Si o No." + RESET);
                }

                String chasis;
                while (true) {
                System.out.print("Número de Chasis: ");
                chasis = scannerApp.next();
                if (chasis.matches("\\d+")) {
                    break;
                } else {
                    System.out.println(AMARILLO + "El número de chasis solo puede contener números. Intente nuevamente." + RESET);
                }
                }

                String motor;
                while (true) {
                System.out.print("Número de Motor: ");
                motor = scannerApp.next();
                if (motor.matches("\\d+")) {
                    break;
                } else {
                    System.out.println(AMARILLO + "El número de motor solo puede contener números. Intente nuevamente." + RESET);
                }
                }

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

                System.out.print("Precio del vehículo: ");
                double precioVehiculo = scannerApp.nextDouble();

                System.out.print("¿Aplica impuesto Nacional? (Si/No): ");
                String aplicaImpuestoNacional = "";
                while (true) {
                aplicaImpuestoNacional = scannerApp.next();
                if (esSiONo(aplicaImpuestoNacional)) break;
                System.out.print("Respuesta no válida. Ingrese Si o No: ");
                }

                System.out.print("¿Aplica impuesto Provincial? (Si/No): ");
                String aplicaImpuestoProvincial = "";
                while (true) {
                aplicaImpuestoProvincial = scannerApp.next();
                if (esSiONo(aplicaImpuestoProvincial)) break;
                System.out.print("Respuesta no válida. Ingrese Si o No: ");
                }

                System.out.print("ID del vehículo: ");
                String ID = scannerApp.next();

                System.out.println(VERDE + "\n✓ Vehículo cargado correctamente." + RESET);

                ((AdminLog) instancia).cargarVehiculo(tipo, marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, ID, precioVehiculo, aplicaImpuestoNacional, aplicaImpuestoProvincial);
                // Agregar el vehículo a la lista local
                boolean in;
                if (aplicaImpuestoNacional.equalsIgnoreCase("Si")) {
                in = true;
                } else {
                in = false;
                }

                boolean ip;
                if (aplicaImpuestoProvincial.equalsIgnoreCase("Si")) {
                ip = true;
                } else {
                ip = false;
                }

                AbstractVehiculo nuevoVehiculo = vehiculoFactory.crearVehiculo(tipo, marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, ID, precioVehiculo, in, ip);

                if (nuevoVehiculo != null) {
                vehiculos.add(nuevoVehiculo);
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

                String cuitConcesionario;
                while (true) {
                    System.out.print("CUIT del concesionario: ");
                    cuitConcesionario = scannerApp.nextLine();
                    if (cuitConcesionario.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("El CUIT solo debe contener números. Intente nuevamente.");
                    }
                }

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
                ((AdminLog) instancia).verClientes();
                String idCliente;
                while (true) {
                    System.out.print("ID Cliente: ");
                    idCliente = scannerApp.nextLine();
                    if (datosVendedor.clienteExistePorId(idCliente)) {
                        break;
                    } else {
                        System.out.println("⚠ Cliente no encontrado. Intente nuevamente.");
                    }
                }

                System.out.print("Dirección: ");
                String direccion = scannerApp.nextLine();

                String cuilCuit;
                while (true) {
                    System.out.print("CUIL/CUIT: ");
                    cuilCuit = scannerApp.nextLine();
                    if (cuilCuit.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("El CUIL/CUIT solo debe contener números. Intente nuevamente.");
                    }
                }

                String formaPago = "";
                while (true) {
                    System.out.print("Forma de Pago (Transferencia/Contado/Tarjeta): ");
                    formaPago = scannerApp.nextLine().trim().toLowerCase();
                    if (formaPago.equals("transferencia") || formaPago.equals("contado") || formaPago.equals("tarjeta")) {
                        // Capitalizar la primera letra para mantener formato
                        formaPago = formaPago.substring(0, 1).toUpperCase() + formaPago.substring(1);
                        break;
                    } else {
                        System.out.println("Forma de pago no válida. Ingrese Transferencia, Contado o Tarjeta.");
                    }
                }

                System.out.println(AZUL + "\n=== Seleccione un vehículo ===" + RESET);
                ((AdminLog) instancia).verVehiculos(vehiculos);

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
                while(datosVendedor.vendedorExistePorId(idVendedor) == false) {
                    System.out.println(ROJO + "⚠ Vendedor no encontrado. Intente nuevamente." + RESET);
                    System.out.print("ID del vendedor: ");
                    idVendedor = scannerApp.next();
                }

                // Agregar el pedido
                ((AdminLog) instancia).agregarPedido(
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

            } else if (opcion == 9) {
                System.out.println("Pedidos disponibles:");
                for (PedidoDeCompra pedido : pedidos) {
                System.out.println("ID del Pedido: " + pedido.getIdPedido() + " | Fecha: " + pedido.getFecha() + " | Estado: " + pedido.getEstado());
                }

                System.out.print("Ingrese el ID del pedido a ver: ");
                int id;
                while (true) {
                try {
                    id = scannerApp.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("⚠ Ingrese un número entero válido.");
                    scannerApp.nextLine(); // Limpiar entrada inválida
                }
                }
                ((AdminLog) instancia).verPedido(pedidos, String.valueOf(id));



            } else {

                System.out.println("Opción no válida. Por favor, intente de nuevo.");

            }
            }
            scannerApp.close();
        }
        }
    }
