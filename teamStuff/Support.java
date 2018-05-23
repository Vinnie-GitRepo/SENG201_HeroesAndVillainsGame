package teamStuff;


/**
 * The Support class of hero, who provides support to the team via some undetermined method.
 *                  Has a high recovery and is famous for their good works.
 * 
 * @author vjj14
 *
 */
public class Support extends Hero {

	
	
	/**
	 * Constructs the Support Hero using the Hero constuctor.
	 * To understand: super(Health, Class, Recovery, Armor, Barter Skill, Luck Status, Fame, Deterrence.
	 */
	public Support() {
		super(100, "Support", 9, 0, 0, false, 20, 5);
	}
	
	
}