package vehiculos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DatosVehiculos {

    String ruta = "src/vehiculos/vehiculos.csv";

    public void verVehiculos() {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (!java.nio.file.Files.exists(path)) {
                System.out.println("No se encontraron vehículos registrados.");
            }
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            for (String line : lines) {
                String[] partes = line.split(",");
                if (partes.length >= 10) {
                    System.out.println("------------------------------Vehiculo------------------------------");
                    String output = "Tipo: " + partes[0] + "\n" +
                        "Marca: " + partes[1] + "\n" +
                        "Modelo: " + partes[2] + "\n" +
                        "Color: " + partes[3] + "\n" +
                        "Equip. Adicional: " + partes[4] + "\n" +
                        "N° de Chasis: " + partes[5] + "\n" +
                        "N° de Motor: " + partes[6] + "\n" +
                        "Características: " + partes[7] + "\n" +
                        "Disponible: " + partes[8];

                    if (partes[0].equals("Auto")) {
                        output += "\nTraccion Delantera: " + partes[9];
                    } else if (partes[0].equals("Moto")) {
                        output += "\nDeportiva: " + partes[9];
                    } else if (partes[0].equals("Camion")) {
                        output += "\nAcoplado: " + partes[9];
                    } else if (partes[0].equals("Camioneta")) {
                        output += "\n4x4: " + partes[9];
                    }

                    System.out.println(output);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertarVehiculo(String tipo, String marca, String modelo, String color, String equipAdicional, String chasis, String motor, String caracteristicas, String disponible, String atributoEspecifico, String id) {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (java.nio.file.Files.exists(path)) {
                java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
                for (String line : lines) {
                    String[] partes = line.split(",");
                    if (partes.length >= 11 && partes[10].equals(id)) {
                        System.out.println("Ya existe un vehículo con el mismo ID.");
                        return;
                    }
                }
            }
            String csvLine = tipo + "," + marca + "," + modelo + "," + color + "," + equipAdicional + "," + chasis + "," + motor + "," + caracteristicas + "," + disponible + "," + atributoEspecifico + "," + id;
            FileWriter fileWriter = new FileWriter(ruta, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(csvLine);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public void eliminarVehiculo(String id){
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            java.util.List<String> updatedLines = new java.util.ArrayList<>();
            for (String line : lines) {
                String[] partes = line.split(",");
                if (partes.length >= 11 && !partes[10].equals(id)) {
                    updatedLines.add(line);
                }
            }
            java.nio.file.Files.write(path, updatedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
