package teamStuff;

import java.awt.Image;

import javax.swing.ImageIcon;

import cityStuff.gameEnvGui;
/**
 * The Support class of hero, who provides support to the team emotionally, which is always needed.<br>
 *                      Has a high recovery and is famous for their good works.
 * 
 * @author vjj14
 *
 */
public class Support extends Hero {

	
	
	/**
	 * Constructs the Support Hero using the Hero constuctor.
	 * To understand: super(Health, Class, Recovery, Armor, Barter Skill, Luck Status, Fame, Deterrence)
	 */
	public Support() {
		super(100, "Support", 30, 0, 0, false, 20, 5,new ImageIcon(new ImageIcon(gameEnvGui.class.getResource("/Images/support.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
	}
	
	
}