package application;
	
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane; 


public class Main extends Application {
	public GameConstants CONST = new GameConstants();
	public Player P1= new Player("RED");
	public Player P2= new Player("GREEN");
	public String currentTurn = "P1";

	
	
	public Tile tile[][] = new Tile[CONST.getGAME_ROW()][CONST.getGAME_COL()];
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,CONST.getSCREEN_X(),CONST.getSCREEN_Y());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Mitosis");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
