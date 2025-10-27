package es.uv.eu.aplicacion3;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeliculaController {
    private PeliculaModel model;
    private PeliculaView view;

    public PeliculaController(PeliculaModel model, PeliculaView view){
        this.model = model;
        this.view = view;

        view.addWindowListener(new PeliculaControllerWindowListener());
        view.setActionListener(new PeliculaControllerActionListener());
    }

    class PeliculaControllerWindowListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            System.out.println("PeliculaController: Cerrar ventana.");
            System.exit(0);
        }
    }

    class PeliculaControllerActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            String command = ae.getActionCommand();

            switch(command){
                case "buttonExit":
                    System.out.println("PeliculaController: Boton 'Salir'.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("PeliculaController: Comando'" + command + "' no reconocido.");
                    break;
            }
        }
    }
}
