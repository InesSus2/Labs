package wordle.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Implementacion de clase wordleTitle
 * consiste en solo la palabra Wordle para que 
 * tenga un diseño peculiar
 * 
 * @author Paulo Medeiros Avila
 * @author Ines Jaso Pernod
 */
public class WordleTitle extends JPanel{
    private JLabel[] letras = new JLabel[6];
    private String nombre = "WORDLE";
    
    public WordleTitle(){
        this.setLayout(new GridLayout(1,6,2,5));
        
        for(int i = 0; i < 6;i++){
            letras[i] = new JLabel(nombre.charAt(i) + "");
            
            letras[i].setFont(new Font("SANS_SERIF", 3, 20));
            letras[i].setBackground(Color.WHITE);
            letras[i].setForeground(Color.WHITE);
            letras[i].setHorizontalAlignment(SwingConstants.CENTER);
            letras[i].setVerticalAlignment(SwingConstants.CENTER);
            LineBorder borde = new LineBorder(Color.BLACK, 1);
            letras[i].setBorder(borde);
            letras[i].setOpaque(true);
        }///FOR
        
        letras[0].setBackground(Color.GRAY);
        letras[1].setBackground(new Color(104, 171, 99));
        letras[2].setBackground(Color.GRAY);
        letras[3].setBackground(new Color(200, 179, 89));
        letras[4].setBackground(Color.GRAY);
        letras[5].setBackground(new Color(200, 179, 89));
        
        for(int i = 0;i < 6;i++)
            this.add(letras[i]);
        
        this.setBorder(new EmptyBorder(60,0,60,0));
    }
}
