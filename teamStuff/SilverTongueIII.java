package teamStuff;


/**
 * The third tier of barter skill increasing PowerUp, Silver Tongue III.
 * @author vjj14
 *
 */
public class SilverTongueIII extends PowerUp {
	
	
	
	/**
	 * Constructs a Silver Tongue III PowerUp by calling the PowerUp constructor.
	 */
	public SilverTongueIII() {
		super("Silver Tongue III", "Barter Skill boost", 50, 100);
	}
	
	
	
	/**
	 * Applies the PowerUp effect to the hero, increasing their barter skill by the PowerUp's potency.
	 * @param hero
	 */
	public void apply(Hero hero) {
		hero.boostBarterSkill(this.getPowerUpPotency());
	}
	
	
	
	
	public static void main(String[] args) {
		Tank boii = new Tank();
		System.out.println(boii);
		
		SilverTongueIII buff1 = new SilverTongueIII();
		buff1.apply(boii);
		
		System.out.println(boii);
		
	}
}
