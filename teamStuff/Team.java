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
	 * Determines the size of the heroArray, which is between 1 and 3 Heroes in length
	 */
	private int teamSize;
	
	
	
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
	* An ArrayList where consumables are added and removed, which the displayInventory uses to sort inventory
	*/
	public static ArrayList<ConsumableItem> workingInventory = new ArrayList<ConsumableItem>();
	
	
	
	/**
	* A TreeSet used to display the workingInventory which gets updated every time the workingInventory changes  
	*/
	public static TreeSet<String> displayInventory = new TreeSet<String>();
	
	
	
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

	
	
	public String viewInventory() {
		String words = "HEALING ITEMS\n";
		for (HealingItem item : healingItems) {
			words = words + item.getHealingItemName() + "\n";
		}
		words = words + "\nPOWER UP ITEMS\n";
		for (PowerUp item : powerUps) {
			words = words + item.getPowerUpName() + "\n";
		}
		return words;
	}
	
	
	/**
	 * Constructor for the Team Class
	 */
	public Team() {

		//chooseTeamSize();		// Determines the size of the heroArray of the team
		//fillHeroArray();		// Lets you select and name heroes for your team
		//nameTeam();				// Lets you name your team of heroes
		
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
	 * Has the player name the team in accordance with the length restrictions.
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
	 * Checks if choice input is valid.<br>
	 * Creates a new hero of the selected type.<br>
	 * Adds the hero to the heroArray of the team.<br>
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
	 * Adds a HealingItem to the healingItems list.
	 * @param healingItem
	 */
	public void addHealingItem(HealingItem healingItem) {
		healingItems.add(healingItem);
	}
	
	
	
	/**
	 * Removes a HealingItem from the healingItems list. 
	 * @param healingItem
	 */
	public static void removeHealingItem(HealingItem healingItem) {
		healingItems.remove(healingItem);
	}
	
	
	
	/**
	 * Returns healingItems list. 
	 * @return healingItems
	 */
	public ArrayList<HealingItem> getHealingItems() {
		return healingItems;
	}
	
	
	
	/**
	 * Adds a PowerUp to the powerUps list.
	 * @param powerUp
	 */
	public void addPowerUp(PowerUp powerUp) {
		powerUps.add(powerUp);
	}
	
	
	
	/**
	 * Removes a PowerUp from the powerUps list.
	 * @param powerUp
	 */
	public static void removePowerUp(PowerUp powerUp) {
		powerUps.remove(powerUp);
	}
	
	
	
	/**
	 * Returns the powerUps list
	 * @return powerUps
	 */
	public ArrayList<PowerUp> getPowerUps() {
		return powerUps;
	}
	
	
		
	/**
	* Adds a consumable item to the workingInventory
	* Reshreshes displayInventory
	* 
	* @param item			The Consumable being added
	*/
	public void addItem(ConsumableItem item) {    
		workingInventory.add(item);
		refreshDisplayInventory();
	}
		
		
	
	/**
	* Removes a consumable item from the workingInventory
	* Refreshes displayInventory
	* 
	* @param item
	*/
	public void removeItem(Consumable item) {
		workingInventory.remove(item);
		refreshDisplayInventory();
	}
		
	
	
	/**
	 * Accesses the team's inventory and lists each item type along with its frequency 
	 */
	public void displayInventory() {
		//ArrayList<Consumable> items = new ArrayList<Consumable>();
		String stuff = "";
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
				//System.out.println(item);
				stuff = stuff + item.toString() + "\n";
			}
			
		}
		else {
			System.out.println("You Have No Items Currently.");
		}
	}
	
	
	//------------------------------------------------
	//                   [GETTERS]
	//------------------------------------------------
	
	/**
	 * @return teamName
	 */
	public String getName() {
		return teamName;
	}
	
	
	
	/**
	 * @return money 
	 */
	public int getMoney() {
		return money;
	}
	
	
	
	/**
	 * @return heroArray
	 */
	public static ArrayList<Hero> getHeroArray() {
		return heroArray;
	}
	
	
	
	/**
	 * @return fameSum
	 */
	public int getFameSum() {
		return fameSum;
	}
	
	
	
	/**
	 * @return deterrenceSum
	 */
	public int getDeterrenceSum() {
		return deterrenceSum;
	}
	
	
	
	/**
	 * @return barterSkillSum
	 */
	public int getBarterSkillSum() {
		return barterSkillSum;
	}
	
	
	
	/**
	 * @return workingInventory
	 */
	public ArrayList<ConsumableItem> getInventory(){
		return workingInventory;
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
	 * @param name
	 */
	public void nameTeam(String name) {
		teamName = name;
	}
	
	
	
	/**
	 * Adds a hero to the team's heroArray.
	 * @param hero
	 */
	public void addHero(Hero hero) {
		heroArray.add(hero);
	}
	
	//------------------------------------------------
	//                [BATTLE METHODS]
	//------------------------------------------------
	
	
	/**
	 * Prints out a list of heroes available to battle the villain.
	 * 					[Command Line Code]
	 */
	public void selectHero () {
		System.out.println("\nSelect a hero for battle!");
		for (int i = 0; i < heroArray.size(); i++) {
			System.out.println("("+ i + ") " + heroArray.get(i).getName());
		}
	}
	
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