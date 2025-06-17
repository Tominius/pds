package pedidos.datosFacturacion;

import login.ClienteLog;

import java.io.FileWriter;
import java.io.IOException;

public class DatosFacturacion {

    String ruta = "src/pedidos/datosFacturacion/datosFacturacion.csv";

    public void cargarDatosFacturacion(String costoTotal, String formaDePago, String idCliente, String direccion, String cuilcuit) {

        try (FileWriter fw = new FileWriter(ruta, true)) {
            fw.write(costoTotal + "," + formaDePago + "," + idCliente + "," + direccion + "," + cuilcuit +"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
