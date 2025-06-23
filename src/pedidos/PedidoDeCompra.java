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



     public void imprimirDatos() {
         System.out.println("Pedido de Compra:");
         System.out.println("ID del Pedido: " + idPedido);
         datosPedido.imprimirDatos();
         datosFacturacion.imprimirDatos();
         vehiculo.imprimirDatos();
         vendedor.imprimirAtributos();
     }

     public String getIdPedido() {
         return idPedido;
     }

     public String getFecha() {
         return datosPedido.getFecha();
     }

     public String getEstado() {
        return datosPedido.getEstado();
     }

     public String getIdCliente() {
        return datosFacturacion.getIdCliente();
     }

     public String getTotal() {
        return datosFacturacion.getTotal();
     }

     public String getCliente() {
         return datosFacturacion.getUsernameCliente();
     }

}
