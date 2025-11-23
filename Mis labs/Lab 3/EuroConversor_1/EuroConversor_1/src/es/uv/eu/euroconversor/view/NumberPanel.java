package es.uv.eu.euroconversor.view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 */

public class NumberPanel extends JPanel{
    private final JButton[] buttons;
    private final String[] labels = {
        "0", "1", "2", "3",
        "4", "5", "6", "7",
        "8", "9", ".", "C"
    };

    public NumberPanel() {
        this.setLayout(new GridLayout(3, 4, 5, 5));
        buttons = new JButton[labels.length];

        for (int i = 0; i < labels.length; i++) {
            buttons[i] = new JButton(labels[i]);
            this.add(buttons[i]);
            buttons[i].setActionCommand("Botones");
        }
        this.setVisible(true);
    }

    public void setActionListener(ActionListener listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }
    // --- Bloque temporal para probar visualmente ---
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba NumberPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.add(new NumberPanel());
            frame.setVisible(true);
        });
    }
}