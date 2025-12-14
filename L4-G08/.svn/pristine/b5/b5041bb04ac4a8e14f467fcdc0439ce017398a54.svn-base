package Ahorcado.view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TituloPanel extends JPanel {
    ///PANEL PARA PONER LA IMAGEN CON EL TITULO DEL JUEGO
    private JLabel titulo;
    public TituloPanel() {
        // Constructor vac ío por ahora
        this.setBackground(Color.WHITE);
        titulo = new JLabel("EL JUEGO DEL AHORCADO");

        this.add(titulo);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba TituloPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new TituloPanel());
            
            frame.setVisible(true);
        });
    }
}