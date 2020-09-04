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

import jeopardy.Main;
import jeopardy.model.QuizModel;

public class GameOverViewController implements Initializable {

	private QuizModel model;

	@FXML private Label winningLabel;
	
	@FXML
	private void goMainMenu(ActionEvent event) throws IOException {
		Parent WinningViewParrent = FXMLLoader.load(getClass().getResource("../view/MainView.fxml"));
		Scene scene = new Scene(WinningViewParrent);

		// Gest the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
	}
	
	@FXML
	private void resetButtonClick(ActionEvent event) {
		System.out.println(getClass().toString() + " resetbuttonClick");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
		// #DEL
		System.out.println("Changing to gameover scene");
		// #LED
		model = Main.getQuizModel();
		
		System.out.println("Changing to gameover scene2");
		String scoreStr = Integer.toString(model.getWinning());
		System.out.println("Changing to gameover scene3");
		winningLabel.setText(scoreStr);
		System.out.println("Changing to gameover scene4");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
