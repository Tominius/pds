
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import login.AdminLog;
import login.ClienteLog;
import login.VendedorLog;
import login.AbstractUserLog;

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
}