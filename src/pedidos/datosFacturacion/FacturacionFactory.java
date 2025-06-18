package pedidos.datosFacturacion;

import login.ClienteLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FacturacionFactory {

    String ruta = "src/pedidos/datosFacturacion/datosFacturacion.csv";
    String rutaClientes = "src/datosUsuarios/datos.csv";

    public Facturacion crearFacturacionPorPedido(String idPedido) {
        List<String[]> datosFacturacion = leerCSV(ruta);
        List<String[]> datosClientes = leerCSV(rutaClientes);

        // Buscar la fila de facturación correspondiente al idPedido
        String[] datos = datosFacturacion.stream()
                .filter(arr -> arr[5].equals(idPedido))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado: " + idPedido));

        String idCliente = datos[2];

        // Buscar datos del cliente por id y tipo "cliente"
        String[] datosCliente = datosClientes.stream()
                .filter(arr -> arr[2].equals("cliente") && arr[arr.length - 1].equals(idCliente))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + idCliente));

        ClienteLog cliente = new ClienteLog(
                datosCliente[0],
                datosCliente[1],
                datosCliente[4],
                datosCliente[3],
                datosCliente[5]
        );

        FormaDePago formaDePago;
        if (datos[1].equals("Contado")) {
            formaDePago = new Contado(2, "Contado");
        } else if (datos[1].equals("Tarjeta")) {
            formaDePago = new Contado(2, "Tarjeta");
        } else if (datos[1].equals("Transferencia")) {
            formaDePago = new Transferencia(2, "Transferencia");
        } else {
            throw new RuntimeException("Forma de pago no reconocida: " + datos[2]);
        }

        // Crear Facturacion con los datos de datosFacturacion y el cliente creado
        return new Facturacion(
                datos[1], // costoTotal
                datos[2], // formaDePago
                formaDePago,
                datos[3], // direccion
                cliente
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
