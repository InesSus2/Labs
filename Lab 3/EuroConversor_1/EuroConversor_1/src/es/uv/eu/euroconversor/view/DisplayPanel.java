package es.uv.eu.euroconversor.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 */

public class DisplayPanel extends JPanel{
    private JLabel displayLabel;   // Muestra la cantidad o resultado
    private JLabel rateLabel;      // Muestra la tasa de cambio
    private Border border;
    
    public DisplayPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        border=BorderFactory.createLineBorder(Color.BLACK, 5);
        
        this.setBorder(border);

        this.setBackground(new Color(180, 170, 105));
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        displayLabel = new JLabel("0");
        displayLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        displayLabel.setForeground(Color.BLACK); // texto oscuro sobre fondo claro
        displayLabel.setOpaque(false);

        topPanel.setBackground(new Color(180, 170, 105));
        topPanel.add(displayLabel);

        // --- Línea inferior (tasa de cambio) ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rateLabel = new JLabel("Exchange rate: 1.11253");
        rateLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        rateLabel.setForeground(Color.BLACK);
        rateLabel.setOpaque(false);

        bottomPanel.setBackground(new Color(180, 170, 105));
        bottomPanel.add(rateLabel);
        
        this.add(topPanel);
        this.add(Box.createVerticalGlue());
        this.add(bottomPanel);
    }

    public String getText(){
        return displayLabel.getText();
    }
    public void setDisplayText(String text) {
        displayLabel.setText(text);
    }

    public void setToZero() {
        displayLabel.setText("0");
    }

    public void setRateText(String text) {
        rateLabel.setText("Exchange rate: " + text);
    }

    public String getRateText() {
        return rateLabel.getText();
    }
    
    // --- Bloque temporal para probar visualmente ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba DisplayPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.add(new DisplayPanel());
            frame.setVisible(true);
        });
    }
}