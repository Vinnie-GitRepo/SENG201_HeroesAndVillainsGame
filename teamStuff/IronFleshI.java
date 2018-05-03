package teamStuff;

public class IronFleshI extends ConsumableItem {
	
	public IronFleshI() {
		super("Iron Flesh I", 5, 15, true);
	}
	
	public void apply(Hero hero) {
		hero.boostArmor(this.getPotency());
	}
}
