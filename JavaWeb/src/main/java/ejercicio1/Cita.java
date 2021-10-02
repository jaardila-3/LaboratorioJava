/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author alex
 */
public class Cita {
    private int numero, tipo;
    private double tarifa, valorFinal;

    //constructor vacío
    //public Cita(){}
    //constructor con params
    public Cita(int numero, int tipo, double tarifa) {
        this.numero = numero;
        this.tipo = tipo;
        this.tarifa = tarifa;
    }

    //getters
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        String tipoStr = (tipo >= 1 && tipo <= 3) ? "general" : "especialista";
        return tipoStr;
    }

    public double getTarifa() {
        return tarifa;
    }

    public double calcularValorFinal() {
        return valorFinal = (getTipo() == "general") ? getTarifa() * 0.5 : getTarifa() * 1.5;
    }
}
