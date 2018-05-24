package teamStuff;

import java.awt.Image;

import javax.swing.ImageIcon;

import cityStuff.gameEnvGui;
/**
 * The LuckyBoii class of hero, whose luck affects gameplay in their favour.<br> 
 *                     Fairly unremarkable otherwise...
 * 
 * @author vjj14
 *
 */
public class LuckyBoii extends Hero {

	
	
	/**
	 * Constructs the LuckyBoii Hero using the Hero constructor.
	 * To understand: super(Health, Class, Recovery, Armor, Barter Skill, Luck Status, Fame, Deterrence).
	 */
	public LuckyBoii() {
		super(100, "LuckyBoii", 20, 10, 10, true, 0, 5, new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/lucky-boii.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
	}
	
}