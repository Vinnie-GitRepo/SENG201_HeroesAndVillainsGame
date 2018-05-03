package teamStuff;

public class SilverTongueII extends ConsumableItem {
	
	public SilverTongueII() {
		super("Silver Tongue II", 20, 55, true);
	}
	
	public void apply(Hero hero) {
		hero.boostBarterSkill(this.getPotency());
	}

}
