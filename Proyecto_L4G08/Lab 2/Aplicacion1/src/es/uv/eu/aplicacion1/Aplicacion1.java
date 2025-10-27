package es.uv.eu.aplicacion1;
/**
 * JavaApplication: controlador del programa
 * 
 * @author Entornos de Usuario
 */
public class Aplicacion1 {
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PeliculaModel model = new PeliculaModel();
        creaPeliculas(model);
        
        PeliculaView view = new PeliculaView(model);

        view.setVisible(true);
    }
    
    static void creaPeliculas(PeliculaModel peliculas) {
        peliculas.add(new Pelicula("2001: Una Odisea en el Espacio","Stanley Kubrick",1968, Pelicula.CIENCIA_FICCION));
        peliculas.add(new Pelicula("2046","Wong Kar Wai",2004,Pelicula.CIENCIA_FICCION));
        peliculas.add(new Pelicula("Aeon Flux","Karyn Kusama",2005, Pelicula.CIENCIA_FICCION));
        peliculas.add(new Pelicula("Alien, el octavo pasajero","Ridley Scott",1979, Pelicula.CIENCIA_FICCION));
        peliculas.add(new Pelicula("Blade Runner","Ridley Scott",1982, Pelicula.CIENCIA_FICCION));
        peliculas.add(new Pelicula("Contact","Robert Zemeckis",1997, Pelicula.CIENCIA_FICCION));
        peliculas.add(new Pelicula("Las crónicas de Riddick","David Twohy",2004, Pelicula.CIENCIA_FICCION));
        peliculas.add(new Pelicula("Dune","David Lynch",1984, Pelicula.CIENCIA_FICCION));
        peliculas.add(new Pelicula("La guerra de los mundos","Byron Haskin",1953, Pelicula.CIENCIA_FICCION));
        peliculas.add(new Pelicula("El quinto elemento","Jean Luc Besson",1997, Pelicula.CIENCIA_FICCION));
        peliculas.add(new Pelicula("Pesadilla en Java Street","Miguel Arevalillo", 2012, Pelicula.TERROR));
    }
}

