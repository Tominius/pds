package login;

public class AdminLog extends AbstractUserLog implements AdminLogI {

    public AdminLog(String usuario, String contrasena) {
        super(usuario, contrasena);
    }


    @Override
    public void verClientes() {
        // Implementación del método para ver clientes
    }

    @Override
    public void agregarCliente(String username, String contraseña, String dni, String telefono, String email) {
        // Implementación del método para agregar un cliente
    }

    @Override
    public void eliminarCliente(String username) {
        // Implementación del método para eliminar un cliente
    }

    @Override
    public void cargarVehiculo() {
        // Implementación del método para cargar un vehículo
    }

    @Override
    public void eliminarVehiculo() {
        // Implementación del método para eliminar un vehículo
    }

    @Override
    public void verVehiculos() {
        // Implementación del método para ver vehículos
    }

    @Override
    public void generarReporte() {
        // Implementación del método para generar un reporte
    }

    @Override
    public void agregarPedido() {
        // Implementación del método para agregar un pedido
    }

    @Override
    public void verPedido(int id) {
        // Implementación del método para ver un pedido por ID
    }

    @Override
    public void imprimirAtributos() {
        System.out.println("Usuario: " + getUsuario());
        System.out.println("Contraseña: " + getContrasena());
    }

}
