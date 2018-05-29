package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import teamStuff.Cartographer;
import teamStuff.Hero;
import teamStuff.Tank;

public class HeroTesting {

	@Test
	public void testArmorAndHealthDamage() {
		
		Hero testDummy = new Cartographer();
		
		testDummy.boostArmor(100);
		testDummy.damageHealth(201);
		
		int testOutput = testDummy.getCurrentHealth();
		int expectedOutput = 0;
		
		assertEquals(expectedOutput, testOutput); // Should destroy the armor and kill the hero, but not set the armor to negative values
	}
	
	
	@Test
	public void testHealthRestoration() {
		Hero testDummy = new Cartographer();
		
		testDummy.restoreHealth(1000);
		
		int testOutput = testDummy.getCurrentHealth();
		int expectedOutput = 100;
		
		assertEquals(expectedOutput, testOutput); // Should not change the hero's maximum health or their current health
		
	}
	
	
	@Test
	public void testArmorDamage() {
		Hero testDummy1 = new Cartographer();       // Armorless hero case
		testDummy1.damageArmor(100);
		int testOutput1 = testDummy1.getArmor();
		int expectedOutput1 = 0;
		assertEquals(expectedOutput1, testOutput1); // Should not change the hero's armor or yield negative values for armor
		
		
		
		Hero testDummy2 = new Tank();               // Armored hero case
		testDummy2.damageArmor(100);
		int testOutput2 = testDummy2.getArmor();
		int expectedOutput2 = 0;
		assertEquals(expectedOutput2, testOutput2); // Should not change the hero's armor or yield negative values for armor
		
		
	}
	
	
	

}
