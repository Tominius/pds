package vehiculos;

public class Moto extends AbstractVehiculo {

    boolean esDeportiva;

    public Moto(String marca, String modelo, String color, String equipAdicional, String chasis, String motor, String caracteristicas, String disponible, String atributoEspecifico, String id) {
        super(marca, modelo, color, equipAdicional, chasis, motor, caracteristicas, disponible, atributoEspecifico, id);
        if (atributoEspecifico.equals("Si")) {
            this.esDeportiva = true; // Si es deportiva
        } else {
            this.esDeportiva = false; // No es deportiva
        } // Valor por defecto
    }

    @Override
    public double impuestoNacionalAbstracto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'impuestoNacionalAbstracto'");
    }

    @Override
    public double impuestoProvinvialAddAbstracto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'impuestoProvinvialAddAbstracto'");
    }

    @Override
    public void imprimirDatos() {
        System.out.println("Tipo: Moto");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Color: " + getColor());
        System.out.println("Número de Chasis: " + getNumero_de_chasis());
        System.out.println("Número de Motor: " + getNum_de_motor());
        System.out.println("Características: " + getCaracteristicas());
        System.out.println("Disponible: " + (isDisponible() ? "Sí" : "No"));
        System.out.println("Deportiva: " + (esDeportiva ? "Sí" : "No"));
        System.out.println("ID del Vehículo: " + getID());
    }

    

}
