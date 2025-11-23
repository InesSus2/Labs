/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uv.eu.photoeditor.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
/**
 *
 * @author Natalia Tauste Rubio
 * @author Inés Jaso Pernod
 */
public class PhotoEditorMenuBar extends JMenuBar{
    private JMenu archivo;
    private JMenuItem cargarImg;
    private JMenuItem guardarImg;
    private JMenuItem salir;

    public PhotoEditorMenuBar() {
        archivo = new JMenu("Archivo");
        cargarImg = new JMenuItem("Cargar imagen");
        guardarImg = new JMenuItem("Guardar imagen");
        salir = new JMenuItem("Salir");

        cargarImg.setActionCommand("CargarImagen");
        guardarImg.setActionCommand("GuardarImagen");
        salir.setActionCommand("Salir");

        archivo.add(cargarImg);
        archivo.add(guardarImg);
        archivo.add(salir);
        this.add(archivo);

        this.setVisible(true);
    }

    public void setActionListener(java.awt.event.ActionListener actionListener){
        cargarImg.addActionListener(actionListener);
        guardarImg.addActionListener(actionListener);
        salir.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba PhotoEditorMenuBar");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.add(new PhotoEditorMenuBar());
            frame.setVisible(true);
        });
    }
}
