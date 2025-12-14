package Ahorcado.view;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class PalabrasAdivJuegoPanel extends JPanel {

    private JLabel palabraAdivinadaLabel;
    private ArrayList<Character> palabraAdivinada;
    private ArrayList<JLabel> letrasLabels;

    public PalabrasAdivJuegoPanel(int tamanoPalabra) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel letrasPanel = new JPanel();
        letrasPanel.setLayout(new FlowLayout());

        palabraAdivinadaLabel = new JLabel("PALABRA A ADIVINAR:");
        this.add(palabraAdivinadaLabel);

        palabraAdivinada = new ArrayList<>(tamanoPalabra);
        letrasLabels = new ArrayList<>(tamanoPalabra);

        for (int i = 0; i < tamanoPalabra; i++) {
            palabraAdivinada.add('_');

            JLabel letra = new JLabel("_");
            letra.setFont(new Font("Times New Roman", Font.BOLD, 24));
            letrasLabels.add(letra);
            letrasPanel.add(letra);
        }

        palabraAdivinadaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        letrasPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(letrasPanel);
    }

    // Método para actualizar una letra
    public void setLetra(int posicion, char letra) {
        palabraAdivinada.set(posicion, letra);
        letrasLabels.get(posicion).setText(String.valueOf(letra));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba PalabrasAdivJuegoPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new PalabrasAdivJuegoPanel(8));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}