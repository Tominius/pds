package pedidos;

import login.VendedorLog;
import pedidos.datosFacturacion.DatosFacturacion;
import pedidos.datosFacturacion.Facturacion;
import pedidos.datosPedidos.DPedido;
import pedidos.datosPedidos.DatosPedido;
import vehiculos.AbstractVehiculo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PedidoDeCompra {

    private String  idPedido;
    private DPedido datosPedido;
    private Facturacion datosFacturacion;
    private AbstractVehiculo vehiculo;
    private VendedorLog vendedor;

    public PedidoDeCompra(String idPedido, DPedido datosPedido, Facturacion datosFacturacion, AbstractVehiculo vehiculo, VendedorLog vendedor) {
        this.idPedido = idPedido;
        this.datosPedido = datosPedido;
        this.datosFacturacion = datosFacturacion;
        this.vehiculo = vehiculo;
        this.vendedor = vendedor;
    }



     // Estructura: ID Pedido, Nombre, Apellido, CUIT, Dirección, Email, Teléfono


}
