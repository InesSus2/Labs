package Ahorcado.view;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ColorLetrasUtilPanel extends JPanel{
    private JLabel coloresUtil;
    private JComboBox<String> CBColoresLetrasUtil;
    private String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Naranja", "Rosa", "Negro", "Blanco"};

    public ColorLetrasUtilPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        coloresUtil = new JLabel("COLOR DE LAS LETRAS ADIVINADAS:");
        CBColoresLetrasUtil = new JComboBox<>(colores);
        CBColoresLetrasUtil.setActionCommand("ColoresLetrasUtil"); ///< NO ESTOY SEGURA DE SI VA AQUÍ O EN ColorLetrasPanel

        coloresUtil.setAlignmentX(Component.CENTER_ALIGNMENT);
        CBColoresLetrasUtil.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(coloresUtil);
        this.add(CBColoresLetrasUtil);
    }

    public void setActionListener(ActionListener actionListener){ ///< NO ESTOY SEGURA DE SI VA AQUÍ O EN ColorLetrasPanel
        CBColoresLetrasUtil.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba ColorLetrasUtilPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new ColorLetrasUtilPanel());
            
            frame.setVisible(true);
        });
    }
}