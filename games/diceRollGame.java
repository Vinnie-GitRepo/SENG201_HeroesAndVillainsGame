package games;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;//randomizer import
import teamStuff.*;
import villianStuff.*;

public class diceRollGame {
	public static Team thisTeam;
	public static int luckynum = 1;
	public static Villian thisVillian;
	
	public static boolean finish = false;
	
	/**
	 * 
	 * Gets the randomly generated roll from the hero
	 * 
	 * @return ThreadLocalRandom.current().nextInt(luckynum, 7)
	 */
	public int getHeroRoll() {
		return ThreadLocalRandom.current().nextInt(luckynum, 7);
	}
	
	/**
	 * 
	 * Gets the randomly generated roll for the Villian
	 * 
	 * @return ThreadLocalRandom.current().nextInt(1, 7)
	 */
	public int getVillianRoll() {
		return ThreadLocalRandom.current().nextInt(1, 7);
	}
	
	/**
	 * 
	 * Calculated the winner of the round
	 * 
	 * @param hero
	 * @param villian
	 * @return true or false
	 */
	public boolean calculateWinner(int hero, int villian) {
		if (hero == villian) {
			System.out.println("It is a draw, roll again!");
			return false;
		} else if (hero > villian) {
			System.out.println("You have won!");
			finish = true;
			return false;
		} else {
			//System.out.println("You have lost you fucking loser!");
			finish = true;
			return true;
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
	
	
	/**
	 * 
	 * This is where the main game happens
	 * it will loop between each of the game operators
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
			finish = false;
			if (selectChar) {
				thisTeam.selectHero();
				heroChoice = this.getPlayerChoice();
				currentHero = thisTeam.getHeroArray().get(heroChoice);
				System.out.println("You Have Chosen To Play With " + currentHero.getName());
				selectChar = false;}
		while (finish == false) {
			Integer hero = this.getHeroRoll();
			System.out.println("You have rolled a " + hero);
			Integer villian = this.getVillianRoll();
			System.out.println("The Villian has rolled a " + villian);
			lost = this.calculateWinner(hero, villian);
			//System.out.println(lost);
			int choice = 0;
			if (lost == true) {
				System.out.println("You have lost!");
				currentHero.damageHealth(25);
				System.out.println(currentHero.getName() + " has taken 25 damage!");
				System.out.println("The heroes health is currently " + currentHero.getCurrentHealth() + "/" +currentHero.getMaxHealth());
				if (currentHero.getCurrentHealth() <= 0) {
					currentHero.deathHandling();
					choice = 0;
					if (thisTeam.getHeroArray().size() == 0) {
						continuePlaying = false;
						finish = true;
						break;
					}
				} else {
				//if there are still players
				System.out.println("Options:\n(0) Switch Character\n(1) Continue Playing\n(2) Flee From Lair");
				choice = this.getPlayerChoice();}
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
				lost = false;
			} else {
				System.out.println("You Deal Damage Towards The Villian");
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
		}
		}//need to at this point go to baseCamp menu
	}
	
	
	/**
	 * Initializes the game
	 * 
	 * @param team
	 * @param vill
	 */
	public static void playGame(Team team, Villian vill) {
		diceRollGame game = new diceRollGame();
		thisTeam = team;
		thisVillian = vill;
		System.out.println("Villian Taunts: " + thisVillian.getTaunt());
		game.gameSequence();
		System.out.println("The game ended");
	}
	
	
	
	/*public static void startGame() {
		diceRollGame game = new diceRollGame();
		while (finish == false) {
			Integer hero = game.getHeroRoll();
			System.out.println("You have rolled a " + hero);
			Integer villian = game.getVillianRoll();
			System.out.println("The Villian has rolled a " + villian);
			game.calculateWinner(hero, villian);
		}
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
