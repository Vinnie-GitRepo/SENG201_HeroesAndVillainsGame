package teamStuff;


/**
 * The second tier of barter skill increasing PowerUp, Silver Tongue II.
 * @author vjj14
 *
 */
public class SilverTongueII extends PowerUp {
	
	
	
	/**
	 * Constructs a Silver Tongue II PowerUp by calling the PowerUp constructor. 
	 */
	public SilverTongueII() {
		super("Silver Tongue II", "Barter Skill boost", 20, 55);
	}
	
	
	
	/**
	 * Applies the PowerUp effect to the hero, increasing their barter skill by the PowerUp's potency.
	 * @param hero
	 */
	public void apply(Hero hero) {
		hero.boostBarterSkill(this.getPowerUpPotency());
	}
}
