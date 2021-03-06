package teamStuff;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Class for healing items where all attributes and methods are defined.<br>
 *            Subclasses only need to call the constructor. 
 *            
 * @author vjj14
 */
public class HealingItem {
	
	/**
	 * Name of the healing item.<br>
	 * The tier (price and potency) of the item is described by the Roman numeral.
	 */
	private String healingItemName;
	
	
	
	/**
	 * Potency of the healing item.<br>
	 * This is the value used in healing item application calculations.<br>
	 * This potency must be divisible by four for incremental application.
	 */
	private int healingItemPotency;					
	
	
	
	/**
	 * Price of the healing item.<br>
	 * This is the value used when calculating the team's money upon purchasing the healing item.
	 */
	private int healingItemPrice;
	
	
	
	/**
	 * Default application time for the healing item.<br>
	 * This value will be used for the applicationTime local variable.
	 */
	private int defaultApplicationTime;
	
	
	
	/**
	 * The time passed since applying the healing item.<br>
	 * Is used by conditionals in apply(Hero hero) to increment the healing process.
	 */
	private int secondsPassed;
	
	
	
	/**
	 * The time left until the healing item has been applied fully.<br>
	 * This is the time status value shown inside the hospital via getRemainingTime(). 
	 */
	private int timeRemaining;
	
	
	
	/**
	 * Calls the TimerTask (main application body) within the apply(Hero hero) method.
	 */
	private Timer time = new Timer();
	
	
	
	/**
	 *  <<Constuctor>> for HealingItem class 
	 * 
	 * @param name       String
	 * @param potency    int
	 * @param price      int
	 * @param time       int
	 */
	public HealingItem(String name, int potency, int price, int time) {
		healingItemName = name;
		healingItemPotency = potency;
		healingItemPrice = price * 3;
		defaultApplicationTime = time;
	}
	
	
	
	/**
	 * Getter for the healing item's name.
	 * 
	 * @return healingItemName String
	 */
	public String getHealingItemName() {
		return healingItemName;
	}
	
	
	
	/**
	 * Getter for the healing item's potency.
	 * 
	 * @return healingItemPotency int
	 */
	public int getHealingItemPotency() {
		return healingItemPotency;
	}
	
	
	
	/**
	 * Getter for the healing item's price.
	 * 
	 * @return healingItemPrice int
	 */
	public int getHealingItemPrice() {
		return healingItemPrice;
	}
	
	
	
	/**
	 * Applies the healing item's effect to the selected hero.<br>
	 * Restores health in 25% increments over time, which varies for hero types.<br> 
	 * The time between increments is determined by a hero's innate recovery boost.
	 * 
	 * @param hero
	 */
	public void apply(Hero hero) {
		int applicationTime = defaultApplicationTime - hero.getRecoveryBoost();
		timeRemaining = 4*applicationTime;
		TimerTask healOverTime = new TimerTask() {
			
			public void run() {
				
				timeRemaining--;
				secondsPassed++;
				
				if(secondsPassed == 1 * applicationTime) {                							//	1st increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getHealingItemPotency() / 4);}
					
				if(secondsPassed == 2 * applicationTime) {											//	2nd increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getHealingItemPotency() / 4);}
					
				if(secondsPassed == 3 * applicationTime) {											//	3rd increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getHealingItemPotency() / 4);}
					
				if(secondsPassed == 4 * applicationTime) {											//	4th increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getHealingItemPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());
					cancel();}																		//	Finished the healing process.  								
			}
		};
		time.scheduleAtFixedRate(healOverTime, 1000, 1000);
	}
	
	
	
	
	/**
	 * Getter for the time until the healing item has finished healing.
	 * 
	 * @return timeRemaining int
	 */
	public int getTimeRemaining() {
		return timeRemaining;
	}
	
	
	
	/**
	 * The toString method for the HealingItem class.<br>
	 * Prints out the result string when passing the HealingItem into a print statement.
	 */
	public String toString() {
			
			String resultString = "<html>Name: " + getHealingItemName() + "<br>"
								+ "Item Type: Healing Item" + "<br>"
								+ "Potency: " + getHealingItemPotency() + "<br>"
								+ "Description: A restorative concoction, perfect for wounded heroes.<br>"
								+ "Item Effect: Will restore " + getHealingItemPotency() + " health in 25% increments over time.<html>";   	
			
			return resultString;
	}
	
	
}
