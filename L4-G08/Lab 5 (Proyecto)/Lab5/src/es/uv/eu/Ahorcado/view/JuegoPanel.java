package Ahorcado.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JuegoPanel extends JPanel{
    private GameCenterPanel gameCenterPanel;
    private GameSouthPanel gameSouthPanel;

    public JuegoPanel(){
        this.setLayout(new BorderLayout());
        gameCenterPanel = new GameCenterPanel();
        gameSouthPanel = new GameSouthPanel(3);

        this.add(gameCenterPanel, BorderLayout.CENTER);
        this.add(gameSouthPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba JuegoPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 800);
            frame.add(new JuegoPanel());
            
            frame.setVisible(true);
        });
    }
}
