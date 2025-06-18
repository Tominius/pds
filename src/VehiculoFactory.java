import vehiculos.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoFactory {

    public static List<AbstractVehiculo> cargarVehiculosDesdeCSV(String ruta) {
        List<AbstractVehiculo> vehiculos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String tipo = campos[0].trim();
                switch (tipo.toLowerCase()) {
                    case "auto":
                        vehiculos.add(new Auto(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10]));
                        break;
                    case "camion":
                        vehiculos.add(new Camion(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10]));
                        break;
                    case "camioneta":
                        vehiculos.add(new Camioneta(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10]));
                        break;
                    case "moto":
                        vehiculos.add(new Moto(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10]));
                        break;
                    default:
                        System.out.println("Tipo de vehículo desconocido: " + tipo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }
}