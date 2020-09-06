package jeopardy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import jeopardy.Main;
import jeopardy.model.Category;
import jeopardy.model.Question;
import jeopardy.model.QuizModel;

public class QuestionSelectViewController implements Initializable{
	private QuizModel model;


	@FXML private Label quetsionLabel;
	@FXML private VBox centerVBox;
	@FXML private Label remainingQuestion;
	
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		ScreenController.goMainMenu(getClass(), event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		model = Main.getQuizModel();
		ArrayList<Category> cats = model.getCategoryList();
		remainingQuestion.setText(Integer.toString(model.getRemainingQuestionCount()));
		
		
		for (Category cat : cats) {
			
			// Creates new rows
			HBox row = new HBox();
			row.setPadding(new Insets(10, 10, 10, 100));
			Label title = new Label(cat.getTitle());
			title.setPadding(new Insets(0,10,0,0));
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
