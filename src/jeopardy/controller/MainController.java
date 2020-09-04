package jeopardy.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainController {
	
	@FXML
	private void showQuestionSelectView(ActionEvent event) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("../view/QuestionSelectView.fxml"));
		Scene scene = new Scene(parent);
		
		// Gets the stage information 
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
	}
	
	
	@FXML
	private void showCurrentWinningView(ActionEvent event) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("../view/CurrentWinningView.fxml"));
		Scene scene = new Scene(parent);
		
		// Gets the stage information 
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
	}
	
	/**
	 * Testing purpose
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void resetButtonClick(ActionEvent event) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("../view/QuestionView.fxml"));
		Scene scene = new Scene(parent);
		
		// Gets the stage information 
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
	}
	/**
	 * Testing purpose
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void quitButtonClick(ActionEvent event) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("../view/GameOverView.fxml"));
		Scene scene = new Scene(parent);
		
		// Gets the stage information 
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
	}
	


}
