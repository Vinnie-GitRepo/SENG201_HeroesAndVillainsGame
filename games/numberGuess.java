package games;

import java.util.concurrent.ThreadLocalRandom;


/**
 * Class handling the outputs of the numberGuess games played in the GUI.
 * 
 * @author cwe55, vjj14
 *
 */
public class numberGuess {
	
	

	
	/**
	 * Returns a hint telling the hero if their guess is lower or higher than the villain's choice.
	 * 
	 * @param guess                                 int
	 * @param num                                   int
	 * @return "Guess Lower" or "Guess Higher"      String
	 */
	public String higherOrLowerGui(int guess, int num) {
		if (guess > num) {
			return "Guess Lower";} 
		else {
			return "Guess Higher";}
	}
	

	/**
	 * Getter for the villain's choice of number.<br>
	 * This number will be what the heroes must guess correctly.
	 * 
	 * @param luckynum           int
	 * @return villainChoice     int
	 */
	public int getVillianChoice(int luckynum) {
		int villainChoice = ThreadLocalRandom.current().nextInt(5, 11);
		return villainChoice;
	}

}
