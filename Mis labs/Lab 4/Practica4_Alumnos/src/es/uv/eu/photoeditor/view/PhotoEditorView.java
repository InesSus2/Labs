/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uv.eu.photoeditor.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import es.uv.eu.photoeditor.model.PhotoEditorModel;

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

    public PhotoEditorView(PhotoEditorModel modelo){
        this.setTitle("Image Viewer");
        this.setLayout(new BorderLayout());
        this.setSize(1000, 900);
        

        panelGrosor = new WidthPanel();
        panelSeleccion = new SelectPanel();
        panelSeleccion.setPreferredSize(new Dimension(300, 0));
        panelImagen = new ImagePanel();
        panelEstado = new StatusPanel();

        this.add(panelGrosor, BorderLayout.NORTH);
        this.add(panelSeleccion, BorderLayout.WEST);
        this.add(panelImagen, BorderLayout.CENTER);
        this.add(panelEstado, BorderLayout.SOUTH);

        this.setVisible(true);
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