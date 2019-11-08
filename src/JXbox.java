import net.java.games.input.*;

import java.io.File;

public class JXbox {
    public static void main(String[] args) {
        System.setProperty("net.java.games.input.librarypath", new File("C:\\Users\\Simon\\GitProjects\\JavaXboxController\\jinput-2.0.9.jar!\\net\\java\\games").getAbsolutePath());
        Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();
        Controller xbox = null;

        for (Controller controller : ca) {
            if (controller.getType() == Controller.Type.GAMEPAD) {
                xbox = controller;

                // Get the name of the controller
                System.out.println(controller.getName());
                System.out.println("Type: " + controller.getType().toString());
            }
        }

        while (true) {
            xbox.poll();
            EventQueue queue = xbox.getEventQueue();
            Event event = new Event();

            while (queue.getNextEvent(event)) {
                Component comp = event.getComponent();

                switch (comp.getIdentifier().toString()) {
                    case "z":
                        if (event.getValue() > 0.5) {
                            System.out.println("BACK");
                        } else if (event.getValue() < -0.5) {
                            System.out.println("FORWARD");
                        }
                        break;
                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
