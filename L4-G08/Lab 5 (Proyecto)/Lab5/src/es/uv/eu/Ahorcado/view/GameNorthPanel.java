package es.uv.eu.Ahorcado.view;

import es.uv.eu.Ahorcado.model.AhorcadoModel;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameNorthPanel extends JPanel{
    
    private LetrasUtilJuegoPanel letrasUtilJuegoPanel;
    private AhorcadoModel model;

    public GameNorthPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.model = model;
        letrasUtilJuegoPanel = new LetrasUtilJuegoPanel();
        this.add(letrasUtilJuegoPanel);

        this.setVisible(true);
    }

    /**
     * Método para actualizar la imagen del ahorcado
     */


    public void setPuntuacionUsuLabel(int puntuacion) {
        letrasUtilJuegoPanel.setPuntuacionUsuLabel(puntuacion);
    }

    public void mostrarLetra(char letra, Color c) {
        // Convertir a mayúscula para consistencia
        letra = Character.toUpperCase(letra);

        // Recorremos los JLabel de LetrasUtilJuegoPanel
        for (int i = 0; i < letrasUtilJuegoPanel.getLetrasLabels().size(); i++) {
            JLabel label = letrasUtilJuegoPanel.getLetrasLabels().get(i);
            // Solo sustituimos la _ si la letra coincide con la letra secreta en esa posición
            if (letrasUtilJuegoPanel.getPalabraAdivinada().get(i) == '_') {
                // Aquí asumimos que la letra coincide con la introducida por el usuario
                // Esto sustituye la _ por la letra
                label.setText(String.valueOf(letra));
                label.setForeground(c);

                // Actualizamos el ArrayList interno
                letrasUtilJuegoPanel.getPalabraAdivinada().set(i, letra);
            }
        }

        // Refrescar el panel
        letrasUtilJuegoPanel.repaint();
    }

    public void appendTextArea(char letra, Color color, int fallos) {
        letrasUtilJuegoPanel.appendTextArea(letra, color, fallos);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba GameCenterPanel");
            AhorcadoModel model = new AhorcadoModel("OSO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GameNorthPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
