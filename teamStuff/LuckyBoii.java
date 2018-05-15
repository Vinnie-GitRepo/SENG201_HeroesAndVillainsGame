package teamStuff;


/**
 * The LuckyBoii class of hero, whose luck affects gameplay in ways undetermined. 
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
		super(100, "LuckyBoii", 20, 10, 10, true, 0, 5);
	}
	
}