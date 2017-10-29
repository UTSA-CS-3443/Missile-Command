package controller;

import javafx.scene.input.MouseEvent;

public class MainController implements javafx.event.EventHandler<MouseEvent>{

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
}
