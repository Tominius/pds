package pedidos.datosPedidos;

import java.io.FileWriter;
import java.io.IOException;

public class DatosPedido {

    String ruta = "src/pedidos/datosPedidos/datosPedido.csv";


    public void cargarDatosPedidos(int pedido, String fecha, String nombreConsecionaria, String cuitConsecionaria) {

        try (FileWriter fw = new FileWriter(ruta, true)) {
            fw.write(pedido + "," + fecha + "," + nombreConsecionaria + "," + cuitConsecionaria + ","+"Administracion" +"\n");

            insertarEnHistorial(String.valueOf(pedido), "Administracion");
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
