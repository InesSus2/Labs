package es.uv.eu.Ahorcado.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/*********************************************************************
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 ********************************************************************/

public class IntroduceLetraPanel extends JPanel{
    private JLabel introduceLetraLabel;
    private JTextField introduceLetraField;
    private JButton aceptarLetraButton;

    public IntroduceLetraPanel() {
        this.setLayout(new BorderLayout(10, 0));

        introduceLetraLabel = new JLabel("Introduce la letra:");
        introduceLetraField = new JTextField(10);
        aceptarLetraButton = new JButton("OK");

        aceptarLetraButton.setActionCommand("AceptarLetra");
        introduceLetraField.setActionCommand("AceptarLetra");

        introduceLetraField.setPreferredSize(new Dimension(500, 30));
        aceptarLetraButton.setPreferredSize(new Dimension(70, 39));
    
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(introduceLetraLabel);
        leftPanel.add(introduceLetraField);

        add(leftPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        rightPanel.add(aceptarLetraButton);
        add(rightPanel, BorderLayout.EAST);
    }

    /*********************** getLetraIntroducida() ***********************
     * @brief Getter para la letra introducida
     * 
     * @return Letra introducida
     ********************************************************************/
    public char getLetraIntroducida() {
        return introduceLetraField.getText().charAt(0);
    }

    /*********************** getTextoIntroducido() ***********************
     * @brief Getter para el texto introducido
     * 
     * @return Texto introducido
     ********************************************************************/
    public String getTextoIntroducido() {
        return introduceLetraField.getText().trim();
    }

    /************************** resetTextField() *************************
     * @brief Método para resetear la configuración del textField del
     * panel IntroduceLetraPanel
     ********************************************************************/
    public void resetTextField(){
        introduceLetraField.setText("");
        introduceLetraField.setEditable(true);
    }

    /************************ setActionListener() *************************
     * @brief Asigna un ActionListener a todos los elementos del menú
     * 
     * @param listener ActionListener a asignar
     ********************************************************************/
    public void setActionListener(ActionListener listener){
        aceptarLetraButton.addActionListener(listener);
        introduceLetraField.addActionListener(listener); //Enter también lo lanza
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba IntroduceLetraPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new IntroduceLetraPanel());
            
            frame.setVisible(true);
        });
    }
}
