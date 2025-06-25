package pedidos.datosFacturacion;

public class Contado extends FormaDePago{

    public Contado(float impuesto, String metodo) {
        super(impuesto, metodo);
    }

    @Override
    public void Mensaje() {
        System.out.println("El efectivo fue recibido");
    }
}
