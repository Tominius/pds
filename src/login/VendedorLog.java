package login;

import vehiculos.AbstractVehiculo;

public class VendedorLog extends AbstractUserLog implements VendedorLogI {

    private String email;

    public VendedorLog(String usuario, String contrasena, String email) {
        super(usuario, contrasena);
        this.email = email;
    }


    @Override
    public void verVehiculosDisponibles(java.util.List<AbstractVehiculo> vehiculos) {
        // Implementación del método para ver los vehículos disponibles
        for (AbstractVehiculo vehiculo : vehiculos) {
            if (vehiculo.isDisponible()) {
                vehiculo.imprimirDatos();
            }
        }
    }



    @Override
    public void imprimirAtributos() {

        final String AZUL = "\u001B[34m";
        final String VERDE = "\u001B[32m";
        final String CYAN = "\u001B[36m";
        final String RESET = "\u001B[0m";

        System.out.println(CYAN + "\n--- Datos del Vendedor ---" + RESET);
        System.out.printf("%-20s %s\n", "Usuario:", this.getUsuario());
        System.out.printf("%-20s %s\n", "Contraseña:", this.getContrasena());
        System.out.printf("%-20s %s\n", "Email:", this.email);
    }

}
