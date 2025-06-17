package pedidos.datosPedidos;

public class Concesionario {

    private String nombre;
    private int cuit;

    public Concesionario(String nombre, int cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
}
