package javaapp1.Pelicula;

import javax.swing.JOptionPane;

public class Starter {
    public static void main(String[] argv){
        String nombre, director;
        int anyo, genero, continuar;
        Coleccion coleccion = new Coleccion();
        String[] generos = {"Terror", "Ciencia Ficción", "Acción", "Suspense", "Comedia"};
        do{
            nombre = JOptionPane.showInputDialog(null, "Introduce el nombre de la película");
            director = JOptionPane.showInputDialog(null, "Introduce el director de la película");
            try{
                anyo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el anyo de la película"));
            } catch (NumberFormatException e){anyo = 0;};
            genero = JOptionPane.showOptionDialog(null, "Introduce el genero de la película", "Genero", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, generos, generos[0]);
            continuar = JOptionPane.showConfirmDialog(null, "Quieres continuar?", "Seleccione la opcion deseada", JOptionPane.YES_NO_OPTION);
            coleccion.add(new Pelicula(nombre, director, anyo, genero));
        }
        while(continuar == 0);
        JOptionPane.showMessageDialog(null, coleccion);
        System.out.println(coleccion);
    }
}