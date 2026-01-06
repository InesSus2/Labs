package es.uv.eu.Ahorcado.view;

import es.uv.eu.Ahorcado.model.AhorcadoModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*********************************************************************
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 ********************************************************************/

public class JuegoPanel extends JPanel{
    //private AhorcadoMenuBar menu;
    private GameCenterPanel gameCenterPanel;
    private GameSouthPanel gameSouthPanel;
    private GameNorthPanel gameNorthPanel;

    public JuegoPanel(AhorcadoModel model, int tamPalabra){
        this.setLayout(new BorderLayout());
        gameCenterPanel = new GameCenterPanel(model, tamPalabra);
        gameSouthPanel = new GameSouthPanel();
        gameNorthPanel = new GameNorthPanel();
        this.add(gameNorthPanel,BorderLayout.NORTH);
        this.add(gameCenterPanel,BorderLayout.CENTER);
        
        ///< Para que aparezca más grande 
        JPanel southWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southWrapper.add(gameSouthPanel);

        this.add(southWrapper, BorderLayout.SOUTH);


        this.setVisible(true);
    }

    /*********************************************************************
     * @brief Getter para la letra introducida en el panel JuegoPanel
     * 
     * @return Letra introducida
     ********************************************************************/
    public char getLetraIntroducida() {
        return gameSouthPanel.getLetraIntroducida();
    }

    /*********************************************************************
     * @brief Getter para el texto introducido en el panel JuegoPanel
     * 
     * @return Texto introducido
     ********************************************************************/
     public String getTextoIntroducido() {
        return gameSouthPanel.getTextoIntroducido();
    }

    /********************** setPuntuacionUsuLabel() **********************
     * @brief Setters de la puntuacion del usuario
     * 
     * @param puntuacion El numero de la puntuacion
     ********************************************************************/
    public void setPuntuacionUsuLabel(int puntuacion) {
        gameNorthPanel.setPuntuacionUsuLabel(puntuacion);
    }

    /********************** setNumFallosUsuLabel() ***********************
     * @brief Setters del número de fallos del usuario
     * 
     * @param numFallos Número de fallos del usuario
     ********************************************************************/
    public void setNumFallosUsuLabel(int numFallos) {
        gameNorthPanel.setNumFallosUsuLabel(numFallos);
    }

    /************************** resetTextField() *************************
     * @brief Método para resetear la configuración del textField del
     * panel JuegoPanel
     ********************************************************************/
    public void resetTextField(){
        gameSouthPanel.resetTextField();
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
        gameNorthPanel.appendTextArea(letra, color, fallos);
    }

    /********************* actualizarImagenAhorcado() ********************
     * @brief Método para actualizar la imagen del ahorcado
     ********************************************************************/
    public void actualizarImagenAhorcado() {
        if (gameCenterPanel != null) {
            gameCenterPanel.actualizarImagenAhorcado();
        }
    }

    /********************** actualizarPalabraAdivinada() *****************
     * @brief Método para actualizar la palabra a adivinar
     * 
     * @param palabraPorAdivinar Palabra a adivinar
     * @param letraProbada Letra introducida por el usuario
     * @param colorLetra Color de la letra
     ********************************************************************/
    public void actualizarPalabraAdivinada(String palabraPorAdivinar, char letraProbada, Color colorLetra) {
        gameCenterPanel.actualizarPalabraAdivinada(palabraPorAdivinar, letraProbada, colorLetra);
    }

    /************************ setActionListener() *************************
     * @brief Asigna un ActionListener a todos los elementos del menú
     * 
     * @param listener ActionListener a asignar
     ********************************************************************/
    public void setActionListener(ActionListener listener){
        gameSouthPanel.setActionListener(listener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba JuegoPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 800);
            frame.add(new JuegoPanel(new AhorcadoModel("OSO"), 3));
            
            frame.setVisible(true);
        });
    }
}
