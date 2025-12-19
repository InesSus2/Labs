package wordle.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;



/**
 * Implementacion de WordPanel
 * @author Paulo Medeiros Avila
 * @author Ines Jaso Pernod
 */
public class WordPanel extends JPanel {
    private int caracteres;
    private final JLabel[][] labelFin;
    

    public WordPanel(int cars,int intentos) {
        JLabel[][] label = new JLabel[intentos][cars]; 
        // Se crea del tamaño (numero de intentos) (numero de caracteres)
        this.caracteres = cars;
        this.setLayout(new GridLayout(intentos, cars, 5, 5));
        
        for (int i = 0; i < intentos; i++) {
            for (int j = 0; j < cars; j++) {
                label[i][j] = new JLabel();

                label[i][j].setBackground(Color.WHITE);
                label[i][j].setForeground(Color.BLACK);
                label[i][j].setHorizontalAlignment(
                        SwingConstants.CENTER);
                label[i][j].setVerticalAlignment(SwingConstants.CENTER);
                label[i][j].setFont(new Font("SANS_SERIF", 
                        3, 30));
                
                label[i][j].setBorder(new LineBorder(Color.BLACK,
                        1));
                
                label[i][j].setOpaque(true);

                this.add(label[i][j]);
            }///FOR2
        }///FOR1
        this.labelFin = label;
    }

   public void setCaracteres(int c) {
        this.caracteres = c;
    }

    public int getCaracteres() {
        return this.caracteres;
    }

    public void setLetra(String c, int pos, int cont) {
        labelFin[cont][pos].setText(c.toUpperCase());
    }

    public void borrar(int pos, int cont) {
        labelFin[cont][pos].setText("");
    }

    /**
     * Comprobar
     * @brief Asigna los colores correspondientes a cada casilla.
     * Hemos decidido no mantener las letras verdes en el 
     * siguiente intento ya que permite usar estrategias para adivinar
     * la palabra.
     * 
     * @param solucion Array que contiene los estados de cada letra
     * @param cont contador para saber en que fila asignar los colores
     */
    public void comprobar(int[] solucion, int cont) {
        for (int i = 0; i < solucion.length; i++) {
            switch (solucion[i]) {

                case 0 -> { // NO ESTÁ en la palabra
                    labelFin[cont][i].setBackground(Color.GRAY);
                    labelFin[cont][i].setForeground(Color.WHITE);
                }
                case 1 -> { // VERDE
                    labelFin[cont][i].setBackground(new Color(104, 171, 
                            99));
                    
                    labelFin[cont][i].setForeground(Color.WHITE);
                }
                case 2 -> { // AMARILLO
                    labelFin[cont][i].setBackground(new Color(200, 179, 
                            89));
                    
                    labelFin[cont][i].setForeground(Color.WHITE);
                }
                default -> {
                }
            }

        }
    }
}
