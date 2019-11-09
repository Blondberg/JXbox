import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControllerListener extends KeyAdapter {

    GUI gui;

    public ControllerListener(GUI gui){
        this.gui = gui;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
    }

    public void controllerPressed(){

    }
}
