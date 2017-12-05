package application.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**Used for additional information and controls, displayed at bottom of game screen. Suggest three parts:
 * General game info and menu buttons, Production controls, and Research controls. Don't really need this
 * for basic implementation. Currently this whole class is defunct since we never got this far.
 *
 * @author Gregory Pugh
 */
public class GamePanelController implements EventHandler<MouseEvent>{

	public GamePanelController() {
		super();
	}

	/**Setups the initial load/save view when program loads.*/
	public void initialize(){

	}

	/**Handles control events.
	 *
	 * @param event		Mouse event calling the on_Click method.
	 */
	public void on_Click(MouseEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	/**Implements the default handle() for EventHandle.
	 *
	 * @param event
	 */
	public void handle(MouseEvent event) {

	}
}
