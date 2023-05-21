package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Main extends Application {
    public static GameConstants CONST = new GameConstants();
    public Player P1 = new Player("RED");
    public Player P2 = new Player("GREEN");
    public GameData DATA = new GameData();
    public String currentTurn = "P1";
    private Image icon = new Image(getClass().getResourceAsStream("icon.png"));

    GridPane tileGrid = new GridPane();
    private BorderPane root = new BorderPane();
    private Scene scene = new Scene(root, CONST.getSCREEN_X(), CONST.getSCREEN_Y());


    public Tile tile[][] = new Tile[CONST.getGAME_ROW()][CONST.getGAME_COL()];

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mitosis");
        primaryStage.setOnCloseRequest(e -> {
            // Release resources
            stop();
        });

        primaryStage.setFullScreen(false);
        primaryStage.getIcons().add(icon);
        root.setCenter(tileGrid);

        AnimationTimer timer = new AnimationTimer() {
            long lastTime = System.nanoTime();
            long interval = 1000000000 / 60; // 60fps update interval

            @Override
            public void handle(long now) {
                long elapsedTime = now - lastTime;
                if (elapsedTime >= interval) {
                    root.getChildren().remove(tileGrid);

                    // Recreate the tile grid
                    tileGrid = new GridPane();

                    for (int row = 0; row < CONST.getGAME_ROW(); row++) {
                        for (int col = 0; col < CONST.getGAME_COL(); col++) {
                            tile[row][col] = new Tile(DATA);
                            tile[row][col].toFront();
                            tileGrid.add(tile[row][col], col, row);

                            // Update the event handler for the Tile object
                            Tile currentTile = tile[row][col];
                            currentTile.setOnMouseClicked(event -> {
                                System.out.println("Clicked on tile");
                                currentTile.addCellcount(DATA);
                                currentTile.getCellCountText().setText(Integer.toString(currentTile.getCellcount()));
                            });
                        }
                    }
                    root.setCenter(tileGrid);

                    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                    primaryStage.setScene(scene);
                    primaryStage.show();

                    lastTime = now;
                }
            }
        };

        timer.start();
    }

    public void stop() {
        // release resources
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
