package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane; 


public class Main extends Application {
	public static GameConstants CONST = new GameConstants();
	public Player P1= new Player("RED");
	public Player P2= new Player("GREEN");
	public GameData DATA = new GameData();
	public String currentTurn = "P1";

	
	public void init() {
		//init resources
	}
	
	public Tile tile[][] = new Tile[CONST.getGAME_ROW()][CONST.getGAME_COL()];
	@Override
	public void start(Stage primaryStage) {
		primaryStage.show();
		GridPane tileGrid = new GridPane();
        for (int row = 0; row < CONST.getGAME_ROW(); row++) {
            for (int col = 0; col < CONST.getGAME_COL(); col++) {
                tile[row][col] = new Tile(this.DATA);
                tile[row][col].toFront();
                tileGrid.add(tile[row][col], col, row);
                
            }
        }
        
        AnimationTimer timer = new AnimationTimer() {
            long lastTime = System.nanoTime();
            long interval = 1000000000 / 60; // 60fps update interval
            
            @Override
            public void handle(long now) {
                long elapsedTime = now - lastTime;
                if (elapsedTime >= interval) {
                    //update code here
                    System.out.println("REFRESH");
                    lastTime = now;
                    BorderPane root = new BorderPane();
                    root.setCenter(tileGrid);
                    Scene scene = new Scene(root, CONST.getSCREEN_X(), CONST.getSCREEN_Y());
                    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("Mitosis");
                    primaryStage.setOnCloseRequest(e -> {
                        // Release resources
                        stop();
                    });
                    primaryStage.show();
                }
            }
        };
		
		timer.start();
		
		
	}
	
	public void stop(){
		//release resources
		Platform.exit();
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
