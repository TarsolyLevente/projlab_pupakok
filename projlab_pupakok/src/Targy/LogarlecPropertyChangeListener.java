package Targy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import Game.Game;

public interface LogarlecPropertyChangeListener 
{
	Game game;
	/**
	 * A feluldefinialt propertyChange függvény.
	 */
	public LogarlecPropertyChangeListener(Game g) {
		game = g;
	}
	public void propertyChange(PropertyChangeEvent e) {
		System.out.println("LogarlecPropertyChangeListener -> propertyChange()");
		game.endgame();
	}
	
} 

