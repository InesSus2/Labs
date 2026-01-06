package es.uv.eu.Ahorcado.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;

/*********************************************************************
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 ********************************************************************/

public class AhorcadoMenuBar extends JMenuBar{
    private JMenu menu;
    private JMenuItem ranking;
    private JMenuItem reset;
    private JMenuItem resetRank;
    private JMenuItem inicio;
    private JMenuItem juego;
    private JMenuItem nosotras;
    private JMenuItem salir;

    public AhorcadoMenuBar() {
        menu = new JMenu("Menú");
        ranking = new JMenuItem("Ranking");
        reset = new JMenuItem("Resetear configuración");
        resetRank = new JMenuItem("Resetear ranking");
        inicio = new JMenuItem("Ir a inicio");
        juego = new JMenuItem("Volver a jugar");
        nosotras = new JMenuItem("Sobre Nosotras");
        salir = new JMenuItem("Salir de la aplicación");

        ranking.setActionCommand("Ranking");
        reset.setActionCommand("Reset");
        resetRank.setActionCommand("ResetRank");
        inicio.setActionCommand("IrAIni");
        juego.setActionCommand("Jugar");
        nosotras.setActionCommand("Nosotras");
        salir.setActionCommand("Salir");

        menu.add(ranking);
        menu.add(reset);
        menu.add(resetRank);
        menu.add(inicio);
        menu.add(juego);
        menu.add(nosotras);
        menu.add(salir);
        this.add(menu);

        this.setVisible(true);
    }

    /************************ setActionListener() *************************
     * @brief Asigna un ActionListener a todos los elementos del menú
     * 
     * @param actionListener ActionListener a asignar
     ********************************************************************/
    public void setActionListener(ActionListener actionListener){
        ranking.addActionListener(actionListener);
        reset.addActionListener(actionListener);
        resetRank.addActionListener(actionListener);
        inicio.addActionListener(actionListener);
        juego.addActionListener(actionListener);
        nosotras.addActionListener(actionListener);
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