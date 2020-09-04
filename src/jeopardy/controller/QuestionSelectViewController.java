package jeopardy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jeopardy.Main;
import jeopardy.model.QuizModel;

public class QuestionSelectViewController implements Initializable{
private QuizModel model;
	
	@FXML private Label quetsionLabel;
	
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		//#DEL
		System.out.println("Question Select go Main Menu");
		//LED
		
		Parent WinningViewParrent = FXMLLoader.load(getClass().getResource("../view/MainView.fxml"));
		Scene scene = new Scene(WinningViewParrent);
		
		// Gets the stage information 
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//#DEL
		System.out.println("Changing quetsion view");
		//#LED
		model = Main.getQuizModel();
	}
}
