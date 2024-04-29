
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogarlecPropertyChangeListener implements PropertyChangeListener {
	Game game;

	/**
	 * A feluldefinialt propertyChange függvény.
	 */
	public LogarlecPropertyChangeListener(Game g) {
		game = g;
	}

	public void propertyChange(PropertyChangeEvent e) {
		game.endgame();
	}

}
