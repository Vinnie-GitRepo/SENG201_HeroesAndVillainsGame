package teamStuff;

import java.awt.Image;

import javax.swing.ImageIcon;

import cityStuff.gameEnvGui;
/**
 * The Cartographer class of Hero who's just a nice regular dude with some maps.<br>
 *                           They're heroic maps.<br>
 *                "We out here reading the planet n shit bruh."
 * 
 * @author vjj14
 *
 */
public class Cartographer extends Hero {
	
	
	
	/**
	 * Constructs the Cartographer Hero using the Hero constructor.
	 * To understand: super(Health, Class, Recovery, Armor, Barter Skill, Luck Status, Fame, Deterrence.
	 */
	public Cartographer() {
		super(100, "Cartographer", 0, 0, 0, false, 0, 0, new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/cartographer.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
	}
}