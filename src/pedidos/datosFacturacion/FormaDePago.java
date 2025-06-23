package pedidos.datosFacturacion;

public abstract class FormaDePago {

    private float impuesto;
    private String metodo;

    public FormaDePago(float impuesto, String metodo) {
        this.impuesto = impuesto;
        this.metodo = metodo;
    }

    public String getMetodo() {
        return metodo;
    }

    public abstract void Mensaje();
}
