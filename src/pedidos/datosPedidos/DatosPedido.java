package pedidos.datosPedidos;

public class DatosPedido {
    private String fecha;
    private int idPedido;
    private Concesionario concesionario;
    private EstadoPedido estadoPedido;

    public DatosPedido(String fecha, int idPedido, Concesionario concesionario, EstadoPedido estadoPedido) {
        this.fecha = fecha;
        this.idPedido = idPedido;
        this.concesionario = concesionario;
        this.estadoPedido = estadoPedido;
    }


}
