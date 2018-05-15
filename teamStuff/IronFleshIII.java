package teamStuff;


/**
 * The third tier of armor increasing PowerUp, Iron Flesh III. 
 * @author vjj14
 *
 */
public class IronFleshIII extends PowerUp {
	
	
	
	/**
	 * Constructs an Iron Flesh III PowerUp by calling the PowerUp constructor.
	 */
	public IronFleshIII() {
		super("Iron Flesh III", "Armor boost", 30, 40);
	}
	
	
	
	/**
	 * Applies the PowerUp effect to the hero, increasing their armor by the PowerUp's potency.
	 * @param hero
	 */
	public void apply(Hero hero) {
		hero.boostArmor(this.getPowerUpPotency());
		System.out.println("The hero's armor is now: " + hero.getArmor());
	}
	
	
	
	
	public static void main(String[] args) {
		
		MerchantMan quod = new MerchantMan();
		System.out.println(quod);
		
		IronFleshIII buff1 = new IronFleshIII();
		buff1.apply(quod);
		IronFleshIII buff2 = new IronFleshIII();
		buff2.apply(quod);
		IronFleshIII buff3 = new IronFleshIII();
		buff3.apply(quod);
		IronFleshIII buff4 = new IronFleshIII();
		buff4.apply(quod);
		
		System.out.println(quod);
		quod.damageHealth(125);
		
		System.out.println(quod);
		System.out.println(buff1);
	}
}
