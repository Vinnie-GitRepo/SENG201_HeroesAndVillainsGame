package jUnitTesting;


import static org.junit.Assert.*;
import org.junit.Test;

import teamStuff.Hero;
import teamStuff.Team;


/**
 * Class for running JUnit tests on the Team class.<br>
 * Tests the basic functionality of methods used within Team.
 * @author vjj14
 *
 */
public class TeamAndHeroTesting {
	
	@Test 
	public void test1() {
		
		Team test = new Team();
		Hero target = test.getHeroArray().get(0);
		target.damageHealth(1000);
		
		
		int testOutput = test.getHeroArray().size();
		int expectedOutput = 2;
		
		
		assertEquals(expectedOutput, testOutput);
		
	}
	
	@Test
	public void test2() {
		Team test = new Team();
		
	}

}
