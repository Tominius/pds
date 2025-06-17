package pedidos.datosFacturacion;

import login.ClienteLog;

public class DatosFacturacion {
    private Facturacion facturacion;
    private float costoTotal;
    private FormaDePago formaDePago;
    private ClienteLog cliente;

    public DatosFacturacion(Facturacion facturacion, float costoTotal, FormaDePago formaDePago, ClienteLog cliente) {
        this.facturacion = facturacion;
        this.costoTotal = costoTotal;
        this.formaDePago = formaDePago;
        this.cliente = cliente;
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(Facturacion facturacion) {
        this.facturacion = facturacion;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public ClienteLog getCliente() {
        return cliente;
    }

    public void setCliente(ClienteLog cliente) {
        this.cliente = cliente;
    }
}
