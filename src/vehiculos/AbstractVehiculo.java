package vehiculos;

public abstract class AbstractVehiculo {

        protected String marca;
        protected String modelo;
        protected String color;
        protected ConfigAdicional equip_adicional;
        protected int numero_de_chasis;
        protected int num_de_motor;
        protected String caracteristicas;
        protected boolean disponible;

        public AbstractVehiculo(String marca, String modelo, String color, String equipAdicional, String chasis, String motor, String caracteristicas, String disponible, String atributoEspecifico, String id) {
            this.marca = marca;
            this.modelo = modelo;
            this.color = color;
            if ((equipAdicional.equals("Ninguno"))) {
                this.equip_adicional = new ConfigAdicional("Ninguno");
            } else {
                this.equip_adicional = new ConfigAdicional(equipAdicional);
            }
            this.numero_de_chasis = Integer.parseInt(chasis);
            this.num_de_motor = Integer.parseInt(motor);
            this.caracteristicas = caracteristicas;
            this.disponible = disponible.equalsIgnoreCase("Sí");

        }

        public abstract double impuestoNacionalAbstracto();
        public abstract double impuestoProvinvialAddAbstracto();

        public double impuestoProvincialGeneral() {
            // Implementación genérica, puede ser sobrescrita por subclases
            return 0.0;
        }
}
