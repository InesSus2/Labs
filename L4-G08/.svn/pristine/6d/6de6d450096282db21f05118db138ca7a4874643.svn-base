package es.uv.eu.Ahorcado.view;

import es.uv.eu.Ahorcado.model.AhorcadoModel;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*********************************************************************
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 ********************************************************************/

public class GameNorthPanel extends JPanel{
    
    private LetrasUtilJuegoPanel letrasUtilJuegoPanel;

    public GameNorthPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        letrasUtilJuegoPanel = new LetrasUtilJuegoPanel();
        this.add(letrasUtilJuegoPanel);

        this.setVisible(true);
    }

    /************************ setPuntuacionUsuLabel() ********************
     * @brief Método para actualizar la puntuacion del usuario
     * 
     * @param puntuacion el numero de la puntuacion
     ********************************************************************/
    public void setPuntuacionUsuLabel(int puntuacion) {
        letrasUtilJuegoPanel.setPuntuacionUsuLabel(puntuacion);
    }

    /************************ setNumFallosUsuLabel() **********************
     * @brief Método para actualizar el número de fallos del usuario
     * 
     * @param numFallos Número de fallos del usuario
     ********************************************************************/
    public void setNumFallosUsuLabel(int numFallos) {
        letrasUtilJuegoPanel.setNumFallosUsuLabel(numFallos);
    }
    
    /*************************** appendTextArea() ***************************
        * @brief Método para actualizar la letra en el panel de
        * letras utilizadas
        * 
        * @param letra Letra utilizada
        * @param color Color de la letra utilizada
        * @param fallos Numero de fallos
        ********************************************************************/
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