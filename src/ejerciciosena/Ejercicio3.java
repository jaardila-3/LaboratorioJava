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

/**
 *
 * @author alex
 */
public class Ejercicio3 extends JFrame implements ActionListener {

    private JButton btnInfo, btnVolver, btnCalcular;
    private JLabel lTitulo, lFormula;
    private int y, sumaTodos = 0, sumaTres = 0, contadorTres = 0, sumaCinco = 0, contadorCinco = 0;
    private int arrayTres[] = new int[10];
    private int arrayCinco[] = new int[10];

    public Ejercicio3() {
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

        lTitulo = new JLabel("Función");
        lTitulo.setBounds(80, 50, 300, 30);
        lTitulo.setFont(new Font("SansSerif", 1, 24));
        lTitulo.setForeground(new Color(200, 200, 200));
        add(lTitulo);

        lFormula = new JLabel("y = x^2 - 2x");
        lFormula.setBounds(80, 80, 200, 30);
        lFormula.setFont(new Font("SansSerif", 0, 18));
        lFormula.setForeground(new Color(200, 200, 200));
        add(lFormula);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 120, 100, 25);
        btnCalcular.setFont(new Font("SansSerif", 0, 14));
        btnCalcular.setForeground(new Color(100, 100, 100));
        btnCalcular.addActionListener(this);
        add(btnCalcular);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInfo) {
            JOptionPane.showMessageDialog(null, "Dada la siguiente función: \n"
                    + "Y= x^2 – 2x \n"
                    + "Se requiere desarrollar un algoritmo que imprima en pantalla, para valores de x desde 1 a 10, lo siguiente: \n"
                    + "\ta. La suma de todos los valores de Y. \n"
                    + "\tb. Valores de Y múltiplos de 3. \n"
                    + "\tc. Suma de los valores de Y múltiplos de 3. \n"
                    + "\td. Valores de Y cuyo último digito sea 5. \n"
                    + "\te. Suma de los valores de Y cuyo último digito es 5. ", "Evidencia 3", JOptionPane.INFORMATION_MESSAGE);
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
            for (int x = 1; x <= 10; x++) {
                y = (int) ((Math.pow(x, 2)) - (2 * x));
                sumaTodos += y;
                if (y > 0) {
                    if (y % 3 == 0) {
                        sumaTres += y;
                        arrayTres[contadorTres] = y;
                        contadorTres++;
                    }
                    if (y % 10 == 5) {
                        sumaCinco += y;
                        arrayCinco[contadorCinco] = y;
                        contadorCinco++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "La suma de todos los valores de y es: " + sumaTodos, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Los múltiplos de tres son:", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            for (int i = 0; i < contadorTres; i++) {
                JOptionPane.showMessageDialog(null, arrayTres[i], "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "La suma de los múltiplos de tres es: " + sumaTres, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Valores de y cuyo ùltimo dìgito es cinco:", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            for (int i = 0; i < contadorCinco; i++) {
                JOptionPane.showMessageDialog(null, arrayCinco[i], "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "La suma de los valores de y cuyo ùltimo dìgito es mùltiplo de cinco es: " + sumaCinco, "Resultado", JOptionPane.INFORMATION_MESSAGE);

            sumaTodos = 0;
            sumaTres = 0;
            contadorTres = 0;
            sumaCinco = 0;
            contadorCinco = 0;

        }
    }

    public static void main(String[] args) {
        Ejercicio3 ejercicio3 = new Ejercicio3();
        ejercicio3.setBounds(0, 0, 350, 300);
        ejercicio3.setVisible(true);
        ejercicio3.setResizable(false);
        ejercicio3.setLocationRelativeTo(null);//centrar ventana

    }

}
