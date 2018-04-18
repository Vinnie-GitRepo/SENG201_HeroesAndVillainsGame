package teamStuff;

public class AugmentVitalityI extends Consumable {
	
	public AugmentVitalityI() {
		super("Augment Vitality I", 20, 10, true);
	}
	
	public void apply() {
		Hero.boostMaxHealth(getPotency());
	}
}
