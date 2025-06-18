package buildersVehiculos;

import vehiculos.ConfigAdicional;


public abstract class BuilderVehiculo {

    protected String marca;
    protected String modelo;
    protected String color;
    protected ConfigAdicional equip_adicional;
    protected int numero_de_motor;
    protected int numero_de_chasis;
    protected String caracteristicas;
    protected boolean disponible;

    public void datos() {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Ingrese la marca: ");
            this.marca = scanner.nextLine();

            System.out.print("Ingrese el modelo: ");
            this.modelo = scanner.nextLine();

            System.out.print("Ingrese el color: ");
            this.color = scanner.nextLine();

            System.out.print("Ingrese el número de motor: ");
            this.numero_de_motor = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            System.out.print("Ingrese el número de chasis: ");
            this.numero_de_chasis = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            System.out.print("Ingrese las características: ");
            this.caracteristicas = scanner.nextLine();

            System.out.print("¿Está disponible? (true/false): ");
            this.disponible = scanner.nextBoolean();
            scanner.nextLine(); // Limpiar buffer
        }

        // Suponiendo que ConfigAdicional tiene un constructor por defecto
        //this.equip_adicional = new ConfigAdicional();
    }

    public abstract void datosExtra();


}
