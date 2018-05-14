package teamStuff;

import java.util.*;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;



public class Team {
	
	
	
	private static String teamName;
	private static ArrayList<Hero> heroArray = new ArrayList<Hero>();
	private static int teamSize;
	private String position = "Base";
	private int money = 100;
	private int fameSum;
	private int deterrenceSum;
	private int barterSkillSum;
	
	/**
	* An ArrayList where consumables are added and removed, which the displayInventory uses to sort inventory
	*/
	public static ArrayList<ConsumableItem> workingInventory = new ArrayList<ConsumableItem>();
		
	/**
	* A TreeSet which gets updated every time the workingInventory changes  
	*/
	public static TreeSet<String> displayInventory = new TreeSet<String>();

	
	
	
	
	
	public ArrayList<ConsumableItem> getInventory(){
		return workingInventory;
	}
	
	
	/**
	 * Constructor for the Team Class
	 */
	public Team() {

		chooseTeamSize();		// Determines the size of the heroArray of the team
		fillHeroArray();		// Lets you select and name heroes for your team
		nameTeam();				// Lets you name your team of heroes
		
		setBarterSkillSum();	//-------------------------------------
		setDeterrenceSum();		// Setters based on the heroes selected
		setFameSum();			//-------------------------------------
	}
	
	
	
	
	/**
	 * Has the player select a valid number of heroes to be in the team.
	 * 
	 * @return teamSize
	 */
	public int chooseTeamSize() {
		
		boolean done = false;
		while(done == false) {
			System.out.println("\nChoose how many heroes are on your team\n \nChoices:");
			System.out.println("(1) One Hero.");
			System.out.println("(2) Two Heroes.");
			System.out.println("(3) Three Heroes.");
			
			try {
				Scanner sizeChoice = new Scanner(System.in);
				int toAdd = sizeChoice.nextInt(); 

				if ((toAdd > 3) || (toAdd < 1)) {
					System.out.println("Your team may only contain 1, 2, or 3 heroes.");}
				else {
					teamSize += toAdd;
					done = true;}}
			
			catch(InputMismatchException e) {
				e.getCause();
				System.out.println("\nYour input is invalid. Please enter a valid number");}
		}
		return teamSize;
	}
	
	
	
	
	/**
	 *  Has the player select valid hero types for heroes they create, according to the size of the team.
	 */
	public void fillHeroArray() {
		for (int i = 0; i < teamSize; i++) {
			boolean correct = false;
			while (!correct) {
				System.out.println("\nWhat type of hero would you like to add to your team? \nEnter one of the following numbers:");
				System.out.println("(1) Merchant Class Hero.");
				System.out.println("(2) Tank Class Hero.");
				System.out.println("(3) Cartographer Class Hero.");
				System.out.println("(4) Support Class Hero.");
				System.out.println("(5) LuckyBoii Class Hero.");
				System.out.println("(6) Intimidating AntiHero Class Hero.");
				
				try {
					Scanner heroChoice = new Scanner(System.in);
					int choice = heroChoice.nextInt();
					
					if ((choice > 6) || (choice < 1)) {
						System.out.println("Your input is invalid. Please enter a valid number");} 
					else {
						correct = true ;
						this.selectHeroType(choice);}}
			    
				catch (InputMismatchException e) {
			    	e.getCause();
			    	System.out.println("Your input is invalid. Please enter a valid number");}
				
			}
			//correct = false;
		}
	}
	
	
	
	/**
	 *  Has the player name the team in accordance with the length restrictions.
	 */
	public void nameTeam() {
		
		System.out.println("Name your team of heroes.");
		Scanner teamNameChoice = new Scanner(System.in);
		String name = teamNameChoice.nextLine();
		
		if(name.length() < 2 || name.length() > 10) {
			System.out.println("The team name must be between 2 and 10 characters in length.");
			nameTeam();}
		else {
			Team.teamName = name;}
	}
	
	
	
	
	/**
	 * Checks if choice is valid;
	 * Creates a new hero of the selected type;
	 * Adds the hero to the heroArray of the team.
	 *  
	 * @param choice
	 */
	public void selectHeroType(int choice) {
			
		switch (choice) {
			// Merchant Hero is chosen.
			case 1:                  
				MerchantMan merchant = new MerchantMan();
				heroArray.add(merchant);
				break;
			
			// Tank Hero is chosen.
			case 2:                  
				Tank tank = new Tank();
				heroArray.add(tank);
				break;
			
			// Cartographer Hero is chosen.
			case 3:                  
				Cartographer cartographer = new Cartographer();
				heroArray.add(cartographer);
				break;
				
			// Support Hero is chosen.	
			case 4:                  
				Support support = new Support();
				heroArray.add(support);
				break;
				
			// LuckyBoii Hero is chosen.
			case 5:                  
				LuckyBoii lucky = new LuckyBoii();
				heroArray.add(lucky);
				break;
			
			// EdgyScaryFiendLord Hero is chosen.
			case 6:                  
				EdgyScaryFiendLord esfl = new EdgyScaryFiendLord(); 
				heroArray.add(esfl);
				break;
				
			// Else
			default:                 
				break;
		}
	}
	
	
	
	//------------------------------------------------
	//                   [INVENTORY]
	//------------------------------------------------
	/**
	* Refreshes the displayInventory when the workingInventory changes
	*/
	public static void refreshDisplayInventory() {
		displayInventory = new TreeSet<String>();    
		for(Consumable item : workingInventory) {
			int itemFrequency = Collections.frequency(workingInventory, item);
			displayInventory.add(item.getName() + " (" + itemFrequency + ")");
		} 
	}
		
		
		
	/**
	* Adds a consumable item to the workingInventory
	* Reshreshes displayInventory
	* @param item
	*/
	public void addItem(ConsumableItem item) {    
		workingInventory.add(item);
		refreshDisplayInventory();
	}
		
		
	/**
	* Removes a consumable item from the workingInventory
	* Refreshes displayInventory
	* @param item
	*/
	public static void removeItem(Consumable item) {
		workingInventory.remove(item);
		refreshDisplayInventory();
	}
		
	
	public void displayInventory() {
		//ArrayList<Consumable> items = new ArrayList<Consumable>();
		if (workingInventory.size() > 0) {
			/*for (Consumable item : workingInventory) {
				if (!items.contains(item)) {
					items.add(item);
				}
			}
			for (int i = 0; i < items.size(); i++) {
				int itemFrequency = Collections.frequency(workingInventory, items.get(i));
				System.out.println(items.get(i) + "(" + itemFrequency + ")"); 
			}*/
			for(String item : displayInventory) {
				System.out.println(item);
			}
			
		}
		else {
			System.out.println("You Have No Items Currently.");
		}
	}
	
	
	//------------------------------------------------
	//                   [GETTERS]
	//------------------------------------------------
	
	public int getMoney() {
		return money;
	}
	
	public static ArrayList<Hero> getHeroArray() {
		return heroArray;
	}
	
	public int getFameSum() {
		return fameSum;
	}
	
	public int getDeterrenceSum() {
		return deterrenceSum;
	}
	
	public int getBarterSkillSum() {
		return barterSkillSum;
	}
	
	
	
	
	//------------------------------------------------
	//                   [SETTERS]
	//------------------------------------------------
	
	public void setFameSum() {
		for(Hero hero : heroArray) {
			fameSum += hero.getFame();
		}
	}
	
	public void setDeterrenceSum() {
		for(Hero hero : heroArray) {
			deterrenceSum += hero.getDeterrence();
		}
	}
	
	public void setBarterSkillSum() {
		for(Hero hero : heroArray) {
			barterSkillSum += hero.getBarterSkill();
		}
	}
	
	
	
	
	//------------------------------------------------
	//                [BATTLE METHODS]
	//------------------------------------------------
	public void selectHero () {
		System.out.println("\nSelect a hero for battle!");
		for (int i = 0; i < heroArray.size(); i++) {
			System.out.println("("+ i + ") " + heroArray.get(i).getName());
		}
	}
	
	public static void removeHero(Hero hero) {
		heroArray.remove(hero);
	}
	
	public void addMoney(int amount) {
		money += amount;
	}
	
	
	
	
	
	public String toString() {
		String resultString = "\n\nHERO TEAM NAME: " + teamName 
				            + "\nMONEY: " + money 
				            + "\n-------------------------------------------\n\n";
		
		for(Hero hero: heroArray) {
			resultString += hero.toString() + "\n";
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