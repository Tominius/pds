package login;

public interface AdminLogI {

    void verClientes();
    void agregarCliente(String username, String contraseña, String dni, String telefono, String email);
    void eliminarCliente(String username);
    void cargarVehiculo();
    void eliminarVehiculo();
    void verVehiculos();
    void generarReporte();
    void agregarPedido();
    void verPedido(int id);
    
}
