package Ahorcado.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ConfiguracionPanel extends JPanel{
    private NombreUsuPanel nombreUsuPanel;
    private NumeroLetrasPanel numeroLetrasPanel;
    private TemaPalabraPanel temaPalabraPanel;
    private EstiloDibujoPanel estiloDibujoPanel;
    private ColorLetrasPanel colorLetrasPanel;

    public ConfiguracionPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nombreUsuPanel = new NombreUsuPanel();
        numeroLetrasPanel = new NumeroLetrasPanel();
        temaPalabraPanel = new TemaPalabraPanel();
        estiloDibujoPanel = new EstiloDibujoPanel();
        colorLetrasPanel = new ColorLetrasPanel();

        this.add(nombreUsuPanel);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(numeroLetrasPanel);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(temaPalabraPanel);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(estiloDibujoPanel);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(colorLetrasPanel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba ConfiguracionPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new ConfiguracionPanel());
            
            frame.setVisible(true);
        });
    }
}