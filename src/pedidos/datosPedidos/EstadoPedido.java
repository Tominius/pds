package pedidos.datosPedidos;

public class EstadoPedido {

    private String idPedido;
    private String area;

    public EstadoPedido(String idPedido, String area) {
        this.idPedido = idPedido;
        this.area = area;
    }

    private void notificacion(){
        System.out.println("El area a pasado a" + area);
    };

    public void ActualizarEstado(String nuevoEstado) {
        this.area = nuevoEstado;
        System.out.println("El estado del pedido ha sido actualizado");
    };

    public String getArea() {
        return area;
    }











}
