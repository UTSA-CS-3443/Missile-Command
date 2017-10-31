package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**Handles the score pane visible at top of screen. For now this simply displays the current score.
 *
 * @author Gregory
 */
public class ScoreController implements EventHandler<MouseEvent>{

	private int score;

	public ScoreController() {
		super();
		this.score = 0;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub

	}
}
