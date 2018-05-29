package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import games.paperScissorsRock;

public class PaperScissorsRockTesting {

	
	
	@Test
	public void heroWinsTest() {
		paperScissorsRock test1 = new paperScissorsRock();
		paperScissorsRock test2 = new paperScissorsRock();
		paperScissorsRock test3 = new paperScissorsRock();
		
		assertTrue(test1.getOutCome("PaperRock").equals("You Have Won"));
		assertTrue(test2.getOutCome("ScissorsPaper").equals("You Have Won"));
		assertTrue(test3.getOutCome("RockScissors").equals("You Have Won"));
		
		
	}
	
	
	@Test
	public void heroLosesTest() {
		paperScissorsRock test1 = new paperScissorsRock();
		paperScissorsRock test2 = new paperScissorsRock();
		paperScissorsRock test3 = new paperScissorsRock();
		assertTrue(test1.getOutCome("PaperScissors").equals("The Villian Has Won"));
		assertTrue(test2.getOutCome("ScissorsRock").equals("The Villian Has Won"));
		assertTrue(test3.getOutCome("RockPaper").equals("The Villian Has Won"));
		
	}
	
	
	
	@Test
	public void heroDrawsTest() {
		paperScissorsRock test1 = new paperScissorsRock();
		paperScissorsRock test2 = new paperScissorsRock();
		paperScissorsRock test3 = new paperScissorsRock();
		
		assertTrue(test1.getOutCome("RockRock").equals("It Is A Draw, Next Round!"));
		assertTrue(test2.getOutCome("PaperPaper").equals("It Is A Draw, Next Round!"));
		assertTrue(test3.getOutCome("ScissorsScissors").equals("It Is A Draw, Next Round!"));
	}
	
}
