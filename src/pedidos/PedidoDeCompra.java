package pedidos;

import login.VendedorLog;
import pedidos.datosFacturacion.DatosFacturacion;
import pedidos.datosPedidos.DatosPedido;
import vehiculos.AbstractVehiculo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PedidoDeCompra {
    private int idPedido;
    private DatosPedido datosPedido;
    private DatosFacturacion datosFacturacion;
    private AbstractVehiculo vehiculo;
    private VendedorLog vendedor;

    public PedidoDeCompra(int idPedido, DatosPedido datosPedido, DatosFacturacion datosFacturacion, AbstractVehiculo vehiculo, VendedorLog vendedor) {
        this.idPedido = idPedido;
        this.datosPedido = datosPedido;
        this.datosFacturacion = datosFacturacion;
        this.vehiculo = vehiculo;
        this.vendedor = vendedor;
    }



     // Estructura: ID Pedido, Nombre, Apellido, CUIT, Dirección, Email, Teléfono

    public void exportarACSV() {
        String nombreArchivo = "pedido_" + idPedido + ".csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Encabezado
            bw.write("ID Pedido, datosPedido, Cliente");
            bw.newLine();

            // Cuerpo
            bw.write(
                    idPedido + "," + datosPedido + "," + datosFacturacion.getCliente().getDni()
            );
            bw.newLine();   // por si luego añadís más registros
        } catch (IOException e) {
            e.printStackTrace();           // en un proyecto real, usar un logger
        }
    }



}
