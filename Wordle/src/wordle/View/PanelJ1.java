package wordle.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


/**
 * Clase para la implementacion del panel de jugador 1
 * @author Paulo Medeiros Avila
 * @author Ines Jaso Pernod
 */
public class PanelJ1 extends JPanel{
    private JSlider slider;
    private JSlider slider2;
    private JLabel caracteres;
    private JLabel palabratext;
    private JButton OKJUGAR;
    private JPasswordField pas;
    private JLabel intentos;
    
    public PanelJ1(){
        this.setLayout(new GridLayout(4,1));
        
        //Slider para el numero de caracteres
        slider = new JSlider(JSlider.HORIZONTAL,3,9,5);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setBackground(new Color(200, 179, 89));
        slider.setBorder(new LineBorder(Color.BLACK,2,false));
        
        //Slider para el numero de intentos
        slider2 = new JSlider(JSlider.HORIZONTAL,3,10,8);
        slider2.setBackground(new Color(104, 171, 99));
        slider2.setBorder(new LineBorder(Color.BLACK,2,false));
        slider2.setPaintLabels(true);
        slider2.setMajorTickSpacing(1);
        slider2.setPaintTicks(true);
        
        pas = new JPasswordField();// Campo para escribir la palabra de forma privada
        
        caracteres = new JLabel("                 Numero de Caracteres: ");
        caracteres.setFont(new Font("SANS_SERIF", 3, 14));
        caracteres.setHorizontalAlignment(SwingConstants.CENTER);
        
        intentos = new JLabel("             Numero de intentos");
        intentos.setFont(new Font("SANS_SERIF", 3, 15));
        intentos.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Panel de caracteres
        JPanel sliderarea = new JPanel();
        sliderarea.setLayout(new BoxLayout(sliderarea, BoxLayout.Y_AXIS));
        sliderarea.add(caracteres);
        sliderarea.add(slider);
        sliderarea.setBorder(new EmptyBorder(50,10,1,10));
        
        //Panel de intentos
        JPanel sliderarea2 = new JPanel();
        sliderarea2.setLayout(new BoxLayout(sliderarea2, BoxLayout.Y_AXIS));
        sliderarea2.add(intentos);
        sliderarea2.add(slider2);
        sliderarea2.setBorder(new EmptyBorder(0,10,0,10));
        
        //Area para escribir palabra
        palabratext = new JLabel("  Palabra");
        palabratext.setFont(new Font("SANS_SERIF", 3, 25));
        palabratext.setHorizontalAlignment(SwingConstants.CENTER);
        palabratext.setVerticalAlignment(SwingConstants.CENTER);
        JPanel j1 = new JPanel();
        j1.setLayout(new BoxLayout(j1, BoxLayout.Y_AXIS));
        j1.setBorder(new EmptyBorder(30,115,50,100));
        j1.add(palabratext);
        j1.add(pas);
        
        //Boton para continuar
        OKJUGAR = new JButton("Ok");
        OKJUGAR.setActionCommand("OKJUGAR");
        OKJUGAR.setFont(new Font("SANS_SERIF", 3, 30));
        OKJUGAR.setBackground(Color.RED);
        OKJUGAR.setForeground(Color.WHITE);
        
        JPanel boton = new JPanel();
        boton.setLayout(new BoxLayout(boton, BoxLayout.Y_AXIS));
        boton.setBorder(new EmptyBorder(10,130,20,0));
        boton.add(OKJUGAR);

        this.add(sliderarea);
        this.add(sliderarea2);
        this.add(j1);
        this.add(boton);
    }
    
    /**
     * Getter de palabra ya que es un JPasswordField
     * @return 
     */
    public String getPalabra(){
        return String.valueOf(pas.getPassword());
    }
    
    /**
     * Getter de cantidad de caracteres
     * @return 
     */
    public int getSlider(){
        return slider.getValue();
    }
    
    /**
     * Getter de numero de intentos
     * @return 
     */
    public int getSlider2(){
        return slider2.getValue();
    }
    
    /**
     * Listeners para el boton OK
     * @param al 
     */
    public void setActionListener(ActionListener al){
        OKJUGAR.addActionListener(al);
    }
    
    
}
