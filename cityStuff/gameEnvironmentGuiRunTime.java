package cityStuff;
import java.awt.Image;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;

import games.*;
import teamStuff.*;
import villianStuff.Villian;


public class gameEnvironmentGuiRunTime {
	
	public static boolean[] foundPlaces = {false, false, false, false};
	
	public static boolean hasMap = false;
	
	public static ArrayList<Villian> villians = new ArrayList<Villian>();
	
	public static ArrayList<shop> shops = new ArrayList<shop>();
	
	public static int currentHero;
	
	public static ArrayList<String> thisMap;
	
	public static shop currentShop;
	
	public static Villian currentVillian;
	
//	public static boolean hasCartographer;
	
	public static boolean luck = false;
	
	public void giveLuck() {
		luck = true;
	}
	
	
	public String randomEvent() {
		String theEvent ="Your Team Had A Safe Journey Back";
		Random happen = new Random();
		boolean event = happen.nextBoolean();
//		System.out.println(event);
		if (event) {
			int number = happen.nextInt(4);
//			System.out.println(number);
			switch(number) {
			case 0:
				theEvent = "Your Team Has Been Given An Item!";
				int itemNum = happen.nextInt(3);
				System.out.println(itemNum);
				team.addHealingItem(currentShop.getHealingItems().get(itemNum));
				break;
			case 1:
				theEvent = "Your Team Has Lost An Item!";
				try {
				team.getHealingItems().remove(happen.nextInt(team.getHealingItems().size()));//team.removeHealingItem(currentShop.getHealingItems().get(happen.nextInt(4)));//removeItem(currentShop.getHealingItems().get(happen.nextInt(4)));
				} catch (Exception e) {
					theEvent = "Someone Tried To Rob You But You Got Nothin!";
				}
				break;
			case 2:
				theEvent = "Your Team Has Been Given Some Money!";
				team.addMoney(100);
				break;
			case 3:
				theEvent = "Your Team Has Been Robbed Of Some Money!";
				team.addMoney(-50);
				break;
			}
		}
		return theEvent;
	}
	
	public boolean hasLuck() {
		return luck;
	}
	
//	public static boolean hasMerchant;
	
	public void giveMap() {
		hasMap = true;
	}
	
	public boolean hasMap() {
		return hasMap;
	}
	
	public void makeAllUnfound() {
		foundPlaces[0] = false;
		foundPlaces[1] = false;
		foundPlaces[2] = false;
		foundPlaces[3] = false;
	}
	
	public void makeAllFound() {
		foundPlaces[0] = true;
		foundPlaces[1] = true;
		foundPlaces[2] = true;
		foundPlaces[3] = true;
	}
	
	public void setFoundPlaceTrue(int num) {
		foundPlaces[num] = true;
	}
	
	public int getNumOfCities() {
		return baseCamps.size();
	}
	
	public String getMapPlace(int num, int city) {
//		System.out.println(num);
//		System.out.println(foundPlaces[num]);
		if (foundPlaces[num] == true) {
			return baseCamps.get(city).getMap().get(num);
		} else {
			//foundPlaces[num] = true;
			return "???";
		}
//		return "ga";
	}
	
	public ArrayList<String> getCurrentMap(int num){
		return baseCamps.get(num).getMap();
	}
	
	public boolean[] getFoundPlaces() {
		return foundPlaces;
	}
	
	public void setCurrentHero(int num) {
		currentHero = num;
	}
	
	
	public int getCurrentHero() {
		return currentHero;
	}
	
	public void setCurrentVillian(int num) {
		currentVillian = villians.get(num);
	}
	
	
	public Villian getCurrentVillian() {
		return currentVillian;
	}
	
	public void setCurrentShop(int num) {
		currentShop = shops.get(num);
	}
	
	
	public shop getCurrentShop() {
		return currentShop;
	}
	
	public ArrayList<baseCamp> baseCamps = new ArrayList<baseCamp>(); 
	
	public Team team;
	
	public Random rand = new Random();
	
	public boolean cityBeat = false;
	
	

	/**
	 * This can be called at any time if the team has lost.<br>
	 * It will simply tell the player that they have lost and exit the game
	 */
	public void endGame() {
		System.out.println("You have lost MWAHAHAHA!");
		System.exit(0);
	}
	
	
	
	
	/**
	 * cityBeat allows the main program to know whether.<br>
	 * the city has been beat or if the heroes have died
	 */
	public void setCityBeat() {
		cityBeat = true;
	}
	
	
	//Adds to the array of baseCamps which contains each
	//camp within the game. Basecamps are in effect citys
	//as each city is centralized to a basecamp.
	/**
	 * Adds to the array of baseCamps which contains each
	 * camp within the game. Basecamps are in effect citys
	 * as each city is centralized to a basecamp.
	 * 
	 */
	public void addBaseCamp(Team team) {
		baseCamp Camp = new baseCamp(team);
		baseCamps.add(Camp);
	}
	
	
	//A likely unneeded function
	public void addBaseCamp(ArrayList<String> map) {
		baseCamp Camp = new baseCamp(map);
		baseCamps.add(Camp);
		//baseCamp Camp = new baseCamp(this.generateLayout());
		//System.out.println("made new one");
		//baseCamps.add(Camp);
	}
	
	
	//This simply returns whatever the user has inputted.
	//Should be turned into a interface though possibly
	/**
	 * This simply returns whatever the user has inputted.
	 * Should be turned into a interface though possibly
	 * 
	 * @return pos.nextInt();
	 */
	public int getPlayerChoice() {
		Scanner pos = new Scanner(System.in);
		return pos.nextInt();
	}
	
	
	//Allows for other classes to get the team in order
	//to edit or add
	/**
	 * Allows for other classes to get the team in order
	 * to edit or add
	 */
	public Team getTeam() {
		return team;
	}
	
	
	public MerchantMan getMerchant() {
		MerchantMan info = new MerchantMan();
		return info;
	}
	
	public Tank getTank() {
		Tank info = new Tank();
		return info;
	}
	
	public Cartographer getCartographer() {
		Cartographer info = new Cartographer();
		return info;
	}
	
	public Support getSupport() {
		Support info = new Support();
		return info;
	}
	
	public LuckyBoii getLuckyBoii() {
		LuckyBoii info = new LuckyBoii();
		return info;
	}
	
	public EdgyScaryFiendLord getAntiHero() {
		EdgyScaryFiendLord info = new EdgyScaryFiendLord();
		return info;
	}
	
	
	public RestoreHealthI getRHI() {
		RestoreHealthI info = new RestoreHealthI();
		return info;
	}
	
	
	public RestoreHealthII getRHII() {
		RestoreHealthII info = new RestoreHealthII();
		return info;
	}
	
	
	public RestoreHealthIII getRHIII() {
		RestoreHealthIII info = new RestoreHealthIII();
		return info;
	}
	
	
	public AugmentVitalityI getAVI() {
		AugmentVitalityI info = new AugmentVitalityI();
		return info;
	}
	
	
	public AugmentVitalityII getAVII() {
		AugmentVitalityII info = new AugmentVitalityII();
		return info;
	}
	
	
	public AugmentVitalityIII getAVIII() {
		AugmentVitalityIII info = new AugmentVitalityIII();
		return info;
	}
	
	
	public IronFleshI getIFI() {
		IronFleshI info = new IronFleshI();
		return info;
	}
	
	
	public IronFleshII getIFII() {
		IronFleshII info = new IronFleshII();
		return info;
	}
	
	
	public IronFleshIII getIFIII() {
		IronFleshIII info = new IronFleshIII();
		return info;
	}
	
	
	public ArrayList<Hero> getHeroList() {
		return this.getTeam().getHeroArray();
	}
	
	//This is used when finishing a city the team is returned
	//through the game and set to theTeam in order to move
	//into the next city
	/**
	 * This is used when finishing a city the team is returned
	 * through the game and set to theTeam in order to move
	 * into the next city
	 */
	public void setTeam(Team theTeam) {
		team = theTeam;
	} 
	
	
	//Generates each villian for each city and stores them within
	//villians an ArrayList<villian>
	/**
	 * Generates each villian for each city and stores them within
	 * villians an ArrayList<villian>
	 */
	public void generateVillians(int num) {
		
		ArrayList<String> villianNames = new ArrayList<String>() 
		{{
		add("Villian NUMBER 1");
		add("Villian NUMBER 2");
		add("Villian NUMBER 3");
		add("Villian NUMBER 4");
		add("Villian NUMBER 5");
		add("Villian NUMBER 6");
		}};
		
		ArrayList<String> catchPhrase = new ArrayList<String>() 
		{{
		add("catchPhrase NUMBER 1");
		add("catchPhrase NUMBER 2");
		add("catchPhrase NUMBER 3");
		add("catchPhrase NUMBER 4");
		add("catchPhrase NUMBER 5");
		add("catchPhrase NUMBER 6");
		}};
		
		ArrayList<ImageIcon> villianIcons = new ArrayList<ImageIcon>() {{
			add(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/vill1.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
			add(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/vill2.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
			add(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/vill3.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
			add(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/vill4.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
			add(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/vill5.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
			add(new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/vill6.png")).getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT)));
		}};
		int numName;
		int numPhrase;	
		
		//Villian Generating Loop
		//Num is passed into it as it will only create as many
		//vilians as there is towns
		for (int i = 0; i < num; i++) {
			numName = rand.nextInt(villianNames.size());
			numPhrase = rand.nextInt(catchPhrase.size());
			boolean switchGame = false;
			
//			if (numName % 2 == 0) 
//			{
//				switchGame = true;
//			}
			Random thing = new Random();
			int changeNum = thing.nextInt(2);
			boolean changes = false;
//			if (changeNum == 1) {
//				changes = true;
//			}
			Villian baddy = new Villian(villianNames.get(numName), 
					catchPhrase.get(numPhrase), switchGame, villianIcons.get(i), changes);
			villians.add(baddy);
			villianNames.remove(numName);														//Makes sure that any names used get removed in order for there to be no double ups
			catchPhrase.remove(numPhrase);														//Makes sure that any catch phrases used get removed in order for there to be no double ups
			
			//TEST TO MAKE SURE IT IS RANDOMIZING
			//System.out.println(villians.get(i).getName()); 
			//System.out.println(villians.get(i).getTaunt());
		}
	}
	
	
	//DATA FOR GENERATING CITIES
	//public ArrayList<String> areas = new ArrayList<String>();
	
	
	
	//THE ACTUAL CITY GENERATOR
	/**
	 * This generates the city and how it will be laid out
	 * 
	 * @return areas
	 */
	public ArrayList<String> generateLayout() {
		ArrayList<String> options = new ArrayList<String>()
		{{add("Shop");
		add("Power Up Den");
		add("Hospital");
		add("Lair");
		}};
		
		String[] directions 	= 	{"North","East ","South","West "};
		ArrayList<String> areas = new ArrayList<String>();
		int size = options.size();
		int num;
		for (int i = size - 1; i != -1; i--) {
			num = rand.nextInt(i + 1);
			areas.add(options.get(num));
			options.remove(num);
		}
		return areas;
	}
	
	
	public int num_of_cities;
	
	public void setNumOfCities(int num) {
		num_of_cities = num;
	}
	
	
	
	public void setThingsUp(int num) {
		team = new Team();
		for (int i = 0; i < num; i++) {
			shop newShop = new shop();
			shops.add(newShop);
		}
	}
	
	/**
	 * Where the game is intialized and played
	 * 
	 * 
	 */
	public void main(String[] args) {
		int num = 0;
		gameEnvironmentGuiRunTime game = new gameEnvironmentGuiRunTime();
		team = new Team();
		System.out.println("Choose How Many Cities You Would Like To Save?");
		while ((num < 3) || (num > 6)) {
			System.out.println("Please Enter A Number Between 3 and 6:\n");
			try {
				num = game.getPlayerChoice();
				}
			catch(InputMismatchException e){
				};
		}
		
		game.generateVillians(num);																//Calls the villian generator passing in the num of cities

		System.out.println(team);																//Prints out the initial team showing stats
		
		for (int i = 0; i != num; i++) {														//THIS IS GENERATING HOW MANY CITIES THERE ARE
			//game.addBaseCamp();
			//System.out.println("added camp");
			//while (cityBeat == false) {
				//game.addBaseCamp(team);															//i need to get the villian into that city
				//baseCamps.get(i).viewMenu();
			//}																					//something like if city is won baseCamps.get(i).finishCity();
			
			//cityBeat = false;
			//System.out.println("You have completed this city!");
			
		}
		for (int i = 0; i < baseCamps.size(); i++) {//(baseCamp camp : baseCamps) {
			baseCamps.get(i).setTeam(team);//camp.setTeam(team);
			//System.out.println(villians.get(i).getTaunt());
			baseCamps.get(i).setVillian(villians.get(i));
			baseCamps.get(i).viewMenu();//camp.viewMenu();
			System.out.println("Finihed the city");
			cityBeat = false;
		}
		//super villian spot is here this will only be called if they finish each city
		System.out.println("WHAT THE FUCK CUNT HOW HAVE U GINISHED IT ALREADY WWUT>?");			//At this point they must have gone though each city, will make super villian happen now

	}

}
