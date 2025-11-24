/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.model.PhotoEditorModel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Natalia Tauste Rubio
 * @author Inés Jaso Pernod
 */
public class ImagePanel extends JPanel{
    private PhotoEditorModel modelo;
    private Border borde;

    public ImagePanel(PhotoEditorModel modelo){
        this.setLayout(new FlowLayout());
        this.modelo = modelo;
        borde = BorderFactory.createLineBorder(Color.BLACK, 1);

        this.setBorder(borde);
        this.setPreferredSize(new Dimension(200, 200));

        this.setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        BufferedImage imagen = modelo.getImagen();
        if(imagen != null){
            //Escalar la imagen al tamao del panel
            Image imagenEscalada = imagen.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(imagenEscalada, 0, 0, this);
        }
    }
}