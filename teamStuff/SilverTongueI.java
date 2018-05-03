package teamStuff;

public class SilverTongueI extends ConsumableItem {
	
	public SilverTongueI() {
		super("Silver Tongue I", 10, 30, true);
	}
	
	public void apply(Hero hero) {
		hero.boostBarterSkill(this.getPotency());
	}
}
