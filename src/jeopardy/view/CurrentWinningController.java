package jeopardy.view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import jeopardy.Main;

public class CurrentWinningController {
	
	private Main _main;
	
	@FXML
	private void goMainMenu() throws IOException{
		_main.showMainView();
	}

	public void setMainApp(Main main) {
		_main = main;
	}
	
	
	
}
