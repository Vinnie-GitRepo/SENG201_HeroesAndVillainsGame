package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import games.paperScissorsRock;

public class PaperScissorsRockTesting {

	@Test
	public void heroWon() {
		paperScissorsRock test1 = new paperScissorsRock();
		paperScissorsRock test2 = new paperScissorsRock();
		paperScissorsRock test3 = new paperScissorsRock();
		
		assertTrue(test1.getOutCome("PaperRock").equals("You Have Won"));
		assertTrue(test2.getOutCome("ScissorsPaper").equals("You Have Won"));
		assertTrue(test3.getOutCome("RockScissors").equals("You Have Won"));
		
		
	}
	
	public void heroLost() {
		paperScissorsRock test1 = new paperScissorsRock();
		paperScissorsRock test2 = new paperScissorsRock();
		paperScissorsRock test3 = new paperScissorsRock();
		assertTrue(test1.getOutCome("PaperScissors").equals("The Villian Has Won"));
		assertTrue(test2.getOutCome("ScissorsRock").equals("The Villian Has Won"));
		assertTrue(test3.getOutCome("RockPaper").equals("The Villian Has Won"));
		
	}
	
	public void heroDraw() {
		paperScissorsRock test1 = new paperScissorsRock();
		paperScissorsRock test2 = new paperScissorsRock();
		paperScissorsRock test3 = new paperScissorsRock();
		assertTrue(test1.getOutCome("RockRock").equals("It Is A Draw, Next Round!"));
		assertTrue(test2.getOutCome("PaperPaper").equals("It Is A Draw, Next Round!"));
		assertTrue(test3.getOutCome("ScissorsScissors").equals("It Is A Draw, Next Round!"));
	}
	
	public void villianGuess() {
		paperScissorsRock test1 = new paperScissorsRock();
		paperScissorsRock test2 = new paperScissorsRock();
		paperScissorsRock test3 = new paperScissorsRock();
		
		String answer1 = test1.getVillianChoice(0);
		String answer2 = test1.getVillianChoice(1);
		String answer3 = test1.getVillianChoice(2);
		
		assertTrue(answer1.equals("Paper") || answer1.equals("Scissors") || answer1.equals("Rock"));
		assertTrue(answer2.equals("Scissors") || answer2.equals("Rock"));
		assertTrue(answer3.equals("Rock"));
	}

}
