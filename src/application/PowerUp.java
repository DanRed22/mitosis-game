package application;

public abstract class PowerUp {
	private String name;
	private int cost;
	private String description;
	
	PowerUp(String name, int cost, String description){
		setName(name);
		setCost(cost);
		setDescription(description);
	}
	PowerUp(){
		setName("NOT SET");
		setCost(0);
		setDescription("NOT SET");
	}
	public void usePowerUp(Player p) {
		System.out.println("[GAME][WARN]: Used Power Up, but undefined");
	}
	public void setName(String name){
		this.name = name;
	}
	public void setCost(int cost){
		this.cost = cost;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
	public String getName(){
		return this.name;
	}
	public int getCost(){
		return this.cost;
	}
	public String getDescription(){
		return this.description;
	}
}
