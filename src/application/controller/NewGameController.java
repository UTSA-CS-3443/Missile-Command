package application.controller;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**This is an intermediate screen after player selects New Game from main menu.
 * Allows player to set some basic option, such as game difficult and number of lives.
 * Not needed for basic version, will be added after Game Options as it is a player convenience
 * to set this options for this individual game at game start.
 *
 * @author Gregory Pugh
 */
public class NewGameController implements EventHandler<MouseEvent>{

	/**Image for new game view background*/
	private Image targets = new Image("file:../Inbound/Resources/TargetsMapBG.png");

	@FXML
	/**Canvas to render the image to*/
	private Canvas newCanvas;

	public NewGameController() {
		super();
	}

	/**Setups the initial new game view when program loads.*/
	public void initialize(){
		//create graphics context and render the background image
		GraphicsContext newBack = newCanvas.getGraphicsContext2D();
		newBack.drawImage(this.targets, 0, 0, 640, 480);
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
			case "easyButton" :
				//start a new game on easy settings.
				Main.stage.hide();
				Main.stage.setScene(Main.game);
				Main.stage.show();
				//TODO: need to implement game difficulty settings.
				break;
			case "normalButton" :
				//start a new game on normal settings.
				Main.stage.hide();
				Main.stage.setScene(Main.game);
				Main.stage.show();
				//TODO: need to implement game difficulty settings.
				break;
			case "hardButton" :
				//start a new game on hard settings.
				Main.stage.hide();
				Main.stage.setScene(Main.game);
				Main.stage.show();
				//TODO: need to implement game difficulty settings.
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
