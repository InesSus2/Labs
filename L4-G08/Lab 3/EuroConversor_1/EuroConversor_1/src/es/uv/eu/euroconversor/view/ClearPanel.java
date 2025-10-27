

package es.uv.eu.euroconversor.view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author EU (2016)
 */

public class ClearPanel extends JPanel {
    
    private JButton clearButton;
    
    public ClearPanel(ActionListener actionListener) {
        clearButton = new JButton("Clear");
        clearButton.setActionCommand("CLEAR");
        clearButton.addActionListener(actionListener);
        
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        this.add(clearButton);
    }
}