package Ahorcado.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import Ahorcado.model.AhorcadoModel;

/**
 * Panel que muestra la imagen inicial del ahorcado
 * 
 * @author Inés
 * @author Natalia
 */
public class ImagenIniPanel extends JPanel {

    private AhorcadoModel modelo;
    private Border borde;
    private BufferedImage imagenActual; // Cache

    public ImagenIniPanel(AhorcadoModel modelo) {
        this.modelo = modelo;
        this.imagenActual = modelo.getImagenAhorcado();

        this.setLayout(new FlowLayout());
        this.setBackground(Color.WHITE);

        borde = BorderFactory.createLineBorder(Color.BLACK, 1);
        this.setBorder(borde);

        this.setPreferredSize(new Dimension(200, 200));
        this.setVisible(true);
    }

    /**
     * Método para actualizar la imagen desde fuera
     */
    public void actualizarImagen() {
        System.out.println("ImagenIniPanel: Actualizando imagen...");
        if (modelo != null) {
            this.imagenActual = modelo.getImagenAhorcado();
            
            SwingUtilities.invokeLater(() -> {
                repaint();
                revalidate();
            });
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagenActual != null) {
            g.drawImage(
                imagenActual,
                0,
                0,
                this.getWidth(),
                this.getHeight(),
                null
            );
        } else if (modelo != null && modelo.getImagenAhorcado() != null) {
            imagenActual = modelo.getImagenAhorcado();
            g.drawImage(
                imagenActual,
                0,
                0,
                this.getWidth(),
                this.getHeight(),
                null
            );
        }
    }

    public int translateX(int x) {
        BufferedImage imagen = modelo.getImagenAhorcado();
        if (imagen == null) return 0;
        return x * imagen.getWidth() / this.getWidth();
    }

    public int translateY(int y) {
        BufferedImage imagen = modelo.getImagenAhorcado();
        if (imagen == null) return 0;
        return y * imagen.getHeight() / this.getHeight();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba ImagenIniPanel");
            AhorcadoModel model = new AhorcadoModel(); // usa constructor sin parámetros

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new ImagenIniPanel(model));
            frame.setVisible(true);
        });
    }
}