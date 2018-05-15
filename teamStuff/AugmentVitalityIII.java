package teamStuff;


/**
 * The third tier of the health increasing PowerUp, Augment Vitality III.
 * @author vjj14
 *
 */
public class AugmentVitalityIII extends PowerUp {
	
	
	
	/**
	 * Constructs an Augment Vitality III PowerUp by calling the PowerUp constructor. 
	 */
	public AugmentVitalityIII() {
		super("Augment Vitality III", "Health boost", 100, 50);
	}
	
	
	
	/**
	 * Applies the PowerUp effect to the hero, increasing their maximum health by the PowerUp's potency.
	 * @param hero
	 */
	public void apply(Hero hero) {
		hero.boostMaxHealth(this.getPowerUpPotency());
	}
	
	
	
	
	public static void main(String[] args) {
		Tank biggo = new Tank();
		System.out.println(biggo);
		
		AugmentVitalityIII buff1 = new AugmentVitalityIII();
		buff1.apply(biggo);
		
		RestoreHealthIII heal1 = new RestoreHealthIII();
		heal1.apply(biggo);
		
		System.out.println(biggo);
		
	}
}
