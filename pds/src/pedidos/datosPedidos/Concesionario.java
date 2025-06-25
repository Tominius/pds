package pedidos.datosPedidos;

public class Concesionario {

    private String nombre;
    private String cuit;

    public Concesionario(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
