package wordle.View;

import wordle.Model.WordleModel.Persona;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Implementacion de la vista para el Wordle
 * @author Paulo Medeiros Avila
 * @author Ines Jaso Pernod
 */
public class WordleView extends JFrame {

    private WordPanel word;
    private JPanel separadorNorte;
    private JPanel separador2;
    private JPanel separador3;
    private WordleTitle titulo;
    private WordleOptions options;
    private PanelJ1 panelj1;
    private RankPanel rank;
    private int aux;
    private int intentos;
    private Persona[] p = new Persona[10];
    private int num_personas = 0;

    public WordleView() {
        super("Wordle");
        this.setLayout(new BorderLayout());
        this.setSize(350, 500);
        
        separadorNorte = new JPanel();
        separadorNorte.setPreferredSize(new Dimension(10, 30));
        separador2 = new JPanel();
        separador2.setPreferredSize(new Dimension(30, 50));

        separador3 = new JPanel();
        separador3.setPreferredSize(new Dimension(30, 50));

        options = new WordleOptions();
        titulo = new WordleTitle();

        panelj1 = new PanelJ1();
        
        this.add(titulo, BorderLayout.CENTER);
        this.add(separadorNorte, BorderLayout.NORTH);
        this.add(separador3, BorderLayout.WEST);
        this.add(separador2, BorderLayout.EAST);
        this.add(options, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }

    /**
     * Metodo para agregar una letra a nuestra palabra
     * @param c Caracter a agregar
     * @param pos Posicion del caracter
     * @param cont contador de filas
     */
    public void setLetra(char c, int pos, int cont) {
        String s = "" + c;
        word.setLetra(s, pos, cont);
    }

    /**
     * Metodo para borrar un caracter de la palabra
     * @param pos posicion del caracter
     * @param cont contador de filas
     */
    public void borrar(int pos, int cont) {
        word.borrar(pos, cont);
    }

    /**
     * Metodo para comprobar la palabra con la solucion
     * @param sol array de solucion
     * @param cont contador de filas
     */
    public void comprobar(int[] sol, int cont) {
        word.comprobar(sol, cont);
    }

    /**
     * Metodo para pasar a la ventana de Jugador 1
     */
    public void jugar() {

        this.remove(titulo);
        this.remove(separadorNorte);
        this.remove(separador3);
        this.remove(separador2);
        this.remove(options);
        
        this.add(panelj1, BorderLayout.CENTER);
        this.setVisible(true);
    }

    /**
     * Metodo para entrar en la ventana de jugador 2
     */
    public void running() {
        this.remove(panelj1);
        
        aux = panelj1.getSlider();
        intentos = panelj1.getSlider2();
        word = new WordPanel(aux,intentos);
        word.setCaracteres(aux);
        
        this.add(word, BorderLayout.CENTER);
        this.requestFocus(true);
        this.setVisible(true);
    }
    /**
     * Getter de palabra
     * @return 
     */
    public String getPalabra() {
        return panelj1.getPalabra();
    }

    /**
     * Listener de botones de opciones
     * @param al 
     */
    public void optionsListener(ActionListener al) {
        options.setActionListener(al);
    }
    
    /**
     * Listener de boton de rank
     * @param al 
     */
    public void rankListener(ActionListener al){
        rank.setActionListener(al);
    }

    /**
     * Listeners de panel de jugador 1
     * @param al 
     */
    public void panelj1Listener(ActionListener al) {
        panelj1.setActionListener(al);
    }
    
    /**
     * Metodo para entrar a la ventana principal
     */
    public void win() {
        JOptionPane.showMessageDialog(null, 
                                "ENHORABUENA");
        this.endGame();
            }
    
    /**
     * Metodo para entrar a la ventana principal
     */
    public void endGame(){
        this.remove(word);
        
        this.add(titulo, BorderLayout.CENTER);
        this.add(separadorNorte, BorderLayout.NORTH);
        this.add(separador3, BorderLayout.WEST);
        this.add(separador2, BorderLayout.EAST);
        this.add(options, BorderLayout.SOUTH);
        this.setSize(350, 500);
        this.setVisible(true);
    }
    
    /**
     * Getter de numero de caracteres
     * @return 
     */
    public int getSlider(){
        return panelj1.getSlider();
    }
    
    /**
     * Getter de numero de intentos
     * @return 
     */
    public int getSlider2(){
        return panelj1.getSlider2();
    }
    
    /**
     * Metodo para entrar en la ventana de ranking
     */
    public void ranking(){
        rank = new RankPanel(p,num_personas);
        this.remove(titulo);
        this.remove(separadorNorte);
        this.remove(separador3);
        this.remove(separador2);
        this.remove(options);
        
        this.add(rank,BorderLayout.CENTER);
        this.requestFocus(true);
        this.setSize(500,350);
        this.setVisible(true);
    }
    
    /**
     * Asigna el vector del model a el view
     * @param p_vec vector de personas en el model
     * @param personas numero de personas
     */
    public void setVector(Persona[] p_vec,int personas){
        this.num_personas = personas;
        this.p = p_vec;
        
    }
    
    /**
     * Metodo para entrar a la ventana despues del ranking
     */
    public void postRanking(){
        this.remove(rank);
        
        this.add(titulo, BorderLayout.CENTER);
        this.add(separadorNorte, BorderLayout.NORTH);
        this.add(separador3, BorderLayout.WEST);
        this.add(separador2, BorderLayout.EAST);
        this.add(options, BorderLayout.SOUTH);
        this.setSize(350, 500);
        this.setVisible(true);
    }
    
}
