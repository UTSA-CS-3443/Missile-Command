package application.controller;

import application.Main;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**Used for the Load/Save screen (only visible difference is the Load/Save button label)
 * Not needed for basic implementation. Currently defunct except for button listeners, we
 * never got this far.
 *
 * @author Gregory Pugh
 *
 */
public class LoadSaveController implements EventHandler<MouseEvent>{

	public LoadSaveController() {
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
		//get control that sent event
		Button b = (Button)event.getSource();

		//take actions for each button
		switch(b.getId()) {
			case "backButton" :
				//go to main menu
				Main.stage.hide();
				Main.stage.setScene(Main.mainMenu);
				Main.stage.show();
				break;
			case "loadButton" :
				//not implemented, print shows button is being detected
				System.out.printf(b.getId() + " pressed\n");
				//TODO: load a saved game from list
				break;
			case "saveButton" :
				//not implemented, print shows button is being detected
				System.out.printf(b.getId() + " pressed\n");
				//TODO: add a new save game.
				break;
			case "deleteButton" :
				//not implemented, print shows button is being detected
				System.out.printf(b.getId() + " pressed\n");
				//TODO: remove saved game from list permanently.
				break;
			default:
		}
	}

	/**Implements the default handle() for EventHandle.
	 *
	 */
	@Override
	public void handle(MouseEvent event) {

	}
}