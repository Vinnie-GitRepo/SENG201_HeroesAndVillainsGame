package games;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;//randomizer import
import teamStuff.*;
import villianStuff.*;

public class diceRollGame {
	/**
	 * 
	 * Gets the randomly generated roll from the hero
	 * 
	 * @return ThreadLocalRandom.current().nextInt(luckynum, 7)
	 */
	public int getHeroRoll(int luckynum) {
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
	public String calculateWinnerGui(int hero, int villian) {
		if (hero == villian) {
			return "Its A Draw, Roll Again";
		} else if (hero > villian) {
			return "You Have Won This Round!";
		} else {
			return "You Have Lost This Round";
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
