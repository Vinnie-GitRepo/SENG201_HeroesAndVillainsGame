package teamStuff;

import java.util.Timer;
import java.util.TimerTask;

public class RestoreHealthI extends ConsumableItem{
	
	private int timeRemaining;
	private static int secondsPassed;
	private static int defaultApplicationTime = 40;
	private Timer time = new Timer();
	
	
	public RestoreHealthI() {
		super("Restore Health I", 40, 20, true);
	}
	
	
	
	public void apply(Hero hero) {
		int applicationTime = defaultApplicationTime - hero.getRecoveryBoost();
		timeRemaining = 4*applicationTime;
		TimerTask healOverTime = new TimerTask() {
			
			public void run() {
				
				timeRemaining--;
				secondsPassed++;
				
				System.out.println("Time remaining: " + timeRemaining);
				
			
				if(secondsPassed == 5) {                	//	First increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());
				}
					
				if(secondsPassed == 10) {					//	Second increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());
				}
					
				if(secondsPassed == 15) {					//	Third increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());
				}
					
				if(secondsPassed == 20) {					//	Fourth increment, restoring 25% of the potion's potency.
					hero.restoreHealth(getPotency() / 4);
					System.out.println("Health is now: " + hero.getCurrentHealth());
					cancel(); 												//	Finished the healing process.
				}  								
			}
		};
		time.scheduleAtFixedRate(healOverTime, 1000, 1000);
	}
	
	public int getTimeRemaining() {
		return timeRemaining;
	}
	
	public static void main(String[] args) {
		MerchantMan quod = new MerchantMan();
		System.out.println(quod);
		quod.damageHealth(50);
		
		
		RestoreHealthI heal = new RestoreHealthI();
		heal.apply(quod);
		
		
	}
}
