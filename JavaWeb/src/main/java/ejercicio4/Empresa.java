package ejercicio4;

/**
 *
 * @author alex
 */
public class Empresa extends Cliente {

    private String nit;
    private String representante;

    @Override
    public String obtIdentificacion() {
        return nit;
    }

    public Empresa(String nit, String representante, String nombre) {
        super(nombre);
        this.nit = nit;
        this.representante = representante;
    }

    public String getRepresentante() {
        return representante;
    }

    public String cambiarRepres(String repres) {
        this.representante = repres;
        return representante;
    }
    
    @Override
    public String obtTipo(){ return "Empresa";}
}
