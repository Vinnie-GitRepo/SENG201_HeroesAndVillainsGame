package teamStuff;

public class AugmentVitalityI extends ConsumableItem {
	
	public AugmentVitalityI() {
		super("Augment Vitality I", 20, 10, true);
	}
	
	public void apply(Hero hero) {
		hero.boostMaxHealth(this.getPotency());
	}
}
