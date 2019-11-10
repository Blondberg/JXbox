import javax.swing.*;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
    JXBox controller;
    public GUI(){

    }

    public void run(){
        controller = new JXBox(this);
        setSize(640, 480);
        ControllerButton button = new ControllerButton();
        button.addControllerListener(new ControllerListener(){
            @Override public void buttonPressed(final ControllerEvent event) {
                System.out.println("hej");
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        controller.start();
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.run();
    }
}
