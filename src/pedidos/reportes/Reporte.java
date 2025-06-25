package pedidos.reportes;

import pedidos.PedidoDeCompra;
import pedidos.datosFacturacion.FormaDePago;

public class Reporte {

    private String fecha;
    private String estado;
    private java.util.List<PedidoDeCompra> pedidos;


    public Reporte(java.util.List<PedidoDeCompra> pedidos, /*FormaDePago metodoPago,*/String fecha, String estado) {
        this.pedidos = pedidos;
        this.fecha = fecha;
        this.estado = estado;
    }

    public void agregarPedido(PedidoDeCompra nuevoPedido) {
        this.pedidos.add(nuevoPedido);
    }

}
