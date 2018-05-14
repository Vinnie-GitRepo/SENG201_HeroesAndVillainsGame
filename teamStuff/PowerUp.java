package teamStuff;

public class PowerUp {
	
	private String powerUpName;
	private int powerUpPotency;
	private int powerUpPrice;
	
	
	
	/**
	 * <<constructor>> for PowerUp class
	 * 
	 * @param name
	 * @param potency
	 * @param price
	 */
	public PowerUp(String name, int potency, int price) {
		powerUpName = name;
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
	
}
