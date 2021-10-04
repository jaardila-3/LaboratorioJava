package ejercicio3;

/**
 *
 * @author alex
 */
public class Cuenta {

    private String numero, tipo;
    private double saldoActual, saldoMinimo;

    public static Cuenta cuenta = new Cuenta();

    public Cuenta() {
    }

    public Cuenta(String numero, String tipo, double valorInicial) {
        if (cuenta.numero == null) {
            cuenta.numero = numero;
            cuenta.tipo = tipo;
            cuenta.saldoActual = valorInicial;
            cuenta.saldoMinimo = valorInicial * 0.1;
        }
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public void consignar(double monto) {
        saldoActual += monto;
    }

    public void retirar(double monto) {
        saldoActual -= monto;
    }

    public double getCapacidadCredito() {
        //comparar String con equals()
        return tipo.equals("credito") ? 3 * getSaldoActual()
                : getSaldoActual() - getSaldoMinimo();
    }

    public void reset() {
        cuenta.numero = null;
    }
}
