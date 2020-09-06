package jeopardy.controller;
import javafx.fxml.FXML;

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
	
	/**
	 * Navigate to main menu
	 * @param event
	 */
	@FXML
	private void goMainMenu(ActionEvent event){
		ScreenController.goMainMenu(getClass(), event);
	}
	
	/**
	 * Navigate to question select screen
	 * @param event
	 */
	@FXML
	private void goQuestionSelect(ActionEvent event) {
		ScreenController.goQuestionSelect(getClass(), event);
	}
	
	/**
	 * Initialize the current page if the user answer is correct
	 * @param question
	 */
	public void validAnswerInit(Question question) {
		isCorrectLabel.setText("Correct");
		model = Main.getQuizModel();
		String scoreStr = Integer.toString(model.getWinning());
		winningLabel.setText(scoreStr);
	}
	
	/**
	 * Initialize the current page if the user answer is wrong
	 * @param question
	 */
	public void invalidAnswerInit(Question question) {
		model = Main.getQuizModel();
		isCorrectLabel.setText("Incorrect");
		model.textToSpeech("Incorrect");
		String scoreStr = Integer.toString(model.getWinning());
		winningLabel.setText(scoreStr);
		correctAnsLabel.setText("The correct answer is " + question.getAnswer() + ".");
	}
	
	
	
}
