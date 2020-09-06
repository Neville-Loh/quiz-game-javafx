package jeopardy;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import jeopardy.controller.CurrentWinningController;
import jeopardy.controller.MainController;
import jeopardy.model.QuizModel;
import jeopardy.util.FileHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Main extends Application {
	private Stage primaryStage;
	private BorderPane _mainLayout;
	private static QuizModel model;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		model = new QuizModel();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Jepardy");
		
		Parent root = FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		

	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public static QuizModel getQuizModel() {
		return model;
	}
}
