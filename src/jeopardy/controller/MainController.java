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
		ScreenController.goQuestionSelect(getClass(), event);
	}
	
	
	@FXML
	private void showCurrentWinningView(ActionEvent event) throws IOException{
		ScreenController.goCurrentWinning(getClass(), event);
	}
	
	/**
	 * Testing purpose
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void resetButtonClick(ActionEvent event) throws IOException{
		ScreenController.goQuestion(getClass(), event);
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
