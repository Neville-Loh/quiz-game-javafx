package jeopardy.view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import jeopardy.model.QuizModel;

public class CurrentWinningController implements Initializable{
	
	private QuizModel model;
	
	@FXML private Label winningLabel;
	
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		Parent WinningViewParrent = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		Scene scene = new Scene(WinningViewParrent);
		
		// Gest the stage information 
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//#DEL
		System.out.println("Changing to view scene");
		//#LED
		model = Main.getQuizModel();
		String scoreStr = Integer.toString(model.getWinning());
		winningLabel.setText(scoreStr);
		
	}
	
	
	
}
