package jeopardy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import jeopardy.Main;
import jeopardy.model.Category;
import jeopardy.model.Question;
import jeopardy.model.QuizModel;

public class QuestionSelectViewController implements Initializable{
	private QuizModel model;


	@FXML private Label quetsionLabel;
	@FXML private Label remainingQuestion;
	@FXML private GridPane centerGridPane;
	
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException{
		ScreenController.goMainMenu(getClass(), event);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		model = Main.getQuizModel();
		ArrayList<Category> cats = model.getCategoryList();
		remainingQuestion.setText(Integer.toString(model.getRemainingQuestionCount()));
		
		
//		for (Category cat : cats) {
//			
//			// Creates new rows
//			HBox row = new HBox();
//			row.setPadding(new Insets(10, 10, 10, 100));
//			Label title = new Label(cat.getTitle());
//			title.setPadding(new Insets(0,10,0,0));
//			row.getChildren().add(title);
//			
//			// creates new button for each not attempted question
//			for (Question question : cat.getQuestions()) {
//				if (!question.isAttempted()) {
//					Button button = new Button(Integer.toString(question.getScore()));
//					
//					// set on Click function to go to question page
//					button.setOnAction(new EventHandler<ActionEvent>() {
//						@Override
//						public void handle(ActionEvent event){
//							model.setActiveQuestion(question);  //TODO maybe change this
//							ScreenController.goQuestion(getClass(), event);
//						}
//					});
//					row.getChildren().add(button);
//				}
//			}
//			centerVBox.getChildren().add(row);
//		}
//		
//    	for (int i=0; i<_categories.size();i++) {
//    		centerGridPane.getColumnConstraints().add(new ColumnConstraints(-1, -1, -1, Priority.ALWAYS, HPos.CENTER, false));
//    	}
//    	for (int i=0; i < 5-1;i++) {
//    		centerGridPane.getRowConstraints().add(new RowConstraints(-1, -1, -1, Priority.ALWAYS, VPos.CENTER, false));
//    	}
    	
    	
    	centerGridPane.setGridLinesVisible(true);
    	
    	int col=0;
    	int i=1;
    	
    	for (Category category : cats) {
    		i=1;
    		centerGridPane.getColumnConstraints().add(new ColumnConstraints(-1, -1, -1, Priority.ALWAYS, HPos.CENTER, false));
    		
    		Label label = new Label(category.getTitle());
    		centerGridPane.add(label, col, 0);
    		for (Question question : category.getQuestions()) {
    			
    			//centerGridPane.getRowConstraints().add(new RowConstraints(-1, -1, -1, Priority.ALWAYS, VPos.CENTER, false));
    			if (!question.isAttempted()) {
    				Button button = new Button(Integer.toString(question.getScore()));
    				centerGridPane.add(button, col, i);
	    			button.setOnAction(new EventHandler<ActionEvent>() {
	    				@Override
	    				public void handle(ActionEvent event) {
	    					model.setActiveQuestion(question);
							ScreenController.goQuestion(getClass(), event);
	    				}
	    			});
    			}
    			i++;
    		}
    		col++;
    	}

	}
}
