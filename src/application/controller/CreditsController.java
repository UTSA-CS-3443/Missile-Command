package application.controller;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
//import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**Game credits which plays on request and on exit.
 *
 * @author Gregory Pugh
 * @author Michael Cavazos
 */
public class CreditsController implements EventHandler<MouseEvent>{

	/**Image for display in scene*/
	private Image nostalgia = new Image("file:../Inbound/Resources/Nostalgia.jpg");
	//private boolean hideButton = false;

	@FXML
	/**Canvas used to display the static image*/
	private Canvas creditsCanvas;
	/**Button control (used to allow user to return to the main menu after viewing credits.
	*This button is not visible when credits are shown on game exit.*/
	private Button backButton;

	//TODO: hide the backButton and do a pause on credit screen when exiting the program

	public CreditsController() {
		super();
	}

	/**Loads scene on program start.*/
	public void initialize(){
		//create graphic for scene
		GraphicsContext creditsBack = creditsCanvas.getGraphicsContext2D();
		creditsBack.drawImage(this.nostalgia, 40, 10, 430, 460);

	}

	/**Returns player to main menu when back button is pressed.
	 *
	 * @param event		Mouse event calling the on_Click method.
	 */
	public void on_Click(MouseEvent event) {
		//swap to main menu
		Main.stage.hide();
		Main.stage.setScene(Main.mainMenu);
		Main.stage.show();
	}

	/**Implements the default handle() for EventHandle (not used).*/
	@Override
	public void handle(MouseEvent event) {

	}
}