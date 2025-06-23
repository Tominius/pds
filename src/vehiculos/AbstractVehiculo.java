package vehiculos;

public abstract class AbstractVehiculo {
    // Atributos comunes a todos los vehículos
        private String id;
        protected String marca;
        protected String modelo;
        protected String color;
        protected ConfigAdicional equip_adicional;
        protected int numero_de_chasis;
        protected int num_de_motor;
        protected String caracteristicas;
        protected boolean disponible;

        public AbstractVehiculo(String marca, String modelo, String color, String equipAdicional, String chasis, String motor, String caracteristicas, String disponible, String atributoEspecifico, String id) {
            this.id = id;
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
            this.disponible = disponible.equalsIgnoreCase("Si");

        }

        public abstract double impuestoNacionalAbstracto();
        public abstract double impuestoProvinvialAddAbstracto();

        public double impuestoProvincialGeneral() {
            // Implementación genérica, puede ser sobrescrita por subclases
            return 0.0;
        }

        abstract public void imprimirDatos();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ConfigAdicional getEquip_adicional() {
        return equip_adicional;
    }

    public void setEquip_adicional(ConfigAdicional equip_adicional) {
        this.equip_adicional = equip_adicional;
    }

    public int getNumero_de_chasis() {
        return numero_de_chasis;
    }

    public void setNumero_de_chasis(int numero_de_chasis) {
        this.numero_de_chasis = numero_de_chasis;
    }

    public int getNum_de_motor() {
        return num_de_motor;
    }

    public void setNum_de_motor(int num_de_motor) {
        this.num_de_motor = num_de_motor;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getID() {
        return id;
    }
}
