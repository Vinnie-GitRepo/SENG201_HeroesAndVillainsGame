package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import games.numberGuess;

public class NumberGuessTesting {

	@Test
	public void higher() {
		numberGuess test = new numberGuess();
		String testString = test.higherOrLowerGui(5, 0);
		assertTrue(testString.equals("Guess Lower"));
		
		numberGuess test1 = new numberGuess();
		String testString1 = test1.higherOrLowerGui(3, 2);
		assertTrue(testString1.equals("Guess Lower"));
	}
	
	@Test
	public void lower() {
		numberGuess test = new numberGuess();
		String testString = test.higherOrLowerGui(0, 5);
		assertTrue(testString.equals("Guess Higher"));
		
		numberGuess test1 = new numberGuess();
		String testString1 = test1.higherOrLowerGui(2, 3);
		assertTrue(testString1.equals("Guess Higher"));
	}
	
	@Test
	public void randomVillianChoice() {
		numberGuess test = new numberGuess();
		int num = test.getVillianChoice(0);
		assertTrue(num >= 0 && num <= 10);
		
		numberGuess test1 = new numberGuess();
		int num1 = test1.getVillianChoice(5);
		assertTrue(num1 >= 5 && num1 <= 10);
	}

}
