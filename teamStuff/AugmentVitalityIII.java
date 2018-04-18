package teamStuff;

public class AugmentVitalityIII extends Consumable {
	
	public AugmentVitalityIII() {
		super("Augment Vitality III", 100, 50, true);
	}
	
	public void apply() {
		Hero.boostMaxHealth(getPotency());
	}
}
