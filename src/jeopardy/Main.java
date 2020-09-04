package jeopardy;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import jeopardy.controller.CurrentWinningController;
import jeopardy.controller.MainController;
import jeopardy.model.QuizModel;
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
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
//		_mainLayout = loader.load();
//		Scene scene = new Scene(_mainLayout);
//		_screenController = new ScreenController(scene);
//		
//		Pane p = FXMLLoader.load(Main.class.getResource( "calculator.fxml" ));
//		_screenController.addScreen("calculator", FXMLLoader.load(Main.class.getResource( "view/MainView.fxml" )));
//		_screenController.addScreen("testSwitch", FXMLLoader.load(getClass().getResource( "view/CurrentWinningView.fxml" )));
		showMainView();
		
		

	}
	public void showMainView() throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

		
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
//		_mainLayout = loader.load();
//		Scene scene = new Scene(_mainLayout);
//		
////		MainController mainControler = loader.getController();
////		mainControler.setMainApp(this);
//		primaryStage.setScene(scene);
//		primaryStage.show();
	}
	
	
//	
//	private void showQuestoinSelectView() {
//		try {
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(Main.class.getResource("view/MainView.fxml"));
//			BorderPane loadView = loader.load();
//			Scene scene = new Scene(loadView);
//			primaryStage.setScene(scene);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	public static QuizModel getQuizModel() {
		return model;
	}
}
