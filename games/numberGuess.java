package games;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import teamStuff.*;
import cityStuff.*;
import villianStuff.*;

public class numberGuess {
	public static Team thisTeam;
	public static int attempts = 0;
	public static Villian thisVillian;
	
	public static boolean finish = false;
	
	
	/**
	 * 
	 * Gets the players choice for their guess of the number
	 * 
	 * @return num.nextInt();
	 */
	public int getHeroChoice() {
		System.out.println("Choose a number between 0 and 10");
		Scanner num = new Scanner(System.in);
		return num.nextInt();//Integer.parseInt(num.nextLine());
	}
	
	/**
	 * 
	 * Calculates whether or not the player needs to guess higher or lower
	 * then prints out a statement letting them know
	 */
	public void higherOrLower(int guess, int num) {
		if (guess > num) {
			System.out.println("Guess Lower");
		} else {
			System.out.println("Guess Higher");
		}
	}
	
	public static String higherOrLowerGui(int guess, int num) {
		if (guess > num) {
			return "Guess Lower";
		} else {
			return "Guess Higher";
		}
	}
	
	/**
	 * 
	 * Gets the players choice for the menu option
	 * 
	 * @return pos.nextInt();
	 */
	public int getPlayerChoice() {
		Scanner pos = new Scanner(System.in);
		return pos.nextInt();
	}
	
	
	
	public static int getVillianChoice() {
		return ThreadLocalRandom.current().nextInt(1, 11);
	}
	
	public static int getVillianChoice(int num) {//for if we imlement luck
		
		return ThreadLocalRandom.current().nextInt(1, num);
	}
	/**
	 * 
	 * This is where the game actually runs calling other methods from numberGuess
	 * 
	 */
	public void gameSequence() {
		boolean continuePlaying = true;
		boolean selectChar = false;
		boolean lost = false;
		
		thisTeam.selectHero();
		
		int heroChoice = this.getPlayerChoice();
		
		Hero currentHero = thisTeam.getHeroArray().get(heroChoice);
		
		System.out.println("You Have Chosen To Play With " + currentHero.getName());
		
		while ((finish == false) || (continuePlaying == true)){
			attempts = 0;
			finish = false;
			if (selectChar) {
				thisTeam.selectHero();
				heroChoice = this.getPlayerChoice();
				currentHero = thisTeam.getHeroArray().get(heroChoice);
				System.out.println("You Have Chosen To Play With " + currentHero.getName());
				selectChar = false;}
			int villianNumber = ThreadLocalRandom.current().nextInt(1, 11);
		//System.out.println(villianNumber);
			while ((finish == false) && (attempts < 3)) {
				int num = this.getHeroChoice();
				int choice = 0;
				if (num == villianNumber) {
					attempts += 1;
					System.out.println("You guessed it in " + attempts + " attempts");
					finish = true;
					System.out.println("You Deal Damage To The Villian");
					thisVillian.oneDefeat();
					System.out.println("You have defeated the Villian " + thisVillian.getLossCount() + "/3 Times");
					System.out.println("Options:\n(0) Switch Character\n(1) Continue Playing\n(2) Flee From Lair");
					if (thisVillian.getLossCount() == 3) {
						continuePlaying = false;
						finish = true;
					} else {
					choice = this.getPlayerChoice();
					if (choice == 0) {
					continuePlaying = true;
					selectChar = true;
					break;
					} else if (choice == 1){
						continuePlaying = true;
					} else if (choice == 2) {
						continuePlaying = false;
						finish = true;
						break;
					}
					lost = false;}
					}
				else 
				{
					attempts += 1;
					if (attempts == 3) {
						System.out.println("You have lost!");
						System.out.println(currentHero.getName() + " has taken 25 damage!");
						currentHero.damageHealth(25);
						System.out.println("The heroes health is currently " + currentHero.getCurrentHealth() + "/" +currentHero.getMaxHealth());
						if (currentHero.getCurrentHealth() <= 0 && thisTeam.getHeroArray().size() == 0) {
							//currentHero.deathHandling();
							choice = 0;
							//if (thisTeam.heroArray.size() == 0) {
								continuePlaying = false;
								finish = true;
								break;
							//}
						} else if (currentHero.getCurrentHealth() <= 0 && thisTeam.getHeroArray().size() > 0) {
							boolean inputAccepted = false;
							System.out.println("Options:\n(0) Switch Character\n(1) Flee From Lair");
							choice = this.getPlayerChoice();
							while (choice != 0) {
								choice = this.getPlayerChoice();
								if (choice == 0 || choice == 1) {
									inputAccepted = true;
								} else {
									System.out.println("Please enter a valid input");
									choice = this.getPlayerChoice();
								}
								//System.out.println(choice);
								//System.out.println(choice + "is fucking right");
							}
						} else {
							//if there are still players
							System.out.println("Options:\n(0) Switch Character\n(1) Continue Playing\n(2) Flee From Lair");
							choice = this.getPlayerChoice();}
						if (choice == 0) {
							continuePlaying = true;
							selectChar = true;
							break;
						}
						else if (choice == 1){
							continuePlaying = true;
						} 
						else if (choice == 2) {
								continuePlaying = false;
							finish = true;
							break;
						}
					} else {
						this.higherOrLower(num, villianNumber);
					}
				}
			
			}
		}
	}
	
	
	/**
	 * 
	 * Initializes the game and passes in the team and villian
	 * 
	 * @param team
	 * @param vill
	 */
	public static void playGame(Team team, Villian vill) {
		thisVillian = vill;
		thisTeam = team;
		numberGuess game = new numberGuess();
		game.gameSequence();
	}
	
	
	public static void main(String[] args) {
		numberGuess game = new numberGuess();
		int villianNumber = ThreadLocalRandom.current().nextInt(1, 11);
		//System.out.println(villianNumber);
		while ((finish == false) && (attempts < 3)) {
			int num = game.getHeroChoice();
			if (num == villianNumber) {
				attempts += 1;
				System.out.println("You guessed it in " + attempts + " attempts");
				finish = true;
			} else {
				attempts += 1;
				if (attempts == 3) {
					System.out.println("You have lost!");
				} else {
				game.higherOrLower(num, villianNumber);
				}
			}
			
		}
	}

}
