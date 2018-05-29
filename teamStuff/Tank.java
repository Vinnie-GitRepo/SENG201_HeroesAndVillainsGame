package teamStuff;

import java.awt.Image;

import javax.swing.ImageIcon;

import cityStuff.GameEnvironmentGui;

/**
 * The Tank class of hero, who's iron form withstands more damage than lesser beings.<br>
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
		super(200, "Tank", 25, 50, -30, false, 0, 10, new ImageIcon(new ImageIcon(GameEnvironmentGui.class.getResource("/Images/tank.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

	}
}