package teamStuff;


/**
 * The second tier of HealingItem, Restore Health II.
 * @author vjj14
 *
 */
public class RestoreHealthII extends HealingItem {
	
	
	
	/**
	 * Constructs a Restore Health I HealingItem by calling the HealingItem constructor.
	 * Should have a greater price and potency than healing items of lower tiers.
	 * Should have a lower price and potency than healing items of higher tiers.
	 */
	public RestoreHealthII() {
		super("Restore Health II", 100, 40, 10);
	}
		
}
