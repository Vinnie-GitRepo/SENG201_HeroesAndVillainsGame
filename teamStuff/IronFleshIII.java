package teamStuff;

public class IronFleshIII extends ConsumableItem {
	
	public IronFleshIII() {
		super("Iron Flesh III", 30, 40, true);
	}
	
	public void apply(Hero hero) {
		hero.boostArmor(this.getPotency());
		System.out.println("Armor is now " + hero.getArmor());
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
	
		
		
	}
}
