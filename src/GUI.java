import javax.swing.*;

public class GUI extends JFrame {
    public GUI(){

    }

    public void run(){
        setSize(640, 480);
        addKeyListener(new ControllerListener(this));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.run();
    }
}
