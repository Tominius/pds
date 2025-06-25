package pedidos.datosPedidos;

import java.util.List;

public class Historial {
    private String idPedido;
    private String[] cambios;

    public Historial(String dato, List<String> cambios) {
        this.idPedido = dato;
        this.cambios = cambios.toArray(new String[0]);
    }

    public void agregarCambio(String cambio) {
        String[] nuevosCambios = new String[cambios.length + 1];
        System.arraycopy(cambios, 0, nuevosCambios, 0, cambios.length);
        nuevosCambios[cambios.length] = cambio;
        this.cambios = nuevosCambios;
    }

    public void imprimirHistorial() {
        System.out.println("Historial de Cambios del Pedido:");
        for (String cambio : cambios) {
            System.out.print("- " + cambio);
        }
    }
}
