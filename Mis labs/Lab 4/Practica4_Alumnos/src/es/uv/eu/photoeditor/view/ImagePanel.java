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
import java.awt.FlowLayout;
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

    public ImagePanel(){
        this.setLayout(new FlowLayout());
        borde = BorderFactory.createLineBorder(Color.BLACK, 1);

        this.setBorder(borde);

        this.setVisible(true);
    }
}