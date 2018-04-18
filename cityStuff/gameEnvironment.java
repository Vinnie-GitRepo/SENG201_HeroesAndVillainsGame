package cityStuff;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import teamStuff.Team;
import villianStuff.Villian;


public class gameEnvironment {
	
	public static ArrayList<Villian> villians = new ArrayList<Villian>();
	
	public static ArrayList<baseCamp> baseCamps = new ArrayList<baseCamp>(); 
	
	public static Team team;
	
	public Random rand = new Random();
	
	public static boolean cityBeat = false;
	
	
	//This is used at any point if all of your super heroes
	//have died it will exit the java application
	public void endGame() {
		System.out.println("You have lost MWAHAHAHA!");
		System.exit(0);
	}
	
	
	//cityBeat allows for the main programme to know whether
	//the city has been beat or if the heroes have died
	public void setCityBeat() {
		cityBeat = true;
	}
	
	
	//Adds to the array of baseCamps which contains each
	//camp within the game. Basecamps are in effect citys
	//as each city is centralized to a basecamp.
	public void addBaseCamp(Team team) {
		baseCamp Camp = new baseCamp(team);
		baseCamps.add(Camp);
	}
	
	
	//A likely uneeded function
	public void addBaseCamp() {
		baseCamp Camp = new baseCamp();
		baseCamps.add(Camp);
	}
	
	
	//This simply returns whatever the user has inputted.
	//Should be turned into a interface though possibly
	public int getPlayerChoice() {
		Scanner pos = new Scanner(System.in);
		return pos.nextInt();
	}
	
	
	//Allows for other classes to get the team in order
	//to edit or add
	public Team getTeam() {
		return team;
	}
	
	
	//This is used when finishing a city the team is returned
	//through the game and set to theTeam in order to move
	//into the next city
	public void setTeam(Team theTeam) {
		team = theTeam;
	} 
	
	
	//Generates each villian for each city and stores them within
	//villians an ArrayList<villian>
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
	
	
	
	public static void main(String[] args) {
		int num = 0;
		gameEnvironment game = new gameEnvironment();
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
			
			while (cityBeat == false) {
				game.addBaseCamp(team);															//i need to get the villian into that city
				baseCamps.get(i).viewMenu();
			}																					//something like if city is won baseCamps.get(i).finishCity();
			
			cityBeat = false;
			System.out.println("You have completed this city!");
			
		}
		System.out.println("WHAT THE FUCK CUNT HOW HAVE U GINISHED IT ALREADY WWUT>?");			//At this point they must have gone though each city, will make super villian happen now

	}

}
