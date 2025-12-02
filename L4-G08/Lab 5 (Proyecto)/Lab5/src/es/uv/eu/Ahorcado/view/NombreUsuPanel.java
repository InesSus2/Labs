package Ahorcado.view;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class NombreUsuPanel extends JPanel {
    private JTextArea nombreUsu;
    private JLabel texto;

    public NombreUsuPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        texto = new JLabel("NOMBRE DE USUARIO:");
        nombreUsu = new JTextArea();
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

    public JTextArea getNombreUsu() {
        return nombreUsu;
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