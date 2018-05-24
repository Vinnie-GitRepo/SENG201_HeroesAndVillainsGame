package games;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import teamStuff.*;
import cityStuff.*;
import villianStuff.*;

public class numberGuess {
	
	
	public String higherOrLowerGui(int guess, int num) {
		if (guess > num) {
			return "Guess Lower";
		} else {
			return "Guess Higher";
		}
	}
	


	public int getVillianChoice(int luckynum) {
		return ThreadLocalRandom.current().nextInt(luckynum, 11);
	}
	

	

	public static void main(String[] args) {
		
	}

}
