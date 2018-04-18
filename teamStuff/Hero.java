package teamStuff;

import java.util.*;

public class Hero {
	
	private String heroName;
	private String heroClass;
	private static int maxHealth;
	private static int currentHealth;
	private static int recoveryBoost;
	private static int heroArmor;
	private static int barterSkill;
	private boolean luck;
	private static int fame;
	private static int deterrence;
	
	
	
	public Hero(int health, int recovery, int armor, int barter, boolean luck, int fame, int deterrence) {
		
		maxHealth = health;
		currentHealth = maxHealth;
		recoveryBoost = recovery;
		heroArmor = armor;
		barterSkill = barter;
		this.luck = luck;
		this.fame = fame;
		this.deterrence = deterrence;
		nameHero();
	}
	
	
	
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
						System.out.println("That name is already taken by a team member, so you must enter another.");
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
	
	
	
	
	
	/**
	 *      [GETTERS]
	 */
	public String getName() {
		return heroName;
	}
	
	public static int getMaxHealth() {
		return maxHealth;
	}
	
	public static int getCurrentHealth() {
		return currentHealth;
	}
	
	public static int getRecoveryBoost() {
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
	
	
	
	
	
	
	public static void restoreHealth(int amount) {
		if(currentHealth + amount >= maxHealth) {
			currentHealth = maxHealth;}
		else {
			currentHealth += amount;}
	}
	
	
	
	
	
	
	
	//------------------------------------------------
	//                     [SETTERS]
	//------------------------------------------------
	public void setHeroClass(String className) {
		heroClass = className;
	}
	
	
	
	

	//------------------------------------------------
	//                    [BOOSTERS]
	//------------------------------------------------
	
	public static void boostMaxHealth(int healthBoost) {
		maxHealth += healthBoost;
	}
	
	public static void boostArmor(int armorBoost) {
		heroArmor += armorBoost;
	}
	
	public static void boostBarterSkill(int barterBoost) {
		barterSkill += barterBoost;
	}
	
	public static void boostFame(int fameBoost) {
		fame += fameBoost;
	}
	
	public static void boostDeterrence(int deterrenceBoost) {
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
			currentHealth -= (damage - heroArmor);}
		if(currentHealth <= 0) {
			currentHealth = 0;
			deathHandling();
		}
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
		String resultString = "Name: " + heroName 
				            + "\nClass: " + heroClass 
				            + "\nHealth: " + currentHealth + "/" + maxHealth 
				            + "\nArmor: " + heroArmor 
				            + "\nBarter Skill: " + barterSkill 
				            + "\nFame: " + fame 
				            + "\nDeterrence: " + deterrence + "\n";
		return resultString;
	}
	
	
}