package teamStuff;

public class RestoreHealthI extends HealingItem{
	
	
	/**
	 * Constructor for "Restore Health I" HealingItem
	 * Should have a lower price and potency than healing items of higher tiers.
	 */
	public RestoreHealthI() {
		super("Restore Health I", 40, 20, 40);
	}
	
	
	public static void main(String[] args) {
		MerchantMan quod = new MerchantMan();
		System.out.println(quod);
		quod.damageHealth(50);
		
		
		RestoreHealthI heal = new RestoreHealthI();
		heal.apply(quod);
		
		
	}

}
