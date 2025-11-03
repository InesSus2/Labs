package es.uv.eu.aplicacion4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class PeliculaModel {
    private HashSet<Pelicula> peliculas;
    
    public PeliculaModel(){
        peliculas = new HashSet<>();
    }
    
    /**
    * Anyade una pelicula a la coleccion
    * @param p La pelicula que debe anyadirse
    * @return verdadero si la operacion ha tenido exito o falso si no cabe
    */
    public boolean add(Pelicula p){
        return peliculas.add(p);
    }

    public int getNumeroPeliculas() {
        return peliculas.size();
    }

    public HashSet<Pelicula> getPeliculas() {
        return peliculas;
    }

    public String[] getTitulosPorIds(int[] top) {
        String[] titulos = new String[3]; //siempre es 3
        int i = 0;

        // Recorremos los IDs guardados en el array 'top'
        for (int x = 0; x < 3; x++) {
            int idBuscado = top[x];

            // Recorremos el HashSet de películas
            for (Pelicula p : peliculas) {
                if (p.getCodigo() == idBuscado) {
                    titulos[i] = p.getTitulo();
                    break; // cuando encuentra el id, pasa al siguiente
                }
            }
            i++;
        }

        return titulos;
    }
    
    @Override
    public String toString(){
        String resultado="";
        for (Pelicula p : peliculas) {
            resultado=resultado+p.toString()+"\n";
        }
        return resultado; 
    }
    
    public static void main(String[] argv) {
        PeliculaModel coleccion=new PeliculaModel();
        coleccion.add(new Pelicula("2001: Una Odisea en el Espacio",
            "Stanley Kubrick",1968,Pelicula.CIENCIA_FICCION));
        coleccion.add(new Pelicula("2046","Wong Kar Wai",2004,
            Pelicula.CIENCIA_FICCION));
        System.out.println(coleccion);
    }
}