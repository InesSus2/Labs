package wordle.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;



/**
 * Implementacion de la clase wordleOptions
 * @author Paulo Medeiros Avila
 * @author Ines Jaso Pernod
 */
public class WordleOptions extends JPanel{
    private final JButton play;
    private final JButton rank;
    private final JButton about;
    private final JButton salir;
    
    public WordleOptions(){
        this.setLayout(new GridLayout(5,1,5,5));
        
        play = new JButton("Jugar");
        play.setFont(new Font("SANS_SERIF", 3, 30));
        play.setBackground(new Color(104, 171, 99));
        play.setFocusable(false);
        
        rank = new JButton("Rankings");
        rank.setFont(new Font("SANS_SERIF", 3, 30));
        rank.setBackground(new Color(200, 179, 89));
        rank.setFocusable(false);
        
        about = new JButton("Info");
        about.setFont(new Font("SANS_SERIF", 3, 30));
        about.setBackground(Color.GRAY );
        about.setFocusable(false);
        
        salir = new JButton("Salir");
        salir.setFont(new Font("SANS_SERIF", 3, 30));
        salir.setBackground(Color.RED);
        salir.setForeground(Color.WHITE);
        salir.setFocusable(false);
        
        this.add(new JPanel());
        this.add(play);
        this.add(rank);
        this.add(about);
        this.add(salir);
    }
    
    /**
     * Listeners de los botones
     * @param al 
     */
    public void setActionListener(ActionListener al){
        play.addActionListener(al);
        rank.addActionListener(al);
        about.addActionListener(al);
        salir.addActionListener(al);
    }
}
