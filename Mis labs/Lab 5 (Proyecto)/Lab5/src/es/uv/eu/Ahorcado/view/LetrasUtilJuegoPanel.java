package es.uv.eu.Ahorcado.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/*********************************************************************
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 ********************************************************************/

public class LetrasUtilJuegoPanel extends JPanel {
    private JLabel letrasUtilesLabel;
    private JLabel puntuUsuLabel;
    private JLabel fallosUsuLabel;
    private JLabel puntuacionUsuLabel;
    private JLabel numFallosUsuLabel;
    private JTextArea letrasUtilesArea;
    private ArrayList<JLabel> letrasLabels;
    private ArrayList<Character> palabraAdivinada;
    private ArrayList<Character> letrasUtilizadas;

    public LetrasUtilJuegoPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.letrasUtilizadas = new ArrayList<>();

        JPanel puntuPanel = new JPanel();
        puntuPanel.setLayout(new BoxLayout(puntuPanel, BoxLayout.X_AXIS));
        puntuUsuLabel = new JLabel("Puntuación actual:  ");
        puntuacionUsuLabel = new JLabel("0");
        puntuPanel.add(puntuUsuLabel);
        puntuPanel.add(puntuacionUsuLabel);

        JPanel fallosPanel = new JPanel();
        fallosPanel.setLayout(new BoxLayout(fallosPanel, BoxLayout.X_AXIS));
        fallosUsuLabel = new JLabel("Fallos actuales:  ");
        numFallosUsuLabel = new JLabel("0");
        fallosPanel.add(fallosUsuLabel);
        fallosPanel.add(numFallosUsuLabel);

        letrasUtilesLabel = new JLabel("Letras utilizadas:");
        letrasUtilesArea = new JTextArea(5, 20);
        letrasUtilesArea.setEditable(false);
        letrasUtilesArea.setLineWrap(true);          ///< Activar ajuste de línea
        letrasUtilesArea.setWrapStyleWord(true);     ///< Ajustar por palabras

        letrasUtilesArea.setPreferredSize(new Dimension(300, 250));
        letrasUtilesArea.setMaximumSize(new Dimension(300, 250));
        letrasUtilesArea.setMinimumSize(new Dimension(300, 250));

        puntuPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        fallosPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        letrasUtilesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        letrasUtilesArea.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(puntuPanel);
        this.add(fallosPanel);
        this.add(letrasUtilesLabel);
        this.add(letrasUtilesArea);

        this.setVisible(true);
    }

    /*********************************************************************
     * @brief Getters de los atributos necesarios
     ********************************************************************/
    public ArrayList<JLabel> getLetrasLabels() {
        return letrasLabels;
    }

    public ArrayList<Character> getPalabraAdivinada() {
        return palabraAdivinada;
    }

    /****************** Setters de los atributos necesarios **************
     * @brief Setter de la puntuación del usuario
     ********************************************************************/
    public void setPuntuacionUsuLabel(int puntuacion) {
        this.puntuacionUsuLabel.setText(String.valueOf(puntuacion));
    }

    /************************ setNumFallosUsuLabel() **********************
     * @brief Setter del número de fallos del usuario
     * 
     * @param numFallos Número de fallos del usuario
     ********************************************************************/
    public void setNumFallosUsuLabel(int numFallos) {
        this.numFallosUsuLabel.setText(String.valueOf(numFallos));
    }

    /************************** appendTextArea() *************************
     * @brief Método para actualizar la letra en el panel de
     * letras utilizadas
     * 
     * @param letra Letra utilizada
     * @param color Color de la letra utilizada
     * @param fallos Numero de fallos
     ********************************************************************/
    public void appendTextArea(char letra, Color color, int fallos) {
        ///< Verificar si la letra ya ha sido utilizada
        if (letrasUtilizadas.contains(letra)) {
            return; ///<  No añadir letra duplicada
        }
        
        letrasUtilizadas.add(letra);
        letrasUtilesArea.setForeground(color);
        if (fallos <= 5)
            letrasUtilesArea.append(Character.toUpperCase(letra) + "           ");
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
