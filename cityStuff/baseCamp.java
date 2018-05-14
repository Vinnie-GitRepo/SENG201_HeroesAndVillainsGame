package cityStuff;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import teamStuff.*;
import villianStuff.*;


public class baseCamp extends gameEnvironment implements menu {
	
	//public Random random = new Random();
	
	//public static String[] RandomEvents = {"Paper","Scissors","Rock"};
	
	/**
	 * Item shop created for a city. 
	 * Refreshes shop inventory and may change location when the city changes.
	 */
	public static shop shopMap = new shop();
	
	/**
	 * Villain lair created for a city.
	 * Changes villain, and may change location when the city changes. 
	 */
	public static lair lairMap = new lair();
	
	/**
	 * Hospital created for a city.
	 * May change location when the city changes.
	 */
	public static hospital hospitalMap = new hospital();
	
	/**
	 * Power Up Den created for a city.
	 * May change location when the city changes.
	 */
	public static powerUpDen PowerUpDenMap = new powerUpDen();
	
	/**
	 * Stores the team's state of location discovery for a city.
	 * Resets to false when entering a new city.
	 */
	public static ArrayList<Boolean> foundPlace = new ArrayList<Boolean>() 
	{{
	add(false);
	add(false);
	add(false);
	add(false);
	}};
	
	/**
	 * A list of areas that are set according to a map made through random numbers. 
	 */
	public ArrayList<String> areas = new ArrayList<String>();
	
	public ArrayList<String> getMap(){
		return areas;
	}
	
	/**
	 * A list of options available to the player.
	 */
	public ArrayList<String> options = new ArrayList<String>()
	{{add("Shop");
	add("PowerUpDen");
	add("Hospital");
	add("Lair");
	}};
	
	/**
	 * An array of directions relative to the base camp that the team may travel from.  
	 */
	public String[] directions 	= 	{"North","East ","South","West "};
	
	/**
	 * An array of options available to the team when located at the base camp.
	 */
	public String[] menu 		= 	{"View Stats", "View Map", "View Inventory", "Exit Game"};
	
	/**
	 * 
	 */
	public Team thisTeam;
	public Villian thisVillian;
	public Random rand;
	
	
	//The initializer to a basecamp. This creates a layout for the
	//city and saves it in the gameEnvironment
	/**
	 * Allows for classes which inherit methods to access the Villian from this city
	 * 
	 * @return thisVillian
	 */
	public Villian getVillian() {
		return thisVillian;
	}
	
	
	/**
	 * This passes the given team into the current city. 
	 * Allows for the retention of the team's status from previous cities
	 * 
	 * @param team
	 */
	public baseCamp(Team team) {
		thisTeam = team;
		rand = new Random();
		this.generateLayout();
	}
	
	
	//Another initializer which is no longer used
	//this is now used again in the latest update
	/**
	 * Initialises the basecamp without using team 
	 */
	public baseCamp() {
		rand = new Random();
		//System.out.println("ples"); got to here
		this.generateLayout();
	}
	
	
	//final intializer
	/**
	 * This sets up the city with the map/layout which has been generated in the game environment
	 * 
	 * @param map
	 */
	public baseCamp(ArrayList map) {
		areas = map;
	}
	
	
	/**
	 * This sets up the city with Villian that was generated in the game environment
	 * it also will pass that Villian into the "lairMap"
	 * 
	 * @param vill
	 */
	public void setVillian(Villian vill) {
		thisVillian = vill;
		lairMap.setVillian(vill);
		//System.out.println(thisVillian.getTaunt());
	}
	//final intializer2.0
	/*public baseCamp(ArrayList map, Villian vill) {
			areas = map;
			thisVillian = vill;
	}*/

	//A method we though we'd need but definitely done
	public void enter() {
	}
	
	
	//This calls the game to exit from the basecamp menu
	//should make this method give the option of saving if 
	//we can work that out
	/**
	 * Used at any point to exit the game completly
	 * 
	 */
	public void exitGame() {
		System.out.println("Thank you for playing");
		System.exit(0);
	}
	
	
	//Operates the menu choice as the menu is specific in each section
	/**
	 * Used for the command line only this method will hand the menu choice 
	 * 
	 * @param choice
	 */
	public void operateMenuChoice(int choice) {
		switch(choice) 
		{
		case 0 :
			this.viewStats();//System.out.println("this.viewStats()");
			break;
		case 1 : 
			this.viewMap();
			break;
		case 2 :
			thisTeam.displayInventory();
			this.viewMenu();
			break;
		case 3 :
			this.exitGame();
			break;
		case 4 ://this is needed to be taken out
			this.finishCity();
			break;
		case 5 ://another developer ,method
			team.addMoney(400);
			break;
		default:
			System.out.println("This Is Not An Availablie Option\nPlease Select An Option");
			this.viewMenu();
			break;
		}
	}
	
	
	/**
	 * Inherited from the Team class this method will show the user team stats, only used in the command line
	 * Prints all the team's stats
	 */
	public void viewStats() {
		System.out.println(thisTeam);
		System.out.println("(0) Back To Menu");
		int choice = this.getPlayerChoice();
		while (choice != 0) {
			System.out.println("Please Select A Valid Choice.");
			choice = this.getPlayerChoice();
		}
		this.viewMenu();
	}
	
	
	//Sends the team out
	/**
	 * This will send the team back to the game environment allowing for it to be passed into the next city/baseCamp
	 * 
	 * @return thisTeam
	 */
	public Team getTeam() {
		return thisTeam;
	}
	
	
	//sets the team
	/**
	 * This will set the team which is in the game environment to be the team now being used in this city
	 * 
	 * @param team
	 */
	public void setTeam(Team team) {
		thisTeam = team;
	}
	
	//This is the menu generator in other sections has been hard coded
	/**
	 * A simple menu generator showing all the available options from within the basecamp
	 * 
	 *
	 */
	public void viewMenu() {
		
		System.out.println("Menu Options:");
		
		for (int i = 0; i < menu.length; i++) {
			System.out.println("(" + i + ") " + menu[i] );
		}
		boolean accepted = false;
		while (accepted == false) {
			System.out.println("Please Select An Option");
			try {
				int choice = this.getPlayerChoice();
				this.operateMenuChoice(choice);
				accepted = true;
			}
			catch(InputMismatchException e) {
				System.out.println("This Is Not An Available Option");
			}
			}
	}
	
	
	//This is the map showing where each thing is, at some point
	//need to make an if statement which works only if you have the map class
	//or purchased a map.
	/**
	 * This method will obtain the map with all the known locations
	 * If the map item is purchased it will allow for all areas to be known
	 * If the MAPPERSON class is within the team it will allow for all areas to be known
	 * 
	 */
	public void viewMap() {
		
		System.out.println("\nMap\n-------------");
		
		for (int i = 0; i < areas.size(); i++) {
			System.out.println("(" + i + ") " + directions[i] + " - " + areas.get(i));//this is only used for testing real coe is below
			/*if (foundPlace.get(i) == false) {
				System.out.println("(" + i + ") " + directions[i] + " - ???");
			} else {
				System.out.println("(" + i + ") " + directions[i] + " - " + areas.get(i));
			}*/
		}
		
		System.out.println("-------------\nChoices\n(0) Move Player\n(1) Exit Map");
		
		int choice = this.getPlayerChoice();
		
		if (choice == 0) {
			System.out.println("\nWhere would you like to move to (0 - 3):\n");
			int pos = this.getPlayerChoice();
			this.movePlayer(pos);
		} 
		else if (choice == 1) 
		{
			this.exit();
		}
		else 
		{
			System.out.println("Please Select A Valid Input");
			this.viewMap();
		}
		
	}
	
	
	//If at any point the menu has been exited it will take you
	//to the main menu
	/**
	 * This method is used to exit out of the menu item you are currently in
	 * and take you back to the main menu
	 * - Command Line
	 * 
	 */
	public void exit() {
		this.viewMenu();
	}
	
	
	//This is the layout generator which randomizes each city
	/*public void generateLayout() {
		
		int size = options.size();
		int num;
		
		for (int i = size - 1; i != -1; i--) {
			num = rand.nextInt(i + 1);
			areas.add(options.get(num));
			options.remove(num);
		}
	}*/
	
	
	/**
	 * This operates from the map allowing the team to move into the next area
	 * 
	 * @param pos
	 */
	public void movePlayer(int pos) {
		
		if (pos >= areas.size()) {
			System.out.println("Please Input A Valid Choice");
			this.viewMap();
		}
		else 
		{
		String direction = directions[pos];
		String area = areas.get(pos);
		foundPlace.set(pos, true);
		Random random = new Random();
		System.out.println("You have chosen to move " + direction + " into the " + area);
		int RandNum;
		switch(area) {
		case "Shop" :
			shopMap.setTeam(thisTeam);
			shopMap.viewMenu();
			RandNum = random.nextInt(2);
			if (RandNum == 0) {
				//System.out.println("You etting robbed or given something bitch!");
				int eventNumber = new Random().nextInt(4);
				switch(eventNumber){
				case 0:
					System.out.println("YOu are given SOmething dop");
					// [TODO Tell user what item was gifted]
					break;
				case 1:
					System.out.println("You got some cash mullah");
					// [TODO Tell user how much money was gifted]
					break;
				case 2:
					System.out.println("Bugger, you got robbed, they stole your money");
					// [TODO Tell user how much money was stolen]
					break;
				case 3:
					System.out.println("Damn u lost an item");
					// [TODO Tell user what item was lost/stolen]
					break;
				}
			}
			//System.out.println(RandNum);
			this.viewMenu();
			break;
		case "PowerUpDen" :
			PowerUpDenMap.viewMenu();
			RandNum = random.nextInt(2);
			if (RandNum == 0) {
				//System.out.println("You etting robbed or given something bitch!");
				int eventNumber = new Random().nextInt(4);
				switch(eventNumber){
				case 0:
					System.out.println("YOu are given SOmething dop");
					break;
				case 1:
					System.out.println("You got some cash mullah");
					break;
				case 2:
					System.out.println("Bugger, you got robbed, they stole your money");
					break;
				case 3:
					System.out.println("Damn u lost an item");
					break;
				}
			}
			//System.out.println(RandNum);
			this.viewMenu();
			break;
		case "Hospital" :
			hospitalMap.setTeam(thisTeam);
			hospitalMap.viewMenu();
			RandNum = random.nextInt(2);
			if (RandNum == 0) {
				//System.out.println("You etting robbed or given something bitch!");
				int eventNumber = new Random().nextInt(4);
				switch(eventNumber){
				case 0:
					System.out.println("YOu are given SOmething dop");
					break;
				case 1:
					System.out.println("You got some cash mullah");
					break;
				case 2:
					System.out.println("Bugger, you got robbed, they stole your money");
					break;
				case 3:
					System.out.println("Damn u lost an item");
					break;
				}
			}
			//System.out.println(RandNum);
			this.viewMenu();
			break;
		case "Lair" :
			lairMap.setTeam(thisTeam);
			lairMap.viewMenu();
			System.out.println("HE finishes");
			//if the teamarray still has people and the cities villian is dead then super.setCityBeat();
			/*if (thisTeam.heroArray.get(0).getCurrentHealth() <= 0) {//should be like if there are sill people in it
				super.setCityBeat();
				System.out.println("THis cit is beat");
			}*/
			if (thisTeam.getHeroArray().size() == 0) {
				super.endGame();// if there are no people in the team then you have lost the game
			}
			if (thisVillian.getLossCount() == 3) {
				super.setCityBeat();
			}
			if (super.cityBeat == false) {//this here will be like well obviously you have left the lair like a pussy
				this.viewMenu();
			} else {
				this.finishCity();
			}
			break;
		default:
			System.out.println("Please Input A Valid Selection");
			this.viewMap();
			break;
		}
		}
		
	}
	/**
	 * This method finishes the city but will only be called once the Villian has lost 3 times
	 * 
	 */
	public void finishCity() {
		super.setTeam(thisTeam);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//baseCamp base = new baseCamp();
		//base.viewMenu();
	}

}
