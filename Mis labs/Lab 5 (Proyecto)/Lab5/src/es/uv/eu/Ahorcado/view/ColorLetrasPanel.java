package Ahorcado.view;

//import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ColorLetrasPanel extends JPanel{
    private ColorLetrasAdivPanel colorLetrasAdivPanel;
    private ColorLetrasUtilPanel colorLetrasUtilPanel;

    public ColorLetrasPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        colorLetrasAdivPanel = new ColorLetrasAdivPanel();
        colorLetrasUtilPanel = new ColorLetrasUtilPanel();

        this.add(colorLetrasAdivPanel);
        this.add(colorLetrasUtilPanel);

        this.setVisible(true);
    }

    /*
    public void setActionListener(ActionListener actionListener){
        CBColoresLetrasAdiv.addActionListener(actionListener);
        CBColoresLetrasUtil.addActionListener(actionListener);
    }
    */

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