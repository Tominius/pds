package datosUsuarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Datos {

    String ruta = "src/datosUsuarios/datos.csv";

    public String obtenerTipoUsuario(String username) {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (!java.nio.file.Files.exists(path)) {
                return null;
            }
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            for (String line : lines) {
                if (line.startsWith(username + ",")) {
                    String[] partes = line.split(",");
                    if (partes.length >= 3) {
                        return partes[2];
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean vendedorExistePorId(String id) {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (!java.nio.file.Files.exists(path)) {
                return false;
            }
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            for (String line : lines) {
                String[] partes = line.split(",");
                if (partes.length >= 5 && "vendedor".equals(partes[2]) && partes[4].equals(id)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean clienteExistePorId(String id) {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (!java.nio.file.Files.exists(path)) {
                return false;
            }
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            for (String line : lines) {
                String[] partes = line.split(",");
                if (partes.length >= 7 && "cliente".equals(partes[2]) && partes[6].equals(id)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean usuarioExiste(String username) {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (!java.nio.file.Files.exists(path)) {
                return false;
            }
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            for (String line : lines) {
                if (line.startsWith(username + ",")) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean verificarUsuario(String username, String contraseña) {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (!java.nio.file.Files.exists(path)) {
                return false;
            }
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            for (String line : lines) {
                String[] partes = line.split(",");
                if (partes[0].equals(username) && partes[1].equals(contraseña)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return false;
    }

    public void insertarCliente(String username, String contraseña, String dni, String telefono, String email) {
        if (usuarioExiste(username)) {
            System.out.println("El usuario ya existe.");
            return;
        }
        String csvLine = username + "," + contraseña + ",cliente," + dni + "," + telefono + "," + email + "," + java.util.UUID.randomUUID().toString();
        try {
            FileWriter fileWriter = new FileWriter(ruta, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(csvLine);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertarAdministrador(String username, String contraseña) {
        if (usuarioExiste(username)) {
            System.out.println("El usuario ya existe.");
            return;
        }
        String csvLine = username + "," + contraseña + ",administrador";
        try {
            FileWriter fileWriter = new FileWriter(ruta, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(csvLine);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertarVendedor(String username, String contraseña, String email) {
        if (usuarioExiste(username)) {
            System.out.println("El usuario ya existe.");
            return;
        }
        String csvLine = username + "," + contraseña + ",vendedor,," + email + "," + java.util.UUID.randomUUID().toString();
        try {
            FileWriter fileWriter = new FileWriter(ruta, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(csvLine);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUser(String username){
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            java.util.List<String> updatedLines = new java.util.ArrayList<>();
            for (String line : lines) {
                if (!line.startsWith(username + ",")) {
                    updatedLines.add(line);
                }
            }
            java.nio.file.Files.write(path, updatedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public java.util.List<String> leerDatos(String username) {
        // Devuelve los datos de un usuario en una lista
        java.util.List<String> datos = new java.util.ArrayList<>();
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            for (String line : lines) {
                if (line.startsWith(username + ",")) {
                    String[] partes = line.split(",");
                    for (String parte : partes) {
                        datos.add(parte);
                    }
                    return datos;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }

    // Devuelve los datos necesarios para crear un ClienteLog (username, contraseña, dni, telefono, email)
    public java.util.List<String> obtenerDatosParaClienteLog(String username) {
        java.util.List<String> datosCliente = new java.util.ArrayList<>();
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (!java.nio.file.Files.exists(path)) {
                return datosCliente;
            }
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            for (String line : lines) {
                String[] partes = line.split(",");
                if (partes.length >= 6 && partes[0].equals(username) && "cliente".equals(partes[2])) {
                    // username, contraseña, dni, telefono, email
                    datosCliente.add(partes[0]); // username
                    datosCliente.add(partes[1]); // contraseña
                    datosCliente.add(partes[3]); // dni
                    datosCliente.add(partes[4]); // telefono
                    datosCliente.add(partes[5]); // email
                    return datosCliente;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datosCliente;
    }

    // Devuelve los datos necesarios para crear un VendedorLog (username, contraseña, email)
    public java.util.List<String> obtenerDatosParaVendedorLog(String username) {
        java.util.List<String> datosVendedor = new java.util.ArrayList<>();
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (!java.nio.file.Files.exists(path)) {
                return datosVendedor;
            }
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            for (String line : lines) {
                String[] partes = line.split(",");
                if (partes.length >= 5 && partes[0].equals(username) && "vendedor".equals(partes[2])) {
                    // username, contraseña, email
                    datosVendedor.add(partes[0]); // username
                    datosVendedor.add(partes[1]); // contraseña
                    datosVendedor.add(partes[3]); // email
                    return datosVendedor;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datosVendedor;
    }

    public void imprimirTodosLosClientes() {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (!java.nio.file.Files.exists(path)) {
                System.out.println("No hay clientes registrados.");
                return;
            }
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            List<List<String>> clientes = getLists(lines);
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes registrados.");
            } else {
                for (java.util.List<String> cliente : clientes) {
                    System.out.println("Nombre: "+ cliente.get(0) + " | DNI: " + cliente.get(3) + " | Telefono: " + cliente.get(4) + " | Email: " + cliente.get(5) + " | ID: " + cliente.get(6));
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void imprimirTodosLosVendedores() {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(ruta);
            if (!java.nio.file.Files.exists(path)) {
                System.out.println("No hay vendedores registrados.");
                return;
            }
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            List<List<String>> vendedores = new java.util.ArrayList<>();
            for (String line : lines) {
                String[] partes = line.split(",");
                if (partes.length >= 4 && "vendedor".equals(partes[2])) {
                    List<String> datosVendedor = new java.util.ArrayList<>();
                    for (String parte : partes) {
                        datosVendedor.add(parte);
                    }
                    vendedores.add(datosVendedor);
                }
            }
            if (vendedores.isEmpty()) {
                System.out.println("No hay vendedores registrados.");
            } else {
                for (java.util.List<String> vendedor : vendedores) {
                    System.out.println("Nombre: " + vendedor.get(0) + " | Email: " + vendedor.get(3) + " | ID: " + vendedor.get(4));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<List<String>> getLists(List<String> lines) {
        List<List<String>> clientes = new java.util.ArrayList<>();
        for (String line : lines) {
            String[] partes = line.split(",");
            if (partes.length >= 7 && "cliente".equals(partes[2])) {
                List<String> datosCliente = new java.util.ArrayList<>();
                for (String parte : partes) {
                    datosCliente.add(parte);
                }
                clientes.add(datosCliente);
            }
        }
        return clientes;
    }

}

