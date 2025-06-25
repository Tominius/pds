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

    public void actualizarEstadoPedido(String nuevoEstado) {
        datosPedido.actualizarEstado(nuevoEstado);
    }



     public void imprimirDatos() {
         final String AZUL = "\u001B[34m";
         final String VERDE = "\u001B[32m";
         final String CYAN = "\u001B[36m";
         final String RESET = "\u001B[0m";

         System.out.println(AZUL + "\n========== PEDIDO DE COMPRA ==========" + RESET);
         System.out.printf("%-20s %s%s%s\n", "ID del Pedido:", VERDE, idPedido, RESET);

         datosPedido.imprimirDatos();
         datosFacturacion.imprimirDatos();
         vehiculo.imprimirDatos();
         try {
             vendedor.imprimirAtributos();
         } catch (Exception e) {
            System.out.println(CYAN + "Vendedor no asignado o no disponible." + RESET);
         }

         System.out.println(AZUL + "======================================" + RESET);
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
