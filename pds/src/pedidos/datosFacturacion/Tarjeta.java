package pedidos.datosFacturacion;

public class Tarjeta extends FormaDePago{

    public Tarjeta(float impuesto, String metodo) {
        super(impuesto, metodo);
    }

    @Override
    public void Mensaje() {
        System.out.println("La tarjeta fue aprobada");
    }
}
