package application.controller;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**Used for the program intro and initialization on starting program. Calls main menu when finished.
 * For now displays static image; Later implementation: intro clips play on first start, after which
 * intro can be skipped (fast forward to static screen while initialization finishes).
 *
 * @author Gregory M Pugh
 * @author Michael Cavazos
 */

public class IntroController implements EventHandler<MouseEvent>{

	/**Background image for scene*/
	private Image intro = new Image("file:../Inbound/Resources/IntroBG.png");
	/**Logo image for scene*/
	private Image logo = new Image("file:../Inbound/Resources/InboundLogo.png");

	/**progress bar to show program initialization (not yet implemented)*/
	@FXML
	private ProgressBar progressBar;
	/**Canvas to display images. (intro videos would use new scene before this one)*/

	@FXML
	/**Background canvas.*/
	private Canvas introCanvas;

	public IntroController() {
		super();
	}

	/**Setups the initial intro view when program loads.
	 * Sets the progress bar to 0.*/
	public void initialize(){
		//create the graphic context for the canvas and add images
		GraphicsContext introBack = introCanvas.getGraphicsContext2D();
		introBack.drawImage(this.intro, 0, 0, 640, 480);
		introBack.drawImage(this.logo, 120, 30, 400, 170);

		//set progress bar to initial value.
		progressBar.setProgress(0);

		//TODO: setup profile/data initialization here.
	}

	/**Adds percent value to progress bar (Currently not used).
	 *
	 * @param i 	percent to add to current progress
	 */
	public void addProgress(int i){
		progressBar.setProgress(progressBar.getProgress() + i/100);
	}

	/**Listens for player input to advance to main menu. Temporary: after
	 * progress bar is implemented this screen will automatically advance upon
	 * completion of initialization.*/
	public void on_Click(MouseEvent event) {
		//swap views to main menu
		Main.stage.hide();
		Main.stage.setScene(Main.mainMenu);
		Main.stage.show();
	}

	/**Implements the default handle() for EventHandle (not used)*/
	@Override
	public void handle(MouseEvent event) {

	}
}
