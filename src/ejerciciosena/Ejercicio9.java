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
public class Ejercicio9 extends JFrame implements ActionListener {

    private JButton btnInfo, btnVolver, btnCalcular;
    private JLabel lTitulo, lNota, lNombre, lCantidad;
    private JTextField tfNota, tfNombre;
    private JTextArea txaResultado;
    private JScrollPane scpResultado;
    private int contadorMenor50 = 0, contador50Menor70 = 0, contador70Menor80 = 0, contador80 = 0, contadorEstudiantes = 0;
    private String nombreMenor50 = "", nombreMenor70 = "", nombreMenor80 = "", nombreMayor80 = "";
    private String[] nombreEstudiantes = new String[10];
    private double[] notasEstudiantes = new double[10];

    public Ejercicio9() {
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

        lTitulo = new JLabel("NOTAS DEL EXAMEN DE FÍSICA");
        lTitulo.setBounds(10, 50, 300, 30);
        lTitulo.setFont(new Font("SansSerif", 1, 17));
        lTitulo.setForeground(new Color(200, 200, 200));
        add(lTitulo);

        lNombre = new JLabel("Nombre del estudiante");
        lNombre.setBounds(10, 80, 200, 30);
        lNombre.setFont(new Font("SansSerif", 0, 14));
        lNombre.setForeground(new Color(200, 200, 200));
        add(lNombre);

        tfNombre = new JTextField("");
        tfNombre.setBounds(10, 110, 200, 25);
        tfNombre.setFont(new Font("SansSerif", 0, 14));
        tfNombre.setForeground(new Color(40, 40, 40));
        add(tfNombre);

        lNota = new JLabel("Nota");
        lNota.setBounds(240, 80, 100, 30);
        lNota.setFont(new Font("SansSerif", 0, 14));
        lNota.setForeground(new Color(200, 200, 200));
        add(lNota);

        tfNota = new JTextField("0");
        tfNota.setBounds(240, 110, 80, 25);
        tfNota.setFont(new Font("SansSerif", 0, 14));
        tfNota.setForeground(new Color(40, 40, 40));
        add(tfNota);

        btnCalcular = new JButton("Registrar");
        btnCalcular.setBounds(20, 150, 100, 25);
        btnCalcular.setFont(new Font("SansSerif", 0, 14));
        btnCalcular.setForeground(new Color(100, 100, 100));
        btnCalcular.addActionListener(this);
        add(btnCalcular);

        lCantidad = new JLabel("Registros: 0");
        lCantidad.setBounds(150, 150, 300, 30);
        lCantidad.setFont(new Font("SansSerif", 1, 17));
        lCantidad.setForeground(new Color(200, 200, 200));
        add(lCantidad);

        txaResultado = new JTextArea();
        txaResultado.setEditable(false); // para no editar o alterar el contenido del textarea
        txaResultado.setBackground(new Color(224, 224, 224)); //fondo    
        txaResultado.setFont(new Font("SansSerif", 0, 14));
        txaResultado.setForeground(new Color(40, 40, 40));
        txaResultado.setText("\n  Aqui aparece el resultado del calculo.");
        scpResultado = new JScrollPane(txaResultado);
        scpResultado.setBounds(20, 200, 300, 130);
        add(scpResultado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInfo) {
            JOptionPane.showMessageDialog(null, "Un grupo de 10 estudiantes presentan un examen de Física.\nHacer un algoritmo que lea por cada estudiante la calificación obtenida.\nLa nota mínima es 0 la máxima es 100.", "Evidencia 9", JOptionPane.INFORMATION_MESSAGE);
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
            if (contadorEstudiantes == 9) {
                btnCalcular.setText("Ver notas");
            }
            if (contadorEstudiantes == 10) {
                for (int i = 0; i < 10; i++) {
                    if (notasEstudiantes[i] < 50) {
                        contadorMenor50++;
                        nombreMenor50 += nombreEstudiantes[i] + ", ";
                    } else if (notasEstudiantes[i] < 70) {
                        contador50Menor70++;
                        nombreMenor70 += nombreEstudiantes[i] + ", ";
                    } else if (notasEstudiantes[i] < 80) {
                        contador70Menor80++;
                        nombreMenor80 += nombreEstudiantes[i] + ", ";
                    } else {
                        contador80++;
                        nombreMayor80 += nombreEstudiantes[i] + ", ";
                    }
                }
                txaResultado.setText("\nLa cantidad de estudiantes que obtuvieron una calificación menor a 50, fueron:\n" + contadorMenor50 + ", " + nombreMenor50
                        + "\nLa cantidad de estudiantes que obtuvieron una calificación de 50 o mas pero menor que 70, fueron:\n" + contador50Menor70 + ", " + nombreMenor70
                        + "\nLa cantidad de estudiantes que obtuvieron una calificación de 70 o mas pero menor que 80, fueron:\n" + contador70Menor80 + ", " + nombreMenor80
                        + "\nLa cantidad de estudiantes que obtuvieron una calificación de 80 o mas, fueron:\n" + contador80 + ", " + nombreMayor80
                );
                return;
            }
            nombreEstudiantes[contadorEstudiantes] = tfNombre.getText();
            notasEstudiantes[contadorEstudiantes] = Double.parseDouble(tfNota.getText());
            if (notasEstudiantes[contadorEstudiantes] < 1 || notasEstudiantes[contadorEstudiantes] > 100) {
                JOptionPane.showMessageDialog(null, "La nota del examen debe ser entre 1 y 100", "Evidencia 9", JOptionPane.WARNING_MESSAGE);
                return;
            }
            contadorEstudiantes++;
            lCantidad.setText("Registros: " + contadorEstudiantes);
            tfNombre.setText("");
            tfNota.setText("0");
        }
    }

    public static void main(String[] args) {
        Ejercicio9 ejercicio1 = new Ejercicio9();
        ejercicio1.setBounds(0, 0, 350, 400);
        ejercicio1.setVisible(true);
        ejercicio1.setResizable(false);
        ejercicio1.setLocationRelativeTo(null);//centrar ventana

    }

}
