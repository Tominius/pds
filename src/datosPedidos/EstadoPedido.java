package datosPedidos;

public class EstadoPedido {

    private String area;
    private Historial historial;

    public EstadoPedido(String area, Historial historial) {
        this.area = area;
        this.historial = historial;
    }

    private void notificacion(){
        System.out.println("El area a pasado a" + area);
    };

    public void ActualizarEstado(){
        System.out.println("El estado del pedido ha sido actualizado");
    };

    public void verEstadoActual(){
        System.out.println("El pedido esta en " + area);
    };











}
