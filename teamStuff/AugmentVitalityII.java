package teamStuff;


/**
 * The second tier of health increasing PowerUp, Augment Vitality II.
 * @author vjj14
 *
 */
public class AugmentVitalityII extends PowerUp {
	
	
	
	/**
	 * Constructs an Augment Vitality II PowerUp by calling the PowerUp constructor. 
	 */
	public AugmentVitalityII() {
		super("Augment Vitality II", "Health boost", 40, 20);
	}
	
	
	
	/**
	 * Applies the PowerUp effect to the hero, increasing their maximum health by the PowerUp's potency.
	 * @param hero
	 */
	public void apply(Hero hero) {
		hero.boostMaxHealth(this.getPowerUpPotency());
	}
}
