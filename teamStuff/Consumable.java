package teamStuff;

public class Consumable implements Consume{
	
	
	
	private String consumableName;
	private int consumablePotency;
	private int consumablePrice;
	private boolean forHeroUse; // Distinguishes Potions and Power Ups from Map consumables
	
	
	
	public Consumable(String name, int potency, int price, boolean forHeroes) {
		consumableName = name;
		consumablePotency = potency;
		consumablePrice = price;
		forHeroUse = forHeroes; 
	}
	
	
	public String getName() {
		return consumableName;
	}
	
	
	public int getPotency() {
		return consumablePotency;
	}
	
	
	public int getPrice() {  // used when calculating buyability, and when subtracting from the team's money. 
		return consumablePrice;
	}
	
	
	public boolean getForHeroUse() { // used when determining if heroes can use a consummable
		return forHeroUse;
	}
	
	
	public void apply() {
		
	}
	
}