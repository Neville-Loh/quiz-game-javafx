package jeopardy;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Main extends Application {
	private Stage primaryStage;
	private static BorderPane _mainLayout;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Jepardy");
		showMainView();
		

	}
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		_mainLayout = loader.load();
		Scene scene = new Scene(_mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
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
	
	
	private void resetGame() {
		System.out.println("reseting game");
	}
	
	private void quit() {
		System.out.println("quting game");
	}
	
	
	public static void showCurrentWinningView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/CurrentWinningView.fxml"));
			BorderPane loadView = loader.load();
			_mainLayout.setCenter(loadView);

		} catch (IOException e) {
			System.out.println("\n\n\n\n\n\n\n ");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
