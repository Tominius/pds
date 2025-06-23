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

    public void actualizarEstado(String nuevoEstado) {
        estadoPedido.ActualizarEstado(nuevoEstado);
        historial.agregarCambio(nuevoEstado);
    }

    public void imprimirDatos() {

        final String AZUL = "\u001B[34m";
        final String VERDE = "\u001B[32m";
        final String CYAN = "\u001B[36m";
        final String RESET = "\u001B[0m";

        System.out.println(CYAN + "\n--- Datos del Pedido ---" + RESET);
        System.out.printf("%-20s %s\n", "Concesionaria:", concesionaria.getNombre());
        System.out.printf("%-20s %s\n", "Estado del Pedido:", estadoPedido.getArea());
        System.out.printf("%-20s %s\n", "Fecha:", fecha);
        historial.imprimirHistorial();

    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estadoPedido.getArea();
    }
}
