package ejercicio2;

/**
 *
 * @author alex
 */
public class Bus {

    private String placa;
    private int capacidadPasajeros, pasajerosActuales, totalPasajeros;
    private double precioPasaje;

    public static Bus bus = new Bus();

    public Bus() {
    }

    public Bus(String placa, int capacidadPasajeros, double precioPasaje) {
//        this.placa = placa;
//        this.capacidadPasajeros = capacidadPasajeros;
//        this.precioPasaje = precioPasaje;
        if (bus.placa == null) {
            bus.placa = placa;
            bus.capacidadPasajeros = capacidadPasajeros;
            bus.precioPasaje = precioPasaje;
        }

    }

    public String getPlaca() {
        return placa;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public int getPasajerosActuales() {
        return pasajerosActuales;
    }

    public int getTotalPasajeros() {
        return totalPasajeros;
    }

    public double getPrecioPasaje() {
        return precioPasaje;
    }

    public void setPasajerosActuales(int pasajerosActuales) {
        this.pasajerosActuales = pasajerosActuales;
    }

    public void setTotalPasajeros(int totalPasajeros) {
        this.totalPasajeros = totalPasajeros;
    }

    public void subirPasajeros(int pasajeros) {
        int pasajerosBus = getPasajerosActuales() + pasajeros;
        setPasajerosActuales(pasajerosBus);
        int totalBus = getTotalPasajeros() + pasajeros;
        setTotalPasajeros(totalBus);
    }

    public void bajarPasajeros(int pasajeros) {
        int pasajerosBus = getPasajerosActuales() - pasajeros;
        setPasajerosActuales(pasajerosBus);
    }

    public double getDineroAcumulado() {
        return (getTotalPasajeros() * getPrecioPasaje());
    }
    
    public void reset(){
        bus.placa = null;
        bus.pasajerosActuales = 0;
        bus.totalPasajeros = 0;
    }
}
