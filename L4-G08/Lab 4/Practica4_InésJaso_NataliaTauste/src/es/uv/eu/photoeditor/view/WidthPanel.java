/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uv.eu.photoeditor.view;
import java.awt.Component;
import java.io.ObjectInputFilter.Status;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Natalia Tauste Rubio
 * @author Inés Jaso Pernod
 */
public class WidthPanel extends JPanel{
     private JLabel texto;
     private JSlider slider;
     private StatusPanel sp;

    public WidthPanel(StatusPanel sp){
        this.sp = sp;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        texto = new JLabel("Grosor del rectángulo: ");
        slider = new JSlider(1, 1000, 5);
        slider.setPaintTicks(true);          //que pinte las “rayitas”
        slider.setMajorTickSpacing(100);       //separación entre marcas “grandes”
        slider.setMinorTickSpacing(1);       //marcas pequeñas entre medias
        slider.setPaintLabels(true);

        slider.addChangeListener(e -> {
            int valor = slider.getValue();
            sp.setGrosRec(String.valueOf(valor));  // ← actualizar el otro panel
        });
        
        
        texto.setAlignmentX(Component.LEFT_ALIGNMENT);
        slider.setAlignmentX(Component.LEFT_ALIGNMENT); //Es necesario poner este pq sino se alinea con el slider al medio no a la izquierda
        //texto.setHorizontalAlignment(SwingConstants.LEFT);
        
        this.add(texto);
        this.add(slider);
    }
     
    public JSlider getSlider() {
        return slider;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba NumberPanel");
            StatusPanel sp = new StatusPanel();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.add(new WidthPanel(sp));
            
            frame.setVisible(true);
        });
    }
}