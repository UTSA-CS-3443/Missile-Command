package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**Used for the program intro and initialization on starting program. Intro clips are not part
 * of basic implementation, (static screen image?). Calls main menu when finished. Plays full intro
 * on first start, intro can be skipped (fast forward to static screen while initialization finishes
 * after first start
 *
 * @author Gregory
 */

public class IntroController implements EventHandler<MouseEvent>{

	public IntroController() {
		super();
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub


	}
}
