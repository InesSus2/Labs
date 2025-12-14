package Ahorcado.view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 */

public class ImagenIniPanel extends JPanel { ///HACER IGUAL QUE IMAGENFALLOSPANEL O ImagePanel (Practica 4)
    ///PANEL PARA PONER LA IMAGEN DEL AHORCADO
    private JLabel imagenAhorcado;
    public ImagenIniPanel() {
        // Constructor vacío por ahora
        this.setBackground(Color.WHITE);

        imagenAhorcado = new JLabel("IMAGEN INICIO DEL AHORCADO");

        this.add(imagenAhorcado);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba ImagenJuegoPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new ImagenIniPanel());
            
            frame.setVisible(true);
        });
    }
}
