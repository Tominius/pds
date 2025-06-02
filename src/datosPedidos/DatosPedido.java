package datosPedidos;

public class DatosPedido {
    private String fecha;
    private int idPedido;
    private Concesionario concesionario;
    private EstadoPedido estadoPedido;
    private String area;

    public DatosPedido(String fecha, int idPedido, Concesionario concesionario, EstadoPedido estadoPedido, String area) {
        this.fecha = fecha;
        this.idPedido = idPedido;
        this.concesionario = concesionario;
        this.estadoPedido = estadoPedido;
        this.area = area;
    }


}
