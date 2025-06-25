package vehiculos;

public class ConfigAdicional {

    boolean existencia;


    public ConfigAdicional(String equipAdicional) {
        if (equipAdicional.equalsIgnoreCase("Ninguno")) {
            this.existencia = false; // No hay equipamiento adicional
        } else {
            this.existencia = true; // Hay equipamiento adicional
        }
    }
}
