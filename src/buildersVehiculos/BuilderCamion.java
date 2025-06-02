package buildersVehiculos;

public class BuilderCamion extends BuilderVehiculo{

    boolean acoplado;


    public void datosExtra() {
        super.datos();
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Ingrese si el camion tiene acoplado (si/no): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                this.acoplado = true;
            } else {
                this.acoplado = false;
            }
        }
    }

}
