package jeopardy.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import jeopardy.Main;
import jeopardy.model.QuizModel;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
/**
 * 
 * @author Neville
 * 
 */
public class MainController implements Initializable{
	private QuizModel model;
	/**
	 * Navigate to question select screen
	 * @param event
	 */
	@FXML
	private void showQuestionSelectView(ActionEvent event){
		ScreenController.goQuestionSelect(getClass(), event);
	}
	
	/**
	 * Navigate to current winning screen
	 * @param event
	 */
	@FXML
	private void showCurrentWinningView(ActionEvent event) throws IOException{
		ScreenController.goCurrentWinning(getClass(), event);
	}
	
	/**
	 * Send out reset Alert, if user confirm, reset the game
	 * @param event
	 */
	@FXML
	private void resetButtonClick(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.CONFIRMATION,
				"Are you sure you want to reset the game? Your save will be reset to its initial status. This can not be undone.",
				ButtonType.YES, ButtonType.NO
			);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle("Rest Confirmation");
		alert.setHeaderText(null);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.YES) {
			model.reset();
		}
		else {
			event.consume();
		}
	}
	
	/**
	 * Navigate to question select screen
	 * @param event
	 */
	@FXML
	private void quitButtonClick(ActionEvent event) throws IOException{
		model.save();
		Platform.exit();
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		model = Main.getQuizModel();
		
	}
	


}
