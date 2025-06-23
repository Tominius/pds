package login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersFactory {

    public static List<AbstractUserLog> cargarUsuariosDesdeCSV(String ruta) {
        List<AbstractUserLog> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String tipo = campos[2].trim().toLowerCase();
                // Ajusta los índices según el formato de tu CSV
                switch (tipo) {
                    case "administrador":
                        usuarios.add(new AdminLog(campos[0], campos[1]));
                        break;
                    case "cliente":
                        usuarios.add(new ClienteLog(campos[0], campos[1], campos[3], campos[4], campos[5]));
                        break;
                    case "vendedor":
                        usuarios.add(new VendedorLog(campos[0], campos[1], campos[3]));
                        break;
                    default:
                        System.out.println("Tipo de usuario desconocido: " + tipo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public ClienteLog devuelveClienteLog(String ruta, String idCliente) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length < 7) {
                    continue;
                }
                String tipo = campos[2].trim().toLowerCase();
                if ("cliente".equals(tipo) && campos[6].equals(idCliente)) {
                    return new ClienteLog(campos[0], campos[1], campos[3], campos[4], campos[5]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public VendedorLog devuelveVendedorLog(String ruta, String idVendedor) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length < 4) {
                    continue;
                }
                String tipo = campos[2].trim().toLowerCase();
                if ("vendedor".equals(tipo) && campos[4].equals(idVendedor)) {
                    return new VendedorLog(campos[0], campos[1], campos[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ClienteLog devuelveClienteLog(String username, String contraseña, String dni, String telefono, String email) {
        return new ClienteLog(username, contraseña, dni, telefono, email);
    }


}