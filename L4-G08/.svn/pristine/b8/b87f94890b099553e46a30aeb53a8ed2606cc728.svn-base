/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uv.eu.photoeditor.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import es.uv.eu.photoeditor.model.PhotoEditorModel;
import javax.swing.JSlider;

/**
 *
 * @author Natalia Tauste Rubio
 * @author Inés Jaso Pernod
 */
public class PhotoEditorView extends JFrame{
    private WidthPanel panelGrosor;
    private SelectPanel panelSeleccion;
    private ImagePanel panelImagen;
    private StatusPanel panelEstado;
    private PhotoEditorMenuBar menu;

    public PhotoEditorView(PhotoEditorModel modelo){
        this.setTitle("Image Viewer");
        this.setLayout(new BorderLayout());
        this.setSize(1000, 900);
        

        panelGrosor = new WidthPanel(panelEstado);
        panelSeleccion = new SelectPanel();
        panelSeleccion.setPreferredSize(new Dimension(300, 0));
        panelImagen = new ImagePanel(modelo);
        panelEstado = new StatusPanel();
        menu = new PhotoEditorMenuBar();

        this.setJMenuBar(menu);
        this.add(panelGrosor, BorderLayout.NORTH);
        this.add(panelSeleccion, BorderLayout.WEST);
        this.add(panelImagen, BorderLayout.CENTER);
        this.add(panelEstado, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public StatusPanel getStatusPanel() {
        return this.panelEstado;
    }

    public WidthPanel getWidthPanel() {
        return panelGrosor;
    }
    
    public JSlider getWidthSlider() {
        return panelGrosor.getSlider();
    }

    public void setActionListener (ActionListener actionListener) {
        menu.setActionListener(actionListener);
        panelSeleccion.setActionListener(actionListener);
    }

    public ImagePanel getImagenPanel() {
        return this.panelImagen;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PhotoEditorModel modelo = new PhotoEditorModel();
            JFrame frame = new JFrame("Prueba PhotoEditorView");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.add(new PhotoEditorView(modelo));
            frame.setVisible(true);
        });
    }
}