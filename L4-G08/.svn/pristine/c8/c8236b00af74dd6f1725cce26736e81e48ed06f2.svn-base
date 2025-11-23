/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uv.eu.photoeditor.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;

//import es.uv.eu.photoeditor.view.ColorPanel;
/**
 *
 * @author Natalia Tauste Rubio
 * @author Inés Jaso Pernod
 */
public class SelectPanel extends JPanel{
    private ColorPanel panelArriba;
    private ColorPanel panelAbajo;
    
    public SelectPanel(){
        this.setLayout(new GridLayout(2, 1));
        panelArriba= new ColorPanel(1);
        panelAbajo= new ColorPanel(2);
        
        this.add(panelArriba);
        this.add(panelAbajo);
    }
    
      public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba NumberPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.add(new SelectPanel());
            
            frame.setVisible(true);
        });
    }
    
    
    
}
