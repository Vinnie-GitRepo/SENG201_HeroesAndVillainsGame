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
	
	
	/**
	 * The toString method for the PowerUp class.
	 * Prints out the result string when passing the PowerUp into a print statement.
	 */
	public String toString() {
		String resultString = "Name: " + getPowerUpName() + "\n"
							+ "Item Type: " + getPowerUpType() + "\n"
							+ "Potency: " + getPowerUpPotency() + "\n"
							+ "Price: " + getPowerUpPrice();
		return resultString;
	}
	
}
