package controller;

import application.Main;
import javafx.event.Event;
import javafx.event.EventHandler;

/**Main menu basic implementation is New Game and Exit. Options for load, Save, Game Options, hi scores,
 * Profile, etc. to be added later
 *
 * @author Gregory
 */
public class MainController implements EventHandler{

	public MainController() {
		super();
	//	this.calc = new Calculator();
	}

	public void new_Clicked(){
		System.out.print("new clicked");
	}
	public void new_Entered(){
		System.out.print("new entered");
	}
	public void new_Exit(){
		System.out.print("new exited");
	}
	public void exit_Clicked(){
		System.out.print("exit clicked");
	}
	public void exit_Entered(){
		System.out.print("exit entered");
	}
	public void exit_Exit(){
		System.out.print("exit exited");
	}

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub

	}

}
