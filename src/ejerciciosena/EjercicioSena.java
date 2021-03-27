/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosena;

import javax.swing.JOptionPane;

/**
 * 
 * @author alex
 */
public class EjercicioSena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Double valorKilo = 4200D;
        Float kilosVendidos;
        Float descuento = 0F;
        Double subTotal;
        Double total;        

        System.out.println("Algo");
        kilosVendidos = Float.parseFloat(JOptionPane.showInputDialog("Ingrese los kilos a comprar."));
        subTotal = kilosVendidos * valorKilo;


        // Se valida si tiene descuento 
        /**
         * Si esta entre 0-2 descuento 0% Si esta entre 2.01-5 descuento 10% Si
         * esta entre 5.01-10 descuento 15% Si esta entre 10.01 descuento 20%
         */
        if (kilosVendidos < 2) {
            total = subTotal;
        } else if (kilosVendidos < 5) {
            descuento = 10F;
            total = subTotal - (subTotal * (descuento / 100));
        } else if (kilosVendidos < 10) {
            descuento = 15F;
            total = subTotal - (subTotal * (descuento / 100));
        } else {
            descuento = 20F;
            total = subTotal - (subTotal * (descuento / 100));
        }

        System.out.println("La compra de " + kilosVendidos + " kilos tiene un valor de $" + subTotal + "\nDescuento por compra de1 " + descuento + "% \nValor con el decuento es de $" + total + " \n");
        JOptionPane.showMessageDialog(null, "La compra de " + kilosVendidos + " kilos tiene un valor de $" + subTotal + "\nDescuento por compra de1 " + descuento + "% \nValor con el decuento es de $" + total + " \n");

    

    }
    
}
