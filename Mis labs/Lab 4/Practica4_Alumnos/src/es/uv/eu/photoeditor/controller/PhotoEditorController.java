/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uv.eu.photoeditor.controller;

import es.uv.eu.photoeditor.model.*;
import es.uv.eu.photoeditor.view.*;

/**
 *
 * @author Natalia Tauste Rubio
 * 
 */
public class PhotoEditorController {
    private PhotoEditorModel modelo;
    private PhotoEditorView vista;

    public PhotoEditorController(PhotoEditorModel modelo, PhotoEditorView vista){
        this.modelo = modelo;
        this.vista = vista;
    }
}
