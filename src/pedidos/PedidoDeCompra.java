package pedidos;

import login.VendedorLog;
import pedidos.datosFacturacion.DatosFacturacion;
import pedidos.datosPedidos.DatosPedido;
import vehiculos.AbstractVehiculo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PedidoDeCompra {
    private int idPedido;
    private DatosPedido datosPedido;
    private DatosFacturacion datosFacturacion;
    private AbstractVehiculo vehiculo;
    private VendedorLog vendedor;

    public PedidoDeCompra(int idPedido, DatosPedido datosPedido, DatosFacturacion datosFacturacion, AbstractVehiculo vehiculo, VendedorLog vendedor) {
        this.idPedido = idPedido;
        this.datosPedido = datosPedido;
        this.datosFacturacion = datosFacturacion;
        this.vehiculo = vehiculo;
        this.vendedor = vendedor;
    }



     // Estructura: ID Pedido, Nombre, Apellido, CUIT, Dirección, Email, Teléfono


}
