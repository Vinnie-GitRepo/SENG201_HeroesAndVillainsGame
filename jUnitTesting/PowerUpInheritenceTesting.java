package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import teamStuff.AugmentVitalityI;
import teamStuff.AugmentVitalityII;
import teamStuff.AugmentVitalityIII;
import teamStuff.IronFleshI;
import teamStuff.IronFleshII;
import teamStuff.IronFleshIII;
import teamStuff.PowerUp;
import teamStuff.SilverTongueI;
import teamStuff.SilverTongueII;
import teamStuff.SilverTongueIII;

public class PowerUpInheritenceTesting {

	
	
	@Test
	public void AugmentVitalityTest() {
		AugmentVitalityI testAugmentVitalityI = new AugmentVitalityI();
		AugmentVitalityII testAugmentVitalityII = new AugmentVitalityII();
		AugmentVitalityIII testAugmentVitalityIII = new AugmentVitalityIII();
		
		assertTrue(testAugmentVitalityI instanceof PowerUp);
		assertTrue(testAugmentVitalityII instanceof PowerUp);
		assertTrue(testAugmentVitalityIII instanceof PowerUp);
	}

	
	
	@Test
	public void IronFleshTest() {
		IronFleshI testIronFleshI = new IronFleshI();
		IronFleshII testIronFleshII = new IronFleshII();
		IronFleshIII testIronFleshIII = new IronFleshIII();
		
		assertTrue(testIronFleshI instanceof PowerUp);
		assertTrue(testIronFleshII instanceof PowerUp);
		assertTrue(testIronFleshIII instanceof PowerUp);
	}
	
	
	
	@Test
	public void SilverTongueTest() {
		SilverTongueI testSilverTongueI = new SilverTongueI();
		SilverTongueII testSilverTongueII = new SilverTongueII();
		SilverTongueIII testSilverTongueIII = new SilverTongueIII();
		
		assertTrue(testSilverTongueI instanceof PowerUp);
		assertTrue(testSilverTongueII instanceof PowerUp);
		assertTrue(testSilverTongueIII instanceof PowerUp);
	}
}
