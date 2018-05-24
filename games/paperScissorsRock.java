package games;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;//randomizer import
import teamStuff.*;
import villianStuff.*;

public class paperScissorsRock {
	
	public static String[] options = {"Paper","Scissors","Rock"};

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

	
	public String getVillianChoice(int num) {
		Random rand = new Random();
		return options[rand.nextInt(num)];
	}
	
	
	public static void main(String[] args) {

	}

}
