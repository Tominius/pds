package vehiculos;

public class Moto extends AbstractVehiculo {

    boolean esDeportiva;

    public Moto(String marca, String modelo, String color, String equipAdicional, String chasis, String motor, String caracteristicas, String disponible, String atributoEspecifico, String id, double precioVehiculo, boolean aplicaImpuestoNacional, boolean aplicaImpuestoProvincial) {
        super(marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, id, precioVehiculo, aplicaImpuestoNacional, aplicaImpuestoProvincial);
        if (atributoEspecifico.equals("Si")) {
            this.esDeportiva = true; // Si es deportiva
        } else {
            this.esDeportiva = false; // No es deportiva
        } // Valor por defecto
    }

    @Override
    public void impuestoNacionalAbstracto(double precio) {
        this.precioVehiculo = precio * 1.15; // Ejemplo: 15% de impuesto nacional
    }

    @Override
    public void impuestoProvinvialAddAbstracto(double precio) {
        this.precioVehiculo = precio * 1.07; // Ejemplo: 7% de impuesto provincial
    }


    @Override
    public void imprimirDatos() {
        final String AZUL = "\u001B[34m";
        final String VERDE = "\u001B[32m";
        final String RESET = "\u001B[0m";

        System.out.println(AZUL + "========== FICHA DEL VEHÍCULO ==========" + RESET);
        System.out.printf("%-25s %s%s%s\n", "Tipo:", VERDE, "Moto", RESET);
        System.out.printf("%-25s %s%s%s\n", "Marca:", VERDE, getMarca(), RESET);
        System.out.printf("%-25s %s%s%s\n", "Modelo:", VERDE, getModelo(), RESET);
        System.out.printf("%-25s %s%s%s\n", "Color:", VERDE, getColor(), RESET);
        System.out.printf("%-25s %s%s%s\n", "Número de Chasis:", VERDE, getNumero_de_chasis(), RESET);
        System.out.printf("%-25s %s%s%s\n", "Número de Motor:", VERDE, getNum_de_motor(), RESET);
        System.out.printf("%-25s %s%s%s\n", "Características:", VERDE, getCaracteristicas(), RESET);
        System.out.printf("%-25s %s%s%s\n", "Disponible:", VERDE, isDisponible() ? "Sí" : "No", RESET);
        System.out.printf("%-25s %s%s%s\n", "Deportiva:", VERDE, esDeportiva ? "Sí" : "No", RESET);
        System.out.printf("%-25s %s%s%s\n", "ID del Vehículo:", VERDE, getID(), RESET);
        System.out.println(AZUL + "========================================" + RESET);
    }

    

}
