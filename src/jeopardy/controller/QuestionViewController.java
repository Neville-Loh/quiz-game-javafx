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

public class QuestionViewController implements Initializable{
	
	private QuizModel model;
	private Question question;
	
	@FXML private Label questionLabel;
	@FXML private TextField textfield;
	
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		ScreenController.goMainMenu(getClass(), event);
		
	}
	
	@FXML
	public void onEnter(ActionEvent event) throws IOException{
	   System.out.println(textfield.getText());
	   
	   String input = textfield.getText();
	   boolean isCorrect = model.answerQuestion(question, input);
	   
	   
	   FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/AnswerResultView.fxml"));
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		
		AnswerResultViewController controller = loader.getController();
	   if (isCorrect) {
		   System.out.println("is correct");
		   controller.validAnswerInit(question);
	   } else {
		   System.out.println("is not correct");
		   controller.invalidAnswerInit(question);
	   }
	   Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	   window.setScene(scene);
	   
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Quesiton view init");
		model = Main.getQuizModel();
		question = model.getActiveQuestion();
		questionLabel.setText(question.toString());
		
	}
	
	
	
}