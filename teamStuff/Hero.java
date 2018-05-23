package teamStuff;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Image;

import javax.swing.ImageIcon;

import cityStuff.gameEnvGui;
import javax.swing.ImageIcon;


/**
 * Class for the Hero objects that comprise a team of heroes   
 * 
 * @author vjj14
 *
 */
public class Hero {
	
	/**
	 * The hero's name.
	 */
	private String heroName;
	
	
	
	private ImageIcon icon;
	
	/**
	 * The hero's class.
	 */
	private String heroClass;
	
	
	
	/**
	 * The hero's maximum health.<br>
	 * This value can only be increased.
	 */
	private int maxHealth;
	
	
	
	/**
	 * The state of the hero's health.<br>
	 * Receives both damage and restoration.
	 */
	private int currentHealth;
	
	
	
	/**
	 * The hero's innate ability to recover.<br>
	 * Determines how long an applied HealingItem takes to restore health.
	 */
	private int recoveryBoost;
	
	
	
	/**
	 * The hero's protective armor level.<br>
	 * Receives damage instead of the hero, acting like extra health.
	 */
	private int heroArmor;
	
	
	
	/**
	 * The hero's bartering skill.<br>
	 * Aids in lowering item shop prices for the team.
	 */
	private int barterSkill;
	
	
	
	/**
	 * Determines whether the hero is lucky or not.<br>
	 * Affects games against villains in beneficial ways.
	 */
	private boolean luck;
	
	
	
	/**
	 * The hero's fame.<br>
	 * Aids in increasing the team's chance of receiving gifts.
	 */
	private int fame;
	
	
	
	/**
	 * The hero's deterrence.<br>
	 * Aids in deterring robberies against the team.
	 */
	private int deterrence;
	
	
	
	/**
	 * A boolean showing whether the Hero has a HealingItem applied.<br>
	 * If this attribute is true then this hero should not be able to apply another HealingItem.
	 */
	private boolean currentlyHealing = false;
	
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
	public Hero(int health, String theClass, int recovery, int armor, int barter, boolean luck, int fame, int deterrence, ImageIcon image) {
		
		maxHealth = health;
		currentHealth = maxHealth;
		heroClass = theClass;
		recoveryBoost = recovery;
		heroArmor = armor;
		barterSkill = barter;
		this.luck = luck;
		this.fame = fame;
		this.deterrence = deterrence;
		icon = image;
		//nameHero();
	}
	
	
	/**
	 * The naming process for the hero.
	 * Ensures the name chosen isn't already taken by another hero.
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
	
	
	
	public void setHeroName(String name) {
		heroName = name;
	}
	
	
	//------------------------------------------------
	//                    [GETTERS]
	//------------------------------------------------
	
	
	/**
	 * Getter for the hero's name.
	 * @return heroName
	 */
	public String getName() {
		return heroName;
	}
	
	
	
	public ImageIcon getIcon() {
		return icon;
	}
	
	/**
	 * Getter for the hero's class.
	 * @return heroClass
	 */
	public String getHeroClass() {
		return heroClass;
	}
	
	
	
	
	/**
	 * Getter for the hero's max health.
	 * @return maxHealth
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	
	
	/**
	 * Getter for the hero's current health.
	 * @return currenthealth
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	
	
	/**
	 * Getter for the hero's recovery boost.
	 * @return recoveryBoost
	 */
	public int getRecoveryBoost() {
		return recoveryBoost;
	}
	
	
	
	/**
	 * Getter for the hero's armor.
	 * @return heroArmor
	 */
	public int getArmor() {
		return heroArmor;
	}
	
	
	
	/**
	 * Getter for the hero's bartering skill.
	 * @return barterSkill
	 */
	public int getBarterSkill() {
		return barterSkill;
	}
	
	
	
	/**
	 * Getter for the hero's deterrence level.
	 * @return deterrence
	 */
	public int getDeterrence() {
		return deterrence;
	}
	
	
	
	/**
	 * Getter for the hero's fame.
	 * @return fame
	 */
	public int getFame() {
		return fame;
	}
	
	
	
	/**
	 * Getter for the hero's luck.
	 * @return luck
	 */
	public boolean getLuck() {
		return luck;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------------------------
	//              [CONSUMABLE METHODS]
	//------------------------------------------------

	
	
	
	/**
	 * Use a HealingItem, item, by applying its effect to the hero, and removing it from the team's inventory.
	 * @param item
	 */
	public void useHealingItem(HealingItem item) {
		item.apply(this);
		Team.removeHealingItem(item);
	}
	
	
	
	
	
	
	
	
	
	public void usePowerUp(PowerUp item) {
		item.apply(this);
		Team.removePowerUp(item);
	}
	
	
	/**
	 * @param amount
	 */
	public void restoreHealth(int amount) {
		if(currentHealth + amount >= maxHealth) {
			currentHealth = maxHealth;}
		else {
			currentHealth += amount;}
	}
	
	
	
	
	
	
	//------------------------------------------------
	//                    [BOOSTERS]
	//------------------------------------------------
	
	
	/**
	 * Executes max health boost on the hero using an Augment Vitality PowerUp.  
	 * @param healthBoost
	 */
	public void boostMaxHealth(int healthBoost) {
		maxHealth += healthBoost;
	}
	
	
	
	/**
	 * Executes armor boost on the hero using an Iron Flesh PowerUp. 
	 * @param armorBoost
	 */
	public void boostArmor(int armorBoost) {
		heroArmor += armorBoost;
	}
	
	
	
	/**
	 * Executes barter skill boost on the hero using a Silver Tongue PowerUp. 
	 * @param barterBoost
	 */
	public void boostBarterSkill(int barterBoost) {
		barterSkill += barterBoost;
	}
	
	
	
	/**
	 * Executes fame boost for when the hero prevails against a villain. 
	 * @param fameBoost
	 */
	public void boostFame(int fameBoost) {
		fame += fameBoost;
	}
	
	
	
	/**
	 * Executes deterence boost for when the hero prevails agains a villain.
	 * @param deterrenceBoost
	 */
	public void boostDeterrence(int deterrenceBoost) {
		deterrence += deterrenceBoost;
	}
	
	
	
	//------------------------------------------------
	//              [DAMAGE & DEATH]
	//------------------------------------------------
	
	
	/**
	 * Ensures that health is never negative.
	 * Reduces the damaged hero's armor, if any.
	 * Calculates how much damage is dealt, if any.
	 * Determines whether the damaged hero is dead.
	 * 
	 * @param damage
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
	
	
	
	/**
	 * Reduces the hero's armor according to the damage.
	 * Ensures the hero's armor value is never negative.
	 * 
	 * @param damage
	 */
	public void damageArmor(int damage) {
		if(heroArmor <= damage) {
			heroArmor = 0;}
		
		else if(heroArmor > damage) {
			heroArmor -= damage;}
	}
	
	
	
	/**
	 * Informs user about the hero's death.
	 * Removes the dead hero from the team.
	 */
	public void deathHandling() {
		System.out.println(this.getName() + " has died");
		//Team.removeHero(this);
	}
	
	
	
	
	public String getFullInfo() {
		String info = "HERO CLASS: ANTI-HERO\n\n\n"
					
					+ getHeroClass() + " Health: " + getMaxHealth() + "\n"
					+ "This is the hero's lifeforce; one'll most surely die without any...\n\n"
					
					+ getHeroClass() + " Recovery: " + getRecoveryBoost() + "\n"
					+ "This is the hero's innate ability to bond with healing items, hastening their application.\n\n"
					
					+ getHeroClass() + " Armor: " + getArmor() + "\n"
					+ "This is the hero's armor, which bears the damage of any attack, acting as additional health, and fading as battles rage.\n\n"
					
					+ getHeroClass() + " Barter Skill: " + getBarterSkill() + "\n"
					+ "This is the hero's ability to haggle with shopkeepers, helping the team get cheap items.\n\n"
					
					+ getHeroClass() + " Fame: " + getFame() + "\n"
					+ "This is the hero's public renown; a team of famous heroes attracts those bearing gifts!\n\n"
					
					+ getHeroClass() + " Deterrence: " + getDeterrence() + "\n"
					+ "This is the hero's intimidating prescence; a team of scary heroes deters thievery.\n\n";
		
		
		
		if(this instanceof Cartographer) {
			   info +="This hero comes with a map, revealing all the locations of every city.";
		}
		else if(this instanceof LuckyBoii) {
			   info +="This hero is lucky enough to have a better chance at winning games. That could be useful.";
		}
		
		return info;
	}
	
	

	/**
	 * The hero's toString method, that prints the hero's attributes as desired.
	 */
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
	
	
	public static void main(String[] args) {
		MerchantMan quod = new MerchantMan();
		SilverTongueI buff1 = new SilverTongueI();
		SilverTongueII buff2 = new SilverTongueII();
		SilverTongueIII buff3 = new SilverTongueIII();
		buff1.apply(quod);
		//buff2.apply(quod);
		//buff3.apply(quod);
		System.out.println(quod);
		
		
	}
	
}