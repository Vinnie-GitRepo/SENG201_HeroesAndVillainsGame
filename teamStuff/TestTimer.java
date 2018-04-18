package teamStuff;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	
	
	int secondsPassed = 0;
	Timer timer = new Timer();
	
	TimerTask task = new TimerTask() {
		public void run() {
			secondsPassed++;
			System.out.println("Seconds passed: " + secondsPassed);
			if(secondsPassed == 10) {
				task.cancel();
			}
		}
	};
	
	
	public void start() {
		timer.scheduleAtFixedRate(task, 1000, 1000);
	}
	
	
	public static void main(String[] args) {
		TestTimer time = new TestTimer();
		time.start();
	}
	
}
