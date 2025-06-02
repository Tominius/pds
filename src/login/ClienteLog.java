package login;

public class ClienteLog extends AbstractUserLog implements ClienteLogI {

    private String dni;
    private String telefono;
    private String email;

    public ClienteLog(String usuario, String contrasena, String dni, String telefono, String email) {
        super(usuario, contrasena);
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public void imprimirAtributos() {
        System.out.println("Usuario: " + getUsuario());
        System.out.println("Contraseña: " + getContrasena());
        System.out.println("DNI: " + dni);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
    }

    @Override
    public void verEstadoCompra() {
        // Implementación del método para ver el estado de la compra
        System.out.println("Estado de la compra: En proceso");
    }

    @Override
    public void verVehiculosDisponibles() {
        // Implementación del método para ver los vehículos disponibles
        System.out.println("Vehículos disponibles: [Vehículo 1, Vehículo 2, Vehículo 3]");
    }

}
