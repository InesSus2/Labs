package es.uv.eu.aplicacion4;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PeliculaMenu extends JMenuBar {
    private JMenu datos;
    private JMenuItem top;
    private JMenuItem res;

    public PeliculaMenu(){
        datos = new JMenu("Datos");
        top = new JMenuItem("Top 3");
        res = new JMenuItem("Resumen");
        top.setActionCommand("Top3");
        res.setActionCommand("Resumen");
        datos.add(top);
        datos.add(res);
        this.add(datos);
    }

    public void setActionListener(ActionListener actionListener){
        top.addActionListener(actionListener);
        res.addActionListener(actionListener);
    }
}
