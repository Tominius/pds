package pedidos.reportes;

import pedidos.PedidoDeCompra;

public class ReporteCliente {

    private PedidoDeCompra[] pedido;

    public ReporteCliente(PedidoDeCompra[] pedido) {
        this.pedido = pedido;
    }

    private void MostrarPedidos(){
        for (int i = 0; i < pedido.length; i++) {
            System.out.println(pedido[i].toString());
        }
    }
}
