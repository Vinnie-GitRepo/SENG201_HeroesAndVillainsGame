package teamStuff;

public class SilverTongueII extends Consumable{
	
	public SilverTongueII() {
		super("Silver Tongue II", 20, 55, true);
	}
	
	public void apply() {
		Hero.boostBarterSkill(getPotency());
	}

}
