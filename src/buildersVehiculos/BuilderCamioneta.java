package buildersVehiculos;

public class BuilderCamioneta extends BuilderVehiculo {

    boolean cuatroxcuatro;

    public void datosExtra() {
        super.datos();
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Ingrese si la camioneta es 4x4 (si/no): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                this.cuatroxcuatro = true;
            } else {
                this.cuatroxcuatro = false;
            }
        }
    }

}
