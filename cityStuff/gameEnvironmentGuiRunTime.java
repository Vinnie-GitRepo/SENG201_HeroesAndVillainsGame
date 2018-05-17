package cityStuff;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import games.*;
import teamStuff.*;
import villianStuff.Villian;


public class gameEnvironmentGuiRunTime {
	
	
	
	public ArrayList<Villian> villians = new ArrayList<Villian>();
	
	public int currentHero;
	
	public Villian currentVillian;
	
	public ArrayList<String> getCurrentMap(int num){
		return baseCamps.get(num).getMap();
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
	
	public ArrayList<baseCamp> baseCamps = new ArrayList<baseCamp>(); 
	
	public Team team;
	
	public Random rand = new Random();
	
	public boolean cityBeat = false;
	
	
	//This is used at any point if all of your super heroes
	//have died it will exit the java application
	/**
	 * This can be called at any time if the team has lost
	 * it will simply tell the player that they have lost and exit the game
	 * 
	 */
	public void endGame() {
		System.out.println("You have lost MWAHAHAHA!");
		System.exit(0);
	}
	
	
	
	
	//cityBeat allows for the main programme to know whether
	//the city has been beat or if the heroes have died
	/**
	 * cityBeat allows for the main programme to know whether
	 * the city has been beat or if the heroes have died
	 * 
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

		int numName;
		int numPhrase;	
		
		//Villian Generating Loop
		//Num is passed into it as it will only create as many
		//vilians as there is towns
		for (int i = 0; i < num; i++) {
			numName = rand.nextInt(villianNames.size());
			numPhrase = rand.nextInt(catchPhrase.size());
			boolean switchGame = false;
			
			if (numName % 2 == 0) 
			{
				switchGame = true;
			}
			
			Villian baddy = new Villian(villianNames.get(numName), 
					catchPhrase.get(numPhrase), switchGame);
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
		add("PowerUpDen");
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
