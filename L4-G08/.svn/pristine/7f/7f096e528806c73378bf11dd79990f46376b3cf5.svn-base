package Ahorcado.view;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class LetrasUtilJuegoPanel extends JPanel {
    private JLabel letrasUtilesLabel;
    private JLabel puntuUsuLabel;
    private JLabel puntuacionUsuLabel;
    private JTextArea letrasUtilesArea;

    public LetrasUtilJuegoPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel puntuPanel = new JPanel();
        puntuPanel.setLayout(new BoxLayout(puntuPanel, BoxLayout.X_AXIS));
        puntuUsuLabel = new JLabel("Puntuación actual:");
        puntuacionUsuLabel = new JLabel("   0");
        puntuPanel.add(puntuUsuLabel);
        puntuPanel.add(puntuacionUsuLabel);

        letrasUtilesLabel = new JLabel("Lestras utilizadas falladas:");
        letrasUtilesArea = new JTextArea(5, 20);
        letrasUtilesArea.setEditable(false);

        letrasUtilesArea.setPreferredSize(new Dimension(300, 250));
        letrasUtilesArea.setMaximumSize(new Dimension(300, 250));
        letrasUtilesArea.setMinimumSize(new Dimension(300, 250));

        puntuPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        letrasUtilesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        letrasUtilesArea.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(puntuPanel);
        this.add(letrasUtilesLabel);
        this.add(letrasUtilesArea);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba LetrasUtilJuegoPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new LetrasUtilJuegoPanel());
            
            frame.setVisible(true);
        });
    }
}
