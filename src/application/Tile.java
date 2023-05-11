package application;

import javafx.scene.layout.StackPane;

public class Tile extends StackPane{
	private boolean occupied = false;
	private String color = "WHITE";
	private int cellcount = 0;
	
	
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
	
	public void addCellcount(Main m) {
		if ((m.currentTurn == "P1" && this.getColor() == "RED" )|| 
			(m.currentTurn == "P2" && this.getColor() == "GREEN" )){
		
		++this.cellcount;
		if (cellcount > 3) {
			//explode
			this.cellcount = 1;
		}
		switch (this.getColor()) {
		case "RED":
			break;
		case "GREEN":
			break;
		}
		
		
		}
		
	}
}
