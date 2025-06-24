package login;

import datosUsuarios.Datos;
import pedidos.DatosGeneral;
import pedidos.PedidoDeCompra;
import pedidos.datosFacturacion.DatosFacturacion;
import pedidos.datosPedidos.DatosPedido;
import pedidos.reportes.Reporte;
import vehiculos.AbstractVehiculo;
import vehiculos.DatosVehiculos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static menus.menuAdmin.esSiONo;

public class AdminLog extends AbstractUserLog implements AdminLogI {

    public AdminLog(String usuario, String contrasena) {
        super(usuario, contrasena);
    }

    Datos datos = new Datos();
    DatosVehiculos datosVehiculos = new DatosVehiculos();
    DatosFacturacion datosFacturacion = new DatosFacturacion();
    DatosGeneral datosGeneral = new DatosGeneral();
    DatosPedido datosPedidos = new DatosPedido();


    @Override
    public void verClientes() {
        // Implementación del método para ver clientes

        datos.imprimirTodosLosClientes();
    }

    @Override
    public void agregarCliente(String username, String contraseña, String dni, String telefono, String email) {//
        // Implementación del método para agregar un cliente
        datos.insertarCliente(username, contraseña, dni, telefono, email);
    }

    @Override
    public void eliminarCliente(String username) {//
        // Implementación del método para eliminar un cliente
        datos.eliminarUser(username);
    }

    @Override
    public void cargarVehiculo(String tipo, String marca, String modelo, String color, String equipAdicional, String chasis, String motor, String caracteristicas, String disponible, String atributoEspecifico, String id, double precioVehiculo, String aplicaImpuestoNacional, String aplicaImpuestoProvincial) {
        // Implementación del método para cargar un vehículo
        datosVehiculos.insertarVehiculo(tipo, marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico,id, String.valueOf(precioVehiculo), aplicaImpuestoNacional, aplicaImpuestoProvincial);
    }

    @Override
    public void eliminarVehiculo(String id) {
        // Implementación del método para eliminar un vehículo
        datosVehiculos.eliminarVehiculo(id);
    }

    @Override
    public void verVehiculos(List<AbstractVehiculo> vehiculos) {//
        // Implementación del método para ver vehículos
        for (AbstractVehiculo vehiculo : vehiculos) {
            vehiculo.imprimirDatos();
        }

    }

    @Override
    public void generarReporte(List<PedidoDeCompra> pedidos) {

        final String ROJO = "\u001B[31m";
        final String VERDE = "\u001B[32m";
        final String RESET = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);

        String fechaFiltro = null;
        String estadoFiltro = null;

        // Validar fecha
        while (true) {
            System.out.print("Ingrese la fecha a filtrar (dd/mm/yyyy) o presione Enter para omitir: ");
            String inputFecha = scanner.nextLine().trim();

            if (inputFecha.isEmpty()) {
                break;
            }

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false); // No permite fechas inválidas como 32/01/2024
                Date fecha = sdf.parse(inputFecha);
                fechaFiltro = inputFecha;
                break;
            } catch (ParseException e) {
                System.out.println(ROJO + "⚠ Fecha inválida. Asegúrese de usar el formato dd/mm/yyyy." + RESET);
            }
        }

        // Leer estado (sin validación específica, pero podría agregarse)
        System.out.print("Ingrese el estado a filtrar o presione Enter para omitir: ");
        estadoFiltro = scanner.nextLine().trim();
        if (estadoFiltro.isEmpty()) {
            estadoFiltro = null;
        }

        // Mostrar filtros aplicados
        System.out.println(VERDE + "\nFiltros aplicados:" + RESET);
        System.out.println("Fecha: " + (fechaFiltro != null ? fechaFiltro : "Sin filtrar"));
        System.out.println("Estado: " + (estadoFiltro != null ? estadoFiltro : "Sin filtrar"));

        Reporte reporte = new Reporte(pedidos, fechaFiltro, estadoFiltro);
        // Aquí puedes pasar el método de pago si es necesario


        System.out.println("Reporte de Pedidos de Compra:");
        for (PedidoDeCompra pedido : pedidos) {
            boolean coincideFecha = (fechaFiltro == null || pedido.getFecha().equals(fechaFiltro));
            boolean coincideEstado = (estadoFiltro == null || pedido.getEstado().equalsIgnoreCase(estadoFiltro));
            if (coincideFecha && coincideEstado) {
                pedido.imprimirDatos();
                reporte.agregarPedido(pedido);
            }
        }

    }

    @Override
    public void agregarPedido(String idVehiculo,String idPedido,String nombreConcesionario, String cuitConcesionario, String fecha, String idCliente, String direccion, String cuilCuit, String costoTotal, String formaPago, String idVendedor) {
            datosPedidos.cargarDatosPedidos(Integer.parseInt(idPedido), fecha,nombreConcesionario, cuitConcesionario);
            datosFacturacion.cargarDatosFacturacion(idPedido,costoTotal, formaPago, idCliente, direccion, cuilCuit);
            datosGeneral.cargarDatosGeneral(String.valueOf(idPedido), idVehiculo, idCliente,idVendedor); // Aquí deberías pasar el ID del vehículo correspondiente
    }

    @Override
    public void verPedido(List<PedidoDeCompra> pedidos , String id) {
        // Implementación del método para ver un pedido
        for (PedidoDeCompra pedido : pedidos) {
            if (pedido.getIdPedido().equals(id)) {
                pedido.imprimirDatos();
                System.out.print("¿Desea actualizar el estado del pedido? (Si/No): ");
                Scanner scannerApp = new Scanner(System.in);
                String actualizar = scannerApp.next();
                if (esSiONo(actualizar) && actualizar.equalsIgnoreCase("si")) {
                    System.out.print("Ingrese el nuevo estado: ");
                    scannerApp.nextLine(); // Limpiar buffer
                    String nuevoEstado = scannerApp.nextLine();
                    for (PedidoDeCompra pedido1 : pedidos) {
                        if (pedido.getIdPedido().equals(String.valueOf(id))) {
                            pedido.actualizarEstadoPedido(nuevoEstado);
                            System.out.println("Estado actualizado correctamente.");
                            break;
                        }
                    }
                }
                return;
            }
        }
        System.out.println("Pedido no encontrado con ID: " + id);
    }

    @Override
    public void imprimirAtributos() {
        System.out.println("Usuario: " + getUsuario());
        System.out.println("Contraseña: " + getContrasena());
    }

}
