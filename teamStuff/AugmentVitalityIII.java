package teamStuff;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class AugmentVitalityIII extends ConsumableItem {
	
	public AugmentVitalityIII() {
		super("Augment Vitality III", 100, 50, true);
	}
	
	public void apply(Hero hero) {
		hero.boostMaxHealth(this.getPotency());
		
	}
	
	public static void main(String[] args) {
		Tank biggo = new Tank();
		System.out.println(biggo);
		
		AugmentVitalityIII buff1 = new AugmentVitalityIII();
		buff1.apply(biggo);
		
		RestoreHealthIII heal1 = new RestoreHealthIII();
		heal1.apply(biggo);
		
		System.out.println(biggo);
		
	}
}
