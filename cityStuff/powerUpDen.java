package cityStuff;
import java.util.*;

public class powerUpDen extends baseCamp {
	
	public void viewMenu() {
		System.out.println("Menu Options");
		System.out.println("0: Power Up A Character");
		System.out.println("1: Exit");
		System.out.println("Please select an option");
		int selection = this.getPlayerChoice();
		switch(selection) {
		case 0 :
			//this.showHealingItems();
			break;
		case 1 :
			this.exit();
			break;
		default:
			System.out.println("Please input a valid choice");
			this.viewMenu();
			break;
		}
	}
	public void exit() {
		System.out.println("Heading Back To The Base Camp");
		super.viewMenu();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
