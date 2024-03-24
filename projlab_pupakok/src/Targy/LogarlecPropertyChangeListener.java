package Targy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogarlecPropertyChangeListener implements PropertyChangeListener{
	/**
	 * A feluldefinialt propertyChange függvény.
	 */
	public void propertyChange(PropertyChangeEvent e) {
		System.out.println("LogarlecPropertyChangeListener -> propertyChange()");
		String propertyName = e.getPropertyName();
		Object oldValue = e.getOldValue();
		Object newValue = e.getNewValue();
	}
}
