package cityStuff;
import java.util.*;

public class hospital extends baseCamp {
	
	
	//Give the options menu for within the hospital
	public void viewMenu() {
		
		System.out.println("Menu Options");
		System.out.println("(0) Heal A Character");
		System.out.println("(1) View Healing Time Remaining");
		System.out.println("(2) Exit");
		
		int selection = this.getPlayerChoice();
		
		switch(selection) {
		case 0 :
			//this.showHealingItems();
			break;
		case 1 :
			//this.showPowerUpItems();
			break;
		case 2 :
			this.exit();
			break;
		default:
			System.out.println("Please input a valid choice");
			this.viewMenu();
			break;
		}
	}
	
	
	
	public void exit() {
		System.out.println("\nHeading Back To The Base Camp\n-------------\n");
		super.viewMenu();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
