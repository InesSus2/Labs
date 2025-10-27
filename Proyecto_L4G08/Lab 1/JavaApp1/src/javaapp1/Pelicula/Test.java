package javaapp1.Pelicula;

import java.util.HashSet;

public class Test {
    public static void main(String[] argv)
    {
        HashSet<Integer>hs = new HashSet<Integer>();
        hs.add(5);
        hs.add(6);

        int suma = 0;
        for(int numero:hs)
        {
            suma+=numero;
        }
        System.out.println("El valor de la suma es: " + suma);
    }
}
