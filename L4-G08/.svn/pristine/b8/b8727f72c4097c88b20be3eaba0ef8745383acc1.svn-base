package es.uv.eu.Ahorcado.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*********************************************************************
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 ********************************************************************/

public class GameSouthPanel extends JPanel{
    private IntroduceLetraPanel introduceLetraPanel;

    public GameSouthPanel(){
        this.setLayout(new BorderLayout());
        introduceLetraPanel = new IntroduceLetraPanel();

        this.add(introduceLetraPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    /*********************** getLetraIntroducida() ***********************
     * @brief Getter para la letra introducida
     * 
     * @return Letra introducida
     ********************************************************************/
    public char getLetraIntroducida() {
        return introduceLetraPanel.getLetraIntroducida();
    }

    /*********************** getTextoIntroducido() ***********************
     * @brief Getter para el texto introducido
     * 
     * @return Texto introducido
     ********************************************************************/
    public String getTextoIntroducido() {
        return introduceLetraPanel.getTextoIntroducido();
    }

    /************************** resetTextField() *************************
     * @brief Método para resetear la configuración del textField del
     * panel GameSouthPanel
     ********************************************************************/
    public void resetTextField(){
        introduceLetraPanel.resetTextField();
    }

    /************************ setActionListener() *************************
     * @brief Asigna un ActionListener a todos los elementos del menú
     * 
     * @param listener ActionListener a asignar
     ********************************************************************/
    public void setActionListener(ActionListener listener){
        introduceLetraPanel.setActionListener(listener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba GameSouthPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GameSouthPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    } 
}