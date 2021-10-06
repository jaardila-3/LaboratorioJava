package ejercicio4;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class Banco {

    private String nombre;
    private ArrayList<Cliente> clientes;
    private ArrayList<Persona> personas;
    private ArrayList<Empresa> empresas;
    private int numeroDeClientes;

    public static Banco banco = new Banco();

    private Banco() {
        clientes = new ArrayList<Cliente>();
        personas = new ArrayList<Persona>();
        empresas = new ArrayList<Empresa>();
    }

    public Banco(String nombre) {
        if (banco.nombre == null) {
            banco.nombre = nombre;
            banco.clientes = new ArrayList<Cliente>();
            banco.personas = new ArrayList<Persona>();
            banco.empresas = new ArrayList<Empresa>();
        }
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

    public ArrayList<Cliente> getClientes() {
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
    }

    //OTROS METODOS IMPLEMENTADOS
    public void addPersona(Persona clie) {
        personas.add(clie);
    }

    public void addEmpresa(Empresa clie) {
        empresas.add(clie);
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }
}
