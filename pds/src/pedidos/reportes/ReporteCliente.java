package pedidos.reportes;
import login.ClienteLog;

import pedidos.PedidoDeCompra;

public class ReporteCliente {

    private PedidoDeCompra[] pedido;
    String cliente;

    public ReporteCliente(String cliente) {
        PedidoDeCompra[] pedidos = new PedidoDeCompra[100]; // Suponiendo un máximo de 100 pedidos
        this.cliente = cliente;
    }

    private void MostrarPedidos(){
        for (int i = 0; i < pedido.length; i++) {
            System.out.println(pedido[i].toString());
        }
    }

    public void agregarPedido(PedidoDeCompra nuevoPedido) {
        if (pedido == null) {
            pedido = new PedidoDeCompra[100];
        }
        for (int i = 0; i < pedido.length; i++) {
            if (pedido[i] == null) {
                pedido[i] = nuevoPedido;
                break;
            }
        }
    }
}
