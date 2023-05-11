package application;

public class GameData {
	private String currentTurn = "P1";
	private int p1_coins = 0;
	private int p2_coins = 0;
	
	
	public String getCurrentTurn() {
		return currentTurn;
	}
	public void setCurrentTurn(String currentTurn) {
		this.currentTurn = currentTurn;
	}
	public int getP1_coins() {
		return p1_coins;
	}
	public void setP1_coins(int p1_coins) {
		this.p1_coins = p1_coins;
	}
	public int getP2_coins() {
		return p2_coins;
	}
	public void setP2_coins(int p2_coins) {
		this.p2_coins = p2_coins;
	}
}
