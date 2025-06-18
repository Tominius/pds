package login;

public class VendedorLog extends AbstractUserLog implements VendedorLogI {

    private String email;

    public VendedorLog(String usuario, String contrasena, String email) {
        super(usuario, contrasena);
        this.email = email;
    }




    public void verEstadoCompra() {
        // Implementación del método para ver el estado de la compra
        System.out.println("Estado de la compra: Contaduria");
    }

    @Override
    public void verVehiculosDisponibles() {
        // Implementación del método para ver los vehículos disponibles
        System.out.println("Vehículos disponibles: [Vehículo 1, Vehículo 2, Vehículo 3]");
    }



    @Override
    public void imprimirAtributos() {
        System.out.println("Usuario: " + getUsuario());
        System.out.println("Contraseña: " + getContrasena());
        System.out.println("Email: " + email);
    }

}
