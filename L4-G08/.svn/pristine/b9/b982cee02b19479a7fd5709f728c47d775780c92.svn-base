/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uv.eu.photoeditor.view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

import java.awt.Color;

/**
 *
 * @author Natalia Tauste Rubio
 * @author Inés Jaso Pernod
 */
public class StatusPanel extends JPanel{
    private JLabel pincel;
    private JTextArea grosRec;
    private JLabel color1;
    private JTextArea col1; //Rectangulo con el color 1
    private JLabel color2;
    private JTextArea col2; //Rectangulo con el color 2

    public StatusPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        pincel = new JLabel("Grosor del rectángulo: ");
        grosRec = new JTextArea();
        grosRec.setEditable(false);
        grosRec.setPreferredSize(new Dimension(35, 15));
        grosRec.setMaximumSize(new Dimension(35, 15));
        grosRec.setMinimumSize(new Dimension(35, 15));
        color1 = new JLabel("Color 1: ");
        col1 = new JTextArea();
        col1.setBackground(Color.WHITE);
        col1.setEditable(false);
        col1.setPreferredSize(new Dimension(100, 20));
        col1.setMaximumSize(new Dimension(100, 20));
        col1.setMinimumSize(new Dimension(100, 20));
        color2 = new JLabel("Color 2: ");
        col2 = new JTextArea();
        col2.setBackground(Color.WHITE);
        col2.setEditable(false);
        col2.setPreferredSize(new Dimension(100, 20));
        col2.setMaximumSize(new Dimension(100, 20));
        col2.setMinimumSize(new Dimension(100, 20));

        this.add(pincel);
        this.add(grosRec);
        this.add(Box.createRigidArea(new Dimension(50, 0)));
        this.add(color1);
        this.add(col1);
        this.add(Box.createRigidArea(new Dimension(50, 0)));
        this.add(color2);
        this.add(col2);

        //this.setVisible(true);
    }

    public void setGrosRec(String grosRec) {
        this.grosRec.setText(grosRec);
    }

    public void setCol1(Color c1) {
        this.col1.setBackground(c1);
    }

    public void setCol2(Color c2) {
        this.col2.setBackground(c2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba StatusPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.add(new StatusPanel());
            frame.setVisible(true);
        });
    }
}