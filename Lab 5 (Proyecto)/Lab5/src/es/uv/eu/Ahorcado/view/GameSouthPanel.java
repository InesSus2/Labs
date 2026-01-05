package Ahorcado.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameSouthPanel extends JPanel{
    private PalabrasAdivJuegoPanel palabrasAdivJuegoPanel;
    private IntroduceLetraPanel introduceLetraPanel;

    public GameSouthPanel(int numLetters){
        this.setLayout(new BorderLayout());
        palabrasAdivJuegoPanel = new PalabrasAdivJuegoPanel(numLetters);
        introduceLetraPanel = new IntroduceLetraPanel();

        palabrasAdivJuegoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        introduceLetraPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(palabrasAdivJuegoPanel, BorderLayout.WEST);
        this.add(introduceLetraPanel, BorderLayout.EAST);

        this.setVisible(true);
    }

    public char getLetraIntroducida() {
        return introduceLetraPanel.getLetraIntroducida();
    }

    public void mostrarLetra(char letra, Color c) {
        // Convertir a mayúscula para consistencia
        letra = Character.toUpperCase(letra);

        // Recorremos los JLabel de PalabrasAdivJuegoPanel
        for (int i = 0; i < palabrasAdivJuegoPanel.getLetrasLabels().size(); i++) {
            JLabel label = palabrasAdivJuegoPanel.getLetrasLabels().get(i);
            // Solo sustituimos la _ si la letra coincide con la letra secreta en esa posición
            if (palabrasAdivJuegoPanel.getPalabraAdivinada().get(i) == '_') {
                // Aquí asumimos que la letra coincide con la introducida por el usuario
                // Esto sustituye la _ por la letra
                label.setText(String.valueOf(letra));
                label.setForeground(c);

                // Actualizamos el ArrayList interno
                palabrasAdivJuegoPanel.getPalabraAdivinada().set(i, letra);
            }
        }

        // Refrescar el panel
        palabrasAdivJuegoPanel.repaint();
    }

    public void resetTextField(){
        introduceLetraPanel.resetTextField();
    }

    public void actualizarPalabraAdivinada(String palabraPorAdivinar, char letraProbada, Color colorLetra) {
        palabrasAdivJuegoPanel.actualizarPalabraAdivinada(palabraPorAdivinar, letraProbada, colorLetra);
    }

    public void setActionListener(ActionListener listener){
        introduceLetraPanel.setActionListener(listener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba GameSouthPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GameSouthPanel(3));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    } 
}