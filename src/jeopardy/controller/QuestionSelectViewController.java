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
import jeopardy.model.Question;
import jeopardy.model.QuizModel;

public class QuestionSelectViewController implements Initializable{
private QuizModel model;
	
	@FXML private Label quetsionLabel;
	
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		
		Question question = model.gettestQuestion();
		model.setActiveQuestion(question);
		ScreenController.goQuestion(getClass(), event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//#DEL
		System.out.println("Select quetsion view");
		//#LED
		model = Main.getQuizModel();
	}
}
