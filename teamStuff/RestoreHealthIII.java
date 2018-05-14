package teamStuff;

public class RestoreHealthIII extends HealingItem {
	
	
	/**
	 * Constructor for a "Restore Health III" HealingItem.
	 * Should have a greater price and potency than healing items of lower tiers.
	 */
	public RestoreHealthIII() {
		super("Restore Health III", 200, 75, 40);
		
	}
	
	
	public static void main(String[] args) {
		MerchantMan quod = new MerchantMan();
		System.out.println(quod);
		quod.damageHealth(50);
		
		
		RestoreHealthIII heal = new RestoreHealthIII();
		heal.apply(quod);
		
	}
	
}
