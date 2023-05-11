package application;

public class Player {
	private String name;
	private String color;
	private int coins;
	
	Player(String name, String color){
		setName(name);
		setColor(color);
		setCoins(0);
	}
	Player(String color){
		setName("NOT SET");
		setColor(color);
		setCoins(0);
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getCoins() {
		return coins;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public void updateCoins(char operation, int coins) {
		switch (operation) {
		case '+':
			setCoins(getCoins()+ coins);
			break;
		case '-':
			setCoins(getCoins()- coins);
			break;
		default:
			System.out.println("[GAME][WARN]: OPERATION NOT DEFINED PROPERLY!");
			System.out.println("Operation: "+operation+" but expected '+' or '-'");
		}
		System.out.println("[GAME][NOTICE]: COIN UPDATE: "+coins);
	}
}
