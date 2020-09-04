package jeopardy.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;


import jeopardy.Main;
import jeopardy.model.Question;
import jeopardy.model.QuizModel;

public class QuestionViewController implements Initializable{
	
	private QuizModel model;
	private Question question;
	
	@FXML private Label questionLabel;
	
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		ScreenController.goMainMenu(getClass(), event);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Quesiton view init");
		model = Main.getQuizModel();
		question = model.getActiveQuestion();
		questionLabel.setText(question.toString());
		
	}
	
	
	
}