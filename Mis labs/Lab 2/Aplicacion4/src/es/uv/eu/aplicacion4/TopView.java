package es.uv.eu.aplicacion4;

import javax.swing.JFrame;

public class TopView extends JFrame{
    private PeliculaModel modelo;
    private int[] top = new int[3];

    public TopView(PeliculaModel modelo){
        this.modelo = modelo;
    }

    public int[] getTop(){
        int agno1 = -1;
        int agno2 = -1;
        int agno3 = -1;

        int id1 = 0;
        int id2 = 0;
        int id3 = 0;

        for (Pelicula p : modelo.getPeliculas()) {
            int id = p.getCodigo();
            int agno = p.getAnyo();
            if (agno > agno1) {
                agno3 = agno2;
                id3 = id2;
                agno2 = agno1;
                id2 = id1;
                agno1 = agno;
                id1 = id;
            } else if (agno > agno2 && agno != agno1) {
                agno3 = agno2;
                id3 = id2;
                agno2 = agno;
                id2 = id;
            } else if (agno > agno3 && agno != agno2 && agno != agno1) {
                agno3 = agno;
                id3 = id;
            }
            top[0] = id1;
            top[1] = id2;
            top[2] = id3;
        }
        return top;
    }
}
