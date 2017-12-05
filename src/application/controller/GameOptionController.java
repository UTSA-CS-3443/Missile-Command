package application.controller;

import application.Main;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**Menu screen called from main menu to set game options. not needed for basic implementation.
 * This would be where player can change default settings to their preferences.
 *
 * @author Gregory Pugh
 */
public class GameOptionController implements EventHandler<MouseEvent>{

	public GameOptionController() {
		super();
	}

	/**Setups the initial game options view when program loads.
	 *
	 */
	public void initialize(){

	}

	/**Handles control events.
	 *
	 * @param event		Mouse event calling the on_Click method.
	 */
	public void on_Click(MouseEvent event) {
		//get control that sent event
		Node b = (Node)event.getSource();

		//take actions for each button
		switch(b.getId()) {
			case "backButton" :
				//go to main menu
				Main.stage.hide();
				Main.stage.setScene(Main.mainMenu);
				Main.stage.show();
				//TODO: need to throw out changes if player does not press apply
				break;
			case "defaultButton" :
				//not implemented, print shows button is being detected
				System.out.printf(b.getId() + " pressed\n");
				//TODO: reset settings
				break;
			case "applyButton" :
				//not implemented, print shows button is being detected
				System.out.printf(b.getId() + " pressed\n");
				//TODO : make changes permanent when player exits scene
				break;
			case "optionTabs" :
				//not implemented, print shows button is being detected
				System.out.printf(b.getId() + " pressed\n");
				//TODO: reset settings
				break;
			//TODO: implement tabs.
			default:
		}
	}

	@Override
	/**Implements the default handle() for EventHandle.
	 *
	 * @param event
	 */
	public void handle(MouseEvent event) {

	}
}
