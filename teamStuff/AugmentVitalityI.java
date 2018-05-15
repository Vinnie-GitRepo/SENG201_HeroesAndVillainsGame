package teamStuff;


/**
 * The first tier of health increasing PowerUp, Augment Vitality I.
 * @author vjj14
 *
 */
public class AugmentVitalityI extends PowerUp {
	
	
	
	/**
	 * Constructs an Augment Vitality I PowerUp by calling the PowerUp constructor. 
	 */
	public AugmentVitalityI() {
		super("Augment Vitality I", "Health boost", 20, 10);
	}
	
	
	
	/**
	 * Applies the PowerUp effect to the hero, increasing their maximum health by the PowerUp's potency. 
	 * @param hero
	 */
	public void apply(Hero hero) {
		hero.boostMaxHealth(this.getPowerUpPotency());
	}
}
