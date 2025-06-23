package pedidos.reportes;

import pedidos.PedidoDeCompra;
import pedidos.datosFacturacion.FormaDePago;

public class Reporte {
    private java.util.List<PedidoDeCompra> pedidos;
    //private FormaDePago metodoPago;
    private ReporteCliente[] reportesClientes;

    public Reporte(java.util.List<PedidoDeCompra> pedidos, /*FormaDePago metodoPago,*/ ReporteCliente[] reportesClientes) {
        this.pedidos = pedidos;
        //this.metodoPago = metodoPago;
        this.reportesClientes = reportesClientes;
    }

    public void agregarPedido(PedidoDeCompra nuevoPedido) {
        this.pedidos.add(nuevoPedido);
    }

}
