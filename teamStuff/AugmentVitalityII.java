package teamStuff;

public class AugmentVitalityII extends ConsumableItem {
	
	public AugmentVitalityII() {
		super("Augment Vitality II", 40, 20, true);
	}
	
	public void apply(Hero hero) {
		hero.boostMaxHealth(this.getPotency());
	}
}
