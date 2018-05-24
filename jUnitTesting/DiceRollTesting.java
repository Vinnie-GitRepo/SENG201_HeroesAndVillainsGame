package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import games.diceRollGame;


public class DiceRollTesting {

	
	
	@Test
	public void HeroDiceRollTest() {
		diceRollGame test = new diceRollGame();
		
		int test1 = test.getHeroRoll(1);
		int test2 = test.getHeroRoll(3);
		int test3 = test.getHeroRoll(6);
		
		assertTrue(test1 >= 1 && test3 <= 6);
		assertTrue(test2 >= 3 && test1 <= 6);
		assertTrue(test3 == 6);	
	}
	
	
	
	@Test
	public void VillainRollTest() {
		diceRollGame test = new diceRollGame();
		
		int villainRoll = test.getVillianRoll();
		assertTrue(villainRoll >= 1 && villainRoll <= 6);
	}
	
	
	
	@Test
	public void DiceRollOutcomeTest() {
		diceRollGame test = new diceRollGame();
		
		
		String test1 = test.calculateWinnerGui(0, 6);
		assertTrue(test1.equals("You Have Lost This Round"));
		
		
		String test2 = test.calculateWinnerGui(6, 0);
		assertTrue(test2.equals("You Have Won This Round!"));

		
		String test3 = test.calculateWinnerGui(3, 3);
		assertTrue(test3.equals("Its A Draw, Roll Again"));
	}

}
