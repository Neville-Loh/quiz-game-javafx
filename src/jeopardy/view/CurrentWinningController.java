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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import jeopardy.Main;

public class CurrentWinningController {
	
	private int _winning;
	
	@FXML private Label winningLabel;
	
	
	
	public void initData() {
		winningLabel.setText(Integer.toString(_winning));
	}
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		Parent WinningViewParrent = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		Scene scene = new Scene(WinningViewParrent);
		
		// Gest the stage information 
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		
	}
	
	
	
}
