package wordle;

import wordle.Model.WordleModel;
import wordle.View.WordleView;
import wordle.Controller.WordleController;


/**
 *
 * @author Paulo Medeiros Avila
 * @author Ines Jaso Pernod
 */
public class Wordle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       WordleModel model = new WordleModel();
       WordleView view = new WordleView();
       WordleController controller = new WordleController(view,model);
       
       view.setVisible(true);
    }
    
}
