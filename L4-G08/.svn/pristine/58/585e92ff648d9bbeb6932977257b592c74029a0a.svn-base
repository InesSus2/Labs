package es.uv.eu.Ahorcado.model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;

/*********************************************************************
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 ********************************************************************/

public class AhorcadoModel {
    private String palabraSecreta;
    private Set<Character> letrasUsadas;
    private int fallos;
    private int puntuacion;
    private BufferedImage imagenAhorcado;
    private int estiloActual = 0; // Sin estilo predefinido
    private static Persona[] p_vec = new Persona[10]; // Static para mantener entre instancias
    public static final int MAX_FALLOS = 5;
    private static int num_personas = 0;

    /*********************************************************************
     * @brief Constructor del model sin parametros
     ********************************************************************/
    public AhorcadoModel() {
        this.palabraSecreta = "";
        this.letrasUsadas = new HashSet<>();
        this.fallos = 0;
        this.puntuacion = 0;
        this.estiloActual = 0; ///< Sin estilo predefinido

        cargarImagenInicio();  ///< SOLO la imagen de inicio
    }

    /*********************************************************************
     * @brief Constructor del model con parametros
     ********************************************************************/
    public AhorcadoModel(String palabra) {
        this.palabraSecreta = palabra.toUpperCase();
        this.letrasUsadas = new HashSet<>();
        this.fallos = 0;
        this.puntuacion = 0;

        ///< Si aún no se eligió estilo, pone uno por defecto para cargar Fallo0
        if (estiloActual == 0) estiloActual = 1;

        ///< Cargar imagen inicial (Fallo0) según el estilo
        cargarImagenSegunEstiloYFallos();
    }

    /****************** cargarImagenSegunEstiloYFallos() *****************
     * @bref Carga la imagen desde recursos: /Estilos/EstiloX/FalloY.png
     ********************************************************************/
    private void cargarImagenSegunEstiloYFallos() {
        if (estiloActual == 0) estiloActual = 2; // estilo por defecto
        if (fallos < 0) fallos = 0;
        if (fallos > MAX_FALLOS) fallos = MAX_FALLOS;

        String ruta = "/Estilos/Estilo" + estiloActual + "/Fallo" + fallos + ".png";

        try {
            var url = getClass().getResource(ruta);

            if (url != null) {
                imagenAhorcado = ImageIO.read(url);
            } else {
                crearImagenDeRespaldo("No encuentro " + ruta);
            }
        } catch (IOException e) {
            crearImagenDeRespaldo("Error cargando " + ruta);
        }
    }

    /*************************** setEstilo() *****************************
     * @brief Establece el estilo actual (1, 2 o 3)
     * 
     * @param estilo Estilo a establecer (1, 2 o 3)
     ********************************************************************/
    
    public void setEstilo(int estilo) {
        if (estilo < 1 || estilo > 3) {
            throw new IllegalArgumentException("Estilo inválido");
        }

        this.estiloActual = estilo;

        //< Para que al cambiar estilo empiece en Fallo0
        this.fallos = 0;

        cargarImagenSegunEstiloYFallos();
    }

    /*************************** probarLetra() ***************************
     * @brief Procesa una letra introducida por el usuario. La puntuación
     * se incrementa en 1 por cada letra introducida (sea correcta o no).
     * 
     * @param letra Letra introducida por el usuario
     * @param estilo Estilo del dibujo (1, 2 o 3)
     * 
     * @return true Si la letra está en la palabra
     * @return false Si la letra no está o ya fue usada
     ********************************************************************/
    public boolean probarLetra(char letra, int estilo) {
        letra = Character.toUpperCase(letra);

        ///< Actualizar estilo si es diferente
        if (this.estiloActual != estilo) {
            setEstilo(estilo);
        }

        ///< Si la letra ya fue usada, no incrementar puntuación ni procesarla
        if (letrasUsadas.contains(letra)) {
            return false; // Letra ya usada
        }

        ///< Agregar la letra al conjunto de letras usadas
        letrasUsadas.add(letra);
        
        ///< Incrementar puntuación por cada letra introducida (nueva especificación)
        puntuacion++;

        ///< Verificar si la letra está en la palabra secreta
        if (!palabraSecreta.contains(String.valueOf(letra))) {
            ///< La letra NO está en la palabra: incrementar fallos
            fallos++;
            ///< Cargar nueva imagen según fallos
            cargarImagenSegunEstiloYFallos();
            return false;
        }
        
        ///< La letra SÍ está en la palabra
        return true;
    }

    /************************ probarLetraEstilo1() ***********************
     * @brief Versiones específicas por estilo (Estilo 1)
     * 
     * @param letra Letra introducida por el usuario
     * @return true Si la letra está en la palabra
     * @return false Si la letra no está o ya fue usada
     ********************************************************************/
    public boolean probarLetraEstilo1(char letra) {
        return probarLetra(letra, 1);
    }

    /************************ probarLetraEstilo2() ***********************
     * @brief Versiones específicas por estilo  (Estilo 2)
     * 
     * @param letra Letra introducida por el usuario
     * @return true Si la letra está en la palabra
     * @return false Si la letra no está o ya fue usada
     ********************************************************************/
    public boolean probarLetraEstilo2(char letra) {
        return probarLetra(letra, 2);
    }

    /************************ probarLetraEstilo3() ***********************
     * @brief Versiones específicas por estilo  (Estilo 3)
     * 
     * @param letra Letra introducida por el usuario
     * @return true Si la letra está en la palabra
     * @return false Si la letra no está o ya fue usada
     ********************************************************************/
    public boolean probarLetraEstilo3(char letra) {
        return probarLetra(letra, 3);
    }
    
    /************************ palabraCompletada() ***********************
     * @brief Comprueba si la palabra secreta ha sido completada
     * 
     * @return true Si la palabra está completa
     * @return false Si la palabra no está completa
     ********************************************************************/
    public boolean palabraCompletada() {
        // Recorre todas las letras de la palabra secreta:
        for (int i = 0; i < palabraSecreta.length(); i++) {
            char c = palabraSecreta.charAt(i);
            if (!letrasUsadas.contains(c)) {
                return false;
            }
        }
        return true;
    }

    /************************ crearImagenDeRespaldo() ********************
     * @brief Crea imagen de respaldo
     * 
     * @param texto Texto a mostrar en la imagen de respaldo
     ********************************************************************/
    private void crearImagenDeRespaldo(String texto) {
        imagenAhorcado = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D g2d = imagenAhorcado.createGraphics();

        g2d.setColor(java.awt.Color.WHITE);
        g2d.fillRect(0, 0, 400, 400);
        g2d.setColor(java.awt.Color.BLACK);
        g2d.drawRect(0, 0, 399, 399);
        g2d.setColor(java.awt.Color.RED);
        g2d.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        g2d.drawString(texto, 20, 200);
        g2d.dispose();
    }

    /************************* getImagenAhorcado() ***********************
     * @brief Getter para la imagen del ahorcado
     * 
     * @return Imagen del ahorcado
     ********************************************************************/
    public BufferedImage getImagenAhorcado() {
        return imagenAhorcado;
    }

    /************************* getFallos() *******************************
     * @brief Getter para el número de fallos
     * 
     * @return Número de fallos
     ********************************************************************/
    public int getFallos() {
        return fallos;
    }

    /************************** getPuntuacion() **************************
     * @brief Getter para la puntuación
     * 
     * @return Puntuación
     ********************************************************************/
    public int getPuntuacion() {
        return puntuacion;
    }

    /************************** getLetrasUsadas() ***********************
     * @brief Getter para las letras usadas
     * 
     * @return Conjunto de letras usadas
     ********************************************************************/
    public Set<Character> getLetrasUsadas() {
        return letrasUsadas;
    }

    /************************* getPalabraSecreta() ***********************
     * @brief Getter para la palabra secreta
     * 
     * @return Palabra secreta
     ********************************************************************/
    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    /************************** getEstiloActual() ***********************
     * @brief Getter para el estilo actual
     * 
     * @return Estilo actual
     ********************************************************************/
    public int getEstiloActual() {
        return estiloActual;
    }

    /*************************** Persona() *******************************
     * @brief Clase persona que contiene la informacion de una persona
     ********************************************************************/
    public static class Persona{
        private int intentos;
        private int ganar;
        private String nombre;
        private static int num = 0;

        public Persona(String n, int ganar, int intentos){
            this.nombre = n;
            this.ganar = ganar;
            this.intentos = intentos;
            num++;
        }

        /************************** getNombre() ******************************
         * @brief Getter para el nombre de la persona
         * 
         * @return Nombre de la persona
         ********************************************************************/
        public String getNombre(){
            return this.nombre;
        }

        /************************** getIntentos() ****************************
         * @brief Getter para los intentos de la persona
         * 
         * @return Intentos de la persona
         ********************************************************************/
        public int getIntentos(){
            return this.intentos;
        }

        /*************************** getGanar() ******************************
         * @brief Getter para saber si la persona ha ganado o perdido
         * 
         * @return Ganar de la persona (1 si ha ganado, 0 si ha perdido)
         ********************************************************************/
        public int getGanar(){
            return this.ganar;
        }

        /**************************** getNum() *******************************
         * @brief Getter para el número de personas en el ranking
         * 
         * @return num Número de personas
         ********************************************************************/
        public int getNum(){
            return num;
        }
    }

    /************************ agregarRanking() ***************************
     * @brief Función para agregar una persona en el array de jugadores.
     * Si el vector está completo, valida si la nueva puntuación es mejor
     * que la del último lugar y reemplaza si es necesario.
     * 
     * @param nombre Nombre del jugador
     * @param ganar Si ha ganado o perdido
     * @param veces Número de intentos
     ********************************************************************/
    public void agregarRanking(String nombre, int ganar, int veces){
        Persona p = new Persona(nombre, ganar, veces);
        Persona aux;

        ///< Si el vector está completo (10 personas)
        if (num_personas >= 10) {
            ///< Comparar con el último del ranking
            Persona ultimo = p_vec[9];
            
            boolean debeReemplazar = false;
            
            ///< Si la nueva puntuación tiene menos intentos, es mejor
            if (p.getIntentos() < ultimo.getIntentos()) {
                debeReemplazar = true;
            }
            ///< Si tienen el mismo número de intentos
            else if (p.getIntentos() == ultimo.getIntentos()) {
                ///< Si hay un ganador y un perdedor, el ganador es mejor
                if (p.getGanar() != ultimo.getGanar()) {
                    debeReemplazar = p.getGanar() > ultimo.getGanar();
                }
                ///< Si tienen el mismo status (ambos ganadores o ambos perdedores),
                ///< se mantiene el que ya está en el vector
                else {
                    debeReemplazar = false;
                }
            }
            ///< Si tiene más intentos, es peor, no se agrega
            
            ///< Solo reemplazar si la nueva puntuación es mejor
            if (debeReemplazar) {
                p_vec[9] = p;
            } else {
                ///< No se agrega, salir del método
                return;
            }
        } else {
            ///< El vector no está completo, agregar normalmente
            p_vec[num_personas] = p;
            num_personas++;
        }

        ///< Ordenar solo los elementos válidos (de 0 a num_personas-1)
        ///< Primero por intentos (menor es mejor), en caso de empate por ganar (ganador = 1 antes que perdedor = 0)
        for(int i = 0; i < num_personas - 1; i++){
            for(int j = i + 1; j < num_personas; j++){
                boolean debeIntercambiar = false;
                
                ///< Si el primero tiene más intentos que el segundo, intercambiar
                if(p_vec[i].getIntentos() > p_vec[j].getIntentos()) {
                    debeIntercambiar = true;
                }
                ///< Si tienen los mismos intentos, el ganador va primero
                else if(p_vec[i].getIntentos() == p_vec[j].getIntentos() 
                        && p_vec[i].getGanar() < p_vec[j].getGanar()) {
                    debeIntercambiar = true;
                }
                
                if(debeIntercambiar) {
                    aux = p_vec[i];
                    p_vec[i] = p_vec[j];
                    p_vec[j] = aux;
                }
            }
        }
    }

    /************************ resetearRanking() *************************
     * @brief Función para resetear el ranking
    ********************************************************************/
    public static void resetearRanking(){
        p_vec = new Persona[10];
        num_personas = 0;
    }

    /************************ mostrarRanking() **************************
     * @brief Función para mostrar el ranking
     * 
     * @return p_vec Array de personas
    ********************************************************************/
    public Persona[] mostrarRanking(){
        return p_vec;
    }
    
    /************************ getNumPersonas() **************************
     * @brief Función para obtener el numero de personas en el ranking
     * 
     * @return num_personas Número de personas
    ********************************************************************/
    public int getNumPersonas(){
        return num_personas;
    }
    
    /************************ cargarImagenInicio() **********************
     * @brief Carga la imagen de inicio (Inicio.png)
    ********************************************************************/
    private void cargarImagenInicio() {
        try {
            var url = getClass().getResource("/Inicio.png");
            if (url != null) {
                imagenAhorcado = ImageIO.read(url);
            } else {
                crearImagenDeRespaldo("No encuentro /Inicio.png");
            }
        } catch (IOException e) {
            crearImagenDeRespaldo("Error cargando Inicio.png");
        }
    }
}