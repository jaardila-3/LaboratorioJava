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
public class Ejercicio8 extends JFrame implements ActionListener {

    private JButton btnInfo, btnVolver, btnCalcular;
    private JLabel lTitulo, lDuracion;
    private JTextField tfDuracion;   
    private double costo, minutos;

    public Ejercicio8() {
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
        
        lTitulo = new JLabel("llamada telefónica");
        lTitulo.setBounds(40, 50, 300, 30);
        lTitulo.setFont(new Font("SansSerif", 1, 24));
        lTitulo.setForeground(new Color(200, 200, 200));
        add(lTitulo);
        
        lDuracion = new JLabel("Duración de la llamada");
        lDuracion.setBounds(70, 80, 200, 30);
        lDuracion.setFont(new Font("SansSerif", 0, 14));
        lDuracion.setForeground(new Color(200, 200, 200));
        add(lDuracion);
        
        tfDuracion=new JTextField("1");
        tfDuracion.setBounds(70, 110, 150, 25);
        tfDuracion.setFont(new Font("SansSerif", 0, 14));
        tfDuracion.setForeground(new Color(40, 40, 40));
        add(tfDuracion);
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(90, 150, 100, 25);
        btnCalcular.setFont(new Font("SansSerif", 0, 14));
        btnCalcular.setForeground(new Color(100, 100, 100));
        btnCalcular.addActionListener(this);
        add(btnCalcular);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInfo) {
            JOptionPane.showMessageDialog(null, "Hacer un algoritmo que imprima el costo de una llamada telefónica,\ncapturando la duración de la llamada en minutos", "Evidencia 8", JOptionPane.INFORMATION_MESSAGE);
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
            minutos = Double.parseDouble(tfDuracion.getText());
            if (minutos<=3) {
                costo=200;
            }else{
                minutos-=3;
		minutos*=30;
		costo=minutos+200;
            }
        JOptionPane.showMessageDialog(null, "El costo de la llamada telefónica es de: "+costo+" pesos", "Factura", JOptionPane.INFORMATION_MESSAGE);

        }
    }
    
    public static void main(String[] args) {
        Ejercicio8 ejercicio1 = new Ejercicio8();
        ejercicio1.setBounds(0, 0, 350, 300);
        ejercicio1.setVisible(true);
        ejercicio1.setResizable(false);
        ejercicio1.setLocationRelativeTo(null);//centrar ventana

    }

}
