package buildersVehiculos;

public class BuilderAuto extends BuilderVehiculo {

    boolean traccionDelantera;

    public void datosExtra() {
        super.datos();
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Ingrese si el auto es traccion delantera o no (si/no): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                this.traccionDelantera = true;
            } else {
                this.traccionDelantera = false;
            }
        }
    }

}
