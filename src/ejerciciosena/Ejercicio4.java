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
public class Ejercicio4 extends JFrame implements ActionListener {

    private JButton btnInfo, btnVolver, btnCalcular;
    private JLabel lTitulo, lNumeroPositivo;
    private JTextField fldNumeroPositivo;
    private int numero_positivo, cifra = 0, cuantos = 0, suma = 0;

    public Ejercicio4() {
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

        lTitulo = new JLabel("Cantidad de nùmeros");
        lTitulo.setBounds(60, 50, 300, 30);
        lTitulo.setFont(new Font("SansSerif", 1, 24));
        lTitulo.setForeground(new Color(200, 200, 200));
        add(lTitulo);

        lNumeroPositivo = new JLabel("Digita un nùmero entero positivo");
        lNumeroPositivo.setBounds(40, 80, 300, 30);
        lNumeroPositivo.setFont(new Font("SansSerif", 0, 16));
        lNumeroPositivo.setForeground(new Color(200, 200, 200));
        add(lNumeroPositivo);

        fldNumeroPositivo = new JTextField();
        fldNumeroPositivo.setBounds(40, 110, 150, 25);
        fldNumeroPositivo.setFont(new Font("SansSerif", 0, 14));
        fldNumeroPositivo.setForeground(new Color(100, 100, 100));
        add(fldNumeroPositivo);

        btnCalcular = new JButton("Ejecutar");
        btnCalcular.setBounds(40, 140, 100, 25);
        btnCalcular.setFont(new Font("SansSerif", 0, 14));
        btnCalcular.setForeground(new Color(100, 100, 100));
        btnCalcular.addActionListener(this);
        add(btnCalcular);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInfo) {
            JOptionPane.showMessageDialog(null, "Desarrollar un algoritmo que lea un número N entero positivo de cualquier número de dígitos, \n"
                    + "calcule la suma de sus dígitos y que imprima en pantalla el número leído y la suma de sus dígitos. \n"
                    + "Se requiere que en el desarrollo utilice la Estructura Cíclica Mientras. \n"
                    + "Ejemplo: \n"
                    + "N= 3567 SUMA= 21", "Evidencia 1", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == btnVolver) {
            Principal principal = new Principal();
            principal.setVisible(true);
            this.setVisible(false);
            principal.setBounds(0, 0, 350, 300);
            principal.setResizable(false);
            principal.setLocationRelativeTo(null);//centrar ventana
        }
        if (e.getSource() == btnCalcular) {
            try {
                numero_positivo = Integer.parseInt(fldNumeroPositivo.getText());
                if (numero_positivo > 0) {
                    while (numero_positivo > 0) {
                        cifra = numero_positivo % 10;
                        numero_positivo = (numero_positivo - cifra) / 10;
                        cuantos++;
                        suma += cifra;
                    }
                    JOptionPane.showMessageDialog(null, "El número tiene " + cuantos + " cifras\nLas cifras del número suman " + suma, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El número debe ser entero Positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                cifra = 0;
                cuantos = 0;
                suma = 0;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "El número no puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio4 ejercicio4 = new Ejercicio4();
        ejercicio4.setBounds(0, 0, 350, 300);
        ejercicio4.setVisible(true);
        ejercicio4.setResizable(false);
        ejercicio4.setLocationRelativeTo(null);//centrar ventana

    }

}
