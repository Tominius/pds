package pedidos.datosFacturacion;

import login.ClienteLog;

public class Facturacion {
    private String idPedido;
    private String direccion;
    private String cuit_cuil;
    private FormaDePago formaDePago;
    private String costoTotal;
    private ClienteLog cliente;

    Facturacion(String direccion, String cuit_cuil, FormaDePago formaDePago, String costoTotal, ClienteLog cliente) {
        this.direccion = direccion;
        this.cuit_cuil = cuit_cuil;
        this.formaDePago = formaDePago;
        this.costoTotal = costoTotal;
        this.cliente = cliente;
    }
}
