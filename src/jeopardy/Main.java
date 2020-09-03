package jeopardy;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Main extends Application {
	private Stage primaryStage;
	Scene scene1, scene2;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
//		Label label1 = new Label("Welcome to the first scene!");
//		Button button1 = new Button("Go to scene 2");
//		button1.setOnAction(e -> primaryStage.setScene(scene2));
//		
//		// Layout 1 - childeren are laid out in vertical column
//		VBox layout1 = new VBox(20);  //20 px apart
//		layout1.getChildren().addAll(label1, button1);
//		scene1 = new Scene(layout1, 200, 200);
//		
//		
//		Label label2 = new Label("Welcome to the first scene!");
//		Button button2 = new Button("Go to scene 1");
//		button2.setOnAction(e -> primaryStage.setScene(scene1));
//		
//		// Layout 1 - childeren are laid out in vertical column
//		StackPane layout2 = new StackPane();  //20 px apart
//		layout2.getChildren().addAll(label2, button2);
//		
//		scene2 = new Scene(layout2, 600, 300);
//		
//		primaryStage.setScene(scene1);
//		primaryStage.setTitle("fda");
//		primaryStage.show();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Jepardy");
		showMainView();
		

	}
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		VBox mainlayout = loader.load();
		Scene scene = new Scene(mainlayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
