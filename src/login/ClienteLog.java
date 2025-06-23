package login;

import pedidos.PedidoDeCompra;
import pedidos.reportes.ReporteCliente;
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
        System.out.print("Usuario: " + getUsuario() + "| ");
        System.out.print("Contraseña: " + getContrasena()+ "| ");
        System.out.print("DNI: " + dni+ "| ");
        System.out.print("Teléfono: " + telefono+ "| ");
        System.out.println("Email: " + email);
    }

    @Override
    public void verEstadoCompra( java.util.List<PedidoDeCompra> pedidos) {

        final String AZUL = "\u001B[34m";
        final String VERDE = "\u001B[32m";
        final String RESET = "\u001B[0m";

        ReporteCliente reporteCliente = new ReporteCliente(this.getUsuario());
        // Implementación del método para ver el estado de la compra
        boolean tienePedidos = false;

        for (PedidoDeCompra pedido : pedidos) {
            if (pedido.getCliente().equals(getUsuario())) {
                tienePedidos = true;
                System.out.printf("%-15s %s%s%s\n", "ID Pedido:", VERDE, pedido.getIdPedido(), RESET);
                System.out.printf("%-15s %s%s%s\n", "Fecha:", VERDE, pedido.getFecha(), RESET);
                System.out.printf("%-15s %s%s%s\n", "Estado:", VERDE, pedido.getEstado(), RESET);
                System.out.println("-----------------------------------------");
                reporteCliente.agregarPedido(pedido);
            }
        }

        if (!tienePedidos) {
            System.out.println(VERDE + "No se encontraron pedidos asociados al cliente." + RESET);
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
