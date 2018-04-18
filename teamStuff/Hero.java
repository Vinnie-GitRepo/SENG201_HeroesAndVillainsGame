package teamStuff;

import java.util.*;

public class Hero {
	
	private String heroName;
	private String heroClass;
	private int maxHealth;
	private int currentHealth;
	private int heroArmor;
	private int barterSkill;
	private boolean luck;
	private int fame;
	private int deterrence;
	
	
	
	public Hero(int health, int armor, int barter, boolean luck, int fame, int deterrence) {
		
		maxHealth = health;
		currentHealth = maxHealth;
		heroArmor = armor;
		barterSkill = barter;
		this.luck = luck;
		this.fame = fame;
		this.deterrence = deterrence;
		nameHero();
		
		
	}
	
	
	
	/*public void nameHero() {
		System.out.println("What is this hero's name? ");
		Scanner inputName = new Scanner(System.in);
		String name = inputName.nextLine();
		
		
		for(Hero hero : Team.getHeroArray()) {
			if(name.equals(hero.getName())) {
				System.out.println("That name is already taken by a team member.");
				System.out.println("Enter another name.");
				nameHero();
			}
		}
		setName(name);
		inputName.close();
	}*/
	
	
	public void nameHero() {
		ArrayList<Hero> checkArray = Team.getHeroArray();
		
		System.out.println("What is this hero's name? ");
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
						setName(name);
						done = true;}
				}
			}
		}
		setName(name);
	}
	
	
	
	
	
	/**
	 *      [GETTERS]
	 */
	public String getName() {
		return heroName;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
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
	
	
	
	
	/**
	 *              [SETTERS]
	 */
	public void setName(String inputName) {
		heroName = inputName;
	}
	
	public void setHeroClass(String className) {
		heroClass = className;
	}
	
	
	
	public void boostMaxHealth(int healthBoost) {
		maxHealth += healthBoost;
	}
	
	
	
	
	/**
	 *             [BOOSTERS]
	 */
	public void boostArmor(int armorBoost) {
		heroArmor += armorBoost;
	}
	
	public void boostBarterSkill(int barterBoost) {
		barterSkill += barterBoost;
	}
	
	public void boostFame(int fameBoost) {
		fame += fameBoost;
	}
	
	
	
	
	/**
	 *          [DAMAGE & DEATH]
	 */
	public void damageHealth(int damage) {
		if(heroArmor < damage) {
			currentHealth -= (damage - heroArmor);}
		if(currentHealth <= 0) {
			currentHealth = 0;
			deathHandling();
		}
	}
	
	public void deathHandling() {
		System.out.println(this.getName() + " has died");
		Team.removeHero(this);
	}
	
	
	
	
	

	
	
	public String toString() {
		String resultString = "Name: " + heroName + "\nClass: " + heroClass + "\nHealth: " + currentHealth + "/" + maxHealth + "\nArmor: " + heroArmor + "\nBarter Skill: " + barterSkill + "\nFame: " + fame + "\nDeterrence: " + deterrence + "\n";
		return resultString;
	}
	
	
}