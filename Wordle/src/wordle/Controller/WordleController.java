package wordle.Controller;

import wordle.Model.WordleModel;
import wordle.View.WordleView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Clase controladora de Wordle
 * 
 * @author Paulo Medeiros Avila
 * @author Ines Jaso Pernod
 */
public class WordleController {

    private WordleView view;
    private WordleModel model;

    private int pos = 0;
    private int caracteres;
    private String palabra = "";
    private int[] solaux;
    private int[] solucion;
    private int intentos = 0;
    private int partidas = 0;

    /**
     * Implementacion de controller
     * @param view Vista del programa
     * @param model Modelo del programa
     */
    public WordleController(WordleView view, WordleModel model) {

        this.view = view;
        this.model = model;

        view.addWindowListener(new WordleControllerWindow());
        view.optionsListener(new WordleControllerActionListener());
        view.panelj1Listener(new WordleControllerActionListener());
        view.addKeyListener(new WordleControllerKeyboard());
        
    }

    /**
     * Clase para la implementacion de los action listeners
     */
    class WordleControllerActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            switch (comando) {
                case "Jugar": //Entrar a ventana de Jugador 1
                    view.jugar();
                    view.repaint();
                    break;
                case "OKJUGAR": //Entrar a ventana de jugador 2
                    if(view.getPalabra().length() == view.getSlider())
                    {
                        partidas++;
                        model.setPalabra(view.getPalabra().toLowerCase());
                        caracteres = view.getSlider();
                        
                        solucion = new int[caracteres];
                        Arrays.fill(solucion, 1);
                        
                        view.running(); // Entra en el estado de jugador 2
                        view.repaint();
                    }
                    else
                        JOptionPane.showMessageDialog(null, 
                                "Palabra de tamaño incorrecto");
                    
                    break;
                case "Rankings": // Entra en la pestaña de ranking
                    if(partidas != 0) {
                        view.setVector(model.mostrarRanking(),partidas);
                        view.ranking();
                        view.repaint();
                        view.rankListener(new WordleControllerActionListener());
                } else JOptionPane.showMessageDialog(null, 
                        "No hay juegos por mostrar");
                    break;

                case "Info": // Ventana de informacion
                    String res = """
                                 Autores: Paulo Medeiros e Ines Jaso Pernod 
                                 
                                 Wordle es un juego de dos jugadores en el 
                                 cual un jugador escoge una palabra mientras el 
                                 otro jugador la intenta adivinar.
                                 
                                 Si una letra es correcta, se marcará como verde
                                 en esa posicion. Si una letra esta en la 
                                 posicion equivocada, será marcada como 
                                 amarilla. Finalmente, si una letra es incorrecta
                                 sera marcada como gris.
                                 
                                 El jugador 1 puede escoger la longitud de la
                                 palabra y el numero de intentos. El jugador 2 
                                 debe adivinar la palabra con esas condiciones.
                                 
                                 Hemos decidido no mantener las letras correctas
                                 para el proximo intento del jugador 2 para 
                                 permitir usar estrategias para descartar letras.
                                 
                                 La pestaña rankings muestra los ultimos 10
                                 juegos jugados.
                                  """;
                    JOptionPane.showMessageDialog(null, res);
                    break;
                case "Salir": //Opcion de salir
                    System.exit(0);
                    break;
                case "OkRanking": // Boton de OK del ranking
                    view.postRanking(); // Vuelve a la pantalla principal
                    view.repaint();
                    break;
            }
        }
    }

    /**
     * Listeners de ventana para poder cerrar el programa al cerrar la 
     * ventana
     */
    class WordleControllerWindow extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    /**
     * Listeners de teclado para escribir la palabra por pantalla 
     * con el teclado
     */
    class WordleControllerKeyboard extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == 8) { // Si la tecla pulsada es el borrar
                if (pos != 0) {
                    pos--;
                    view.borrar(pos, intentos);
                    palabra = palabra.substring(0, palabra.length() - 1);
                }

            } else if (e.getKeyCode() == 10) { /// Pulsar la tecla enter
                solaux = model.comprobar(palabra);
                view.comprobar(solaux, intentos);
                intentos++;
                if (Arrays.equals(solaux, solucion) || intentos == view.getSlider2()){ 
                    //Comprueba si la palabra es correcta^ o si se han usado todos los intentos
                    if (intentos == view.getSlider2()) { // Si se ha perdido
                        model.agregarRanking(0, intentos);
                        
                        palabra = "";
                        pos = 0;
                        intentos = 0;
                    } else { // Si se ha ganado
                        model.agregarRanking(1, intentos);
                        palabra = "";
                        pos = 0;
                        intentos = 0;
                    }
                    view.win(); // entra en la pantalla de ganar
                    view.repaint();

                } else { // Reinicia el array solucion a 0
                    Arrays.fill(solaux, 0);
                    palabra = "";
                    pos = 0;
                }
            } else if (pos < caracteres) { // Escribir cualquier otro caracter
                view.setLetra(e.getKeyChar(), pos, intentos);
                palabra = palabra + e.getKeyChar();
                pos++;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
