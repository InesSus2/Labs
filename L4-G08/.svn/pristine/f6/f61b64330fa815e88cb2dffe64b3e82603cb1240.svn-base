package Ahorcado.view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import Ahorcado.model.AhorcadoModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ImagenFallosPanel extends JPanel{
    private AhorcadoModel modelo;
    private Border borde;

    public ImagenFallosPanel(AhorcadoModel modelo){
        this.setLayout(new FlowLayout());
        this.modelo = modelo;
        borde = BorderFactory.createLineBorder(Color.BLACK, 1);

        this.setBorder(borde);
        this.setPreferredSize(new Dimension(150, 150));

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        BufferedImage imagen = modelo.getImagen();
        if(imagen != null){
            g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }

    public int translateX(int x) {
        return x * modelo.getImagen().getWidth() / this.getWidth();
    }

    public int translateY(int y) {
        return y * modelo.getImagen().getHeight() / this.getHeight();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba ImagenFallosPanel");
            AhorcadoModel modelo = new AhorcadoModel();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new ImagenFallosPanel(modelo));
            
            frame.setVisible(true);
        });
    }
}