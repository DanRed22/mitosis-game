package application;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tile extends StackPane{
	
	private boolean occupied = false;
	private String color = "WHITE";
	private int cellcount = 0;
	private Text cellCountText;
	private GameData DATA; 
	
	Tile(GameData DATA){
		this.DATA = DATA;
		Rectangle tile = new Rectangle(Main.CONST.getTILE_SIZE(), Main.CONST.getTILE_SIZE());
		switch (this.color) {
		case "WHITE":
			tile.setFill(Color.WHITE);
			break;
		case "RED":
			tile.setFill(Color.RED);
			break;
		case "GREEN":
			tile.setFill(Color.GREEN);
			break;
		}
		
		tile.setStroke(Color.BLACK);
		tile.setStrokeWidth(3d);
		cellCountText = new Text(Integer.toString(getCellcount()));
		System.out.println(Main.CONST.getTILE_SIZE());
		this.setMouseTransparent(true);
		setOnMouseClicked(event -> {
            // increase the cell count and update the text
			System.out.println("Clicked on tile");
		    addCellcount(DATA);
		    cellCountText.setText(Integer.toString(getCellcount()));
            
        });
		
		getChildren().addAll(tile, cellCountText);
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCellcount() {
		return cellcount;
	}
	public void setCellcount(int cellcount) {
		this.cellcount = cellcount;
	}
	
	public void addCellcount(GameData DATA) {
//		if ((m.currentTurn == "P1" && this.getColor() == "RED" )|| 
//			(m.currentTurn == "P2" && this.getColor() == "GREEN" )){
		if (this.getColor() == "WHITE" || this.getColor() == "RED") {
			++this.cellcount;
			if (cellcount > 3) {
				//explode
				this.cellcount = 1;
			}
			this.setColor("RED");
			
		}
		
		if (this.getColor() == "WHITE" || this.getColor() == "GREEN") {
			++this.cellcount;
			if (cellcount > 3) {
				//explode
				this.cellcount = 1;
			}
			this.setColor("GREEN");
			
		}
		
		
		
		//}
		
	}

	public GameData getDATA() {
		return DATA;
	}

	public void setDATA(GameData dATA) {
		DATA = dATA;
	}
}
