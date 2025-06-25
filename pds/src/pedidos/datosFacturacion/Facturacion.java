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

        final String AZUL = "\u001B[34m";
        final String VERDE = "\u001B[32m";
        final String CYAN = "\u001B[36m";
        final String RESET = "\u001B[0m";

        System.out.println(CYAN + "\n--- Datos de Facturación ---" + RESET);
        System.out.printf("%-20s %s\n", "Dirección:", direccion);
        System.out.printf("%-20s %s\n", "CUIT/CUIL:", cuit_cuil);
        System.out.printf("%-20s %s\n", "Forma de Pago:", formaDePago.getMetodo());
        System.out.printf("%-20s %s\n", "Costo Total:", costoTotal);
        System.out.printf("%-20s %s\n", "Cliente:", cliente.getUsername());

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
