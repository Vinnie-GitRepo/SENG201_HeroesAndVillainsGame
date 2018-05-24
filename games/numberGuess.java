package games;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import teamStuff.*;
import cityStuff.*;
import villianStuff.*;

public class numberGuess {
	
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
	
	
	
	public String higherOrLowerGui(int guess, int num) {
		if (guess > num) {
			return "Guess Lower";
		} else {
			return "Guess Higher";
		}
	}
	


	public int getVillianChoice(int luckynum) {
		return ThreadLocalRandom.current().nextInt(5, 11);
	}
	

	

	public static void main(String[] args) {
		
	}

}
