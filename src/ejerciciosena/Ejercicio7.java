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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author alex
 */
public class Ejercicio7 extends JFrame implements ActionListener, ChangeListener {

    private JButton btnInfo, btnVolver, btnCalcular, btnEstadistica, btnRegistrar;
    private JLabel lTitulo, lEdad, lGenero;
    private JTextField tfEdad;
    private JRadioButton rbhombre, rbmujer;
    private ButtonGroup bg;  //en grupo para que al seleccionar uno se desmarque el otro  
    private int edad, contador=0, contadorHombres=0, contadorMujeres=0, sexo, sumaEdadMujeres=0, sumaEdadHombres=0, masjoven=200;
    private double promedioEdadHombres=0, promedioEdadMujeres=0;

    public Ejercicio7() {
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
        
        lTitulo = new JLabel("FIESTA");
        lTitulo.setBounds(80, 50, 200, 30);
        lTitulo.setFont(new Font("SansSerif", 1, 24));
        lTitulo.setForeground(new Color(200, 200, 200));
        add(lTitulo);
        
        lEdad = new JLabel("Edad en años");
        lEdad.setBounds(10, 80, 200, 30);
        lEdad.setFont(new Font("SansSerif", 0, 14));
        lEdad.setForeground(new Color(200, 200, 200));
        add(lEdad);
        
        lGenero = new JLabel("Genero");
        lGenero.setBounds(190, 80, 200, 30);
        lGenero.setFont(new Font("SansSerif", 0, 14));
        lGenero.setForeground(new Color(200, 200, 200));
        add(lGenero);
        
        tfEdad=new JTextField("0");
        tfEdad.setBounds(10, 110, 100, 25);
        tfEdad.setFont(new Font("SansSerif", 0, 14));
        tfEdad.setForeground(new Color(40, 40, 40));
        add(tfEdad);
        
        btnRegistrar = new JButton("Registar");
        btnRegistrar.setBounds(10, 150, 100, 30);
        btnRegistrar.setFont(new Font("SansSerif", 0, 16));
        btnRegistrar.setBackground(new Color(100, 100, 100));
        btnRegistrar.setForeground(new Color(200, 200, 200));
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);
        // Botón de Volver al inicio
        btnEstadistica = new JButton("Ver Estadísticas");
        btnEstadistica.setBounds(120, 150, 200, 30);
        btnEstadistica.setFont(new Font("SansSerif", 0, 16));
        btnEstadistica.setBackground(new Color(100, 100, 100));
        btnEstadistica.setForeground(new Color(200, 200, 200));
        btnEstadistica.addActionListener(this);
        add(btnEstadistica);
        
        bg=new ButtonGroup();        
        
        rbhombre=new JRadioButton("Hombre");
        rbhombre.setBounds(120,110,100,25);
        rbhombre.addChangeListener(this);
        add(rbhombre);
        bg.add(rbhombre);
        
        rbmujer=new JRadioButton("Mujer");
        rbmujer.setBounds(220,110,100,25);
        rbmujer.addChangeListener(this);        
        add(rbmujer);
        bg.add(rbmujer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInfo) {
            JOptionPane.showMessageDialog(null, "desarrollar un algoritmo que permita"
                    + "\ncalcular los siguientes datos de una fiesta:\n" +
                    "​\n" +"¿Cuántas personas asistieron a la fiesta?\n" +
                    "¿Cuántos hombres y cuantas mujeres?\n" +
                    "-Promedio de edades por sexo\n" +
                    "-La edad de la persona más joven que asistió", "Evidencia 7", JOptionPane.INFORMATION_MESSAGE);
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
        if (e.getSource() == btnRegistrar) {            
            edad = Integer.parseInt(tfEdad.getText());
            if (edad<18) {
                JOptionPane.showMessageDialog(null, "No se permiten menores de edad", "Edad", JOptionPane.ERROR_MESSAGE);
                tfEdad.setText("0");                
                return;
            }
            if (rbhombre.isSelected()) {
                contadorHombres++;
                sumaEdadHombres+=edad;
                contador++;
                if (edad<masjoven) {
                    masjoven=edad;
                }
            }
            else if(rbmujer.isSelected()){
                contadorMujeres++;
                sumaEdadMujeres+=edad;
                contador++;
                if (edad<masjoven) {
                    masjoven=edad;
                }
            }else{
                JOptionPane.showMessageDialog(null, "Escoja el genero", "Genero", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);  
            tfEdad.setText("0");  
        }
        
        if (e.getSource() == btnEstadistica) {
            if (contadorHombres==0) {
                promedioEdadHombres=0;
            }else{
                promedioEdadHombres=sumaEdadHombres/contadorHombres;
            }
            
            if (contadorMujeres==0) {
                promedioEdadMujeres=0;
            }else{
                promedioEdadMujeres=sumaEdadMujeres/contadorMujeres;
            }
            JOptionPane.showMessageDialog(null, "A la fiesta asistieron: "+contador+" personas"
                    +"\nA la fiesta asistieron "+contadorHombres+" hombres y "+contadorMujeres+" mujeres"
                    +"\nLa edad promedio entre los hombres es de: "+promedioEdadHombres+" y entre mujeres de: "+promedioEdadMujeres
                    +"\nla edad de la persona mas joven es: "+ masjoven
                    , "Estadística", JOptionPane.INFORMATION_MESSAGE);  
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent ce) {
        if (rbhombre.isSelected()) {
            
        }
        if (rbmujer.isSelected()) {
           
        }
    }
    
    public static void main(String[] args) {
        Ejercicio7 ejercicio1 = new Ejercicio7();
        ejercicio1.setBounds(0, 0, 350, 300);
        ejercicio1.setVisible(true);
        ejercicio1.setResizable(false);
        ejercicio1.setLocationRelativeTo(null);//centrar ventana
    }
}
