package cityStuff;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import teamStuff.*;

public class baseCamp extends gameEnvironment implements menu {
	
	public ArrayList<String> areas = new ArrayList<String>();
	
	public static ArrayList<Boolean> foundPlace = new ArrayList<Boolean>() 
	{{
	add(false);
	add(false);
	add(false);
	add(false);
	}};
	
	public ArrayList<String> options = new ArrayList<String>()
	{{add("Shop");
	add("PowerUpDen");
	add("Hospital");
	add("Lair");
	}};
	
	public String[] directions 	= 	{"North","East ","South","West "};
	public String[] menu 		= 	{"View Stats", "View Map", "Exit Game"};
	public Team thisTeam;
	public Random rand;
	
	
	//The initializer to a basecamp. This creates a layout for the
	//city and saves it in the gameEnvironment
	public baseCamp(Team team) {
		thisTeam = team;
		rand = new Random();
		this.generateLayout();
	}
	
	
	//Another initializer which is no longer used
	public baseCamp() {
		rand = new Random();
		this.generateLayout();
	}
	
	
	//A method we though we'd need but definitely done
	public void enter() {
	}
	
	
	//This calls the game to exit from the basecamp menu
	//should make this method give the option of saving if 
	//we can work that out
	public void exitGame() {
		System.out.println("Thank you for playing");
		System.exit(0);
	}
	
	
	//Operates the menu choice as the menu is specific in each section
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
			this.exitGame();
			break;
		case 3 ://this is needed to be taken out
			this.finishCity();
			break;
		case 4 ://another developer ,method
			team.addMoney(400);
			break;
		default:
			System.out.println("Input is invalid");
			this.viewMenu();
			break;
		}
	}
	
	
	//This will print out all the stats of the team
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
	
	
	//This is the menu generator in other sections has been hard coded
	public void viewMenu() {
		
		System.out.println("Menu Options:");
		
		for (int i = 0; i < menu.length; i++) {
			System.out.println("(" + i + ") " + menu[i] );
		}
		int choice = this.getPlayerChoice();
		this.operateMenuChoice(choice);
	}
	
	
	//This is the map showing where each thing is, at some point
	//need to make an if statement which works only if you have the map class
	//or purchased a map.
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
	public void exit() {
		this.viewMenu();
	}
	
	
	//This is the layout generator which randomizes each city
	public void generateLayout() {
		
		int size = options.size();
		int num;
		
		for (int i = size - 1; i != -1; i--) {
			num = rand.nextInt(i + 1);
			areas.add(options.get(num));
			options.remove(num);
		}
	}
	
	
	
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
		System.out.println("You have chosen to move " + direction + " into the " + area);
		switch(area) {
		case "Shop" :
			shop shopMap = new shop();
			shopMap.viewMenu();
			break;
		case "PowerUpDen" :
			powerUpDen PowerUpDenMap = new powerUpDen();
			PowerUpDenMap.viewMenu();
			break;
		case "Hospital" :
			hospital hospitalMap = new hospital();
			hospitalMap.viewMenu();
			break;
		case "Lair" :
			lair lairMap = new lair();
			lairMap.viewMenu();
			System.out.println("HE finishes");
			//if the teamarray still has people and the cities villian is dead then super.setCityBeat();
			/*if (thisTeam.heroArray.get(0).getCurrentHealth() <= 0) {//should be like if there are sill people in it
				super.setCityBeat();
				System.out.println("THis cit is beat");
			}*/
			if (thisTeam.heroArray.size() == 0) {
				super.endGame();// if there are no people in the team then you have lost the game
			}
			if (super.cityBeat == false) {//this here will be like well obviously you have left the lair like a pussy
				this.viewMenu();
			} 
			break;
		default:
			System.out.println("Please Input A Valid Selection");
			this.viewMap();
			break;
		}
		}
		
	}
	public void finishCity() {
		super.setTeam(thisTeam);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//baseCamp base = new baseCamp();
		//base.viewMenu();
	}

}
