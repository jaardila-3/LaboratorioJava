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
public class Ejercicio1 extends JFrame implements ActionListener {

    private JButton btnInfo, btnVolver, btnCalcular;
    private JLabel lTitulo, lValorConsignar;
    private JTextField fldValorInicial;
    private double valor_inicial, valor_futuro;

    public Ejercicio1() {
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
        
        lTitulo = new JLabel("Banco");
        lTitulo.setBounds(80, 50, 300, 30);
        lTitulo.setFont(new Font("SansSerif", 1, 24));
        lTitulo.setForeground(new Color(200, 200, 200));
        add(lTitulo);
        
        lValorConsignar = new JLabel("Dinero a Consignar");
        lValorConsignar.setBounds(40, 80, 300, 30);
        lValorConsignar.setFont(new Font("SansSerif", 0, 16));
        lValorConsignar.setForeground(new Color(200, 200, 200));
        add(lValorConsignar);

        fldValorInicial = new JTextField();
        fldValorInicial.setBounds(40, 110, 150, 25);
        fldValorInicial.setFont(new Font("SansSerif", 0, 14));
        fldValorInicial.setForeground(new Color(100, 100, 100));
        add(fldValorInicial);

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
            JOptionPane.showMessageDialog(null, "Una persona deposita hoy al Banco cierta \ncantidad de dinero, donde le reconocen un \ninterés del 2% mensual, capitalizado mensualmente. \n¿Cuál será el saldo al cabo de 5 años? ", "Evidencia 1", JOptionPane.INFORMATION_MESSAGE);
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
            valor_inicial = Double.parseDouble(fldValorInicial.getText());
            valor_futuro = valor_inicial * (1+0.02) * 60;
            JOptionPane.showMessageDialog(null, "El valor consignado es de " + valor_inicial + ".\nEl valor a 5 años es de: " + valor_futuro, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        ejercicio1.setBounds(0, 0, 350, 300);
        ejercicio1.setVisible(true);
        ejercicio1.setResizable(false);
        ejercicio1.setLocationRelativeTo(null);//centrar ventana

    }

}
