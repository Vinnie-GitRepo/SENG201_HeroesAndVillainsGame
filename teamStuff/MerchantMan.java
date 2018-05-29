package teamStuff;

import java.awt.Image;

import javax.swing.ImageIcon;

import cityStuff.GameEnvironmentGui;

/**
 * The Merchant class of hero, whose bartering abilities benefit the team in the shop.<br>
 * 			  However being a weak Merchant hero invites pain and robbery. 
 * 
 * @author vjj14
 *
 */
public class MerchantMan extends Hero {
	
	
	
	/**
	 * Constructs the MerchantMan Hero using the Hero constructor.
	 * To understand: super(Health, Class, Recovery, Armor, Barter Skill, Luck Status, Fame, Deterrence.
	 */
	public MerchantMan() {
		super(75, "Merchant", 10, 0, 50, false, 5, -20, new ImageIcon(new ImageIcon(GameEnvironmentGui.class.getResource("/Images/merchant.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
	}
}