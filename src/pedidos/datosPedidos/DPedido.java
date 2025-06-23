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

    public void imprimirDatos() {
        System.out.println("Datos del Pedido:");
        System.out.print("Concesionaria: " + concesionaria.getNombre()+"|");
        System.out.print("Estado del Pedido: " + estadoPedido.getArea()+"|");
        System.out.print("Fecha: " + fecha+"|");
        historial.imprimirHistorial();
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estadoPedido.getArea();
    }
}
