package Ahorcado.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

/**
 * 
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 */

public class NumeroLetrasPanel extends JPanel {
    private JLabel texto;
    private JSlider slider;

    public NumeroLetrasPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);

        texto = new JLabel ("NÚMERO DE LETRAS:");
        slider = new JSlider(3, 8, 5);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(1);
        slider.setMinorTickSpacing(1);
        slider.setPaintLabels(true);

        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        slider.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(texto);
        this.add(slider);
    }

    public int getSlider() {
        return slider.getValue();
    }

    public void setValue(int value) {
        slider.setValue(value);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba NumeroLetrasPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.add(new NumeroLetrasPanel());
            
            frame.setVisible(true);
        });
    }
}