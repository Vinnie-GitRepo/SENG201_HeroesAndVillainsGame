package teamStuff;

import java.awt.Image;

import javax.swing.ImageIcon;

import cityStuff.gameEnvGui;
/**
 * The EdgyScaryFiendLord or "Anti-Hero" class of hero.
 *     Very intimidating and actually kinda tough.
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
<<<<<<< HEAD
		super(150, "Edgy Anti-Hero", 8, 25, 10, false, 10, 50);
=======
		super(150, "Edgy Anti-Hero", 20, 25, 10, false, 10, 50, new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/anti-hero.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
>>>>>>> b002efe764264ae5ecfa81284c2cb9ef9637134a
	}
	
}	