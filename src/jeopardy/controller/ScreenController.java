package jeopardy.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jeopardy.model.Question;

public class ScreenController {
	
	/**
	 * Main Menu
	 * Utility Method to go to the main menu
	 * @param controllerClass
	 * @param event of button
	 */
	public static void goMainMenu(Class<?> controllerClass , ActionEvent event) {
		try {
			Parent parent = FXMLLoader.load(controllerClass.getResource("../view/MainView.fxml"));
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(new Scene(parent));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Question Select
	 * Utility Method to go to the Question Select View
	 * @param controllerClass
	 * @param event of button
	 */
	public static void goQuestionSelect(Class<?> controllerClass , ActionEvent event){
		try {
			Parent parent = FXMLLoader.load(controllerClass.getResource("../view/QuestionSelectView.fxml"));
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(new Scene(parent));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Question Page
	 * Utility Method to go to the Question View
	 * @param controllerClass
	 * @param event of button
	 */
	public static void goQuestion(Class<?> controllerClass , ActionEvent event){
		try {
			Parent parent = FXMLLoader.load(controllerClass.getResource("../view/QuestionView.fxml"));
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(new Scene(parent));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Current Winning
	 * Utility Method to go to the Current Winning View
	 * @param controllerClass
	 * @param event of button
	 */
	public static void goCurrentWinning(Class<?> controllerClass , ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(controllerClass.getResource("../view/CurrentWinningView.fxml"));
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(new Scene(parent));
	}
	
	/**
	 * Game Over
	 * Utility Method to go to the GameOver View
	 * @param controllerClass
	 * @param event of button
	 */
	public static void goGameOver(Class<?> controllerClass , ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(controllerClass.getResource("../view/GameOverView.fxml"));
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(new Scene(parent));
	}
	
	
	
	
	
	
	
}
