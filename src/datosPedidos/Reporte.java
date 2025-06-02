package datosPedidos;

public class Reporte {
    private PedidoDeCompra[] pedidos;
    private FormaDePago metodoPago;
    private ReporteCliente[] reportesClientes;

    public Reporte(PedidoDeCompra[] pedidos, FormaDePago metodoPago, ReporteCliente[] reportesClientes) {
        this.pedidos = pedidos;
        this.metodoPago = metodoPago;
        this.reportesClientes = reportesClientes;
    }

    public void agregarPedido(PedidoDeCompra nuevoPedido) {
        PedidoDeCompra[] nuevoArray = new PedidoDeCompra[this.pedidos.length + 1];

        // Copiar los pedidos existentes
        for (int i = 0; i < this.pedidos.length; i++) {
            nuevoArray[i] = this.pedidos[i];
        }

        // Agregar el nuevo pedido al final
        nuevoArray[this.pedidos.length] = nuevoPedido;

        // Reemplazar el array original
        this.pedidos = nuevoArray;
    }



}
