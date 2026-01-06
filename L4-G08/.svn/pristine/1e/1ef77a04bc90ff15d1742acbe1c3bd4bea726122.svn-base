package es.uv.eu.Ahorcado.view;

import es.uv.eu.Ahorcado.model.AhorcadoModel;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.NORTH;
import javax.swing.BorderFactory;

/*********************************************************************
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 ********************************************************************/

public class ImagenesPanel extends JPanel{
    private TituloPanel tituloPanel;
    private ImagenIniPanel imagenJuegoPanel;
    private AhorcadoModel model;

    public ImagenesPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        this.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        model = new AhorcadoModel();
        tituloPanel = new TituloPanel();
        imagenJuegoPanel = new ImagenIniPanel(model);

        this.add(tituloPanel, NORTH);
        this.add(imagenJuegoPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba ImagenesPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new ImagenesPanel());
            
            frame.setVisible(true);
        });
    }
}
