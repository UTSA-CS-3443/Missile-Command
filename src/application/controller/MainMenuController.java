package application.controller;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**Main menu screen  allows player to make changes to otptions, load or continue a previous saved game,
 * start a new game, view game credits, or exit the program.
 *
 * @author Gregory Pugh
 */
public class MainMenuController implements EventHandler<MouseEvent> {

	/**Main background image for this view.*/
	private Image radar = new Image("file:../Inbound/Resources/RadarDishBG.png");
	/**Game logo for title on page.*/
	private Image logo = new Image("file:../Inbound/Resources/InboundLogo.png");

	@FXML
	/**Canvas used to render to the view.*/
	private Canvas menuCanvas;

	/**Setups the initial main menu view when program loads.*/
	public void initialize(){
		//set the graphic context and render the background images
		GraphicsContext mainBack = menuCanvas.getGraphicsContext2D();
		mainBack.drawImage(this.radar, 0, 0, 640, 480);
		mainBack.drawImage(this.logo, 140, 0, 400, 200);
	}

	/**handles control events.
	 *
	 * @param event		Mouse event calling the on_Click method.
	 */
	public void on_Click(MouseEvent event) {
		//get control that sent event
		Button b = (Button)event.getSource();

		//take actions for each button
		switch(b.getId()) {
			case "newGameButton" :
				//go to the new game menu
				Main.stage.hide();
				Main.stage.setScene(Main.newGame);		//needs to change
				Main.stage.show();
				break;
			case "continueButton" :
				//go to the load/save menu.
				Main.stage.hide();
				Main.stage.setScene(Main.loadSave);
				Main.stage.show();
				//TODO: this will eventually automatically load the last game saved/played rather
				//than taking the user to the load/save screen.
				break;
			case "loadButton" :
				//go to the load/save menu.
				Main.stage.hide();
				Main.stage.setScene(Main.loadSave);
				Main.stage.show();
				break;
			case "optionsButton" :
				//go to the game options menu.
				Main.stage.hide();
				Main.stage.setScene(Main.options);
				Main.stage.show();
				break;
			case "creditsButton" :
				//go to the credits.
				Main.stage.hide();
				Main.stage.setScene(Main.credits);
				Main.stage.show();
				break;
			case "exitButton" :
				//want to bring up credits here on a time loop, but for now just exits program
				Main.popupStage.close();
				Main.stage.close();
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

	}
}
