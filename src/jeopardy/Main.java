package jeopardy;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
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
 * Main class for the Jeopardy application. THe application is built with Javafx
 * The application uses Model view controller architecture
 * @author Neville
 */


public class Main extends Application {
	private Stage primaryStage;
	private static  QuizModel model;
	private EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
        Alert closeConfirmation = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Do you wish to exit without saving?",
                ButtonType.YES, ButtonType.NO
        );
        
        Button noButton = (Button) closeConfirmation.getDialogPane().lookupButton(
                ButtonType.NO
        );
        noButton.setText("save and exit");
        closeConfirmation.setHeaderText(null);
        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
        closeConfirmation.initOwner(primaryStage);


        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
        
        // save and exit
        if (ButtonType.NO.equals(closeResponse.get())) {
        	model.save();
        	Platform.exit();
        	//System.out.println();
        	//System.exit(0);
        }
        
        // exit without saving
        if (ButtonType.YES.equals(closeResponse.get())) {
        	Platform.exit();
        	//System.exit(0);
        } else {
            event.consume();
        }
        
    };
   
	
	
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
		
		primaryStage.setOnCloseRequest(confirmCloseEventHandler);
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
