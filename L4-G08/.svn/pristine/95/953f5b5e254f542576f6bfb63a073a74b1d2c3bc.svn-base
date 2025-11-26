package es.uv.eu.photoeditor.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * @author Natalia Tauste Rubio
 * @author Inés Jaso Pernod
 */
public class PhotoEditorModel {
    private BufferedImage imagen; //Se utiliza un objeto de este tipo porque
    //permite cargar inicialmente una imagen a partir de un chero
    private String imagenFileName = "";

    public PhotoEditorModel() {
        try {
            imagenFileName = "/imagenes/imagen_00.jpg";
            imagen = ImageIO.read(getClass().getResourceAsStream(imagenFileName));
        }
        catch (IOException | IllegalArgumentException e) {
            System.out.println("Problemas leyendo la imagen '" + this.imagenFileName + "'.");
            System.out.println("Motivo: " + e.getLocalizedMessage());
        }
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public String getImagenFileName() {
        return imagenFileName;
    }

    public void loadImagen(File imagenFile) {
        if (imagenFile != null) {
            this.imagenFileName = imagenFile.getName();
            try {
                imagen = ImageIO.read(imagenFile);
            }
            catch (IOException e) {
                System.out.println("Problemas leyendo la imagen '" + this.imagenFileName + "'.");
                System.out.println("Motivo: " + e.getLocalizedMessage());
            }
        }
    }

    public void saveImagen(File imagenFile) {
        if (imagenFile != null) {
            try {
                this.imagenFileName = imagenFile.getName();
                ImageIO.write(imagen,"jpg",imagenFile);
            } 
            catch (IOException e) {
                System.out.println("Problemas guardando la imagen '" + imagenFile.getName() + "'.");
                System.out.println("Motivo: " + e.getLocalizedMessage());
            }
        }
    }

    public void pintaRectangulo(int x1, int y1, int x2, int y2, int width, Color color2, Color color1){
        if(imagen == null) return;

        Graphics2D gr = imagen.createGraphics();
        GradientPaint gradiente = new GradientPaint(0, 0, color2, imagen.getWidth(), imagen.getHeight(), color1, true);

        gr.setPaint(gradiente);
        gr.setStroke(new BasicStroke(width));

        int rx = Math.min(x1, x2);
        int ry = Math.min(y1, y2);
        int rw = Math.abs(x2 - x1);
        int rh = Math.abs(y2 - y1);

        gr.fillRect(rx, ry, rw, rh);
        gr.setStroke(new BasicStroke(width));
        gr.drawRect(rx, ry, rw, rh); // dibuja borde
        gr.dispose();
    }
    
    private int grosorRectangulo = 0;

    public void setGrosorRectangulo(int grosor) {
        //this.grosorRectangulo = grosor;
        //notifyObservers(); // o el método que use tu modelo
    }

    public int getGrosorRectangulo() {
        return this.grosorRectangulo;
    }
}