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

public class AnswerResultViewController{
	
	private QuizModel model;
	
	@FXML private Label winningLabel;
	@FXML private Label isCorrectLabel;
	@FXML private Label correctAnsLabel;
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		ScreenController.goMainMenu(getClass(), event);
	}
	
	@FXML
	private void goQuestionSelect(ActionEvent event) throws IOException{
		ScreenController.goQuestionSelect(getClass(), event);
	}
	
	public void invalidAnswerInit(Question question) {
		model = Main.getQuizModel();
		isCorrectLabel.setText("Incorrect");
		model.textToSpeech("Incorrect");
		String scoreStr = Integer.toString(model.getWinning());
		winningLabel.setText(scoreStr);
		correctAnsLabel.setText("The correct answer is " + question.getAnswer() + ".");
	}
	
	public void validAnswerInit(Question question) {
		isCorrectLabel.setText("Correct");
		model = Main.getQuizModel();
		String scoreStr = Integer.toString(model.getWinning());
		winningLabel.setText(scoreStr);
	}
	
	
	
}
