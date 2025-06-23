package vehiculos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoFactory {

    public static boolean parseSiNo(String valor) {
        return "si".equalsIgnoreCase(valor);
    }

    public static List<AbstractVehiculo> cargarVehiculosDesdeCSV(String ruta) {
        List<AbstractVehiculo> vehiculos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String tipo = campos[0].trim();
                switch (tipo.toLowerCase()) {
                    case "auto":
                        vehiculos.add(new Auto(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], Double.parseDouble(campos[11]), parseSiNo(campos[12]), parseSiNo(campos[13])));
                        break;
                    case "camion":
                        vehiculos.add(new Camion(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10],Double.parseDouble(campos[11]), parseSiNo(campos[12]), parseSiNo(campos[13])));
                        break;
                    case "camioneta":
                        vehiculos.add(new Camioneta(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10],Double.parseDouble(campos[11]),parseSiNo(campos[12]), parseSiNo(campos[13])));
                        break;
                    case "moto":
                        vehiculos.add(new Moto(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10],Double.parseDouble(campos[11]), parseSiNo(campos[12]), parseSiNo(campos[13])));
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

    public static AbstractVehiculo cargarVehiculoPorIdDesdeCSV(String ruta, String idVehiculo) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String tipo = campos[0].trim();
                String id = campos[10].trim();
                if (id.equals(idVehiculo)) {
                    switch (tipo.toLowerCase()) {
                        case "auto":
                            return new Auto(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], Double.parseDouble(campos[11]), Boolean.parseBoolean(campos[12]), Boolean.parseBoolean(campos[13]));
                        case "camion":
                            return new Camion(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], Double.parseDouble(campos[11]), Boolean.parseBoolean(campos[12]), Boolean.parseBoolean(campos[13]));
                        case "camioneta":
                            return new Camioneta(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], Double.parseDouble(campos[11]), Boolean.parseBoolean(campos[12]), Boolean.parseBoolean(campos[13]));
                        case "moto":
                            return new Moto(campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], Double.parseDouble(campos[11]), Boolean.parseBoolean(campos[12]), Boolean.parseBoolean(campos[13]));
                        default:
                            System.out.println("Tipo de vehículo desconocido: " + tipo);
                            return null;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AbstractVehiculo crearVehiculo(String tipo, String marca, String modelo, String color, String equipAdicional, String chasis, String motor, String caracteristicas, String disponible, String atributoEspecifico, String id, double precioVehiculo, boolean aplicaImpuestoNacional, boolean aplicaImpuestoProvincial) {
        switch (tipo.toLowerCase()) {
            case "auto":
                return new Auto(marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, id, precioVehiculo, aplicaImpuestoNacional, aplicaImpuestoProvincial);
            case "camion":
                return new Camion(marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, id, precioVehiculo, aplicaImpuestoNacional, aplicaImpuestoProvincial);
            case "camioneta":
                return new Camioneta(marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, id, precioVehiculo, aplicaImpuestoNacional, aplicaImpuestoProvincial);
            case "moto":
                return new Moto(marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, id, precioVehiculo, aplicaImpuestoNacional, aplicaImpuestoProvincial);
            default:
                System.out.println("Tipo de vehículo desconocido: " + tipo);
                return null;
        }
    }


}