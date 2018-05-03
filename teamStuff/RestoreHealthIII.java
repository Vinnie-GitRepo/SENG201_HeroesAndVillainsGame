package teamStuff;

import java.util.Timer;
import java.util.TimerTask;

public class RestoreHealthIII extends ConsumableItem {
	
	private static int secondsPassed = 0;
	private static int defaultApplicationTime = 40;
	private Timer time = new Timer();
	
	
	public RestoreHealthIII() {
		super("Restore Health III", 200, 75, true);
		
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
	
}
