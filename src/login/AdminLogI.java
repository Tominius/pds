package login;

import pedidos.PedidoDeCompra;
import vehiculos.AbstractVehiculo;

public interface AdminLogI {

    void verClientes();
    void agregarCliente(String username, String contraseña, String dni, String telefono, String email);
    void eliminarCliente(String username);
    void cargarVehiculo(String tipo, String marca, String modelo, String color, String equipAdicional, String chasis, String motor, String caracteristicas, String disponible, String atributoEspecifico, String id);
    void eliminarVehiculo(String id);
    void verVehiculos(java.util.List<AbstractVehiculo> vehiculos);
    void generarReporte(java.util.List<PedidoDeCompra> pedidos);
    void agregarPedido(String idVehiculo,String idPedido, String nombreConcesionario, String cuitConcesionario, String fecha, String idCliente, String direccion, String cuilCuit, String costoTotal, String formaPago, String idVendedor);
    void verPedido(java.util.List<PedidoDeCompra> pedidos , String id);
    
}
