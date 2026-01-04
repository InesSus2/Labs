package Ahorcado.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 * 
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 */

public class NombreUsuPanel extends JPanel {
    private JTextArea nombreUsu;
    private JLabel texto;
    private Border borde;

    public NombreUsuPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        
        borde = BorderFactory.createLineBorder(Color.BLACK, 1);
        texto = new JLabel("NOMBRE DE USUARIO:");
        nombreUsu = new JTextArea("");
        nombreUsu.setBorder(borde);
        nombreUsu.setPreferredSize(new Dimension(150, 20));
        nombreUsu.setMaximumSize(new Dimension(150, 20));
        nombreUsu.setMinimumSize(new Dimension(150, 20));
        nombreUsu.setEditable(true);
        nombreUsu.setLineWrap(true);
        nombreUsu.setWrapStyleWord(true);

        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        nombreUsu.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(texto);
        this.add(nombreUsu);

        this.setVisible(true);
    }

    public String getNombreUsu() {
        return nombreUsu.getText();
    }

    public void resetNombreUsu() {
        nombreUsu.setText("");
        nombreUsu.setEditable(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba NombreUsuPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.add(new NombreUsuPanel());
            
            frame.setVisible(true);
        });
    }
}