package wordle.Model;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Clase modelo para Wordle
 * @author Paulo Medeiros Avila
 * @author Ines Jaso Pernod
 */
public class WordleModel {

    private String palabra = ""; // Nuestra palabra que hemos escogido
    private Persona[] p_vec = new Persona[10];
    private static int num_personas = 0;

    
    public WordleModel(){
    }

    /**
     * Asigna la palabra de la solucion
     * @param s palabra que queremos guardar
     */
    public void setPalabra(String s) {
        this.palabra = s;
    }

    /**
     * Devuelve la palabra
     * @return palabra
     */
    public String getPalabra() {
        return this.palabra;
    }

    /**
     * Algoritmo para crear un array de enteros que representan
     * el estado de cada letra. 1 significa que la letra esta en la posicion 
     * correcta, 2 significa que la letra esta contenida en la palabra y 0 
     * significa que no esta en la posicion/en la palabra
     * 
     * @param palabraUser La palabra del usuario
     * @return Array de solucion
     */
    public int[] comprobar(String palabraUser){
        int[] res = new int[palabra.length()];
        String faltan = palabra;
        
        Arrays.fill(res,0); // Todas mal por defecto
        
        String palabraaux = this.palabra;
        
        // Recorrido de letras correctas
        for(int i = 0;i < palabra.length();i++){
            char c = palabraUser.charAt(i);
            if(palabraaux.charAt(i) == c){
                res[i] = 1;
                faltan = faltan.replaceFirst(c+"",""); // Se guardan las letras que faltan por encontrar
            }///IF
        }///FOR
        
        //Letras amarillas
        for(int i = 0;i<palabra.length();i++){
            char c = palabraUser.charAt(i);
            if(palabraaux.contains(c+"") && res[i] != 1){
                res[i] = 2;
            }///IF
            
            if(palabraaux.contains("" + c) && !faltan.contains(c+"")  && res[i] != 1)
                res[i] = 0;
            faltan = faltan.replaceFirst(c+"",""); // Quitas las letras que ya has marcado como amarillas
                
        }///FOR
        return res;
    }
    
    /**
     * Funcion para agregar una persona en el array de jugadores
     * @param ganar si ha ganado o perdido
     * @param veces cuantos intentos
     */
    public void agregarRanking(int ganar,int veces){
        Persona p = new Persona(JOptionPane.showInputDialog(null,
                "Introduce el nombre del jugador 2 "),ganar,veces);
        Persona aux;
        
        p_vec[num_personas] = p; 
        num_personas++; // Se suma 1 al total de personas que son contenidas en el array
        
        for(int i = 0; i < num_personas; i++){ // Se ordenan las entradas cada vez que se introduce un dato
        for(int j = 0; j < num_personas; j++){
            if(p_vec[j].getIntentos() > p_vec[i].getIntentos()) 
            {
                aux = p_vec[i];
                p_vec[i] = p_vec[j];
                p_vec[j] = aux;
            }
        }
        }
    }
    
    /**
     * Devuelve el vector personas
     * @return 
     */
    public Persona[] mostrarRanking(){
        return p_vec;
    }
    
    /**
     * Clase persona que contiene la informacion de una 
     * persona
     */
    public class Persona{
        private int intentos;
        private int ganar;
        private String nombre;
        private static int num = 0;
        
        /**
         * Constructor por defectos
         * @param n Nombre
         * @param ganar Si ha ganado o no
         * @param intentos Numero de intentos
         */
        public Persona(String n,int ganar,int intentos){
            this.nombre = n;
            this.ganar = ganar;
            this.intentos = intentos;
            num++;
        }
        /**
         * getter de nombre
         * @return 
         */
       public String getNombre(){
           return this.nombre;
       }
       /**
        * getter de intentos
        * @return 
        */
       public int getIntentos(){
           return this.intentos;
       }
       /**
        * getter de si ha ganado o no
        * @return 
        */
       public int getGanar(){
           return this.ganar;
       }
       /**
        * Getter de numero de personas
        * @return 
        */
       public int getNum(){
           return num;
       }
    }
}
