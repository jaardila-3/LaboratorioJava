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
public class Ejercicio5 extends JFrame implements ActionListener {

    private JButton btnInfo, btnVolver, btnCalcular;
    private JLabel lTitulo;

    public Ejercicio5() {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInfo) {
            JOptionPane.showMessageDialog(null, "%MESG%", "Evidencia 1", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == btnVolver) {
            Principal principal = new Principal();
            principal.setVisible(true);
            this.setVisible(false);
            principal.setBounds(0, 0, 350, 300);
            principal.setResizable(false);
            principal.setLocationRelativeTo(null);//centrar ventana
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
