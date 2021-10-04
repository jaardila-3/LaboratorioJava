package ejercicio4;

/**
 *
 * @author alex
 */
public abstract class Cliente {

    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    //Los métodos abstractos se escriben sin llaves {} y con ; al final
    public abstract String obtIdentificacion();

}
