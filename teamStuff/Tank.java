package teamStuff;

import java.awt.Image;

import javax.swing.ImageIcon;

import cityStuff.gameEnvGui;

/**
 * The Tank class of hero, who's iron form withstands more damage than lesser beings.
 *       However Tank heroes are prime targets for explotative shopkeepers. 
 *       
 * @author vjj14
 *
 */
public class Tank extends Hero {

	
	
	/**
	 * Constructs the Tank Hero using the Hero constructor
	 * To understand: super(Health, Class, Recovery, Armor, Barter Skill, Luck Status, Fame, Deterrence.
	 */
	public Tank() {
<<<<<<< HEAD
		super(200, "Tank", 7, 50, -30, false, 0, 10);
=======
		super(200, "Tank", 25, 50, -30, false, 0, 10, new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/tank.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
>>>>>>> b002efe764264ae5ecfa81284c2cb9ef9637134a
	}
}