package teamStuff;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Class for healing items where all attributes and methods are defined.
 *            Subclasses only need to call the constructor. 
 *            
 * @author vjj14
 */
public class HealingItem {
	
	private String healingItemName;
	private int healingItemPotency;					// NOTE: This potency must be divisible by four for incremental application.
	private int healingItemPrice;
	private int defaultApplicationTime;
	private int secondsPassed;
	private int timeRemaining;
	private Timer time = new Timer();
	
	
	
	/**
	 *  <<Constuctor>> for HealingItem class 
	 * 
	 * @param name
	 * @param potency
	 * @param price
	 * @param time
	 */
	public HealingItem(String name, int potency, int price, int time) {
		healingItemName = name;
		healingItemPotency = potency;
		healingItemPrice = price;
		defaultApplicationTime = time;
	}
	
	
	
	/**
	 * Getter for the healing item's name.
	 * @return healingItemName
	 */
	public String getHealingItemName() {
		return healingItemName;
	}
	
	
	
	/**
	 * Getter for the healing item's potency.
	 * @return healingItemPotency
	 */
	public int getHealingItemPotency() {
		return healingItemPotency;
	}
	
	
	
	/**
	 * Getter for the healing item's price.
	 * @return
	 */
	public int getHealingItemPrice() {
		return healingItemPrice;
	}
	
	
	
	/**
	 * Getter for the time until the healing item has finished healing.
	 * @return timeRemaining
	 */
	public int getTimeRemaining() {
		return timeRemaining;
	}
	
	
	
	/**
	 * Applies the healing item's effect to the selected hero.
	 * Restores health in 25% increments over time, which varies for hero types. 
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
				
				System.out.println("Time remaining: " + timeRemaining);
				
			
				if(secondsPassed == 1 * applicationTime) {                							//	First increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getHealingItemPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());
				}
					
				if(secondsPassed == 2 * applicationTime) {											//	Second increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getHealingItemPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());
				}
					
				if(secondsPassed == 3 * applicationTime) {											//	Third increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getHealingItemPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());
				}
					
				if(secondsPassed == 4 * applicationTime) {											//	Fourth increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getHealingItemPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());
					cancel(); 																		//	Finished the healing process.
				}  								
			}
		};
		time.scheduleAtFixedRate(healOverTime, 1000, 1000);
	}
}
