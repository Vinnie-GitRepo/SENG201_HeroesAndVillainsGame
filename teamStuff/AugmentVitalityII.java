package teamStuff;

public class AugmentVitalityII extends Consumable {
	
	public AugmentVitalityII() {
		super("Augment Vitality II", 40, 20, true);
	}
	
	public void apply() {
		Hero.boostMaxHealth(getPotency());
	}
}
