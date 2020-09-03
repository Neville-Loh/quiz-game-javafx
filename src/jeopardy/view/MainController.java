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

public class MainController {
	
	private Main main;
	
	@FXML
	private void SelectQuestionView(){
		Main.showCurrentWinningView();
	}
//	@FXML
//	private void showCurrentWinningView(){
//		Main.showCurrentWinningView();
//	}
//	
//	@FXML
//	private void showCurrentWinningView(){
//		Main.showCurrentWinningView();
//	}
//	
//	@FXML
//	private void showCurrentWinningView(){
//		Main.showCurrentWinningView();
//	}
//	
//	@FXML
//	private void 

}
