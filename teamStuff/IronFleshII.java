package teamStuff;

public class IronFleshII extends Consumable{
	
	public IronFleshII() {
		super("Iron Flesh II", 10, 25, true);
	}
	
	public void apply() {
		Hero.boostArmor(getPotency());
	}
}
