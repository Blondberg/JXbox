import java.util.EventListener;

interface ControllerListener extends EventListener
{
    public void buttonPressed(ControllerEvent event);
}
