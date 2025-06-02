package buildersVehiculos;


public class BuilderMoto extends BuilderVehiculo {

    int cilindrada;

    @Override
    public void datosExtra() {
        super.datos();
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Ingrese la cilindrada de la moto: ");
            this.cilindrada = scanner.nextInt();
        }
    }
    
}
