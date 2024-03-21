package targy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogarlecPropertyChangeListener implements PropertyChangeListener{
	/**
	 * A feluldefinialt propertyChange függvény.
	 */
	public void propertyChange(PropertyChangeEvent e) {
		System.out.println("LogarlecPropertyChangeListener -> propertyChange()");
	}
}
