package ejercicio4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class Banco {

    private String nombre;
    private List<Cliente> clientes = new ArrayList();
    private int numeroDeClientes;

    public static Banco banco = new Banco();

    private Banco() {
    }

    public Banco(String nombre) {
        banco.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroDeClientes() {
        return numeroDeClientes = clientes.size();
    }

    public Cliente getCliente(int position) {
        return clientes.get(position);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    

    public void addCliente(Cliente clie) {
        clientes.add(clie);
    }

    public void reset() {
        banco.nombre = null;
        banco.clientes = null;
        banco.numeroDeClientes = 0;
    }
}
