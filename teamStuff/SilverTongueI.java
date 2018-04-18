package teamStuff;

public class SilverTongueI extends Consumable{
	
	public SilverTongueI() {
		super("Silver Tongue I", 10, 30, true);
	}
	
	public void apply() {
		Hero.boostBarterSkill(getPotency());
	}

}
