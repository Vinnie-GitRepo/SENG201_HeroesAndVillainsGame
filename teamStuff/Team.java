package teamStuff;

import java.util.*;


/**
 * Class for the team of heroes.
 * 
 * @author vjj14
 *
 */
public class Team {
	
	
	/**
	 * Name of the team, which is between 2 and 10 characters in length.
	 */
	private static String teamName;
	
	
	
	/**
	 * The array in which Hero objects are stored
	 */
	private static ArrayList<Hero> heroArray = new ArrayList<Hero>();
	
	
	
	/**
	 * The money the team has to spend on items, which is awarded to the team for victories. 
	 * Can be gifted or stolen.
	 */
	private int money = 100;
	
	
	
	/**
	 * This is the team's net fame.
	 * Is used to increase chance of randomly receiving gifts.
	 */
	private int fameSum;
	
	
	
	/**
	 * This is the team's net deterrence.
	 * Is used to decrease chance of randomly being robbed.
	 */
	private int deterrenceSum;
	
	
	
	/**
	 * This is the team's net bartering skill.
	 * Is used to determine shop prices for the team.
	 */
	private int barterSkillSum;
	
	
	
	/**
	 * A list that stores the team's HealingItem objects.
	 * A hero's use of any healing item in a hospital will result in it being removed from this list.
	 */
	public static ArrayList<HealingItem> healingItems = new ArrayList<HealingItem>();
	
	
	
	/**
	 * A list that stores the team's PowerUp objects.
	 * A hero's use of any power up in a power up den will result in it being removed from this list.
	 */
	public static ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();

	

	
	//------------------------------------------------
	//                   [INVENTORY]
	//------------------------------------------------
	
		
	/**
	 * Adds a HealingItem to the healingItems list.
	 * @param healingItem HealingItem
	 */
	public void addHealingItem(HealingItem healingItem) {
		healingItems.add(healingItem);
	}
	
	
	
	/**
	 * Removes a HealingItem from the healingItems list. 
	 * @param healingItem HealingItem
	 */
	public static void removeHealingItem(HealingItem healingItem) {
		healingItems.remove(healingItem);
	}
	
	
	
	/**
	 * Returns healingItems list. 
	 * @return healingItems ArrayList<HealingItem>
	 */
	public ArrayList<HealingItem> getHealingItems() {
		return healingItems;
	}
	
	
	
	/**
	 * Adds a PowerUp to the powerUps list.
	 * @param powerUp PowerUp
	 */
	public void addPowerUp(PowerUp powerUp) {
		powerUps.add(powerUp);
	}
	
	
	
	/**
	 * Removes a PowerUp from the powerUps list.
	 * @param powerUp PowerUp
	 */
	public static void removePowerUp(PowerUp powerUp) {
		powerUps.remove(powerUp);
	}
	
	
	
	/**
	 * Returns the powerUps list
	 * @return powerUps ArrayList<PowerUp> 
	 */
	public ArrayList<PowerUp> getPowerUps() {
		return powerUps;
	}
	
	
	/**
	 * Prints out all the items of the team to view
	 * @return words String
	 */
	public String viewInventory() {
		String words = "HEALING ITEMS\n";
		
		for (HealingItem item : healingItems) {
			words += item.getHealingItemName() + "\n";}
		
			words += "\nPOWER UP ITEMS\n";
			
		for (PowerUp item : powerUps) {
			words += item.getPowerUpName() + "\n";}
		
		return words;
	}
	

	
	
	
	//------------------------------------------------
	//                   [GETTERS]
	//------------------------------------------------
	
	
	/**
	 * @return teamName String
	 */
	public String getName() {
		return teamName;
	}
	
	
	
	/**
	 * @return money int
	 */
	public int getMoney() {
		return money;
	}
	
	
	
	/**
	 * @return heroArray ArrayList<Hero>
	 */
	public static ArrayList<Hero> getHeroArray() {
		return heroArray;
	}
	
	
	
	/**
	 * @return fameSum int
	 */
	public int getFameSum() {
		return fameSum;
	}
	
	
	
	/**
	 * @return deterrenceSum int
	 */
	public int getDeterrenceSum() {
		return deterrenceSum;
	}
	
	
	
	/**
	 * @return barterSkillSum int
	 */
	public int getBarterSkillSum() {
		return barterSkillSum;
	}
	
	
	
	
	
	//------------------------------------------------
	//                   [SETTERS]
	//------------------------------------------------
	
	
	/**
	 * Sets the team's fameSum.<br>
	 * Refreshes the sum before iterating over the heroArray.
	 */
	public void setFameSum() {
		fameSum = 0;
		for(Hero hero : heroArray) {
			fameSum += hero.getFame();
		}
	}
	
	
	
	/**
	 * Sets the team's deterrenceSum.<br>
	 * Refreshes the sum before iterating over the heroArray.
	 */
	public void setDeterrenceSum() {
		deterrenceSum = 0;
		for(Hero hero : heroArray) {
			deterrenceSum += hero.getDeterrence();
		}
	}
	
	
	
	/**
	 * Sets the team's barterSkillSum.<br>
	 * Refreshes the sum before iterating over the heroArray.
	 */
	public void setBarterSkillSum() {
		barterSkillSum = 0;
		for(Hero hero : heroArray) {
			barterSkillSum += hero.getBarterSkill();
		}
	}
	
	
	
	
	/**
	 * Sets the name for the team.<br>
	 * Is called when submitting a name of valid length into the teamNameEntryBox
	 * @param name String
	 */
	public void nameTeam(String name) {
		teamName = name;
	}
	
	
	
	/**
	 * Adds a hero to the team's heroArray.
	 * @param hero Hero
	 */
	public void addHero(Hero hero) {
		heroArray.add(hero);
	}
	
	
	
	
	
	//------------------------------------------------
	//                [BATTLE METHODS]
	//------------------------------------------------
	
	
	/**
	 * Removes a dead hero from the team
	 * @param hero
	 */
	public static void removeHero(Hero hero) {
		heroArray.remove(hero);
	}
	
	
	
	/**
	 * Changes the amount of money in the team's posession.
	 * @param amount
	 */
	public void addMoney(int amount) {
		money += amount;
	}
	
	
	
	/**
	 * The toString method for the Team class.<br>
	 * Calls the toString method of the Hero class, printing the Team stats and members in desired format.
	 */
	public String toString() {
		String resultString = "\n\nHERO TEAM NAME: " + teamName 
				            + "\nMONEY: " + money 
				            + "\nTEAM FAME: " + fameSum
				            + "\nTEAM DETERRENCE: " + deterrenceSum
				            + "\nTEAM BARTER SKILL: " + barterSkillSum 
				            + "\n-------------------------------------------\n\n";
		
		for(Hero hero: heroArray) {
			if (hero.getCurrentHealth() > 0) {
			resultString += hero.toString() + "\n";
			}
		}
		
		resultString += "-------------------------------------------";
		return resultString;
	}
	
	
	public static void main(String[] args) {
		Team team = new Team();
		System.out.println(team);
		//team.selectHero();
		//Hero dead = heroArray.get(0);
		//dead.damageHealth(10000000);
		//System.out.println(team);
		
		
	}
	
	
}