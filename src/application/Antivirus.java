package application;

public class Antivirus extends PowerUp{
	
	Antivirus(){
		super("Antivirus", 300, "Sets all the enemy cell count to 1");
	}
	
	public void usePowerUp(Player p){
		if (p.getCoins() >= this.getCost()) {
			p.updateCoins('-', getCost());
		}else {
			System.out.println("[GAME][NOTICE]: You don't have enough coins!");
		}
	}
}
