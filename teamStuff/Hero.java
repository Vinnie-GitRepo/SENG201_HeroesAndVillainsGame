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
	
	
	
	//------------------------------------------------
	//              [HERO INITIALIZING]
	//------------------------------------------------
	
	
	/**
	 * <<Constructor>> for the Hero class
	 * 
	 * @param health int
	 * @param theClass String
	 * @param recovery int
	 * @param armor int
	 * @param barter int
	 * @param luck boolean
	 * @param fame int 
	 * @param deterrence int
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
	}
	
	
	/**
	 * Setter for the hero's name.
	 * @param name String
	 */
	public void setHeroName(String name) {
		heroName = name;
	}
	
	
	//------------------------------------------------
	//                    [GETTERS]
	//------------------------------------------------
	
	
	/**
	 * Getter for the hero's name.
	 * @return heroName String
	 */
	public String getName() {
		return heroName;
	}
	
	
	
	/**
	 * Getter for the hero's GUI representation
	 * @return icon ImageIcon
	 */
	public ImageIcon getIcon() {
		return icon;
	}
	
	
	
	
	/**
	 * Getter for the hero's class.
	 * @return heroClass String
	 */
	public String getHeroClass() {
		return heroClass;
	}
	
	
	
	
	/**
	 * Getter for the hero's max health.
	 * @return maxHealth int
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	
	
	/**
	 * Getter for the hero's current health.
	 * @return currenthealth int
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	
	
	/**
	 * Getter for the hero's recovery boost.
	 * @return recoveryBoost int
	 */
	public int getRecoveryBoost() {
		return recoveryBoost;
	}
	
	
	
	/**
	 * Getter for the hero's armor.
	 * @return heroArmor int 
	 */
	public int getArmor() {
		return heroArmor;
	}
	
	
	
	/**
	 * Getter for the hero's bartering skill.
	 * @return barterSkill int
	 */
	public int getBarterSkill() {
		return barterSkill;
	}
	
	
	
	/**
	 * Getter for the hero's deterrence level.
	 * @return deterrence int
	 */
	public int getDeterrence() {
		return deterrence;
	}
	
	
	
	/**
	 * Getter for the hero's fame.
	 * @return fame int
	 */
	public int getFame() {
		return fame;
	}
	
	
	
	/**
	 * Getter for the hero's luck.
	 * @return luck boolean
	 */
	public boolean getLuck() {
		return luck;
	}
	
	
	
	
	
	//------------------------------------------------
	//              [CONSUMABLE METHODS]
	//------------------------------------------------

	
	/**
	 * Use a HealingItem, item, by applying its effect to the hero, and removing it from the team's inventory.
	 * @param item HealingItem
	 */
	public void useHealingItem(HealingItem item) {
		item.apply(this);
		Team.removeHealingItem(item);
	}
	
	
	
	/**
	 * Use a PowerUp, item, by applying its effect to the hero, and removing it from the team's inventory.
	 * @param item PowerUp
	 */
	public void usePowerUp(PowerUp item) {
		item.apply(this);
		Team.removePowerUp(item);
	}
	
	
	
	/**
	 * This is called by the apply method in HealingItem during each time increment.<br>
	 * This method also ensure that the current health is less than or equal to their maximum health. 
	 * @param amount int
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
	 * @param healthBoost int
	 */
	public void boostMaxHealth(int healthBoost) {
		maxHealth += healthBoost;
	}
	
	
	
	/**
	 * Executes armor boost on the hero using an Iron Flesh PowerUp. 
	 * @param armorBoost int
	 */
	public void boostArmor(int armorBoost) {
		heroArmor += armorBoost;
	}
	
	
	
	/**
	 * Executes barter skill boost on the hero using a Silver Tongue PowerUp. 
	 * @param barterBoost int 
	 */
	public void boostBarterSkill(int barterBoost) {
		barterSkill += barterBoost;
	}
	
	
	
	/**
	 * Executes fame boost for when the hero prevails against a villain. 
	 * @param fameBoost int
	 */
	public void boostFame(int fameBoost) {
		fame += fameBoost;
	}
	
	
	
	/**
	 * Executes deterence boost for when the hero prevails agains a villain.
	 * @param deterrenceBoost int
	 */
	public void boostDeterrence(int deterrenceBoost) {
		deterrence += deterrenceBoost;
	}
	
	
	
	
	
	
	//------------------------------------------------
	//              [DAMAGE & DEATH]
	//------------------------------------------------
	
	
	/**
	 * Ensures that health is never negative.<br>
	 * Reduces the damaged hero's armor, if any.<br>
	 * Calculates how much health damage is dealt, if any.
	 * 
	 * @param damage int
	 */
	public void damageHealth(int damage) {
		if(heroArmor < damage) {
			currentHealth -= (damage - heroArmor);
			damageArmor(damage);}
		
		else if(heroArmor >= damage) {
			damageArmor(damage);}
		
		if(currentHealth <= 0) {
			currentHealth = 0;
		}
	}
	
	
	
	/**
	 * This method reduces the hero's armor according to the damage.
	 * This method ensures the hero's armor value is never negative.
	 * 
	 * @param damage int
	 */
	public void damageArmor(int damage) {
		if(heroArmor <= damage) {
			heroArmor = 0;}
		
		else if(heroArmor > damage) {
			heroArmor -= damage;}
	}
	
	
	
	
	//------------------------------------------------
	//        [PRESENTABLE HERO INFORMATION]
	//------------------------------------------------
	
	
	
	/**
	 * Returns a message detailing the hero class and hero attributes.<br>
	 * This method is used when clicking on any "class info" button in the teamInitializerPanel  
	 * @return info String
	 */
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
	}
	
}