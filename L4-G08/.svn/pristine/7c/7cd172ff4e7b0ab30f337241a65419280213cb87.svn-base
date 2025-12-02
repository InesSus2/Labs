package Ahorcado.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;

/**
 *
 * @author Natalia Tauste Rubio
 * @author Inés Jaso Pernod
 */

public class AhorcadoMenuBar extends JMenuBar{
    private JMenu archivo;
    private JMenuItem ranking;
    private JMenuItem nuevaPartida;
    private JMenuItem salir;

    public AhorcadoMenuBar() {
        archivo = new JMenu("Archivo");
        ranking = new JMenuItem("Ranking");
        nuevaPartida = new JMenuItem("Nueva partida");
        salir = new JMenuItem("Salir");

        ranking.setActionCommand("Ranking");
        nuevaPartida.setActionCommand("NuevaPartida");
        salir.setActionCommand("Salir");

        archivo.add(ranking);
        archivo.add(nuevaPartida);
        archivo.add(salir);
        this.add(archivo);

        this.setVisible(true);
    }

    public void setActionListener(ActionListener actionListener){
        ranking.addActionListener(actionListener);
        nuevaPartida.addActionListener(actionListener);
        salir.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba AhorcadoMenuBar");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.add(new AhorcadoMenuBar());
            frame.setVisible(true);
        });
    }
}