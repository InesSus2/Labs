package javaapp1.Pelicula;

import java.util.HashSet;
public class Coleccion {
    private HashSet<Pelicula> peliculas;
    
    public Coleccion(){
        peliculas = new HashSet<Pelicula>();
    }

    public boolean add(Pelicula p){
        return peliculas.add(p);
    }

    public String toString(){
        String resultado = "";
        for(Pelicula p:peliculas)
            resultado = resultado + p.toString() + "\n";
        return resultado;
    }

    public static void main(String[] argv){
        Coleccion coleccion = new Coleccion();
        coleccion.add(new Pelicula("2001: Una Odisea en el Espacio", "Stanley Kubrick", 1968, Pelicula.CIENCIA_FICCION));
        coleccion.add(new Pelicula("2046", "Wong Kar Wai", 2004, Pelicula.CIENCIA_FICCION));
        System.out.println(coleccion);
    }
}