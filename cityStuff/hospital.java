package cityStuff;
import java.util.*;
import teamStuff.*;

public class hospital extends baseCamp {
	
	public static ConsumableItem current;
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
			this.showHeroes();
			break;
		case 1 :
			//this.showPowerUpItems();
			System.out.println("Still has time to go soz");
			this.viewMenu();
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
	
	public Team currentTeam;
	public void setTeam(Team team) {
		currentTeam = team;
		System.out.println("it set the team");
	}
	
	public void showHeroes() {
		System.out.println("Please Select A Char");
		for (int i = 0; i < currentTeam.getHeroArray().size(); i++) {
			System.out.println("(" + i +") " + currentTeam.getHeroArray().get(i).getName());
		}
		int selection = this.getPlayerChoice();
		this.showHealingItems(currentTeam.getHeroArray().get(selection));
	}
	
	
	public void showHealingItems(Hero hero) {
		System.out.println("Available Items");
		//currentTeam.displayInventory();
		int count = 0;
		for (int i = 0; i < currentTeam.getInventory().size(); i++) {
			System.out.println("(" + i + ")" + currentTeam.getInventory().get(i));
			count = i;
		}
		count += 1; 
		System.out.println("(" + count + ")" + "Exit");
		int selection = this.getPlayerChoice();
		if (selection > currentTeam.getInventory().size()) {
			this.viewMenu();
		} else {
			current = currentTeam.getInventory().get(selection);
			hero.useConsumable(currentTeam.getInventory().get(selection));
			//.apply(hero);
			System.out.println("Done");
			this.viewMenu();
		}
		//workingInventory
	}

	
	public void exit() {
		System.out.println("Heading Back To The Base Camp");
		super.setTeam(currentTeam);
		//super.viewMenu();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
