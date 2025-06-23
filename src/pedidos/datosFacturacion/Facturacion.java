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

    public void imprimirDatos() {
        System.out.println("Datos de Facturación:");
        System.out.print("Dirección: " + direccion +"|");
        System.out.print("CUIT/CUIL: " + cuit_cuil+"|");
        System.out.print("Forma de Pago: " + formaDePago+"|");
        System.out.print("Costo Total: " + costoTotal+"|");
        System.out.println("Cliente: " + cliente.getUsername());
    }

    public String getIdCliente() {
        return cliente.getUsername();
    }

    public String getTotal() {
        return costoTotal;
    }

    public String getUsernameCliente() {
        return cliente.getUsername();
    }
}
