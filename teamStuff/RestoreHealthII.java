package teamStuff;


public class RestoreHealthII extends HealingItem {
	
	/**
	 * Constructor for a "Restore Health II" HealingItem.
	 * Should have a greater price and potency than healing items of lower tiers.
	 */
	public RestoreHealthII() {
		super("Restore Health II", 100, 40, 40);
	}
		
	
	/**
	 * TESTING MAIN
	 * @param args
	 */
	public static void main(String[] args) {
		MerchantMan quod = new MerchantMan();
		System.out.println(quod);
		quod.damageHealth(50);
		
		
		RestoreHealthII heal = new RestoreHealthII();
		heal.apply(quod);
	}
}
