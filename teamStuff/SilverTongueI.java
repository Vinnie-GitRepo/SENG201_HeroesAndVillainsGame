package teamStuff;


/**
 * The first tier of barter skill increasing PowerUp, Silver Tongue I.
 * @author vjj14
 *
 */
public class SilverTongueI extends PowerUp {
	
	
	
	/**
	 * Constructs a Silver Tongue I PowerUp by calling the PowerUp constructor. 
	 */
	public SilverTongueI() {
		super("Silver Tongue I", "Barter Skill boost", 10, 30);
	}
	
	
	
	/**
	 * Applies the PowerUp effect to the hero, increasing their barter skill by the PowerUp's potency. 
	 * @param hero
	 */
	public void apply(Hero hero) {
		hero.boostBarterSkill(this.getPowerUpPotency());
	}
}
