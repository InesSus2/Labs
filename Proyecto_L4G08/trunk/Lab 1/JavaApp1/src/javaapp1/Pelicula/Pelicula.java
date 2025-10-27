/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapp1.Pelicula;

/**
 *
 * @author inesjasopernod
 */
public class Pelicula {
    private String titulo;
    private String director;
    private int anyo;
    private int codigo;
    private static int proximoCodigo = 0;
    private int genero;
    public final static int TERROR = 0, CIENCIA_FICCION = 1, ACCION = 2, SUSPENSE = 3, COMEDIA = 4;

    public Pelicula(String titulo, String director, int anyo, int genero){
        this.titulo = titulo;
        this.director = director;
        this.anyo = anyo;
        codigo = proximoCodigo;
        proximoCodigo++;
    }

    public int getAnyo(){
        return anyo;
    }

    public void setAnyo(int anyo){
        this.anyo = anyo;
    }

    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public int getCodigo(){
        return codigo;
    }

    public int getGenero(){
        return genero;
    }

    public void setGenero(int genero){
        this.genero = genero;
    }

    public String toString(){
        String cadenaGenero="";
        switch(genero){
            case 0:
                cadenaGenero = "Terror";
                break;
            case 1:
                cadenaGenero = "Ciencia Ficción";
                break;
            case 2:
                cadenaGenero = "Acción";
                break;
            case 3:
                cadenaGenero = "Suspense";
                break;
            case 4:
                cadenaGenero = "Comedia";
                break;
        }
        return "Pelicula: " + titulo + "\n" + "Director: " + director + "\n" + "Año: " + anyo + "\n" + "Genero: " + cadenaGenero + "\n";
    }

    public static void main(String[] args){
        Pelicula peli1, peli2;
        peli1 = new Pelicula("2001: Una odisea en el espacio", "Stanley Kubrick", 1968, Pelicula.CIENCIA_FICCION);
        peli2 = new Pelicula("2046", "Wong Kar Wai", 2004, Pelicula.CIENCIA_FICCION);
        System.out.println(peli1);
        System.out.println(peli2);
    }
}