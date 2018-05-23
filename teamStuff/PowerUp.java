package teamStuff;

public class PowerUp {
	
	
	/**
	 * Name of the power up.
	 */
	private String powerUpName;
	
	
	
	/**
	 * Type of the power up.
	 * Denotes what hero attribute will receive a boost.
	 */
	private String powerUpType;
	
	
	
	/**
	 * Potency of the power up.
	 * This is the value used in power up application calculations.
	 */
	private int powerUpPotency;
	
	
	
	/**
	 * Price of the power up.
	 * This is the value used when calculating the team's money upon purchasing the power up
	 */
	private int powerUpPrice;
	
	
	
	/**
	 * <<constructor>> for PowerUp class
	 * 
	 * @param name
	 * @param potency
	 * @param price
	 */
	public PowerUp(String name, String type, int potency, int price) {
		powerUpName = name;
		powerUpType = type;
		powerUpPotency = potency;
		powerUpPrice = price;
	}
	
	
	
	/**
	 * Getter for the power up's name.
	 * @return powerUpName
	 */
	public String getPowerUpName() {
		return powerUpName;
	}
	
	
	
	
	 public String getPowerUpType() {
		 return powerUpType; 
	 }
	
	
	/**
	 * Getter for the power up's potency.
	 * @return powerUpPotency
	 */
	public int getPowerUpPotency() {
		return powerUpPotency;
	}
	
	
	
	/**
	 * Getter for the power up's price.
	 * @return powerUpPrice
	 */
	public int getPowerUpPrice() {
		return powerUpPrice;
	}
	
	public void apply(Hero hero) {
		if(this instanceof SilverTongueI || this instanceof SilverTongueII || this instanceof SilverTongueIII) {
			hero.boostBarterSkill(getPowerUpPotency());
		}
		else if(this instanceof IronFleshI || this instanceof IronFleshII || this instanceof IronFleshIII) {
			hero.boostArmor(getPowerUpPotency());
		}
		else if(this instanceof AugmentVitalityI || this instanceof AugmentVitalityII || this instanceof AugmentVitalityIII) {
			hero.boostMaxHealth(getPowerUpPotency());
		}
	}
	
	
	/**
	 * The toString method for the PowerUp class.
	 * Prints out the result string when passing the PowerUp into a print statement.
	 */
	public String toString() {
		
		String resultString = "Name: " + getPowerUpName() + "\n"
							+ "Item Type: " + getPowerUpType() + "\n"
							+ "Potency: " + getPowerUpPotency() + "\n"
							+ "Price: " + getPowerUpPrice() + "\n";
		
		if(this instanceof SilverTongueI || this instanceof SilverTongueII || this instanceof SilverTongueIII) {
			resultString += "Description: This power up heightens one's ability to coerce shopkeepers into accepting less favourable deals.\n" 
						  + "Item effect: Upon application this power up will increase a hero's bartering skill by " + getPowerUpPotency() + ".\n";
		}
		else if(this instanceof IronFleshI || this instanceof IronFleshII || this instanceof IronFleshIII) {
			resultString += "Description: This power up hardens one's being, shielding them, but the effect fades with each blow.\n"
						  + "Item effect: Upon application this power up will increase a hero's armor by " + getPowerUpPotency() + ".\n";
		}
		else if(this instanceof AugmentVitalityI || this instanceof AugmentVitalityII || this instanceof AugmentVitalityIII) {
			resultString += "Description: This power up stimulates one's cell growth and energy efficiency, extending their lifeforce.\n"
					      + "Item effect: Upon application this power up will increase a hero's maximum health by " + getPowerUpPotency() + ".\n";
		}
		
		return resultString;
	}
	
}
