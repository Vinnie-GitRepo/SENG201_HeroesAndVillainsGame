package teamStuff;

import java.awt.Image;

import javax.swing.ImageIcon;

import cityStuff.gameEnvGui;
/**
 * The EdgyScaryFiendLord or "Anti-Hero" class of hero.<br>
 *      Very intimidating and actually kinda tough.
 * 									 
 * @author vjj14
 *
 */
public class EdgyScaryFiendLord extends Hero {

	
	
	/**
	 * Constructs the EdgyScaryFiendLord using the Hero constructor.
	 * To understand: super(Health, Class, Recovery, Armor, Barter Skill, Luck Status, Fame, Deterrence.   
	 */
	public EdgyScaryFiendLord() {
		super(150, "Anti Hero", 20, 25, 10, false, 10, 50, new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/anti-hero.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
	}
	
	
	
}	