/*
  * Clase Pelicula
  *  
  * Entornos de Usuario, Practica 1 
  * 
  */
package es.uv.eu.aplicacion3;
  /**
  *
  * @author Entornos de Usuario
  * @version 1.0
  * 
  */
  public class Pelicula {
    public final static int TERROR=0, CIENCIA_FICCION=1, ACCION=2, SUSPENSE=3, COMEDIA=4;
    private static final String[] generos = { "Terror", "Ciencia ficcion", "Accion", "Suspense", "Comedia" };

    /*
    * Titulo de la pelicula.
    */
    private String titulo;
    /*
    * Nombre del director.
    */
    private String director;
    /*
    * Anyo de produccion.
    */
    private int anyo;
    /*
    * Codigo generado automaticamente para la pelicula
    */
    private int codigo;

    /*
    * Genero de la pelicula
    */
    private int genero;

    /*
    * Variable de clase para almacenar el proximo codigo que sera asignado a una pelicula
    */
    private static int proximoCodigo=0;
    
    /**
    * Constructor de Pelicula
    * @param titulo Titulo de la pelicula.
    * @param director Nombre del director.
    * @param anyo Anyo de produccion.
    */
    public Pelicula(String titulo, String director, int anyo, int genero) {
        this.titulo = titulo;
        this.director = director;
        this.anyo = anyo;
        this.genero = genero;
        codigo = proximoCodigo;
        proximoCodigo++;
    }     
    
    /**
    * Devuelve el anyo de produccion de la pelicula.
    * @return Anyo de produccion de la pelicula.
    */
    public int getAnyo() {
      return anyo;
    }
    
    /**
    * Asigna el anyo de produccion de la pelicula.
    * @param anyo Anyo de produccion de la pelicula.
    */
    public void setAnyo(int anyo) {
      this.anyo = anyo;
    }
    
    /**
    * Obtiene el nombre del director de la pelicula.
    * @return Nombre del director de la pelicula.
    */
    public String getDirector() {
      return director;
    }
    
    /**
    * Asigna el nombre del director de la pelicula.
    * @param director Nombre del director de la pelicula.
    */
    public void setDirector(String director) {
      this.director = director;
    }
    
    /**
    * Obtiene el titulo de la pelicula.
    * @return  Titulo de la pelicula.
    */
    public String getTitulo() {
      return titulo;
    }
    
    /**
    * Asigna el titulo de la pelicula.
    * @param titulo Titulo de la pelicula.
    */
    public void setTitulo(String titulo) {
      this.titulo = titulo;
    }
  
    /**
    * Devuelve un entero con el codigo de la pelicula
    * @return El entero correspondiente
    */
    public int getCodigo() {
        return codigo;
    }

    /**
    * Devuelve un entero con el codigo del genero de la pelicula
    * @return El entero correspondiente
    */
    public int getGenero(){
        return genero;
    }    
  
    /**
    * Asigna el genero a la pelicula
    * @param genero 
    */
    public void setGenero(int genero) {
        this.genero=genero;
    }

    /**
    * Devuelve una cadena que contiene el genero de la pelicula
    * @return La cadena
    */
    public String getGeneroComoCadena(){
        return generos[genero];
    }

    @Override
    public String toString(){
        return "Codigo:"+codigo+"\n"+"Pelicula: "+titulo+"\n"+"Director: "+director+
            "\n"+"Anyo: "+anyo+"\n"+"Genero: "+generos[genero]+"\n";
    }

}