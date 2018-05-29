package games;

import java.util.*;


/**
 * Class handling the outputs of the paperScissorsRock games played in the GUI.
 * 
 * @author cwe55, vjj14
 * 
 */
public class paperScissorsRock {
	
	
	
	/**
	 * An array of options available to both the hero and the villain.<br>
	 * The hero should select their choice while the villain's choice is random.
	 */
	private static String[] options = {"Paper","Scissors","Rock"};
	

	
	
	/**
	 * Processes the choices of both the villain and the hero, returning the outcome.
	 * 
	 * @param outcome      String
	 * @return to_return   String
	 */
	public String getOutCome(String outcome) {
		String to_return = "";
		switch(outcome) {
		case "PaperScissors" :
			to_return = "The Villian Has Won";
			break;
		case "PaperRock" :
			to_return = "You Have Won";
			break;
		case "ScissorsPaper" :
			to_return = "You Have Won";
			break;
		case "ScissorsRock" :
			to_return = "The Villian Has Won";
			break;
		case "RockScissors" :
			to_return = "You Have Won";
			break;
		case "RockPaper" :
			to_return = "The Villian Has Won";
			break;
		case "RockRock" :
			to_return = "It Is A Draw, Next Round!";
			break;
		case "PaperPaper" :
			to_return = "It Is A Draw, Next Round!";
			break;
		case "ScissorsScissors" :
			to_return = "It Is A Draw, Next Round!";
			break;
		}
		return to_return;
	}

	
	
	/**
	 * Randomly generates a choice for the villain.<br>
	 * Then returns this choice for comparison with the hero's choice.
	 * 
	 * @param num               int
	 * @return villainChoice    String
	 */
	public String getVillianChoice(int num) {
		Random rand = new Random();
		String villainChoice = options[rand.nextInt(num)];
		return villainChoice;
	}
	
}
