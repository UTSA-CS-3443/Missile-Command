package application.controller;

import application.Main;
import application.model.GameModel;
import application.model.PlayerProjectileModel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**Main view of the game (at runtime, where everything is really happening)
 *
 * @author Michael Cavazos
 * @author Gregory Pugh
 * @author Divya Emani
 */
public class GameController implements EventHandler<MouseEvent>{

	/**Game session.*/
	GameModel thisGame;
	/**Graphics context for the animated part of the game.*/
	private GraphicsContext gameBack;

	@FXML
	/**main game canvas for rendering.*/
	private Canvas gameCanvas;

	@FXML
	/**Displays the player's current score.*/
	private Label scoreLabel;

	public GameController() {
		super();
	}

	/**Setups the initial game view when program loads.
	 *
	 */
	public void initialize(){

	}

	/**Handles game panel control events.
	 *
	 * @param event		Mouse event calling the on_Click method.
	 */
	public void on_Click(MouseEvent event) {
		Main.popupStage.show();
		//TODO: need to modify this window for better display (later versions)
		//TODO: other controls will be added, this method will then need a case statement
	}

	/**May add mouse over events (later versions). Right now, this is used to fire a new wave of missiles.
	 *
	 * @param event
	 */
	public void on_Enter(MouseEvent event) {
		// TODO Auto-generated method stub
		this.thisGame = new GameModel();
		setGameBack(gameCanvas.getGraphicsContext2D());
		thisGame.initGame(gameBack, scoreLabel);
	}

	@Override
	/**handles other game input like mouse position and firing.
	 *
	 * @param event
	 */
	public void handle(MouseEvent event) {
		//fire player projectile at point if we are in target area and have ammunition
		if (event.getY()<280 && thisGame.getAmmo().getAmmoCount() != 0) {
			//create the player missile
			PlayerProjectileModel playerProj = new PlayerProjectileModel(event.getX(),event.getY());
			playerProj.setPosition(320, 280);

			//set the missiles initial velocity
			double xDistance = (event.getX() - playerProj.getPositionX());
			double yDistance = (event.getY() - playerProj.getPositionY());
			double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
			playerProj.setVelocity(10*xDistance/distance, 10*yDistance/distance); //change hardcoded 2 to adjust speed

			//add it to the player projectile list
			thisGame.getPlayerProjectileList().add(playerProj);

			//decrement player's ammunition
			thisGame.getAmmo().setAmmoCount(thisGame.getAmmo().getAmmoCount());
		}
	}

	/**Gets the game display*/
	public GraphicsContext getGameBack() {
		return gameBack;
	}

	/**Sets the game display (gameCanvas).*/
	public void setGameBack(GraphicsContext gameBack) {
		this.gameBack = gameBack;
	}
}