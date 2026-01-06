package es.uv.eu.Ahorcado.view;

import es.uv.eu.Ahorcado.model.AhorcadoModel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import es.uv.eu.Ahorcado.model.AhorcadoModel.Persona;

/*********************************************************************
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 ********************************************************************/

public class AhorcadoView extends JFrame {
    private AhorcadoMenuBar menu;
    private ImagenesPanel imagenesPanel;
    private ConfiguracionPanel configuracionPanel;
    private RankingPanel rank;
    private JuegoPanel juegoPanel;
    private Persona[] p = new Persona[10];
    private int num_personas = 0;

    public AhorcadoView() {
        this.setLayout(new GridLayout(1,2));
        menu = new AhorcadoMenuBar();
        imagenesPanel = new ImagenesPanel();
        configuracionPanel = new ConfiguracionPanel();

        this.setSize(1200, 800);

        this.setJMenuBar(menu);
        this.add(imagenesPanel);
        this.add(configuracionPanel);
        this.setVisible(true);
    }

    /************************** cambiarVista() ***************************
     * @brief Cambia la vista del JFrame al panel especificado
     * 
     * @param panel JPanel al que cambiar la vista
     ********************************************************************/
    private void cambiarVista(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    /********************* actualizarImagenJuego() ***********************
     * @brief Actualiza la imagen del ahorcado en el panel de juego
     ********************************************************************/
    public void actualizarImagenJuego() {
        if (juegoPanel != null) {
            juegoPanel.actualizarImagenAhorcado();
        }
    }

    /********************* postJuegoPanel() ******************************
     * @brief Método para entrar a la ventana de juego
     * 
     * @param model Modelo del juego
     * @param tamPalabra Tamaño de la palabra secreta
     ********************************************************************/
    public void postJuegoPanel(AhorcadoModel model, int tamPalabra) {
        juegoPanel = new JuegoPanel(model, tamPalabra);
        cambiarVista(juegoPanel);
    }

    /*************************** postRanking() ***************************
     * @brief Método para cerrar la ventana inicial y abrir la del ranking
     ********************************************************************/
    public void postRanking() {
        rank = new RankingPanel(p, num_personas);
        cambiarVista(rank);
    }

    /*************************** volverAInicio() *************************
     * @brief Método para cerrar la ventana actual y volver a la de inicio
     ********************************************************************/
    public void volverAInicio() {
        mostrarInicio();
    }

    /*************************** closeRanking() **************************
     * @brief Método para cerrar la ventana del ranking y volver a
     * la inicial
     ********************************************************************/
    public void closeRanking(){
        if (rank != null) {
            remove(rank);
            rank = null;
        }

        mostrarInicio();
    }

    /*************************** closeJuegoPanel() ***********************
     * @brief Metodo para cerrar la ventana del juego y volver a
     * la inicial
     ********************************************************************/
    public void closeJuegoPanel(){
        if (juegoPanel != null) {
            remove(juegoPanel);
            juegoPanel = null;
        }

        volverAPantallaInicial();
    }

    /*************************** mostrarInicio() *************************
     * @brief Método para crear un nuevo panel inicial
     ********************************************************************/
    public void mostrarInicio() {
        JPanel inicio = new JPanel(new GridLayout(1, 2));
        inicio.add(imagenesPanel);
        inicio.add(configuracionPanel);

        cambiarVista(inicio);
    }

    /************************ volverAPantallaInicial() *******************
     * @brief Método para cerrar el panel actual y volver al inicial
     ********************************************************************/
    private void volverAPantallaInicial() {
        if (imagenesPanel.getParent() == null)
            this.add(imagenesPanel);

        if (configuracionPanel.getParent() == null)
            this.add(configuracionPanel);

        this.revalidate();
        this.repaint();
    }

    /************************ getTemaPalabra() ***************************
     * @brief Getter para el tema de la palabra seleccionado
     * 
     * @return Tema de la palabra seleccionado
     ********************************************************************/
    public String getTemaPalabra() {
        return configuracionPanel.getTemaPalabra();
    }

    /************************ getEstiloDibujo() **************************
     * @brief Getter para el estilo de dibujo seleccionado
     * 
     * @return Estilo de dibujo seleccionado
     ********************************************************************/
    public String getEstiloDibujo() {
        return configuracionPanel.getEstiloDibujo();
    }

    /************************ getColorLetrasAdiv() ***********************
     * @brief Getter para el color de las letras adivinadas
     * 
     * @return Color de las letras adivinadas
     ********************************************************************/
    public String getColorLetrasAdiv() {
        return configuracionPanel.getColorLetrasAdiv();
    }

    /************************ getColorLetrasUtil() ***********************
     * @brief Getter para el color de las letras utilizadas
     * 
     * @return Color de las letras utilizadas
     ********************************************************************/
    public String getColorLetrasUtil() {
        return configuracionPanel.getColorLetrasUtil();
    }

    /************************ getLetraIntroducida() **********************
     * @brief Getter para la letra introducida por el usuario
     * 
     * @return Letra introducida por el usuario
     ********************************************************************/
    public char getLetraIntroducida() {
        return juegoPanel.getLetraIntroducida();
    }

    /************************ getSlider() ********************************
     * @brief Getter para el número de letras seleccionado
     * 
     * @return Número de letras seleccionado
     ********************************************************************/
    public int getSlider() {
        return configuracionPanel.getSlider();
    }

    /************************ getNombreUsu() *****************************
     * @brief Getter para el nombre del usuario
     * 
     * @return Nombre del usuario
     ********************************************************************/
    public String getNombreUsu() {
        return configuracionPanel.getNombreUsu();
    }

    /************************ getTextoIntroducido() **********************
     * @brief Getter para el texto introducido por el usuario
     * 
     * @return Texto introducido por el usuario
     ********************************************************************/
    public String getTextoIntroducido() {
        return juegoPanel.getTextoIntroducido();
    }

    /******************************** setVector() ************************
     * @brief Asigna el vector del model al view
     * 
     * @param p_vec vector de personas en el model
     * @param personas numero de personas
     ********************************************************************/
    public void setVector(Persona[] p_vec,int personas){
        this.num_personas = personas;
        this.p = p_vec;
    }

    /*********************** actualizarPalabraAdivinada() ****************
     * @brief Método para actualizar la palabra adivinada
     * en el panel de juego
     * 
     * @param palabra Palabra a adivinar
     * @param letra Letra introducida por el usuario
     * @param color Color de la letra
     ********************************************************************/
    public void actualizarPalabraAdivinada(String palabra, char letra, Color color) {
        juegoPanel.actualizarPalabraAdivinada(palabra, letra, color);
    }

    /*********************** convertirColor() ****************************
     * @brief Método para convertir una cadena de color a un objeto Color
     * 
     * @param color Cadena de color
     * 
     * @return Objeto Color correspondiente
     ********************************************************************/
    public Color convertirColor(String color) {
        if (color == null) return Color.BLACK;

        switch (color) {
            case "Rojo":
                return Color.RED;
            case "Azul":
                return Color.BLUE;
            case "Verde":
                return Color.GREEN;
            case "Amarillo":
                return Color.YELLOW;
            case "Naranja":
                return Color.ORANGE;
            default:
                return Color.BLACK;
        }
    }

    /*********************** resetTextField() ****************************
     * @brief Método para resetear el TextField del panel de juego
     ********************************************************************/
    public void resetTextField(){
        juegoPanel.resetTextField();
    }

    /*********************** resetConfiguracion() ************************
     * @brief Método para resetear la configuración del
     * panel de configuración
     ********************************************************************/
    public void resetConfiguracion() {
        configuracionPanel.reset();
    }

    /*********************** setPuntuacionUsuLabel() *********************
     * @brief Método para asignar la puntuación del usuario
     * en el panel de juego
     ********************************************************************/
    public void setPuntuacionUsuLabel(int puntuacion) {
        juegoPanel.setPuntuacionUsuLabel(puntuacion);
    }

    /********************** setNumFallosUsuLabel() ***********************
     * @brief Método para asignar el número de fallos del usuario
     * en el panel de juego
     ********************************************************************/
    public void setNumFallosUsuLabel(int numFallos) {
        juegoPanel.setNumFallosUsuLabel(numFallos);
    }

    /************************** appendTextArea() *************************
     * @brief Método para añadir la letras al TextArea del panel de juego
     * 
     * @param letra Letra introducida
     * @param color Color de la letra
     * @param fallos Número de fallos
     ********************************************************************/
    public void appendTextArea(char letra, Color color, int fallos) {
        juegoPanel.appendTextArea(letra, color, fallos);
    }

    /************************ setActionListener() ************************
     * @brief Asigna un ActionListener solo a los paneles que existen
     * 
     * @param al ActionListener a asignar
     ********************************************************************/
    public void setActionListener(ActionListener al){
        menu.setActionListener(al);
        configuracionPanel.setActionListener(al);

        if (juegoPanel != null) {
            juegoPanel.setActionListener(al);
        }
    }
    
    /******************** setJuegoPanelActionListener() ******************
     * @brief Método para asignar listener solo al panel de juego si existe
     * 
     * @param actionListener ActionListener a asignar
     ********************************************************************/
    public void setJuegoPanelActionListener(ActionListener al){
        if (juegoPanel != null) {
            juegoPanel.setActionListener(al);
        }
    }

    /************************ setRankingListener() ***********************
     * @brief Método para asignar listener solo al panel de ranking
     * 
     * @param actionListener ActionListener a asignar
     ********************************************************************/
    public void setRankingListener(ActionListener al) {
        if (rank != null) {
            rank.setActionListener(al);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Prueba AhorcadoView");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new AhorcadoView());
            
            frame.setVisible(true);
        });
    }
}