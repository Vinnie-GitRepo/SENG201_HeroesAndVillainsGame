package teamStuff;


/**
 * The first tier of HealingItem, Restore Health I.
 * @author vjj14
 *
 */
public class RestoreHealthI extends HealingItem{
	
	
	
	/**
	 * Constructs a Restore Health I HealingItem by calling the HealingItem constructor.
	 * Should have a lower price and potency than healing items of higher tiers.
	 */
	public RestoreHealthI() {
		super("Restore Health I", 40, 20, 10);
	}

}
