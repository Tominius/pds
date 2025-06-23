package login;

import datosUsuarios.Datos;
import pedidos.DatosGeneral;
import pedidos.PedidoDeCompra;
import pedidos.datosFacturacion.DatosFacturacion;
import pedidos.datosPedidos.DatosPedido;
import vehiculos.AbstractVehiculo;
import vehiculos.DatosVehiculos;

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
    public void cargarVehiculo(String tipo, String marca, String modelo, String color, String equipAdicional, String chasis, String motor, String caracteristicas, String disponible, String atributoEspecifico, String id) {
        // Implementación del método para cargar un vehículo
        datosVehiculos.insertarVehiculo(tipo, marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico,id);
    }

    @Override
    public void eliminarVehiculo(String id) {
        // Implementación del método para eliminar un vehículo
        datosVehiculos.eliminarVehiculo(id);
    }

    @Override
    public void verVehiculos(java.util.List<AbstractVehiculo> vehiculos) {//
        // Implementación del método para ver vehículos
        for (AbstractVehiculo vehiculo : vehiculos) {
            vehiculo.imprimirDatos();
        }

    }

    @Override
    public void generarReporte(java.util.List<PedidoDeCompra> pedidos) {

        // Solicitar filtros por consola
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingrese la fecha a filtrar (dd/mm/yyyy) o presione Enter para omitir: ");
        String fechaFiltro = scanner.nextLine().trim();
        if (fechaFiltro.isEmpty()) fechaFiltro = null;

        System.out.print("Ingrese el estado a filtrar o presione Enter para omitir: ");
        String estadoFiltro = scanner.nextLine().trim();
        if (estadoFiltro.isEmpty()) estadoFiltro = null;

        System.out.println("Reporte de Pedidos de Compra:");
        for (PedidoDeCompra pedido : pedidos) {
            boolean coincideFecha = (fechaFiltro == null || pedido.getFecha().equals(fechaFiltro));
            boolean coincideEstado = (estadoFiltro == null || pedido.getEstado().equalsIgnoreCase(estadoFiltro));
            if (coincideFecha && coincideEstado) {
                pedido.imprimirDatos();
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
    public void verPedido(java.util.List<PedidoDeCompra> pedidos , String id) {
        // Implementación del método para ver un pedido
        for (PedidoDeCompra pedido : pedidos) {
            if (pedido.getIdPedido().equals(id)) {
                pedido.imprimirDatos();
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
