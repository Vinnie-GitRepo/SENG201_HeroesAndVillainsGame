package teamStuff;

import java.util.Timer;
import java.util.TimerTask;

public class RestoreHealthI extends ConsumableItem{
	
	private static int secondsPassed = 0;
	private static int defaultApplicationTime = 40;
	private Timer time = new Timer();
	
	
	public RestoreHealthI() {
		super("Restore Health I", 40, 20, true);
	}
	
	
	
	public void apply(Hero hero) {
		int applicationTime = defaultApplicationTime - hero.getRecoveryBoost();
		TimerTask healOverTime = new TimerTask() {
			
			public void run() {
				
				secondsPassed++;
				System.out.println("Seconds passed: " + secondsPassed);
			
				if(secondsPassed == 1*applicationTime) {                	//	First increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());}
					
				if(secondsPassed == 2*applicationTime) {					//	Second increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());}
					
				if(secondsPassed == 3*applicationTime) {					//	Third increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());}
					
				if(secondsPassed == 4*applicationTime) {					//	Fourth increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());
					cancel();} 												//	Finished the healing process.  								
			}
		};
		time.scheduleAtFixedRate(healOverTime, 1000, 1000);					//  Initiates the healing process.										
	}
	
	
	public static void main(String[] args) {
		MerchantMan quod = new MerchantMan();
		System.out.println(quod);
		quod.damageHealth(50);
		
		
		RestoreHealthI heal = new RestoreHealthI();
		heal.apply(quod);
		
		
	}
}
