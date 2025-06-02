package datosPedidos;

public class Historial {
    private String[] cambios;

    public Historial(String[] cambios) {
        this.cambios = cambios;
    }

    public void verHistorial() {
        for (int i = 0; i < cambios.length; i++) {
            System.out.println(cambios[i]);
        }
    }
}
