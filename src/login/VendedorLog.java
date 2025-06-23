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
        System.out.print("Usuario: " + getUsuario()+"|");
        System.out.print("Contraseña: " + getContrasena()+"|");
        System.out.println("Email: " + email);
    }

}
