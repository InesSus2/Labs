package Ahorcado.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import Ahorcado.model.AhorcadoModel;

public class GameCenterPanel extends JPanel{
    private ImagenFallosPanel imagenFallosPanel;
    private LetrasUtilJuegoPanel letrasUtilJuegoPanel;
    private AhorcadoModel model = new AhorcadoModel();

    public GameCenterPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        imagenFallosPanel = new ImagenFallosPanel(model);
        letrasUtilJuegoPanel = new LetrasUtilJuegoPanel();

        this.add(imagenFallosPanel);
        this.add(letrasUtilJuegoPanel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba GameCenterPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GameCenterPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
