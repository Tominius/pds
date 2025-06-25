package pedidos.datosFacturacion;

public class Transferencia extends FormaDePago{

    public Transferencia(float impuesto, String metodo) {
        super(impuesto, metodo);
    }

    @Override
    public void Mensaje() {
        System.out.println("La transferencia fue recibida");
    }
}
