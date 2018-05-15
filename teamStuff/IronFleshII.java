package teamStuff;


/**
 * The second tier of armor increasing PowerUp, Iron Flesh II.
 * @author vjj14
 *
 */
public class IronFleshII extends PowerUp {
	
	
	
	/**
	 * Constructs an Iron Flesh II PowerUp by calling the PowerUp constructor.
	 */
	public IronFleshII() {
		super("Iron Flesh II", "Armor boost", 10, 25);
	}
	
	
	
	/**
	 * Applies the PowerUp effect to the hero, increasing their armor by the PowerUp's potency.
	 * @param hero
	 */
	public void apply(Hero hero) {
		hero.boostArmor(this.getPowerUpPotency());
	}
}
