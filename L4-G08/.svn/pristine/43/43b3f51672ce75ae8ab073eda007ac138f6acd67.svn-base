package es.uv.eu.Ahorcado.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*********************************************************************
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 ********************************************************************/

public class ColorLetrasPanel extends JPanel{
    private ColorLetrasAdivPanel colorLetrasAdivPanel;
    private ColorLetrasUtilPanel colorLetrasUtilPanel;

    public ColorLetrasPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        colorLetrasAdivPanel = new ColorLetrasAdivPanel();
        colorLetrasUtilPanel = new ColorLetrasUtilPanel();
        
       
        this.add(colorLetrasAdivPanel);
        this.add(javax.swing.Box.createVerticalStrut(8)); ///< Separación pequeña controlada
        this.add(colorLetrasUtilPanel);

        this.setVisible(true);
    }

    /************************ getColorLetrasAdiv() ***********************
     * @brief Getter para el color de las letras adivinadas
     * 
     * @return Color de las letras adivinadas
     ********************************************************************/
    public String getColorLetrasAdiv() {
        return colorLetrasAdivPanel.getColorLetrasAdiv();
    }

    /************************ getColorLetrasUtil() ***********************
     * @brief Getter para el color de las letras utilizadas
     * 
     * @return Color de las letras utilizadas
     ********************************************************************/
    public String getColorLetrasUtil() {
        return colorLetrasUtilPanel.getColorLetrasUtil();
    }

    /****************************** reset() ******************************
     * @brief Método para resetear la configuración del
     * panel de ColorLetrasPanel
     * 
     * @param index Índice a seleccionar en ambos JComboBox
     ********************************************************************/
    public void reset(int index) {
        colorLetrasAdivPanel.setSelectedIndex(index);
        colorLetrasUtilPanel.setSelectedIndex(index);
    }

    /************************ setActionListener() ************************
     * @brief Asigna un ActionListener a todos los elementos del menú
     * 
     * @param actionListener ActionListener a asignar
     ********************************************************************/
    public void setActionListener(ActionListener actionListener){
        colorLetrasAdivPanel.setActionListener(actionListener);
        colorLetrasUtilPanel.setActionListener(actionListener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba ColorLetrasPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new ColorLetrasPanel());
            
            frame.setVisible(true);
        });
    }
}