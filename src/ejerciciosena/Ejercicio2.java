/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosena;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alex
 */
public class Ejercicio2 extends JFrame implements ActionListener {

    private JButton btnInfo, btnVolver, btnCalcular;
    private JLabel lTitulo, lCantidadKilos;
    private JTextField fldCantidadKilos;
    private final double valor_kilo = 4200;
    private double cantidad_kilos, descuento = 0, valor_bruto, valor_total;

    public Ejercicio2() {
        setLayout(null); //posiciones manuales
        setTitle("Laboratorio Java");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(50, 50, 50));

        // Botón del enunciado
        btnInfo = new JButton("Enuciado");
        btnInfo.setBounds(10, 10, 100, 30);
        btnInfo.setFont(new Font("SansSerif", 0, 16));
        btnInfo.setBackground(new Color(100, 100, 100));
        btnInfo.setForeground(new Color(200, 200, 200));
        btnInfo.addActionListener(this);
        add(btnInfo);
        // Botón de Volver al inicio
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(115, 10, 100, 30);
        btnVolver.setFont(new Font("SansSerif", 0, 16));
        btnVolver.setBackground(new Color(100, 100, 100));
        btnVolver.setForeground(new Color(200, 200, 200));
        btnVolver.addActionListener(this);
        add(btnVolver);

        lTitulo = new JLabel("Frutería");
        lTitulo.setBounds(80, 50, 300, 30);
        lTitulo.setFont(new Font("SansSerif", 1, 24));
        lTitulo.setForeground(new Color(200, 200, 200));
        add(lTitulo);

        lCantidadKilos = new JLabel("Peso de la fruta");
        lCantidadKilos.setBounds(40, 80, 300, 30);
        lCantidadKilos.setFont(new Font("SansSerif", 0, 16));
        lCantidadKilos.setForeground(new Color(200, 200, 200));
        add(lCantidadKilos);

        fldCantidadKilos = new JTextField();
        fldCantidadKilos.setBounds(40, 110, 150, 25);
        fldCantidadKilos.setFont(new Font("SansSerif", 0, 14));
        fldCantidadKilos.setForeground(new Color(100, 100, 100));
        add(fldCantidadKilos);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(40, 140, 100, 25);
        btnCalcular.setFont(new Font("SansSerif", 0, 14));
        btnCalcular.setForeground(new Color(100, 100, 100));
        btnCalcular.addActionListener(this);
        add(btnCalcular);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInfo) {
            JOptionPane.showMessageDialog(null, "Una frutería ofrece las manzanas a $4.200 el kilo, con un descuento según los kilos comprados. \nDesarrollar un algoritmo que permita a la frutería y al cliente conocer cuanto pagará un cliente que compre manzanas. ", "Evidencia 2", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == btnVolver) {
            Principal principal = new Principal();
            principal.setVisible(true);
            principal.setBounds(0, 0, 350, 300);
            principal.setResizable(false);
            principal.setLocationRelativeTo(null);
            //cierra la ventana mas no la aplicación.
            this.dispose();
        }
        if (e.getSource() == btnCalcular) {
            cantidad_kilos = Double.parseDouble(fldCantidadKilos.getText());
            valor_bruto = cantidad_kilos * valor_kilo;
            if (cantidad_kilos <= 2) {
                valor_total = valor_bruto;
            } else if (cantidad_kilos <= 5) {
                descuento = 10;
            } else if (cantidad_kilos <= 10) {
                descuento = 15;
            } else {
                descuento = 20;
            }
            valor_total = valor_bruto - (valor_bruto * (descuento / 100));
            JOptionPane.showMessageDialog(null, "La compra de " + cantidad_kilos + " kilos tiene un valor de $" + valor_bruto + "\nDescuento por compra del " + descuento + "% \nValor con el decuento es de $" + valor_total + " \n", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Ejercicio2 ejercicio2 = new Ejercicio2();
        ejercicio2.setBounds(0, 0, 350, 300);
        ejercicio2.setVisible(true);
        ejercicio2.setResizable(false);
        ejercicio2.setLocationRelativeTo(null);//centrar ventana
    }

}
