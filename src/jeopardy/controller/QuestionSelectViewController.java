package jeopardy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import jeopardy.Main;
import jeopardy.model.Category;
import jeopardy.model.Question;
import jeopardy.model.QuizModel;

public class QuestionSelectViewController implements Initializable{
	private QuizModel model;


	@FXML private Label quetsionLabel;
	@FXML private VBox centerVBox;
	
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		
		Question question = model.gettestQuestion();
		model.setActiveQuestion(question);
		ScreenController.goQuestion(getClass(), event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		model = Main.getQuizModel();
		ArrayList<Category> cats = model.getCategoryList();
		
		
		for (Category cat : cats) {
			
			// Creates new rows
			HBox row = new HBox();
			Label title = new Label(cat.getTitle());
			row.getChildren().add(title);
			
			// creates new button for each not attempted question
			for (Question question : cat.getQuestions()) {
				if (!question.isAttempted()) {
					Button button = new Button(Integer.toString(question.getScore()));
					
					// set on Click function to go to question page
					button.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event){
							model.setActiveQuestion(question);  //maybe change this
							ScreenController.goQuestion(getClass(), event);
						}
					});
					row.getChildren().add(button);
				}
			}
			centerVBox.getChildren().add(row);
		}

	}
}
