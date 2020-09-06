package jeopardy.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import jeopardy.Main;
import jeopardy.model.QuizModel;

public class GameOverViewController implements Initializable {

	private QuizModel model;

	@FXML private Label winningLabel;
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException {
		ScreenController.goMainMenu(getClass(), event);
	}
	
	@FXML
	private void resetButtonClick(ActionEvent event) {
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
		model = Main.getQuizModel();
		String scoreStr = Integer.toString(model.getWinning());
		winningLabel.setText(scoreStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
