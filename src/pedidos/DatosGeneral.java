package pedidos;

import datosUsuarios.Datos;

import java.io.FileWriter;
import java.io.IOException;

public class DatosGeneral {

    String ruta = "src/pedidos/pedidos.csv";
    String rutaVehiculos = "src/vehiculos/vehiculos.csv";
    Datos datosVendedor = new Datos();


    public void cargarDatosGeneral(String idPedido, String idVehiculo, String idCliente, String idVendedor) {

        try (FileWriter fw = new FileWriter(ruta, true)) {
            fw.write(idPedido + "," + idVehiculo + "," +idCliente+","+ idVendedor + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void verDatosGeneral() {

    }
}
