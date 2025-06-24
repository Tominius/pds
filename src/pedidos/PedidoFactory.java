package pedidos;
import login.ClienteLog;
import login.UsersFactory;
import login.VendedorLog;
import pedidos.datosFacturacion.Facturacion;
import pedidos.datosFacturacion.FacturacionFactory;
import pedidos.datosPedidos.DPedido;
import pedidos.datosPedidos.DPedidoFactory;
import pedidos.datosPedidos.DatosPedido;
import vehiculos.AbstractVehiculo;
import vehiculos.VehiculoFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PedidoFactory {

    FacturacionFactory facturacionFactory = new FacturacionFactory();
    DPedidoFactory dPedidoFactory = new DPedidoFactory();
    UsersFactory usersFactory = new UsersFactory();
    VehiculoFactory vehiculoFactory = new VehiculoFactory();

    public PedidoDeCompra crearPedido(String idPedido, String idVehiculo, String idVendedor) {

        Facturacion factura = facturacionFactory.crearFacturacionPorPedido(idPedido);
        DPedido datosPedido = dPedidoFactory.crearDPedidoPorId(idPedido);
        VendedorLog vendedor = usersFactory.devuelveVendedorLog("src/datosUsuarios/datos.csv", idVendedor);
        AbstractVehiculo vehiculo = VehiculoFactory.cargarVehiculoPorIdDesdeCSV("src/vehiculos/vehiculos.csv", idVehiculo);

        return new PedidoDeCompra(
                idPedido,
                datosPedido,
                factura,
                vehiculo,
                vendedor
        );
    }

    public List<PedidoDeCompra> cargarPedidosDesdeCSV(String rutaCSV) {
        List<PedidoDeCompra> pedidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 3) {
                    String idPedido = datos[0].trim();
                    String idVehiculo = datos[1].trim();
                    String idVendedor = datos[3].trim();
                    PedidoDeCompra pedido = crearPedido(idPedido, idVehiculo, idVendedor);
                    pedidos.add(pedido);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pedidos;
    }
}
