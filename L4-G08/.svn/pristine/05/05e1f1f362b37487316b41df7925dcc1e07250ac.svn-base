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

    /*
    class PhotoEditorControllerMouseListener extends MouseListener{
        @Override
        public void mouseClicked(MouseEvent me){
            System.out.println("PhotoEditorController: Click en la imagen.");
        }
    }
    */

    class PhotoEditorControllerActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            String command = ae.getActionCommand();
            switch(command){
                case "BotonesColor":
                    System.out.println("PhotoEditorController: Acción recibida - Botones");

                    // Todos los botones de color deben tener ActionCommand: "BotonesColor_<nPanel>_<ColorName>"
                    if (command.startsWith("BotonesColor_")) {

                        String[] partes = command.split("_");
                        int panel = Integer.parseInt(partes[1]);  // 1 = panelArriba, 2 = panelAbajo
                        String colorName = partes[2];            // Ej: Rojo, Azul, GrisClaro

                        // Convertir nombre de color a java.awt.Color
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
                        }

                        // Actualizar StatusPanel según el panel
                        if(panel == 1){
                            view.getStatusPanel().setCol1(colorSeleccionado);
                        } else if(panel == 2){
                            view.getStatusPanel().setCol2(colorSeleccionado);
                        }

                        System.out.println("Panel: " + panel + " | Color: " + colorName);
                    }

                    break;
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
                    selectorGuardar.setFileFilter(
                        new FileNameExtensionFilter("Imágenes (JPG, PNG, GIF, TIFF)", 
                            "jpg", "png", "gif", "tiff")
                    );

                    int opcionGuardar = selectorGuardar.showOpenDialog(view);

                    if (opcionGuardar == JFileChooser.APPROVE_OPTION) {
                        File ficheroCargar = selectorGuardar.getSelectedFile();
                        model.saveImagen(ficheroCargar);
                        System.out.println("Imagen cargada: " + ficheroCargar.getAbsolutePath());
                        view.repaint();  // necesario para que se vea la nueva imagen
                    }
                    break;
                case "Salir":
                    System.out.println("PhotoEditorController: Acción recibida - Salir");
                    System.exit(0);
                    break;
            }
        }
    }
}