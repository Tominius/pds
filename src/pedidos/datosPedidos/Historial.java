package pedidos.datosPedidos;

import java.util.List;

public class Historial {
    private String idPedido;
    private String[] cambios;

    public Historial(String dato, List<String> cambios) {
        this.idPedido = dato;
        this.cambios = cambios.toArray(new String[0]);
    }
}
