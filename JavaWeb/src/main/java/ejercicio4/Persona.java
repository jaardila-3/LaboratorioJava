package ejercicio4;

/**
 *
 * @author alex
 */
public class Persona extends Cliente {

    private String cedula;
    private int edad;

    public Persona(String cedula, int edad, String nombre) {
        super(nombre); // de la clase padre
        this.cedula = cedula;
        this.edad = edad;
    }

    @Override
    public String obtIdentificacion() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }
    
    public void cumplirAños(){}

}
