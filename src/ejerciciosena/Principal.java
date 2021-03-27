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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author alex
 */
public class Principal extends JFrame implements ActionListener{
    private JMenuBar menu;
    private JMenu opciones;
    private JMenuItem ejercicio1, ejercicio2, ejercicio3,
            ejercicio4, ejercicio5, ejercicio6, ejercicio7, ejercicio8;
    private JLabel lLaboratorio, lAlex, lLuis;
    
    /**
     * constructor
     */
    public Principal(){
        setLayout(null); //posiciones manuales
        setTitle("Laboratorio Java");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(50,50,50));
        //inicializamos los atributos
        menu = new JMenuBar();
        menu.setBackground(Color.red);
        setJMenuBar(menu);
        
        opciones = new JMenu("Evidencias");        
        opciones.setFont(new Font("SansSerif", 0, 12));
        opciones.setForeground(new Color(255, 255, 255));
        menu.add(opciones);
        
        ejercicio1 = new JMenuItem("Ejercicio 1");        
        ejercicio2 = new JMenuItem("Ejercicio 2");
        ejercicio3 = new JMenuItem("Ejercicio 3");
        ejercicio4 = new JMenuItem("Ejercicio 4");
        ejercicio5 = new JMenuItem("Ejercicio 5");
        ejercicio6 = new JMenuItem("Ejercicio 6");
        ejercicio7 = new JMenuItem("Ejercicio 7");
        ejercicio8 = new JMenuItem("Ejercicio 8");
        
        opciones.add(ejercicio1);
        opciones.add(ejercicio2);
        opciones.add(ejercicio3);
        opciones.add(ejercicio4);
        opciones.add(ejercicio5);
        opciones.add(ejercicio6);
        opciones.add(ejercicio7);
        opciones.add(ejercicio8);
        
        ejercicio1.addActionListener(this);
        ejercicio2.addActionListener(this);
        ejercicio3.addActionListener(this);
        ejercicio4.addActionListener(this);
        ejercicio5.addActionListener(this);
        ejercicio6.addActionListener(this);
        ejercicio7.addActionListener(this);
        ejercicio8.addActionListener(this);
        
        lLaboratorio = new JLabel("Laboratorio Java");
        lLaboratorio.setBounds(70, 50, 300, 30);
        lLaboratorio.setFont(new Font("SansSerif", 1, 24));
        lLaboratorio.setForeground(new Color(200,200,200));
        add(lLaboratorio);
        
        lAlex = new JLabel("Jorge Alexander Ardila R.");
        lAlex.setBounds(60, 100, 300, 30);
        lAlex.setForeground(new Color(200,200,200));
        lAlex.setFont(new Font("SansSerif", 1, 18));
        add(lAlex);
        lLuis = new JLabel("Luis Miguel Mora C.");
        lLuis.setBounds(80, 150, 300, 30);
        lLuis.setForeground(new Color(200,200,200));
        lLuis.setFont(new Font("SansSerif", 1, 18));
        add(lLuis);       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         //To change body of generated methods, choose Tools | Templates.
      if(e.getSource()== ejercicio1){
          Ejercicio1 ejercicio = new Ejercicio1();
          //ejercicio.setVisible(true);
          //this.setVisible(false);
      }   
    }
    
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.setBounds(0, 0, 350, 300);
        principal.setVisible(true);
        principal.setResizable(false);
        principal.setLocationRelativeTo(null);//centrar ventana
        
    }
    
}
