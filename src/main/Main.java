package main;

import login.AbstractUserLog;
import login.Login;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        datosUsuarios.Datos datos = new datosUsuarios.Datos();

        // Pruebas básicas con la clase Datos
        datos.insertarCliente("cliente1", "contrasena1", "12345678A", "123456789", "t@uade.com");
        datos.insertarAdministrador("admin1", "contrasenaAdmin");
        datos.eliminarUser("cliente1");

        // Leer y mostrar datos del usuario "admin1"
        List<String> datosUsuario = datos.leerDatos("admin1");
        if (datosUsuario != null) {
            for (String dato : datosUsuario) {
                System.out.println(dato);
            }
        }

        // Login interactivo
        Login login = new Login();
        AbstractUserLog instancia = login.loginYCrearInstancia();
        instancia.imprimirAtributos();
    }
    }

