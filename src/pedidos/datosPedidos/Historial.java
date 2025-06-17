package pedidos.datosPedidos;

public class Historial {
    private String idHistorial;
    private String[] cambios;

    public Historial(String idHistorial, String[] cambios) {
        this.idHistorial = idHistorial;
        this.cambios = cambios;
    }

    public void verHistorial() {
        for (int i = 0; i < cambios.length; i++) {
            System.out.println(cambios[i]);
        }
    }
}
