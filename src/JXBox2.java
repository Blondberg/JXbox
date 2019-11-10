import net.java.games.input.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class JXBox2 extends Thread {
    private Controller xBoxController;
    private Controller[] controllers;

    private GUI gui;

    private boolean controllerFound;

    public JXBox2(GUI gui) {
        this.gui = gui;
        System.setProperty("net.java.games.input.librarypath",
                new File("jinput-2.0.9-natives.jar\\net\\java\\games").getAbsolutePath());
        xBoxController = null;
        controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

        controllerFound = false;
    }

    /**
     * Check all controllers and find an XBox controller
     */
    private void findController() {
        for (Controller controller : controllers) {
            if (controller.getType() == Controller.Type.GAMEPAD) {
                xBoxController = controller;
                System.out.println("Controller found!");
                System.out.println("Name: " + controller.getName());
                System.out.println("Type: " + controller.getType().toString());
                System.out.println("Port number: " + controller.getPortNumber());
                System.out.println("Port type: " + controller.getPortType().toString());
                controllerFound = true;
                break;
            }
        }
    }

    /**
     * Runs the controller checker
     */
    @Override
    public void run() {
        boolean left = false;
        boolean right = false;
        boolean forward = false;
        boolean back = false;
        findController();
        if (!controllerFound) {
            System.out.println("No controller found... Try plugging it in and restarting the program!");
        } else {
            while (true) {
                if (!xBoxController.poll()) {
                    System.out.println("Oh oooh, looks like your controller is no longer connected.");
                    System.out.println("Connect the controller and restart the program.");
                    break;
                }

                EventQueue queue = xBoxController.getEventQueue();
                Event event = new Event();

                while (queue.getNextEvent(event)) {
                    Component comp = event.getComponent();

                    switch (comp.getIdentifier().toString()) {
                        case "z":
                            if (event.getValue() > 0.5) {
                                back = true;
                            } else {
                                back = false;
                            }
                            if (event.getValue() < -0.5) {
                                forward = true;
                            } else {
                                forward = false;
                            }
                            break;
                        case "x":
                            if (event.getValue() < -0.5) {
                                left = true;
                            } else {
                                left = false;
                            }
                            if (event.getValue() > 0.5) {
                                right = true;
                            } else {
                                right = false;
                            }
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Left: " + left + ", Right: " + right + ", Forward: " + forward + ", Back: " + back);
            }
        }
    }

}
