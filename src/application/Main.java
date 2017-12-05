package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	/**Stage for main window*/
	public static Stage stage;
	/**Stage for pop-up windows*/
	public static Stage popupStage = new Stage();
	/**Scene for Intro view*/
	public static Scene intro;
	/**Scene for introView*/
	public static Scene credits;
	/**Scene for Game view*/
	public static Scene game;
	/**Scene for Load and Save view*/
	public static Scene loadSave;
	/**Scene for Start New Game view*/
	public static Scene newGame;
	/**Scene for Main menu view*/
	public static Scene mainMenu;
	/**Scene for Popup Menu view*/
	public static Scene popupMenu;
	/**Scene for Game Options view*/
	public static Scene options;


	/**Initialize program at start. Creates all scenes and sets the main stage to the introView.*/
	public void init(){
		//create the scenes for views
		try {
			Parent introView = FXMLLoader.load(getClass().getResource("view/IntroFXML.fxml"));
			intro = new Scene(introView, 640, 480);
			Parent creditsView = FXMLLoader.load(getClass().getResource("view/CreditsFXML.fxml"));
			credits = new Scene(creditsView, 640, 480);
			Parent gameView = FXMLLoader.load(getClass().getResource("view/GameFXML.fxml"));
			game = new Scene(gameView, 640, 480);
			Parent loadSaveView = FXMLLoader.load(getClass().getResource("view/LoadSaveFXML.fxml"));
			loadSave = new Scene(loadSaveView, 640, 480);
			Parent newGameView = FXMLLoader.load(getClass().getResource("view/NewGameFXML.fxml"));
			newGame = new Scene(newGameView, 640, 480);
			Parent mainMenuView = FXMLLoader.load(getClass().getResource("view/MainMenuFXML.fxml"));
			mainMenu = new Scene(mainMenuView, 640, 480);
			Parent menuPopupView = FXMLLoader.load(getClass().getResource("view/MenuPopupFXML.fxml"));
			popupMenu = new Scene(menuPopupView, 200, 260);
			Parent optionsView = FXMLLoader.load(getClass().getResource("view/OptionsFXML.fxml"));
			options = new Scene(optionsView, 640, 480);
		} catch (IOException e) {
			//if any scene fails, exit with error trace
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			//load and set up the pop up stage
			popupStage.setScene(Main.popupMenu);
			popupStage.initStyle(StageStyle.TRANSPARENT);
			popupStage.setAlwaysOnTop(true);

			//load stage with intro scene
			primaryStage.setScene(intro);
			primaryStage.show();
		} catch(Exception e) {
			//if a stage fails, exit with error trace
			e.printStackTrace();
		}
		//set main.stage to intro
		Main.stage = primaryStage;
	}

	/**Cleans up program before exiting. Currently unused*/
	public void stop(){

	}

	public static void main(String[] args) {
		//launch the program
		launch(args);
	}

	/**Gets the primary stage.
	 *
	 * @return stage	the main window for the program
	 */
	public static Stage getStage() {
		return stage;
	}
}
