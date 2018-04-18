package teamStuff;

public class IronFleshIII extends Consumable{
	
	public IronFleshIII() {
		super("Iron Flesh III", 30, 40, true);
	}
	
	public void apply() {
		Hero.boostArmor(getPotency());
	}
}
