package teamStuff;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class for the Hero objects that comprise a team of heroes   
 * 
 * @author vjj14
 * @version 
 *
 */
public class Hero {
	
	public static int secondsPassed = 0;
	private String heroName;
	private String heroClass;
	private int maxHealth;
	private int currentHealth;
	private int recoveryBoost;
	private int heroArmor;
	private int barterSkill;
	private boolean luck;
	private int fame;
	private int deterrence;
	
	
	/**
	 * Constructor for the Hero class
	 * 
	 * @param health
	 * @param theClass
	 * @param recovery
	 * @param armor
	 * @param barter
	 * @param luck
	 * @param fame
	 * @param deterrence
	 */
	public Hero(int health, String theClass, int recovery, int armor, int barter, boolean luck, int fame, int deterrence) {
		
		maxHealth = health;
		currentHealth = maxHealth;
		heroClass = theClass;
		recoveryBoost = recovery;
		heroArmor = armor;
		barterSkill = barter;
		this.luck = luck;
		this.fame = fame;
		this.deterrence = deterrence;
		nameHero();
	}
	
	
	/**
	 * 
	 */
	public void nameHero() {
		ArrayList<Hero> checkArray = Team.getHeroArray();
		
		System.out.println("\nWhat is this hero's name? ");
		Scanner inputName = new Scanner(System.in);
		String name = inputName.nextLine();
		
		boolean done;
		
		if(checkArray.size() >= 1) {
			for(Hero hero : checkArray) {
				done = false;
				while (done == false) {
					if(name.equals(hero.getName())) {
						System.out.println("That name is already taken by a team member");
						System.out.println("Enter another name: ");
						inputName = new Scanner(System.in);
						name = inputName.nextLine();}
					else {
						heroName = name;
						done = true;}
				}
			}
		}
		heroName = name;
	}
	
	
	
	
	
	//------------------------------------------------
	//                    [GETTERS]
	//------------------------------------------------
	
	public String getName() {
		return heroName;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public int getRecoveryBoost() {
		return recoveryBoost;
	}
	
	public int getArmor() {
		return heroArmor;
	}
	
	public int getBarterSkill() {
		return barterSkill;
	}
	
	public int getDeterrence() {
		return deterrence;
	}
	
	public int getFame() {
		return fame;
	}
	
	public boolean getLuck() {
		return luck;
	}
	
	
	
	//------------------------------------------------
	//              [CONSUMABLE METHODS]
	//------------------------------------------------
	public void useConsumable(ConsumableItem item) { 
		item.apply(this);
		Team.removeItem(item);
	}
	
	
	public void restoreHealth(int amount) {
		if(currentHealth + amount >= maxHealth) {
			currentHealth = maxHealth;}
		else {
			currentHealth += amount;}
	}
	
	
	
	
	
	
	//------------------------------------------------
	//                    [BOOSTERS]
	//------------------------------------------------
	
	public void boostMaxHealth(int healthBoost) {
		maxHealth += healthBoost;
	}
	
	public void boostArmor(int armorBoost) {
		heroArmor += armorBoost;
	}
	
	public void boostBarterSkill(int barterBoost) {
		barterSkill += barterBoost;
	}
	
	public void boostFame(int fameBoost) {
		fame += fameBoost;
	}
	
	public void boostDeterrence(int deterrenceBoost) {
		deterrence += deterrenceBoost;
	}
	
	
	
	//------------------------------------------------
	//              [DAMAGE & DEATH]
	//------------------------------------------------
	
	/**
	 * Calculates how much damage is dealt, if any.
	 * Reduces the damaged hero's armor, if any.
	 * Determines whether the damaged hero is dead.
	 */
	public void damageHealth(int damage) {
		if(heroArmor < damage) {
			currentHealth -= (damage - heroArmor);
			damageArmor(damage);}
		
		else if(heroArmor >= damage) {
			damageArmor(damage);}
		
		if(currentHealth <= 0) {
			currentHealth = 0;
			deathHandling();}
	}
	
	
	public void damageArmor(int damage) {
		if(heroArmor <= damage) {
			heroArmor = 0;}
		
		else if(heroArmor > damage) {
			heroArmor -= damage;}
		
		
	}
	
	
	/**
	 * Informs the player about a hero's death.
	 * Removes dead hero from the team.
	 */
	public void deathHandling() {
		System.out.println(this.getName() + " has died");
		Team.removeHero(this);
	}
	
	
	
	

	
	public String toString() {
		String resultString = "Name: " + getName() 										// Name: (heroName)
				            + "\nClass: " + heroClass 									// Class: (heroClass)
				            + "\nHealth: " + getCurrentHealth() + "/" + getMaxHealth()  // Health: (currentHealth/maxHealth)
				            + "\nRecovery: " + getRecoveryBoost()						// Recovery: (recoveryBoost)
				            + "\nArmor: " + getArmor() 									// Armor: (heroArmor)
				            + "\nBarter Skill: " + getBarterSkill() 					// Barter Skill: (barterSkill)
				            + "\nFame: " + getFame() 									// Fame: (fame)
				            + "\nDeterrence: " + getDeterrence() + "\n";				// Deterrence (deterrence)
		return resultString;
	}
	
	
}