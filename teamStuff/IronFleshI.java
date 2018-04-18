package teamStuff;

public class IronFleshI extends Consumable{
	
	public IronFleshI() {
		super("Iron Flesh I", 5, 15, true);
	}
	
	public void apply() {
		Hero.boostArmor(getPotency());
	}
}
