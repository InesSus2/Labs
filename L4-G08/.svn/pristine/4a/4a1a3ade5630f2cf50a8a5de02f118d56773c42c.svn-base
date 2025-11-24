package es.uv.eu.photoeditor.view;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import java.awt.Color;

/**
 *
 * @author Natalia Tauste Rubio
 * @author Inés Jaso Pernod
 */
public class ColorPanel extends JPanel{
    private Border border;
    private final JButton[] buttons;
    private final String[] labels = {
        "Negro", "Cyan", "Gris oscuro", "Gris",
        "Gris claro", "Magenta", "Naranja", "Rosa",
        "Amarillo", "Blanco", "Rojo", "Azul", "Verde"
    };
    
    private int numeroPanel; // ← guarda si es 1 o 2

    public ColorPanel(int n) {

        this.numeroPanel = n;

        this.setLayout(new GridLayout(7, 2, 5, 3));
        border = BorderFactory.createLineBorder(Color.BLACK, 1);
        this.setBorder(border);
        buttons = new JButton[labels.length];
        
        JLabel titulo = new JLabel("Color "+ n + ": ");
        this.add(titulo);
        
        JButton firstButton = new JButton(labels[0]);
        
        Color c0 = Color.BLACK;
        Color c1 = Color.WHITE;
        
        firstButton.setBackground(c0);
        firstButton.setForeground(c1);
        firstButton.setOpaque(true);
        Border borde = BorderFactory.createLineBorder(Color.BLACK, 2);
        Dimension dimen = new Dimension(10, 10);
        firstButton.setBorder(borde);
        firstButton.setPreferredSize(dimen);

        // ✔ COMMAND ÚNICO
        firstButton.setActionCommand("COLOR_" + n + "_" + labels[0].replace(" ", ""));
        
        buttons[0] = firstButton;
        this.add(firstButton);
        
        for(int i = 1; i < labels.length; i++){
            buttons[i] = new JButton(labels[i]);
            Color c;

            switch (labels[i]) {
                case "Negro": c = Color.BLACK; buttons[i].setForeground(Color.WHITE); break;
                case "Cyan": c = Color.CYAN; break;
                case "Gris oscuro": c = Color.DARK_GRAY; buttons[i].setForeground(Color.WHITE); break;
                case "Gris": c = Color.GRAY; break;
                case "Gris claro": c = Color.LIGHT_GRAY; break;
                case "Magenta": c = Color.MAGENTA; break;
                case "Naranja": c = Color.ORANGE; break;
                case "Rosa": c = Color.PINK; break;
                case "Amarillo": c = Color.YELLOW; break;
                case "Blanco": c = Color.WHITE; break;
                case "Rojo": c = Color.RED; break;
                case "Azul": c = Color.BLUE; break;
                case "Verde": c = Color.GREEN; break;
                default: c = Color.BLACK;
            }

            buttons[i].setBackground(c);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(true);
            
            buttons[i].setActionCommand("BotonesColor_" + n + "_" + labels[i].replace(" ", ""));

            buttons[i].setBorder(borde);
            buttons[i].setPreferredSize(dimen);
            this.add(buttons[i]);
        }
    }
    
    public void setActionListener(ActionListener listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }
}