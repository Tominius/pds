package login;

import pedidos.PedidoDeCompra;
import vehiculos.AbstractVehiculo;

public interface ClienteLogI {

    void verEstadoCompra( java.util.List<PedidoDeCompra> pedidos);
    void verVehiculosDisponibles(java.util.List<AbstractVehiculo> vehiculos);
}
