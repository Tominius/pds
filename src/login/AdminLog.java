package login;

import datosUsuarios.Datos;
import pedidos.DatosGeneral;
import pedidos.datosFacturacion.DatosFacturacion;
import pedidos.datosPedidos.DatosPedido;
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
    public void verVehiculos() {//
        // Implementación del método para ver vehículos
        datosVehiculos.verVehiculos();
    }

    @Override
    public void generarReporte() {

    }

    @Override
    public void agregarPedido(String idVehiculo,String idPedido,String nombreConcesionario, String cuitConcesionario, String fecha, String idCliente, String direccion, String cuilCuit, String costoTotal, String formaPago, String idVendedor) {
            datosPedidos.cargarDatosPedidos(Integer.parseInt(idPedido), fecha,nombreConcesionario, cuitConcesionario);
            datosFacturacion.cargarDatosFacturacion(idPedido,costoTotal, formaPago, idCliente, direccion, cuilCuit);
            datosGeneral.cargarDatosGeneral(String.valueOf(idPedido), idVehiculo, idCliente,idVendedor); // Aquí deberías pasar el ID del vehículo correspondiente
    }

    @Override
    public void verPedido(int id) {
        // Implementación del método para ver un pedido por ID
    }

    @Override
    public void imprimirAtributos() {
        System.out.println("Usuario: " + getUsuario());
        System.out.println("Contraseña: " + getContrasena());
    }

}
