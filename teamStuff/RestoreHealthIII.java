package teamStuff;


/**
 * The third tier of HealingItem, Restore Health III.
 * @author vjj14
 *
 */
public class RestoreHealthIII extends HealingItem {
	
	
	
	/**
	 * Constructs a Restore Health I HealingItem by calling the HealingItem constructor.
	 * Should have a greater price and potency than healing items of lower tiers.
	 */
	public RestoreHealthIII() {
		super("Restore Health III", 200, 75, 40);
	}
	
}
