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
public class Ejercicio5 extends JFrame implements ActionListener {

    private JButton btnInfo, btnVolver, btnCalcular;
    private JLabel lTitulo;   
    private JTextArea resultado;
    private JScrollPane scpResultado;    
    private JLabel[] arrayLabel = new JLabel[6];
    private JTextField[] arrayTxt = new JTextField[6];
    private String[] nombreLabel = {"Cédula del empleado", "Nombre del empleado", "Salario Básico", "Días Laborados", "Ventas del mes", "Cuota del préstamo"};
    private String[] nombreTxt = {"", "", "0", "0", "0", "0"};
    private int cedula, diaslaborados;
    private String nombreEmpleado;    
    private double salarioBasico, ventasMes, prestamo, sueldoDevengado, 
            auxTransporte = 0, comisionVentas, totalDevendago, salarioNeto;
    private final double smmlv = 737717;

    public void ObtenerDatos(){
        cedula = Integer.parseInt(arrayTxt[0].getText()) ;
        nombreEmpleado = arrayTxt[1].getText();
        salarioBasico = Double.parseDouble(arrayTxt[2].getText());
        diaslaborados = Integer.parseInt(arrayTxt[3].getText());
        ventasMes = Double.parseDouble(arrayTxt[4].getText());
        prestamo = Double.parseDouble(arrayTxt[5].getText());        
    }
    
    public void Formulas(){
        sueldoDevengado=salarioBasico*diaslaborados/30;
        if (salarioBasico<=(smmlv*2)) {
            auxTransporte=83140*diaslaborados/30;
        }
        comisionVentas=ventasMes*0.02;
        totalDevendago=sueldoDevengado+comisionVentas;
        salarioNeto=totalDevendago+auxTransporte-prestamo;
    }
    
    public void LimpiarPantalla(){
        arrayTxt[0].setText("");
        arrayTxt[1].setText("");
        arrayTxt[2].setText("0");
        arrayTxt[3].setText("0");
        arrayTxt[4].setText("0");
        arrayTxt[5].setText("0");
    }
    
    public void Resultado() {
        resultado.setText("\nLa cedula del empleado es: " + cedula
                + "\nEl nombre del empleado es: " + nombreEmpleado
                + "\nEl salario básico es de: " + salarioBasico 
                + "\nEl auxilio de transporte es: " + auxTransporte
                + "\nLa comisión por ventas es: " + comisionVentas
                + "\nLa cuota del préstamo es: " + prestamo
                + "\nEl salario neto a recibir es: " + salarioNeto
        );
    }
    
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
        
        lTitulo = new JLabel("DATOS DEL EMPLEADO");
        lTitulo.setBounds(40, 50, 300, 30);
        lTitulo.setFont(new Font("SansSerif", 1, 20));
        lTitulo.setForeground(new Color(200, 200, 200));
        add(lTitulo);
        
        int x = 40, y = 80;
        for (int i = 0; i < 6; i++) {
            arrayLabel[i]=new JLabel(nombreLabel[i]);
            arrayLabel[i].setBounds(x, y, 300, 25);
            arrayLabel[i].setFont(new Font("SansSerif", 0, 14));
            arrayLabel[i].setForeground(new Color(200, 200, 200));
            add(arrayLabel[i]);
            y += 30;
            
            arrayTxt[i]=new JTextField (nombreTxt[i]);
            arrayTxt[i].setBounds(x, y, 300, 25);
            arrayTxt[i].setFont(new Font("SansSerif", 0, 14));
            arrayTxt[i].setForeground(new Color(40, 40, 40));
            add(arrayTxt[i]);
            y += 30;
        }
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(130, 450, 100, 25);
        btnCalcular.setFont(new Font("SansSerif", 0, 14));
        btnCalcular.setForeground(new Color(100, 100, 100));
        btnCalcular.addActionListener(this);
        add(btnCalcular);
        
        resultado = new JTextArea();
        resultado.setEditable(false); // para no editar o alterar el contenido del textarea
        resultado.setBackground(new Color(224, 224, 224)); //fondo    
        resultado.setFont(new Font("SansSerif", 0, 14));
        resultado.setForeground(new Color(40, 40, 40));
        resultado.setText("\n  Aqui aparece el resultado del calculo.");
        scpResultado = new JScrollPane(resultado);
        scpResultado.setBounds(40, 490, 300, 140);
        add(scpResultado);        
    }
        

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInfo) {
            JOptionPane.showMessageDialog(null, "desarrollar un algoritmo que calcule el salario neto \n"
                    + "que debe recibir un vendedor de un almacén. "
                    + "\nSe debe tener en cuenta si tiene derecho o no al "
                    + "\nauxilio de transporte.", "Evidencia 5", JOptionPane.INFORMATION_MESSAGE);
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
            ObtenerDatos();
            Formulas();
            Resultado();
            LimpiarPantalla();            
        }
    }
    
    public static void main(String[] args) {
        Ejercicio5 ejercicio = new Ejercicio5();
        ejercicio.setBounds(0, 0, 400, 700);
        ejercicio.setVisible(true);
        ejercicio.setResizable(false);
        ejercicio.setLocationRelativeTo(null);//centrar ventana
    }

}
