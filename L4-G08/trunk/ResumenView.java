package es.uv.eu.aplicacion4;

import javax.swing.JFrame;

public class ResumenView extends JFrame{
    private PeliculaModel modelo;

    public ResumenView(PeliculaModel modelo){
        this.modelo = modelo;
    }

    public int contarPelis(){
        return modelo.getNumeroPeliculas();
    }
}