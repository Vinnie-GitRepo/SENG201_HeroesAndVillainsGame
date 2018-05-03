package teamStuff;

public class SilverTongueIII extends ConsumableItem {
	
	public SilverTongueIII() {
		super("Silver Tongue III", 50, 100, true);
	}
	
	public void apply(Hero hero) {
		hero.boostBarterSkill(this.getPotency());
		System.out.println("Hero's barter skill is now: " + hero.getBarterSkill() + "\n");
	}
	
	public static void main(String[] args) {
		Tank boii = new Tank();
		System.out.println(boii);
		
		SilverTongueIII buff1 = new SilverTongueIII();
		buff1.apply(boii);
		
		System.out.println(boii);
		
	}
}
