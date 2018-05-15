package teamStuff;


/**
 * The first tier of armor increasing PowerUp, Iron Flesh I.
 * @author vjj14
 *
 */
public class IronFleshI extends PowerUp {
	
	
	
	/**
	 * Constructs an Iron Flesh I PowerUp by calling the PowerUp constructor.
	 */
	public IronFleshI() {
		super("Iron Flesh I", "Armor boost", 5, 15);
	}
	
	
	
	/**
	 * Applies the PowerUp effect to the hero, increasing their armor by the PowerUp's potency.
	 * @param hero
	 */
	public void apply(Hero hero) {
		hero.boostArmor(this.getPowerUpPotency());
	}
}
