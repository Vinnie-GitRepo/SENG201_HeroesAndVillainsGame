package games;

import java.util.concurrent.ThreadLocalRandom;//randomizer import


/**
 * Class handling the outputs of the diceRoll games played in the GUI.
 * 
 * @author cwe55, vjj14
 *
 */
public class diceRollGame {
	
	
	
	/**
	 * Gets the randomly generated roll from the hero.
	 * 
	 * @return heroRoll      int
	 */
	public int getHeroRoll(int luckynum) {
		int heroRoll = ThreadLocalRandom.current().nextInt(luckynum, 7);
		return heroRoll;
	}
	
	
	
	/**
	 * Gets the randomly generated roll for the Villian.
	 * 
	 * @return villainRoll   int
	 */
	public int getVillianRoll() {
		int villainRoll = ThreadLocalRandom.current().nextInt(1, 7);
		return villainRoll;
	}
	
	
	
	/**
	 * 
	 * Calculates the winner of the round based on who has the highest
	 * 
	 * @param hero           int
	 * @param villian        int
	 * @return outcome       String
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



}


