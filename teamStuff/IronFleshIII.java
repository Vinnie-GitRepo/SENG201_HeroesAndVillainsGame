package teamStuff;

public class IronFleshIII extends ConsumableItem {
	
	public IronFleshIII() {
		super("Iron Flesh III", 30, 40, true);
	}
	
	public void apply(Hero hero) {
		hero.boostArmor(getPotency());
	}
}
