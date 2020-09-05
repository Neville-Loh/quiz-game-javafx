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
import javafx.scene.control.TextField;
import jeopardy.Main;
import jeopardy.model.Question;
import jeopardy.model.QuizModel;

public class QuestionViewController implements Initializable {

	private QuizModel model;
	private Question question;

	@FXML
	private Label questionLabel;
	@FXML
	private TextField textfield;

	@FXML
	private void goMainMenu(ActionEvent event) {
		ScreenController.goMainMenu(getClass(), event);

	}

	@FXML
	public void centerButton(ActionEvent event) {
		submitAnswer(event);
	}

	@FXML
	public void onEnter(ActionEvent event) throws IOException {
		submitAnswer(event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Quesiton view init");
		model = Main.getQuizModel();
		question = model.getActiveQuestion();
		model.textToSpeech(question.toString());
		questionLabel.setText(question.toString());

	}
	private void submitAnswer(ActionEvent event) {
		String input = textfield.getText();
		boolean isCorrect = model.answerQuestion(question, input);

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/AnswerResultView.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			AnswerResultViewController controller = loader.getController();

			// Initialize different page according to the user answer
			if (isCorrect) {
				controller.validAnswerInit(question);
			} else {
				controller.invalidAnswerInit(question);
			}
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}