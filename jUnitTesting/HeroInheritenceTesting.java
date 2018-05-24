package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;
import teamStuff.Hero;
import teamStuff.MerchantMan;
import teamStuff.Tank;
import teamStuff.Cartographer;
import teamStuff.Support;
import teamStuff.LuckyBoii;
import teamStuff.EdgyScaryFiendLord;


public class HeroInheritenceTesting {

	@Test
	public void testMerchant() {
		MerchantMan testMerchantMan = new MerchantMan();
		assertTrue(testMerchantMan instanceof Hero);
	}
	
	
	@Test
	public void testTank() {
		Tank testTank = new Tank();
		assertTrue(testTank instanceof Hero);
	}
	
	
	@Test
	public void testCartographer() {
		Cartographer testCartographer = new Cartographer();
		assertTrue(testCartographer instanceof Hero);
	}
	
	
	@Test
	public void testSupport() {
		Support testSupport = new Support();
		assertTrue(testSupport instanceof Hero);
	}
	
	
	@Test
	public void testLuckyBoii() {
		LuckyBoii testLuckyBoii = new LuckyBoii();
		assertTrue(testLuckyBoii instanceof Hero);
	}
	
	
	@Test
	public void testEdgyScaryFiendLord() {
		EdgyScaryFiendLord testEdgyScaryFiendLord = new EdgyScaryFiendLord();
		assertTrue(testEdgyScaryFiendLord instanceof Hero);
	}
	

}
