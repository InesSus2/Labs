package javaapp1.Herencia;

public class Padre {
    Padre(){
        System.out.println("Creando Padre");
    }

    Padre(int a){
        System.out.println("Creando padre con parametro");
    }
}

class Hijo extends Padre{
    Hijo(){
        System.out.println("Creando Hijo");
    }

    Hijo(int a){
        System.out.println("Creando Hijo con parametro");
    }

    Hijo(int a, int b){
        super(b);
        System.out.println("Creando Hijo con dos parametros");
    }
}

class Nieto extends Hijo{
    Nieto(){
        System.out.println("Creando Nieto");
    }
}