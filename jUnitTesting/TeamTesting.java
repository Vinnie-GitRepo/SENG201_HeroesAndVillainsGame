package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import teamStuff.Cartographer;
import teamStuff.EdgyScaryFiendLord;
import teamStuff.Hero;
import teamStuff.LuckyBoii;
import teamStuff.MerchantMan;
import teamStuff.Support;
import teamStuff.Tank;
import teamStuff.Team;

/**
 * Tests whether a team will have its barterSkillSum calculated correctly.<br>
 * Also tests other essential team methods when constructing the team and removing from the team.
 * 
 * @author vjj14
 *
 */
public class TeamTesting {
	
	
	Team test = new Team();
	
	
	@Test
	public void testHeroArray() {
		
		Hero toRemove1 = new Support();
		Hero toRemove2 = new LuckyBoii();
		Hero toRemove3 = new Cartographer();
		
		
		//----------------------------------------------
		//                  [Addition]
		//----------------------------------------------
		
		
		test.addHero(toRemove1);
		int testOutput1 = test.getHeroArray().size();
		int expectedOutput1 = 1;
		assertEquals(testOutput1, expectedOutput1);
		
		
		test.addHero(toRemove2);
		int testOutput2 = test.getHeroArray().size();
		int expectedOutput2 = 2;
		assertEquals(testOutput2, expectedOutput2);
		
		
		test.addHero(toRemove3);
		int testOutput3 = test.getHeroArray().size();
		int expectedOutput3 = 3;
		assertEquals(testOutput3, expectedOutput3);
		
		
		//----------------------------------------------
		//                   [Removal]
		//----------------------------------------------
		
		
		test.removeHero(toRemove3);
		int testOutput4 = test.getHeroArray().size();
		int expectedOutput4 = 2;
		assertEquals(testOutput4, expectedOutput4);
		
		
		test.removeHero(toRemove2);
		int testOutput5 = test.getHeroArray().size();
		int expectedOutput5 = 1;
		assertEquals(testOutput5, expectedOutput5);
		
		
		test.removeHero(toRemove1);
		int testOutput6 = test.getHeroArray().size();
		int expectedOutput6 = 0;
		assertEquals(testOutput6, expectedOutput6);
	
	}
	
	
	
	@Test
	public void testInitialTeamBarterSkill() {
		
		Hero add1 = new Tank();
		Hero add2 = new MerchantMan();
		Hero add3 = new EdgyScaryFiendLord();
		
		test.addHero(add1);
		test.addHero(add2);
		test.addHero(add3);
		test.setBarterSkillSum();
		
		int expectedOutput = add1.getBarterSkill() 
						   + add2.getBarterSkill()
						   + add3.getBarterSkill();
		
		int testOutput = test.getBarterSkillSum();
		
		assertEquals(expectedOutput, testOutput); 
	}
	
}
