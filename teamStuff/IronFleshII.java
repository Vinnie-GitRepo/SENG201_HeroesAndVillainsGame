package teamStuff;

public class IronFleshII extends ConsumableItem {
	
	public IronFleshII() {
		super("Iron Flesh II", 10, 25, true);
	}
	
	public void apply(Hero hero) {
		hero.boostArmor(this.getPotency());
	}
}
