package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import teamStuff.HealingItem;
import teamStuff.RestoreHealthI;
import teamStuff.RestoreHealthII;
import teamStuff.RestoreHealthIII;

public class HealingItemInheritenceTesting {

	@Test
	public void HealingItemsTest() {
		RestoreHealthI test1 = new RestoreHealthI();
		RestoreHealthII test2 = new RestoreHealthII();
		RestoreHealthIII test3 = new RestoreHealthIII();
		
		assertTrue(test1 instanceof HealingItem);
		assertTrue(test2 instanceof HealingItem);
		assertTrue(test3 instanceof HealingItem);
	}

}
