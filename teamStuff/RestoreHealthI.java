package teamStuff;

import java.util.Timer;
import java.util.TimerTask;

public class RestoreHealthI extends Consumable{
	
	private static int secondsPassed = 0;
	private static int defaultApplicationTime = 40;
	private static int applicationTime = (defaultApplicationTime - Hero.getRecoveryBoost()) / 4;
	
	Timer time = new Timer();
	
	TimerTask healOverTime = new TimerTask() {
		public void run() {
			
			secondsPassed++;
			System.out.println("Seconds passed: " + secondsPassed);
				
			if(secondsPassed == 1*applicationTime) {                	//	First increment, restoring 25% of the potion's potency.
				Hero.restoreHealth(getPotency() / 4);
				System.out.println(Hero.getCurrentHealth());}
				
			if(secondsPassed == 2*applicationTime) {					//	Second increment, restoring 25% of the potion's potency.
				Hero.restoreHealth(getPotency() / 4);
				System.out.println(Hero.getCurrentHealth());}
				
			if(secondsPassed == 3*applicationTime) {					//	Third increment, restoring 25% of the potion's potency.
				Hero.restoreHealth(getPotency() / 4);
				System.out.println(Hero.getCurrentHealth());}
				
			if(secondsPassed == 4*applicationTime) {					//	Fourth increment, restoring 25% of the potion's potency.
				Hero.restoreHealth(getPotency() / 4);
				System.out.println(Hero.getCurrentHealth());
				healOverTime.cancel();}  								//	Finished the healing process.
		}
	};
	
	
	public RestoreHealthI() {
		super("Restore Health I", 40, 20, true);
	}
	
	public static void showApplyTime() {
		System.out.println("Time Remaining for full application:" + secondsPassed + "/120");
	}
	
	
	
	public void apply(Hero hero) {
		time.schedule(healOverTime, 1000, 1000);
	}
	
	
	public static void main(String[] args) {
		MerchantMan quod = new MerchantMan();
		System.out.println(quod);
		quod.damageHealth(10);
		System.out.println(applicationTime);
		
		
		
		RestoreHealthI heal = new RestoreHealthI();
		heal.apply(quod);
		
		
		
	}
}
