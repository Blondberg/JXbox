import java.awt.*;
import java.awt.event.KeyEvent;

public class ControllerEvent extends KeyEvent {
    public ControllerEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
        super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
    }
}
