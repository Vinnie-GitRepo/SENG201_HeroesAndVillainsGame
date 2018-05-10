package teamStuff;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimeTest {
	

	int secondsPassed = 0;
	Timer timer = new Timer();
	
	TimerTask timeGameplay = new TimerTask() {
		
		public void run() {
			
			secondsPassed++;
			
			if(secondsPassed == 10) {
				cancel();
				System.out.println(secondsPassed);
			}
		}
	};
	
	
	public void start() {
		timer.scheduleAtFixedRate(timeGameplay, 1000, 1000);
	}
	
	
	public static void main(String[] args) {
		GameTimeTest test = new GameTimeTest();
		test.start();
	}
	
	
	
	
}
