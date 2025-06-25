package pedidos.datosPedidos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DPedidoFactory {

    public DPedido crearDPedidoPorId(String idPedido) {
        List<String[]> datosPedidos = leerCSV("src/pedidos/datosPedidos/datosPedido.csv");
        List<String[]> datosHistorial = leerCSV("src/pedidos/datosPedidos/historiale.csv");

        // Buscar el pedido por idPedido
        String[] datos = datosPedidos.stream()
                .filter(arr -> arr[0].equals(idPedido))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        // Crear EstadoPedido usando el primer y último campo
        EstadoPedido estadoPedido = new EstadoPedido(datos[0], datos[4]);

        // Crear Consecionario usando el tercer y cuarto campo
        Concesionario consecionario = new Concesionario(datos[2], datos[3]);

        // Buscar historial por idPedido (primer campo)
        String[] historialArr = datosHistorial.stream()
                .filter(arr -> arr[0].equals(datos[0]))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));

        // Crear lista de cambios (ignorando el primer campo que es el idPedido)
        List<String> cambios = new ArrayList<>();
        for (int i = 1; i < historialArr.length; i++) {
            cambios.add(historialArr[i]);
        }
        Historial historial = new Historial(datos[0], cambios);

        // Crear y retornar DPedido
        return new DPedido(
                consecionario,
                estadoPedido,
                datos[1],
                historial
        );
    }

    private List<String[]> leerCSV(String rutaArchivo) {
        List<String[]> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea.split(","));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return datos;
    }


}
