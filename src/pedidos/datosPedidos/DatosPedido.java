package pedidos.datosPedidos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DatosPedido {

    String ruta = "src/pedidos/datosPedidos/datosPedidos.csv";


    public void cargarDatosPedidos(String idPedido ,String fecha, String nombreConsecionaria, String cuitConsecionaria) {

        try (FileWriter fw = new FileWriter(ruta, true)) {
            fw.write(idPedido + "," + fecha + "," + nombreConsecionaria + "," + cuitConsecionaria + "Administracion" +"\n");

            insertarEnHistorial(idPedido, "Administracion");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void insertarEnHistorial(String id, String area) {
        String rutaHistorial = "src/pedidos/datosPedidos/historiale.csv";
        try (FileWriter fw = new FileWriter(rutaHistorial, true)) {
            fw.write(id + "," + area + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
