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

        public abstract double impuestoNacionalAbstracto();
        public abstract double impuestoProvinvialAddAbstracto();

        public double impuestoProvincialGeneral() {
            // Implementación genérica, puede ser sobrescrita por subclases
            return 0.0;
        }
}
