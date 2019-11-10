import javax.swing.event.EventListenerList;

public class ControllerButton
{
    // http://www.java2s.com/Code/Java/Event/CreatingaCustomEvent.htm
    // https://docs.oracle.com/javase/7/docs/api/java/util/EventObject.html
    // https://www.javaworld.com/article/2077333/mr-happy-object-teaches-custom-events.html
    // https://castever.wordpress.com/2008/07/31/how-to-create-your-own-events-in-java/

    protected EventListenerList listenerList = new EventListenerList();

    public void addControllerListener(ControllerListener listener){
        listenerList.add(ControllerListener.class, listener);
    }

    public void removeControllerListener(ControllerListener listener){
        listenerList.remove(ControllerListener.class, listener);
    }

    void fireControllerEvent(ControllerEvent evt){
        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i++){
            if(listeners[i] == ControllerListener.class){
		((ControllerListener) listeners[i+1]).buttonPressed(evt);
	    }
	}
    }
}
