package login;

import java.util.Scanner;

import datosUsuarios.Datos;

public class Login {

    static Datos datos = new Datos();
    
    private String username;
    private String password;

    public AbstractUserLog loginYCrearInstancia() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su username: ");
        this.username = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        this.password = scanner.nextLine();

        AbstractUserLog instancia = null;

        if (datos.usuarioExiste(this.username)) {
            if (datos.verificarUsuario(this.username, this.password)) {
                System.out.println("Bienvenido " + this.username);
                instancia = crearInstancia();
            } else {
                System.out.println("Contraseña incorrecta.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
       // scanner.close();
        return instancia;
    }

    public AbstractUserLog crearInstancia() {
        String tipoUsuario = datos.obtenerTipoUsuario(username);
        if (tipoUsuario.equals("administrador")) {
            // Crear instancia de la clase AdminLog
            return new AdminLog(username, password);
        } else if (tipoUsuario.equals("cliente")) {
            // Crear instancia de la clase ClienteLog
            return new ClienteLog(username, password, datos.obtenerDatosParaClienteLog(username).get(2), datos.obtenerDatosParaClienteLog(username).get(3), datos.obtenerDatosParaClienteLog(username).get(4));
        } else if (tipoUsuario.equals("vendedor")) {
            // Crear instancia de la clase VendedorLog
            return new VendedorLog(username, password, datos.obtenerDatosParaVendedorLog(username).get(2));
        } else {
            System.out.println("Tipo de usuario no reconocido.");
            return null;
        }
    }


}
