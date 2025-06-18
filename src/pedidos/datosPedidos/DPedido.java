package pedidos.datosPedidos;

public class DPedido {

    Concesionario concesionaria;
    EstadoPedido estadoPedido;
    String fecha;
    Historial historial;

    public DPedido(Concesionario concesionaria, EstadoPedido estadoPedido, String fecha, Historial historial) {
        this.concesionaria = concesionaria;
        this.estadoPedido = estadoPedido;
        this.fecha = fecha;
        this.historial = historial;
    }
}
