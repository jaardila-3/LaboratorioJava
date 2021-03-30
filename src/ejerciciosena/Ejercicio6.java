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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author alex
 */
public class Ejercicio6 extends JFrame implements ActionListener {

    private JButton btnInfo, btnVolver, btnCalcular;
    private JLabel lTitulo;
    private int contador=1, resultado;
    private String secuencia="\n";
    private JTextArea txaResultado;
    private JScrollPane scpResultado;   

    public Ejercicio6() {
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
        
        lTitulo = new JLabel("1, 3, 6, 10, 15, 21, 28,……");
        lTitulo.setBounds(40, 50, 300, 30);
        lTitulo.setFont(new Font("SansSerif", 1, 14));
        lTitulo.setForeground(new Color(200, 200, 200));
        add(lTitulo);
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 90, 100, 25);
        btnCalcular.setFont(new Font("SansSerif", 0, 14));
        btnCalcular.setForeground(new Color(100, 100, 100));
        btnCalcular.addActionListener(this);
        add(btnCalcular);
        
        txaResultado = new JTextArea();
        txaResultado.setEditable(false); // para no editar o alterar el contenido del textarea
        txaResultado.setBackground(new Color(224, 224, 224)); //fondo    
        txaResultado.setFont(new Font("SansSerif", 0, 14));
        txaResultado.setForeground(new Color(40, 40, 40));
        txaResultado.setText("\n  Aqui aparece el resultado del calculo.");
        scpResultado = new JScrollPane(txaResultado);
        scpResultado.setBounds(30, 120, 270, 130);
        add(scpResultado);     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInfo) {
            JOptionPane.showMessageDialog(null, "hacer un algoritmo que imprima los primeros\n20 términos de la siguiente serie:", "Evidencia 6", JOptionPane.INFORMATION_MESSAGE);
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
            while (contador<=20) {                
                resultado=contador+1;
		resultado*=contador;
		resultado/=2;
                secuencia += resultado+"\n";                
                contador++;                
            }
         txaResultado.setText(secuencia);         
        }
    }
    
    public static void main(String[] args) {
        Ejercicio6 ejercicio1 = new Ejercicio6();
        ejercicio1.setBounds(0, 0, 350, 300);
        ejercicio1.setVisible(true);
        ejercicio1.setResizable(false);
        ejercicio1.setLocationRelativeTo(null);//centrar ventana

    }

}
