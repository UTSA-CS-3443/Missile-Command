package application.controller;

import application.Main;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**popup menu that pauses game and allows player to access main menu from in game.
 *
 * @author Gregory Pugh
 */
public class MenuPopupController implements EventHandler<MouseEvent>{

	public MenuPopupController() {
		super();
	}

	/**Setups the initial pop up view when program loads.*/
	public void initialize(){

	}
	
	/**handles control events.
	 *
	 * @param event			Mouse event calling the on_Click method.
	 */
	public void on_Click(MouseEvent event) {
		//get control that sent event
		Button b = (Button)event.getSource();

		//TODO: need to make sure this pauses game while menu is open

		//take actions for each button
		switch(b.getId()) {
			//return to the game
			case "resumeButton" :
				Main.popupStage.hide();
				//TODO: need to unpause game when menu is closed.
				break;
			case "saveButton" :
				//takes player to save menu
				Main.popupStage.hide();
				Main.stage.hide();
				Main.stage.setScene(Main.loadSave);
				Main.stage.show();
				break;
			case "loadButton" :
				//takes player to save menu
				Main.popupStage.hide();
				Main.stage.hide();
				Main.stage.setScene(Main.loadSave);
				Main.stage.show();
				break;
			case "optionsButton" :
				//takes player to game options menu
				Main.popupStage.hide();
				Main.stage.hide();
				Main.stage.setScene(Main.options);
				Main.stage.show();
				break;
			case "exitButton" :
				//end game and return player to main menu.
				Main.popupStage.hide();
				Main.stage.hide();
				Main.stage.setScene(Main.mainMenu);
				Main.stage.show();
				break;
			default:
		}
	}

	@Override
	/**Implements the default handle() for EventHandle.
	 *
	 * @param event
	 */
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub

	}
}

