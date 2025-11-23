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
    
    private final JButton[] buttons;
    private final String[] labels = {
        "Negro", "Cyan", "Gris oscuro", "Gris",
        "Gris claro", "Magenta", "Naranja", "Rosa",
        "Amarillo", "Blanco", "Rojo", "Azul", "Verde"
    };
    
    public ColorPanel(int n) {
        this.setLayout(new GridLayout(7, 2, 5, 3));
        buttons = new JButton[labels.length];
        
        JLabel titulo = new JLabel("Color "+ n + ": ");
        this.add(titulo);
        
        JButton firstButton = new JButton(labels[0]);
        
        Color c0 = Color.BLACK;
        Color c1 = Color.WHITE;
        
        firstButton.setBackground(c0);
        firstButton.setForeground(c1);
        firstButton.setOpaque(true);
        //Crear Borde
        Border borde=BorderFactory.createLineBorder(Color.BLACK, 2);
        Dimension dimen=new Dimension(10, 10);
        firstButton.setBorder(borde);
        firstButton.setPreferredSize(dimen);
        
        firstButton.setActionCommand("Botones");
        buttons[0] = firstButton; 
        this.add(firstButton);
        
        for(int i=1; i<labels.length; i++){
            buttons[i] = new JButton(labels[i]);
            Color c;
            switch (labels[i]) {
            case "Negro":
                c = Color.BLACK;
                buttons[i].setForeground(Color.WHITE);
                break;
            case "Cyan":
                c = Color.CYAN;
                break;
            case "Gris oscuro":
                c = Color.DARK_GRAY;
                buttons[i].setForeground(Color.WHITE);
                break;
            case "Gris":
                c = Color.GRAY;
                break;
            case "Gris claro":
                c = Color.LIGHT_GRAY;
                break;
            case "Magenta":
                c = Color.MAGENTA;
                break;
            case "Naranja":
                c = Color.ORANGE;
                break;
            case "Rosa":
                c = Color.PINK;
                break;
            case "Amarillo":
                c = Color.YELLOW;
                break;
            case "Blanco":
                c = Color.WHITE;
                break;
            case "Rojo":
                c = Color.RED;
                break;
            case "Azul":
                c = Color.BLUE;
                break;
            case "Verde":
                c = Color.GREEN;
                break;
            default:
                c = Color.BLACK;
            };
            
            buttons[i].setBackground(c);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(true);
            buttons[i].setActionCommand("Botones");
            buttons[i].setBorder(borde);
            buttons[i].setPreferredSize(dimen);
            this.add(buttons[i]);
        }
        
    }
    
    
    //dos actionListeners para cada color panel
       public void setActionListener(ActionListener listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }
       
              public void setActionListener2(ActionListener listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }
    // --- Bloque temporal para probar visualmente ---
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba ColorPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.add(new ColorPanel(1));
            frame.setVisible(true);
        });
    }
    
}
