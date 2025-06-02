package datosPedidos;

public class Facturacion {

    private String direccion;
    private int cuit_cuil;

    public Facturacion(String direccion, int cuit_cuil) {
        this.direccion = direccion;
        this.cuit_cuil = cuit_cuil;
    }

    public void verDatosFacturacion() {
        System.out.println("Direccion: " + direccion);
        System.out.println("Cuitcuil: " + cuit_cuil);
    }
}
