package es.uv.eu.aplicacion4;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Natalia Tauste
 * @author Inés Jaso Pernod
 */
public class PeliculaView extends JFrame {
    private PeliculaModel peliculas;
    private ListaPanel listaPanel;
    private PeliculaMenu peliculaMenu;
    private JButton exit;

    public PeliculaView(PeliculaModel peliculas) {
        super("Aplication 1: Lista de peliculas");

        this.peliculas = peliculas;
        this.setLayout(new BorderLayout());

        this.setSize(700, 400);

        peliculaMenu = new PeliculaMenu();
        this.setJMenuBar(peliculaMenu);

        JLabel label = new JLabel("Lista de peliculas");
        label.setFont(new Font("Sans", Font.BOLD, 14));

        listaPanel = new ListaPanel(peliculas);
        listaPanel.mostrar();

        exit = new JButton("Salir");
        exit.setActionCommand("buttonExit");

        this.add(label, BorderLayout.NORTH);
        this.add(listaPanel, BorderLayout.CENTER);
        this.add(exit, BorderLayout.SOUTH);

        this.setVisible(true);
    }
    public void setActionListener(ActionListener actionListener){
        peliculaMenu.setActionListener(actionListener);
        exit.addActionListener(actionListener);
    }
}