package jeopardy.controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;


import jeopardy.Main;
import jeopardy.model.Question;
import jeopardy.model.QuizModel;

public class CurrentWinningController implements Initializable{
	
	private QuizModel model;
	
	@FXML private Label winningLabel;
	
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		ScreenController.goMainMenu(getClass(), event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		model = Main.getQuizModel();
		String scoreStr = Integer.toString(model.getWinning());
		winningLabel.setText(scoreStr);
		
		model.textToSpeech("Current winning");
		
	}
	
	
	
}
