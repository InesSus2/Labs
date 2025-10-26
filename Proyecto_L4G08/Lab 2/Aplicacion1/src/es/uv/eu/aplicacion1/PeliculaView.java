package es.uv.eu.aplicacion1;

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

        this.setSize(800, 400);

        exit = new JButton("Salir");

        JLabel label = new JLabel("Lista de peliculas");
        label.setFont(new Font("Sans", Font.BOLD, 14));

        listaPanel = new ListaPanel(peliculas);
        listaPanel.mostrar();

        this.add(label, BorderLayout.NORTH);
        this.add(listaPanel, BorderLayout.CENTER);
        this.add(exit, BorderLayout.SOUTH);
    }
    public void setActionListener(ActionListener actionListener){}
}
