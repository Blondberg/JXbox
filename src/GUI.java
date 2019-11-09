import javax.swing.*;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
    JXBox controller;
    public GUI(){

    }

    public void run(){
        controller = new JXBox(this);
        setSize(640, 480);
        addKeyListener(new ControllerListener(this));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getKeyListeners()[0].keyPressed(new KeyEvent());
        setVisible(true);

        controller.run();
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.run();
    }
}
