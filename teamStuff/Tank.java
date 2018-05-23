package teamStuff;


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
		super(200, "Tank", 7, 50, -30, false, 0, 10);
	}
}