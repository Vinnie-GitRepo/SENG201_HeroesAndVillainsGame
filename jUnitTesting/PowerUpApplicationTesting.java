package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import teamStuff.AugmentVitalityI;
import teamStuff.AugmentVitalityII;
import teamStuff.AugmentVitalityIII;
import teamStuff.Cartographer;
import teamStuff.IronFleshI;
import teamStuff.IronFleshII;
import teamStuff.IronFleshIII;
import teamStuff.SilverTongueI;
import teamStuff.SilverTongueII;
import teamStuff.SilverTongueIII;

public class PowerUpApplicationTesting {

	@Test
	public void AugmentVitalityTests() {
		
		Cartographer test1 = new Cartographer();
		AugmentVitalityI testAugmentVitalityI = new AugmentVitalityI();
		test1.usePowerUp(testAugmentVitalityI);
		
		
		Cartographer test2 = new Cartographer();
		AugmentVitalityII testAugmentVitalityII = new AugmentVitalityII();
		test2.usePowerUp(testAugmentVitalityII);
		
		
		Cartographer test3 = new Cartographer();
		AugmentVitalityIII testAugmentVitalityIII = new AugmentVitalityIII();
		test3.usePowerUp(testAugmentVitalityIII);
		
		
		assertEquals((100 + 20), test1.getMaxHealth());
		assertEquals((100 + 40), test2.getMaxHealth());
		assertEquals((100 + 100), test3.getMaxHealth());
	
	}
	
	
	
	@Test
	public void IronFleshTests() {
		
		Cartographer test1 = new Cartographer();
		IronFleshI testIronFleshI = new IronFleshI();
		test1.usePowerUp(testIronFleshI);
		
		
		Cartographer test2 = new Cartographer();
		IronFleshII testIronFleshII = new IronFleshII();
		test2.usePowerUp(testIronFleshII);
		
		
		Cartographer test3 = new Cartographer();
		IronFleshIII testIronFleshIII = new IronFleshIII();
		test3.usePowerUp(testIronFleshIII);
		
		
		assertEquals((0 + 5), test1.getArmor());
		assertEquals((0 + 10), test2.getArmor());
		assertEquals((0 + 30), test3.getArmor());
	
	}
	
	
	
	
	@Test
	public void SilverTongueTests() {
		
		Cartographer test1 = new Cartographer();
		SilverTongueI testSilverTongueI = new SilverTongueI();
		test1.usePowerUp(testSilverTongueI);
		
		
		Cartographer test2 = new Cartographer();
		SilverTongueII testSilverTongueII = new SilverTongueII();
		test2.usePowerUp(testSilverTongueII);
		
		
		Cartographer test3 = new Cartographer();
		SilverTongueIII testSilverTongueIII = new SilverTongueIII();
		test3.usePowerUp(testSilverTongueIII);
		
		
		assertEquals((0 + 10), test1.getBarterSkill());
		assertEquals((0 + 20), test2.getBarterSkill());
		assertEquals((0 + 50), test3.getBarterSkill());
	
	}
	
	
	
	
	
	
	
	
	

}
