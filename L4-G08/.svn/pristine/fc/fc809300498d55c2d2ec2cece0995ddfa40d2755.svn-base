package es.uv.eu.aplicacion2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PeliculaController {
    private PeliculaModel model;
    private PeliculaView view;

    public PeliculaController(PeliculaModel model, PeliculaView view){
        this.model = model;
        this.view = view;

        view.addWindowListener(new PeliculaControllerWindowListener());
    }

    class PeliculaControllerWindowListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            System.out.println("PeliculaController: Cerrar ventana.");
            System.exit(0);
        }
    }
}
