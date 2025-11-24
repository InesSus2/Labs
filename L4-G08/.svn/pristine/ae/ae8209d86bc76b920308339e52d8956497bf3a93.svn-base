/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uv.eu.photoeditor.controller;

import es.uv.eu.photoeditor.model.*;
import es.uv.eu.photoeditor.view.*;
import java.awt.event.*;

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
    }

    class PhotoEditorControllerWindowListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            System.out.println("PhotoEditorController: Cerrar ventana.");
            System.exit(0);
        }
    }

    class PhotoEditorControllerActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            String command = ae.getActionCommand();
            switch(command){
                case "Botones":
                case "CargarImagen":
                case "GuardarImagen":
                case "Salir":
            }
        }
    }
}