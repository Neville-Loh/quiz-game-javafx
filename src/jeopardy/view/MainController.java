package jeopardy.view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import jeopardy.Main;

public class MainController {
	
	@FXML
	private void showCurrentWinningView(ActionEvent event) throws IOException{
		Parent WinningViewParrent = FXMLLoader.load(getClass().getResource("CurrentWinningView.fxml"));
		Scene scene = new Scene(WinningViewParrent);
		
		// Gets the stage information 
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
	}
	

}
