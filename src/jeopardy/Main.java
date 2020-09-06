package jeopardy;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jeopardy.model.QuizModel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/**
 * 
 * @author Neville
 */


public class Main extends Application {
	private Stage primaryStage;
	private static  QuizModel model;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		// to ensure singleton assignment
		if (model == null) {
			model = new QuizModel();
		}
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Jepardy");
		
		Parent root = FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Stage stage = primaryStage;
		EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
	        Alert closeConfirmation = new Alert(
	                Alert.AlertType.CONFIRMATION,
	                "Are you sure you want to exit?"
	        );
	        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(
	                ButtonType.OK
	        );
	        exitButton.setText("Exit");
	        closeConfirmation.setHeaderText("Confirm Exit");
	        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
	        closeConfirmation.initOwner(stage);

//	        // normally, you would just use the default alert positioning,
//	        // but for this simple sample the main stage is small,
//	        // so explicitly position the alert so that the main window can still be seen.
//	        closeConfirmation.setX(stage.getX());
//	        closeConfirmation.setY(stage.getY() + stage.getHeight());

	        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
	        if (!ButtonType.OK.equals(closeResponse.get())) {
	            event.consume();
	        }
	    };
	    
	    stage.setOnCloseRequest(confirmCloseEventHandler);
		
	}
	/**
	 * @return the current quiz model of the game
	 */
	public static QuizModel getQuizModel() {
		return model;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
