package games;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import teamStuff.*;
import cityStuff.*;

public class numberGuess {
	public static Team thisTeam;
	public static int attempts = 0;
	
	public static boolean finish = false;
	
	public int getHeroChoice() {
		System.out.println("Choose a number between 0 and 10");
		Scanner num = new Scanner(System.in);
		return num.nextInt();//Integer.parseInt(num.nextLine());
	}
	public void higherOrLower(int guess, int num) {
		if (guess > num) {
			System.out.println("Guess Lower");
		} else {
			System.out.println("Guess Higher");
		}
	}
	public int getPlayerChoice() {
		Scanner pos = new Scanner(System.in);
		return pos.nextInt();
	}
	public void gameSequence() {
		boolean continuePlaying = true;
		boolean selectChar = false;
		boolean lost = false;
		
		thisTeam.selectHero();
		
		int heroChoice = this.getPlayerChoice();
		
		Hero currentHero = thisTeam.heroArray.get(heroChoice);
		
		System.out.println("You Have Chosen To Play With " + currentHero.getName());
		
		while ((finish == false) || (continuePlaying == true)){
			attempts = 0;
			finish = false;
			if (selectChar) {
				thisTeam.selectHero();
				heroChoice = this.getPlayerChoice();
				currentHero = thisTeam.heroArray.get(heroChoice);
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
					}
				else 
				{
					attempts += 1;
					if (attempts == 3) {
						System.out.println("You have lost!");
						System.out.println(currentHero.getName() + " has taken 25 damage!");
						currentHero.damageHealth(25);
						System.out.println("The heroes health is currently " + currentHero.getCurrentHealth() + "/" +currentHero.getMaxHealth());
						if (currentHero.getCurrentHealth() <= 0 && thisTeam.heroArray.size() == 0) {
							//currentHero.deathHandling();
							choice = 0;
							//if (thisTeam.heroArray.size() == 0) {
								continuePlaying = false;
								finish = true;
								break;
							//}
						} else if (currentHero.getCurrentHealth() <= 0 && thisTeam.heroArray.size() > 0) {
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
	public static void playGame(Team team) {
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
