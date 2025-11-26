/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uv.eu.photoeditor.controller;

import es.uv.eu.photoeditor.model.*;
import es.uv.eu.photoeditor.view.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/*
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
*/

/**
 *
 * @author Natalia Tauste Rubio
 * @author Inés Jaso Pernod
 * 
 */
public class PhotoEditorController {
    private PhotoEditorModel model;
    private PhotoEditorView view;

    public PhotoEditorController(PhotoEditorModel model, PhotoEditorView view){
        this.model = model;
        this.view = view;

        view.addWindowListener(new PhotoEditorControllerWindowListener());
        view.setActionListener(new PhotoEditorControllerActionListener());
        //view.addMouseListener(new PhotoEditorControllerMouseListener());
        view.getImagenPanel().addMouseListener(new PhotoEditorControllerMouseListener());
        
        view.getWidthSlider().addChangeListener(e -> {
            int valor = view.getWidthSlider().getValue();

            // 1) Actualizar el modelo
            model.setGrosorRectangulo(valor);

            // 2) Actualizar la vista (StatusPanel)
            view.getStatusPanel().setGrosRec(String.valueOf(valor));
        });
        
    }

    class PhotoEditorControllerWindowListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            System.out.println("PhotoEditorController: Cerrar ventana.");
            System.exit(0);
        }
    }

    class PhotoEditorControllerMouseListener extends MouseAdapter {
        private int x1 = -1, y1 = -1;

        @Override
        public void mousePressed(MouseEvent e) {

            /***************************************
            CLICK DERECHO: copiar Color1 a Color2
            ***************************************/
            if (e.getButton() == MouseEvent.BUTTON3) {
                Color col1 = view.getStatusPanel().getCol1();
                view.getStatusPanel().setCol2(col1);
                System.out.println("Click derecho → Color2 = Color1");
                return;
            }

            /***************************************
            CLICK IZQUIERDO: marcar puntos
            ***************************************/
            if (e.getButton() == MouseEvent.BUTTON1) {

                ImagePanel panel = view.getImagenPanel();
                int x = panel.translateX(e.getX());
                int y = panel.translateY(e.getY());

                // Primer punto
                if (x1 == -1 && y1 == -1) {
                    x1 = x;
                    y1 = y;
                    System.out.println("Primer punto (izq): (" + x1 + ", " + y1 + ")");
                    return;
                }

                // Segundo punto
                int x2 = x;
                int y2 = y;
                System.out.println("Segundo punto (izq): (" + x2 + ", " + y2 + ")");

                // Obtener parámetros
                int grosor = model.getGrosorRectangulo();
                Color col1 = view.getStatusPanel().getCol1();
                Color col2 = view.getStatusPanel().getCol2();

                // Dibujar rectángulo
                model.pintaRectangulo(x1, y1, x2, y2, grosor, col1, col2);

                // Repintar la imagen
                view.getImagenPanel().repaint();

                // Reset para permitir dibujar otro
                x1 = -1;
                y1 = -1;
            }
        }
    }

    class PhotoEditorControllerActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            String command = ae.getActionCommand();
            switch(command){
                case "CargarImagen":
                    System.out.println("PhotoEditorController: Acción recibida - CargarImagen");

                    JFileChooser selectorCargar = new JFileChooser();
                    selectorCargar.setFileFilter(
                        new FileNameExtensionFilter("Imágenes (JPG, PNG, GIF, TIFF)", 
                            "jpg", "png", "gif", "tiff")
                    );

                    int opcionCargar = selectorCargar.showOpenDialog(view);

                    if (opcionCargar == JFileChooser.APPROVE_OPTION) {
                        File ficheroCargar = selectorCargar.getSelectedFile();
                        model.loadImagen(ficheroCargar);
                        System.out.println("Imagen cargada: " + ficheroCargar.getAbsolutePath());
                        view.repaint();  // necesario para que se vea la nueva imagen
                    }
                    break;
                case "GuardarImagen":
                    System.out.println("PhotoEditorController: Acción recibida - GuardarImagen");
                    
                    JFileChooser selectorGuardar = new JFileChooser();
                    selectorGuardar.setFileFilter(new FileNameExtensionFilter("Imágenes JPG (*.jpg)", "jpg"));

                    int opcionGuardar = selectorGuardar.showSaveDialog(view);

                    if (opcionGuardar == JFileChooser.APPROVE_OPTION) {

                        File ficheroGuardar = selectorGuardar.getSelectedFile();
                        String path = ficheroGuardar.getAbsolutePath();

                        // Si no tiene extensión, añadimos .jpg
                        if (!path.toLowerCase().endsWith(".jpg")) {
                            ficheroGuardar = new File(path + ".jpg");
                        }

                        model.saveImagen(ficheroGuardar);

                        System.out.println("Imagen guardada en: " + ficheroGuardar.getAbsolutePath());

                        view.repaint();
                    }
                    break;
                case "Salir":
                    System.out.println("PhotoEditorController: Acción recibida - Salir");
                    System.exit(0);
                    break;
                default:
                    if (command.startsWith("BotonesColor_")) {
                        System.out.println("PhotoEditorController: Acción recibida - BotonesColor_");
                        String[] partes = command.split("_");
                        int panel = Integer.parseInt(partes[1]);  
                        String colorName = partes[2];

                        Color colorSeleccionado;

                        switch(colorName) {
                            case "Negro":
                                colorSeleccionado = Color.BLACK;
                                break;
                            case "Cyan":
                                colorSeleccionado = Color.CYAN;
                                break;
                            case "GrisOscuro":
                                colorSeleccionado = Color.DARK_GRAY;
                                break;
                            case "Gris":
                                colorSeleccionado = Color.GRAY;
                                break;
                            case "GrisClaro":
                                colorSeleccionado = Color.LIGHT_GRAY;
                                break;
                            case "Magenta":
                                colorSeleccionado = Color.MAGENTA;
                                break;
                            case "Naranja":
                                colorSeleccionado = Color.ORANGE;
                                break;
                            case "Rosa":
                                colorSeleccionado = Color.PINK;
                                break;
                            case "Amarillo":
                                colorSeleccionado = Color.YELLOW;
                                break;
                            case "Blanco":
                                colorSeleccionado = Color.WHITE;
                                break;
                            case "Rojo":
                                colorSeleccionado = Color.RED;
                                break;
                            case "Azul":
                                colorSeleccionado = Color.BLUE;
                                break;
                            case "Verde":
                                colorSeleccionado = Color.GREEN;
                                break;
                            default:
                                colorSeleccionado = Color.BLACK;
                                break;
                        }

                        if(panel == 1){
                            view.getStatusPanel().setCol1(colorSeleccionado);
                        } else if(panel == 2){
                            view.getStatusPanel().setCol2(colorSeleccionado);
                        }

                        System.out.println("Panel: " + panel + " | Color: " + colorName);
                    }
                break;
            }
        }
    }
}