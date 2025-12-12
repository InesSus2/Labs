package Ahorcado.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class InicioPanel extends JPanel {
    private ConfiguracionPanel configuracionPanel;

    public InicioPanel() {
        this.setLayout(new BorderLayout());
        configuracionPanel = new ConfiguracionPanel();

        this.add(configuracionPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
