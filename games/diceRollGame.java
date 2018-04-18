package games;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;//randomizer import
import teamStuff.*;

public class diceRollGame {
	public static Team thisTeam;
	public static int luckynum = 1;
	
	public static boolean finish = false;
	
	public int getHeroRoll() {
		return ThreadLocalRandom.current().nextInt(luckynum, 7);
	}
	public int getVillianRoll() {
		return ThreadLocalRandom.current().nextInt(1, 7);
	}
	public boolean calculateWinner(int hero, int villian) {
		if (hero == villian) {
			System.out.println("It is a draw, rolla again!");
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
			finish = false;
			if (selectChar) {
				thisTeam.selectHero();
				heroChoice = this.getPlayerChoice();
				currentHero = thisTeam.heroArray.get(heroChoice);
				System.out.println("You Have Chosen To Play With " + currentHero.getName());
				selectChar = false;}
		while (finish == false) {
			Integer hero = this.getHeroRoll();
			System.out.println("You have rolled a " + hero);
			Integer villian = this.getVillianRoll();
			System.out.println("The Villian has rolled a " + villian);
			lost = this.calculateWinner(hero, villian);
			int choice = 0;
			if (lost == true) {
				System.out.println("You have lost!");
				currentHero.damageHealth(25);
				System.out.println(currentHero.getName() + " has taken 25 damage!");
				System.out.println("The heroes health is currently " + currentHero.getCurrentHealth() + "/" +currentHero.getMaxHealth());
				if (currentHero.getCurrentHealth() <= 0) {
					currentHero.deathHandling();
					choice = 0;
					if (thisTeam.heroArray.size() == 0) {
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
			}
		}
		}//need to at this point go to baseCamp menu
	}
	public static void playGame(Team team) {
		diceRollGame game = new diceRollGame();
		thisTeam = team;
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
