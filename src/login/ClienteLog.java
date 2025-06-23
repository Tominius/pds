package login;

import pedidos.PedidoDeCompra;
import vehiculos.AbstractVehiculo;

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
    public void verEstadoCompra( java.util.List<PedidoDeCompra> pedidos) {
        // Implementación del método para ver el estado de la compra
        for (PedidoDeCompra pedido : pedidos) {
            if (pedido.getCliente().equals(getUsuario())) {
                System.out.println(pedido.getIdPedido());
                System.out.println(pedido.getFecha());
                System.out.println(pedido.getEstado());
            }
        }
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

    public String getUsername() {
        return getUsuario();
    }

}
